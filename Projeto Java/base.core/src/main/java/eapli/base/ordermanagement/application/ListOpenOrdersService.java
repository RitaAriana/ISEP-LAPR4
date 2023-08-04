package eapli.base.ordermanagement.application;

import eapli.base.MessageUtils;
import eapli.base.clientmanagement.domain.Email;
import eapli.base.clientmanagement.repositories.ClientRepository;
import eapli.base.clientusermanagement.repositories.ClientUserRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.ordermanagement.domain.ProductOrder;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;



public class ListOpenOrdersService {

    private final ClientRepository clientRepository = PersistenceContext.repositories().client();

    private static class ClientSocket {
        private Socket sock;
        private InetAddress serverIP;
        private DataOutputStream sOutData;
        private DataInputStream sInData;

        public void connect(final String address, final int port) throws IOException {

            try {
                serverIP = InetAddress.getByName(address);
            } catch (UnknownHostException ex) {
                System.out.println("Invalid server specified: " + serverIP);
                System.exit(1);
            }

            try {
                sock = new Socket(serverIP, port);
            } catch (IOException ex) {
                System.out.println("Failed to establish TCP connection");
                System.exit(1);
            }

            System.out.println("Connected to: " + serverIP + ":" + 10001);

            sOutData = new DataOutputStream(sock.getOutputStream());
            sInData = new DataInputStream(sock.getInputStream());
        }

        public void stop() throws IOException {
            sock.close();
        }
    }
    public Iterable<ProductOrder> getOpenOrdersOfTheClient(Long clientId) {
        Iterable<ProductOrder> productsOrders = null;
        try {

            final var socket = new ClientSocket();
            socket.connect(getAddress(), getPort());
            try {
                if (MessageUtils.testCommunicationWithServer(socket.sOutData, socket.sInData)) {

                    MessageUtils.writeMessageWithData((byte) 6, clientId.toString(), socket.sOutData);

                    // mostrar os produtos existentes
                    ObjectInputStream sInputObject = new ObjectInputStream(socket.sock.getInputStream());
                    productsOrders = (Iterable<ProductOrder>) sInputObject.readObject();

                    if (MessageUtils.wantsToExit(socket.sOutData, socket.sInData)) {
                        socket.stop();

                    } else {
                        System.out.println("==> ERROR: Erro no pacote do Servidor");

                    }
                } else {
                    System.out.println("==> ERROR: Erro no pacote do Servidor");
                }
            } catch (IOException e) {
                System.out.println("==> ERROR: Falha durante a troca de informação com o server");
            } finally {
                try {
                    socket.stop();
                } catch (IOException e) {
                    System.out.println("==> ERROR: Falha a fechar o socket");
                }
            }

            return productsOrders;
        } catch (Exception e) {
            System.out.println("Server down");
            System.out.println(e.getMessage());
            return productsOrders;
        }

    }

    public Long getClientId(String email){

        return clientRepository.findByEmail(new Email(email)).get().identity();

    }
    private int getPort() {
        return 10001;
    }

    private String getAddress() {
        return "localhost";
    }
}
