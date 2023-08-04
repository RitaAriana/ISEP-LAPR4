/*
 * Copyright (c) 2013-2022 the original author or authors.
 *
 * MIT License
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and
 * associated documentation files (the "Software"), to deal in the Software without restriction,
 * including without limitation the rights to use, copy, modify, merge, publish, distribute,
 * sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or
 * substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT
 * NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package daemon.digitaltwin.presentation;

import digitaltwin.tcpprotocol.server.DigitalTwinProtocolRequest;
import digitaltwin.tcpprotocol.server.RequestMessageParser;
import eapli.base.AGV.domain.AGV;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.Socket;

/**
 * Server socket for Digital Twin Using byte arrays as the way of communication
 *
 * @author Francisco Redol
 */
public class DigitalTwinProtocolServer {

    private static final Logger LOGGER = LogManager.getLogger(DigitalTwinProtocolServer.class);

    private static final String TRUSTED_STORE = "server_J.jks";

    private static final String STORE_PATH = "base.daemon.digitalTwin/src/main/resources/" + TRUSTED_STORE;

    private static final String KEYSTORE_PASS="forgotten";

    /**
     * Client socket.
     *
     * @author Francisco Redol
     */
    private static class ClientHandler extends Thread {
        private Socket clientSocket;

        private final RequestMessageParser parser;

        public ClientHandler(final Socket socket, final RequestMessageParser parser) {
            this.clientSocket = socket;
            this.parser = parser;
        }

        @Override
        public void run() {
            final var clientIP = clientSocket.getInetAddress();
            LOGGER.debug("Accepted connection from {}:{}", clientIP.getHostAddress(), clientSocket.getPort());

            try {
                var in = new DataInputStream(clientSocket.getInputStream());
                var out = new DataOutputStream(clientSocket.getOutputStream());

                var inputArray = in.readNBytes(4);

                if (inputArray[1] == 0) {
                    LOGGER.debug("[SUCCESS] TEST CODE RECEIVED");

                    byte code = 0;
                    byte[] message = {code, (byte) 2, code, code};
                    out.write(message);
                    LOGGER.debug("[ACKNOWLEDGMENT] SENDING ACKNOWLEDGMENT MESSAGE");
                }
                inputArray = in.readNBytes(4);
                if (inputArray[1] == 3) {

                    int length = inputArray[2] + (256 * inputArray[3]);

                    String extraInfo = null;
                    byte[] string;
                    if (length > 0) {
                        string = in.readNBytes(length);
                        extraInfo = new String(string);
                    }

                    LOGGER.debug("Received message:----{}----", inputArray);
                    final DigitalTwinProtocolRequest request = parser.parse(inputArray, extraInfo);
                    String response = request.execute();

                    var array = calculateSize(response);
                    inputArray[2] = array[0];
                    inputArray[3] = array[1];
                    out.write(inputArray);

                    if(response != null)
                        out.write(response.getBytes());

                    LOGGER.debug("Sent message:----{}----", response);
                }
                inputArray = in.readNBytes(4);
                if (inputArray[1] == 1) {
                    LOGGER.debug("[SUCCESS] DISCONNECT CODE RECEIVED");

                    byte code = 0;
                    byte[] message = {code, (byte) 2, code, code};
                    out.write(message);
                    LOGGER.debug("[ACKNOWLEDGMENT] SENDING ACKNOWLEDGMENT MESSAGE");

                }
            } catch (final IOException e) {
                LOGGER.error(e);
            } finally {
                try {
                    clientSocket.close();
                    LOGGER.debug("Closing client socket {}:{}", clientIP.getHostAddress(), clientSocket.getPort());
                } catch (final IOException e) {
                    LOGGER.error("While closing the client socket {}:{}", clientIP.getHostAddress(), clientSocket.getPort(), e);
                }

                clientSocket = null;
            }
        }
    }




    /**
     * @param string created response string
     *
     * Method used to calculate the size of the response
     *
     * @return array containing the sizes
     */
    private static byte[] calculateSize(final String string){
        byte d1 = 0, d2 = 0;
        int stringSize = string.length();

        while(stringSize > 0) {
            if (stringSize > 256) {
                d2 = (byte) (stringSize / 256);
                stringSize %= 256;
            } else {
                d1 = (byte) stringSize;
                break;
            }
        }
        return new byte []{d1, d2};
    }

    private SSLServerSocket getServerSocket(final int port){
        final var fileName = new File(STORE_PATH).getAbsolutePath();

        System.setProperty("javax.net.ssl.trustStore", fileName);
        System.setProperty("javax.net.ssl.trustStorePassword",KEYSTORE_PASS);

        System.setProperty("javax.net.ssl.keyStore", fileName);
        System.setProperty("javax.net.ssl.keyStorePassword",KEYSTORE_PASS);

        var sslF = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        SSLServerSocket sock = null;

        try {
            sock = (SSLServerSocket) sslF.createServerSocket(port);
            sock.setNeedClientAuth(true);
        } catch(IOException ex) {
            System.out.println("Server failed to open local port " + port);
            System.exit(1);
        }
        return sock;
    }

    private final RequestMessageParser parser;

    private final AGV agv;

    public DigitalTwinProtocolServer(final RequestMessageParser requestMessageParser, final AGV agv){
        this.parser = requestMessageParser;
        this.agv = agv;
        this.agv.activateControlSystem();
    }

    /**
     * Wait for connections.
     * <p>
     * Suppress warning java:S2189 - Loops should not be infinite
     *
     * @param port of the socket
     */
    @SuppressWarnings("java:S2189")
    private void listen(final int port)  {
        try (var serverSocket = getServerSocket(port)) {
            while (true) {
                final var clientSocket = serverSocket.accept();
                new ClientHandler(clientSocket, parser).start();
            }
        } catch (final IOException e) {
            LOGGER.error(e);
        }
    }

    /**
     * Wait for connections.
     *
     * @param port of the socket
     * @param blocking
     *            if {@code false} the socket runs in its own thread and does not block calling
     *            thread.
     */
    public void start(final int port, final boolean blocking) {
        if (blocking) {
            listen(port);
        } else {
            new Thread(() -> listen(port)).start();
        }
    }
}

