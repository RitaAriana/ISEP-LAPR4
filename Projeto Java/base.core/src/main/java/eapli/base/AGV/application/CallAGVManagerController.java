package eapli.base.AGV.application;

import eapli.base.AGV.domain.AGV;
import eapli.base.infrastructure.persistence.PersistenceContext;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.*;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;

public class CallAGVManagerController {

    public static final int VERSION = 1;

    public static final int CALL_FIFO = 4;

    public static final int DASHBOARD_REQUEST = 3;

    private static final String TRUSTED_STORE = "client2_J.jks";

    private static final String STORE_PATH = "base.daemon.agvManager/src/main/resources/";

    private static final String KEYSTORE_PASS = "forgotten";

    private SSLSocket sock;

    private DataOutputStream output;

    private DataInputStream input;



    public void connectDaemon(final int port) throws IOException {
        try {
            sock = getClientSocket(port);
            sock.startHandshake();
        } catch (final IOException ignored) {}

        output = new DataOutputStream(sock.getOutputStream());
        input = new DataInputStream(sock.getInputStream());

        testConnection();
    }

    public void callFIFO() throws IOException {
        byte [] array = new byte[]{VERSION,CALL_FIFO,0,0};
        output.write(array);
    }

    public List<String> getAGVInfo() throws IOException {
        List<String> agvInfoList = new ArrayList<>();

        for(AGV agv : PersistenceContext.repositories().agv().findAll()){
            String agvId = agv.getAgvId().getAGVId();
            byte [] array = new byte[]{VERSION,DASHBOARD_REQUEST,(byte)agvId.length(),0};
            output.write(array);


            agvInfoList.add(input.readLine()); // fazer verif do array verificar o tamanho

            int length = array[2] + 256*array[3];
            var info = new String(input.readNBytes(length));


        }
        return agvInfoList;
    }

    private SSLSocket getClientSocket(final int port) throws IOException {
        final var fileName = new File(STORE_PATH + TRUSTED_STORE).getAbsolutePath();

        System.setProperty("javax.net.ssl.trustStore", fileName);
        System.setProperty("javax.net.ssl.trustStorePassword", KEYSTORE_PASS);

        System.setProperty("javax.net.ssl.keyStore", fileName);
        System.setProperty("javax.net.ssl.keyStorePassword",KEYSTORE_PASS);

        var sslF = (SSLSocketFactory) SSLSocketFactory.getDefault();
        SSLSocket sock = null;

        var serverIP = InetAddress.getByName("localhost");

        try {
            sock = (SSLSocket) sslF.createSocket(serverIP, port);
        } catch(IOException ex) {
            System.out.println("Client failed to connect to local port " + port);
            System.exit(1);
        }
        //sock.startHandshake();
        return sock;
    }

    public boolean testConnection() throws IOException {
        byte code = 0;
        byte[] testArray = new byte[]{code, code, code, code};
        output.write(testArray);

        var ackArray = input.readNBytes(4);

        return 2 == ackArray[1];
    }

    public void closeConnection() throws IOException {

        byte code = 0;
        byte[] testArray = new byte[]{code, (byte) 1, code, code};
        output.write(testArray);

        var ackArray = input.readNBytes(4);

        if(ackArray[1] == 2)
            sock.close();
    }

}