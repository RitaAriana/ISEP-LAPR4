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
package daemon.agvmanager.presentation;

import agvmanager.tcpprotocol.server.AGVManagerProtocolRequest;
import agvmanager.tcpprotocol.server.RequestMessageParser;
import eapli.base.orderServer.tcp.utils.ConstantsServer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Server socket for booking daemon using the CSV-based protocol.
 *
 * @author Paulo Gandra Sousa 01/06/2020
 */
public class AgvManagerProtocolServer {

    private static final Logger LOGGER = LogManager.getLogger(AgvManagerProtocolServer.class);

    private static final String SERVER = "server_J.jks";

    private static final String TRUSTED_STORE = "client2_J.jks";

    private static final String STORE_PATH = "base.daemon.agvManager/src/main/resources/";

    private static final String KEYSTORE_PASS="forgotten";

    /**
     * Client socket.
     *
     * @author Paulo Gandra Sousa 01/06/2020
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
            LOGGER.debug("Acepted connection from {}:{}", clientIP.getHostAddress(), clientSocket.getPort());

            try {

                var in = new DataInputStream(clientSocket.getInputStream());
                var out = new DataOutputStream(clientSocket.getOutputStream());

                var inputArray = in.readNBytes(4);

                if (inputArray[1] == ConstantsServer.START_CODE) {
                    LOGGER.debug("[SUCCESS] TEST CODE RECEIVED");

                    byte code = 0;
                    byte[] message = {code, (byte) 2, code, code};
                    out.write(message);
                    LOGGER.debug("[ACKNOWLEDGMENT] SENDING ACKNOWLEDGMENT MESSAGE");
                }

                inputArray = in.readNBytes(4);
                if (inputArray[1] == 3 || inputArray[1] == 4) {

                    int length = inputArray[2] + (256 * inputArray[3]);

                    String extraInfo = null;
                    byte[] string;
                    if (length > 0) {
                        string = in.readNBytes(length);
                        extraInfo = new String(string);
                    }

                    LOGGER.debug("Received message:----{}----", inputArray);
                    final AGVManagerProtocolRequest request = parser.parse(inputArray, extraInfo);
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
                if (inputArray[1] == ConstantsServer.FINISH_CODE) {
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
                    LOGGER.error("While closing the client socket {}:{}", clientIP.getHostAddress(),
                            clientSocket.getPort(), e);
                }
                // null the reference to ensure it will be caught by the garbage collector
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

        System.setProperty("javax.net.ssl.trustStore", STORE_PATH + TRUSTED_STORE);
        System.setProperty("javax.net.ssl.trustStorePassword",KEYSTORE_PASS);

        System.setProperty("javax.net.ssl.keyStore", STORE_PATH + SERVER);
        System.setProperty("javax.net.ssl.keyStorePassword",KEYSTORE_PASS);

        var sslF = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        SSLServerSocket sock = null;

        try {
            sock = (SSLServerSocket) sslF.createServerSocket(port);
            sock.setNeedClientAuth(true);
            System.out.println(" Sock: " + sock);
        } catch(IOException ex) {
            System.out.println("Server failed to open local port " + port);
            System.out.println(ex.getMessage());
            System.exit(1);
        }
        return sock;
    }

    private final RequestMessageParser parser;

    public AgvManagerProtocolServer(final RequestMessageParser requestMessageParser){
        this.parser = requestMessageParser;
    }


    /**
     * Wait for connections.
     * <p>
     * Suppress warning java:S2189 - Loops should not be infinite
     *
     * @param port
     */
    // @SuppressWarnings("java:S2189")
    private void listen(final int port) {
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
     * @param port
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
