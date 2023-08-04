package eapli.base.AGV.application;
import eapli.base.AGV.domain.AGV;
import eapli.base.AGV.repositories.AGVRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.warehouse.domain.AGVDock;
import eapli.base.warehouse.domain.Aisle;
import eapli.base.warehouse.domain.WarehousePlant;
import eapli.base.warehouse.repositories.AGVDockRepository;
import eapli.base.warehouse.repositories.AisleRepository;
import eapli.base.warehouse.repositories.WarehouseRepository;
import httpServerAjax.HTTPMessage;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URI;
import java.net.UnknownHostException;

public class DashboardService {

    private final WarehouseRepository warehouseRepository = PersistenceContext.repositories().warehouse();
    private final AGVDockRepository agvDockRepository = PersistenceContext.repositories().dock();
    private final AisleRepository aisleRepository = PersistenceContext.repositories().aisle();
    private final AGVRepository agvRepository = PersistenceContext.repositories().agv();

    //static private SSLSocket sock;
    static private Socket sock;
    static private InetAddress serverIP;
    static private int serverPort;
    static private DataOutputStream sOut;
    static private DataInputStream sIn;

    static private String WAREHOUSE_ID = "1";

    private static final String TRUSTED_STORE = "client3_J.jks";
    private static final String STORE_PATH = "base.daemon.webServer/src/main/resources/" + TRUSTED_STORE;
    private static final String KEYSTORE_PASS="forgotten";

    HTTPMessage request = new HTTPMessage();
    private StringBuilder string = new StringBuilder("/dashboardData/");

    public void sendInformationToDashboard(){

        warehouseInformation(WAREHOUSE_ID);
        agvDockInformation();
        aisleInformation();
        agvInformation();

        request.setRequestMethod("PUT");
        request.setURI(string.toString());

        try{
            request.send(sOut);
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    private void warehouseInformation(String id){
        WarehousePlant warehousePlant = warehouseRepository.findById(id).getWarehousePlant();
        string.append(warehousePlant.getLength()).append(",");
        string.append(warehousePlant.getWidth()).append(",");
        string.append(warehousePlant.getSquare()).append(",");
    }


    private void agvDockInformation(){
        int size = agvDockRepository.totalAGVDocks();
        string.append(size);
        string.append(",");
        for (AGVDock agvDock : agvDockRepository.findAll()){
            string.append(agvDock.getBegin().getBeginLSquare());
            string.append(",");
            string.append(agvDock.getBegin().getBeginWSquare());
            string.append(",");
            string.append((agvDock.identity()));
            string.append(",");
        }
    }

    private void aisleInformation(){
        int size = aisleRepository.totalAisle();
        string.append(size);
        string.append(",");
        for (Aisle aisle: aisleRepository.findAll()){
            string.append(aisle.getBegin().getBeginLSquare());
            string.append(",");
            string.append(aisle.getEnd().getEndLSquare());
            string.append(",");
            string.append(aisle.getBegin().getBeginWSquare());
            string.append(",");
            string.append(aisle.getEnd().getEndWSquare());
            string.append(",");
            string.append(aisle.getDepth().getlSquare());
            string.append(",");
            string.append(aisle.getDepth().getwSquare());
            string.append(",");
        }
    }

    private void agvInformation(){
        int size = agvRepository.totalAGVs();
        string.append(size);
        string.append(",");
        for (AGV agv: agvRepository.findAll()){
            string.append(agv.agvDock().getId());
            string.append(",");
        }
    }

    /*public void sendAGVInformation() throws IOException {

        controller.connectDaemon("localhost", 8890);
        List<String> strings = controller.getAGVInfo();


        for (String s : strings){
            string.append(s);
        }

        request.setRequestMethod("PUT");
        request.setURI(string.toString());


        try{
            request.send(sOut);
        } catch(Exception e){
            e.printStackTrace();
        }
        controller.closeConnection();
    }*/

    public void openDashboard() throws IOException {

        /*System.setProperty("javax.net.ssl.keyStore", STORE_PATH);
        System.setProperty("javax.net.ssl.keyStorePassword",KEYSTORE_PASS);

        System.setProperty("javax.net.ssl.trustStore", STORE_PATH);
        System.setProperty("javax.net.ssl.trustStorePassword", KEYSTORE_PASS);*/


        try {
            serverIP = InetAddress.getByName("localhost");
        }
        catch(UnknownHostException ex) {
            System.out.println("Invalid SERVER-ADDRESS.");
            System.exit(1);
        }
        try { serverPort = 80; }
        catch(NumberFormatException ex) {
            System.out.println("Invalid SERVER-PORT.");
            System.exit(1);
        }

        //SSLSocketFactory factory = (SSLSocketFactory) SSLSocketFactory.getDefault();

        try {
            //sock =  (SSLSocket) factory.createSocket(serverIP, serverPort);
            sock = new Socket(serverIP, serverPort);

        }
        catch(IOException ex) {
            ex.printStackTrace();
            System.out.println("Failed to connect to provided SERVER-ADDRESS and SERVER-PORT.");
            System.out.println("Application aborted.");
            System.exit(1);
        }

        //sock.startHandshake();

        sOut = new DataOutputStream(sock.getOutputStream());
        sIn = new DataInputStream(sock.getInputStream());



        sendInformationToDashboard();

        java.awt.Desktop.getDesktop().browse(URI.create("http://localhost:80"));
    }
}
