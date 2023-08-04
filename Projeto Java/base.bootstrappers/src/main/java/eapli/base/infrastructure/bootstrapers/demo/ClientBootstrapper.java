package eapli.base.infrastructure.bootstrapers.demo;

import eapli.base.clientmanagement.application.RegisterClientController;
import eapli.base.clientmanagement.domain.Client;
import eapli.framework.time.util.Calendars;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ClientBootstrapper extends BaseDemoBootstrapper{

    private final RegisterClientController registerClientController = new RegisterClientController();

    @Override
    public boolean execute() {
        try {
            createClient();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return true;
    }

    private void createClient() throws ParseException {
        List<List<String>> addresses = new ArrayList<>();
        List<String> address = new ArrayList<>();
        address.add("Rua do Ouro");
        address.add("353");
        address.add("4505-102");
        address.add("Aveiro");
        address.add("Portugal");
        addresses.add(address);
        String strDate = "2006/09/15";
        SimpleDateFormat df = new SimpleDateFormat("yyyy/mm/dd");
        Calendar birthDate = Calendars.fromDate(df.parse(strDate));

        registerClientController.registerClient("Carlota","de Castro Ribeiro e Pereira Sobral","arianasobral26@outlook.pt","+351939214644","PT999999999",addresses,birthDate, Client.Gender.FEMININE);
        registerClientController.registerClient("Manuela","Leite","manuela@isep.ipp.pt","+351999999999","PT999999999",addresses, birthDate, Client.Gender.FEMININE);
        registerClientController.registerClient("Francisco","Redol","francisco@isep.ipp.pt","+351999999989","PT999999999",addresses, birthDate, Client.Gender.MASCULINE);
        registerClientController.registerClient("Pedro","Celestino","pedro@isep.ipp.pt","+351999979999","PT999999999",addresses, birthDate, Client.Gender.MASCULINE);
        registerClientController.registerClient("Rita","Ariana","rita@isep.ipp.pt","+351996999999","PT999999999",addresses, birthDate, Client.Gender.FEMININE);
        registerClientController.registerClient("Diogo","Lourenco","locenzo@isep.ipp.pt","+351997999999","PT999999999",addresses, birthDate, Client.Gender.MASCULINE);
        registerClientController.registerClient("Ines","Cesar","ines@isep.ipp.pt","+351996998999","PT999999999",addresses, birthDate, Client.Gender.FEMININE);
        registerClientController.registerClient("Luis","Busto","busto@isep.ipp.pt","+351996989999","PT999999999",addresses, birthDate, Client.Gender.MASCULINE);
        registerClientController.registerClient("Daniel","Leitao","leitao@isep.ipp.pt","+351956989999","PT999999999",addresses, birthDate, Client.Gender.MASCULINE);
        registerClientController.registerClient("Diogo","Soares","diogo@isep.ipp.pt","+351996989979","PT999999999",addresses, birthDate, Client.Gender.MASCULINE);
        registerClientController.registerClient("Joao Pedro","Xino","joaoPedro@gmail.com","+351996989999","PT999999999",addresses, birthDate, Client.Gender.MASCULINE);
        registerClientController.registerClient("Tiago","Soares","tiago@isep.ipp.pt","+351996989999","PT999999999",addresses, birthDate, Client.Gender.MASCULINE);



    }
}
