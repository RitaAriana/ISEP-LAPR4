package httpServerAjax;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 *
 * @author ANDRE MOREIRA (asc@isep.ipp.pt)
 */
public class HTTPSServerAjaxDashboard {

    static private final String BASE_FOLDER="base.daemon.webServer/src/main/java/httpServerAjax/www";
    //static private SSLServerSocket sock;
    static private ServerSocket sock;
    static private final int PORT = 80;

    private static final String TRUSTED_STORE = "server_J.jks";
    private static final String STORE_PATH = "base.daemon.webServer/src/main/resources/" + TRUSTED_STORE;
    private static final String KEYSTORE_PASS="forgotten";

    public static void main(String[] args) throws IOException {

        //SSLSocket cliSock;
        Socket cliSock;

        /*System.setProperty("https.protocols", "TLSv1,TLSv1.1,TLSv1.2");

        System.setProperty("javax.net.ssl.keyStore", STORE_PATH);
        System.setProperty("javax.net.ssl.keyStorePassword", KEYSTORE_PASS);

        System.setProperty("javax.net.ssl.trustStore", STORE_PATH);
        System.setProperty("javax.net.ssl.trustStorePassword",KEYSTORE_PASS);*/

        try {
            //SSLServerSocketFactory sslF = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            //sock = (SSLServerSocket) sslF.createServerSocket(PORT);
            sock = new ServerSocket(PORT);
        }
        catch(IOException ex) {
            System.out.println("Server failed to open local port " + PORT);
            System.exit(1);
        }

        while(true) {
            cliSock = sock.accept();
            HTTPAjaxDashboardRequest req = new HTTPAjaxDashboardRequest(cliSock, BASE_FOLDER);
            req.start();
        }

    }

    private static int length;
    private static int width;
    private static int square;
    private static List<String> agvDocks = new ArrayList<>();
    private static List<Long> aisles = new ArrayList<>();
    private static List<String> agvs = new ArrayList<>();

    public static synchronized void getData(String dataAux) {
        String[] arraySplited = dataAux.split(",");

        width= Integer.parseInt(arraySplited[0]);
        length = Integer.parseInt(arraySplited[1]);
        square = Integer.parseInt(arraySplited[2]);

        int size = 4 + Integer.parseInt(arraySplited[3]) * 3;

        agvDocks.addAll(Arrays.asList(arraySplited).subList(4, size));

        int size1 = size + 1 + (Integer.parseInt(arraySplited[size]) * 6);

        for (int i = size + 1; i < size1; i++){
            aisles.add(Long.parseLong(arraySplited[i]));
        }

        int size2 = (size1 + 1) + Integer.parseInt(arraySplited[size1]);

        agvs.addAll(Arrays.asList(arraySplited).subList(size1 + 1, size2));

    }

    public static synchronized String updateData(){
        boolean agvD, isAisle, isAislelimit;
        String agvId = null;
        StringBuilder textHtml = new StringBuilder("<table style=\"border: 1px solid black; margin: auto; border-collapse: collapse;\">");
        if (square != 0) {
            for (int j = 0; j < (length / square); j++) {
                textHtml.append("<tr>");
                for (int i = 0; i < (width / square); i++) {
                    agvD = false;
                    isAisle = false;
                    isAislelimit = false;
                    for (int k = 0; k < agvDocks.size(); k+=3){
                        if (Long.parseLong(agvDocks.get(k))-1 == i && Long.parseLong(agvDocks.get(k+1))-1 == j){
                            agvId = agvDocks.get(k+2);
                            agvD = true;
                        }
                    }
                    for (int l = 0; l < aisles.size(); l+=6){
                        if (aisles.get(l)-1 <= i && aisles.get(l+4)-1 >= i && ((aisles.get(l+2)-1 <= j  && aisles.get(l+5)-1 >= j) || (aisles.get(l+2)-1 >= j  && aisles.get(l+5)-1 <= j))){
                            if (aisles.get(l)-1 <= i && aisles.get(l+4)-1 >= i && ((aisles.get(l+2)-1 <= j  && aisles.get(l+5)-1 == j))){
                                isAislelimit = true;
                            }
                            isAisle = true;
                        }
                    }
                    if (agvD){
                        textHtml.append("<td id=\"");
                        textHtml.append(agvId);
                        if (agvs.contains(agvId)){
                            textHtml.append("\" style=\"border: 1px solid black; width: 40px; height: 40px; background-color: #B0E0E6; text-align: center;\">&#9899;</td>");
                        }
                        else{
                            textHtml.append("\" style=\"border: 1px solid black; width: 40px; height: 40px; background-color: #B0E0E6; text-align: center;\">&nbsp;</td>");
                        }
                    }
                    else if (isAisle){
                        if (isAislelimit){
                            textHtml.append("<td style=\"border-bottom: 1px solid black; width: 40px; height: 40px; background-color: #5F9EA0; text-align: center;\">&nbsp;</td>");
                        }
                        else{
                            textHtml.append("<td style=\"border: 0px solid black; width: 40px; height: 40px; background-color: #5F9EA0; text-align: center;\">&nbsp;</td>");
                        }
                    }
                    else{
                        textHtml.append("<td style=\"border: 1px solid black; width: 40px; height: 40px; text-align: center;\">&nbsp;</td>");
                    }
                }
                textHtml.append("</tr>");
            }
        }
        textHtml.append("</table>");
        return textHtml.toString();
    }

}