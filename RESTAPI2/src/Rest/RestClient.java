package Rest;

import Entities.Buch;
import Entities.Lieferant;
import Entities.Bestellung;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class RestClient {

    public static String responsePostLieferant;
    public static String responsePostBuch;
    public static String resonsePostBestellung;
    public static String preisResponce;
    public static Lieferant lieferantResponse;
    public static Buch buchResponse;

    public static void main(String args[]) {

        // Erzeugen eines Jersey-Clients
        Client client = ClientBuilder.newClient();
        // Referenz auf die Web-Ressource erzeugen
        WebTarget target = client.target("http://localhost:55321/buchservices");

        /*
        *  Es sollen die Lieferanten „Ballauf“ mit Adresse „Koeln“, „Thiel“ mit Adresse „Muenster“ und „Batic“ mit Adresse „Muenchen“ angelegt werden.
         */
        responsePostLieferant = target.path("lieferant").queryParam("adresse", "Koeln").request().post(Entity.entity("Ballauf", MediaType.APPLICATION_XML), String.class);
        System.out.println("Erstellen der Lieferanten:");
        if (responsePostLieferant.equals("false")) {
            System.out.println("Fehlermeldung: Lieferant Ballauf existiert bereits.");
        } else {
            System.out.println("Lieferant Ballauf wurde erfolgreich angelegt.");
        }

        responsePostLieferant = target.path("lieferant").queryParam("adresse", "Muenster").request().post(Entity.entity("Thiel", MediaType.APPLICATION_XML), String.class);
        if (responsePostLieferant.equals("false")) {
            System.out.println("Fehlermeldung: Lieferant Thiel existiert bereits.");
        } else {
            System.out.println("Lieferant Thiel wurde erfolgreich angelegt.");
        }

        responsePostLieferant = target.path("lieferant").queryParam("adresse", "Muenchen").request().post(Entity.entity("Batic", MediaType.APPLICATION_XML), String.class);
        if (responsePostLieferant.equals("false")) {
            System.out.println("Fehlermeldung: Lieferant Batic existiert bereits.");
        } else {
            System.out.println("Lieferant Batic wurde erfolgreich angelegt.");
        }
        System.out.println();
        System.out.println();

        /*
        * Es soll die Lieferanten-Ressource für den Lieferanten mit Namen „Ballauf“ erfragt werden und die Attribute der Rückgabe sollen ausgegeben werden.
         */
        lieferantResponse = target.path("lieferant").path("Ballauf").request().accept(MediaType.APPLICATION_XML).get(Lieferant.class);
        System.out.println("Abfragen des Lieferanten:");
        System.out.println("Name: " + lieferantResponse.getName());
        System.out.println("Adresse: " + lieferantResponse.getAdresse());
        System.out.println();
        System.out.println();

        /*
        * Es soll für jeden Lieferanten jeweils 1 Buch angelegt werden mit dem Preis 50€ für „Ballauf“, 80€ für „Thiel“ 
        * und 120€ für „Batic“. Es sollen die vergebenen Registrierungsnummern ausgegeben werden.
         */
        responsePostBuch = target.path("buch").queryParam("name", "Ballauf").request().post(Entity.entity("50", MediaType.TEXT_PLAIN), String.class);
        System.out.println("Erstellen der Bücher:");
        System.out.println("Buch für Ballauf angelegt, Registrierungsnummer: " + responsePostBuch);

        responsePostBuch = target.path("buch").queryParam("name", "Thiel").request().post(Entity.entity("80", MediaType.TEXT_PLAIN), String.class);
        System.out.println("Buch für Thiel angelegt, Registrierungsnummer: " + responsePostBuch);

        responsePostBuch = target.path("buch").queryParam("name", "Batic").request().post(Entity.entity("120", MediaType.TEXT_PLAIN), String.class);
        System.out.println("Buch für Batic angelegt, Registrierungsnummer: " + responsePostBuch);
        System.out.println();
        System.out.println();

        /*
        * Für das vom Lieferant „Batic“ gelieferte Buch soll eine Bestellung vom Kunden mit dem Namen „Adler“ erstellt werden. 
        * Die Daten der Rückgabe sollen ausgegeben werden.
         */
        resonsePostBestellung = target.path("bestellung").queryParam("registrierungsnummer", "2003").request().post(Entity.entity("Adler", MediaType.TEXT_PLAIN), String.class);
        System.out.println("Erstellen der Bestellung für Batic, Kunde Adler:");
        System.out.println("Bestellung angelegt, Bestellnummer: " + resonsePostBestellung);
        System.out.println();
        System.out.println();

        /*
        * Es sollen alle Bestellungen von „Adler“ erfragt werden und die jeweiligen Bestellnummern ausgegeben werden. 
        */ 
        Bestellung[] kundenBestellung = target.path("bestellung/Adler").request().accept(MediaType.APPLICATION_XML).get(Bestellung[].class);
        System.out.println("Bestellungen des Kunden Adler:");
        for (int i = 0; i < kundenBestellung.length; i++) {
            System.out.println(i + 1 + ". BestellNr.: " + kundenBestellung[i].getBestellnr());
        }
        System.out.println();
        System.out.println();

        /*
        * Für das vom Lieferanten „Batic“ gelieferte Buch soll eine Bestellung vomKunden mit dem Namen „Neuer“ erstellt werden. 
        * Die Daten der Rückgabe sollen ausgegeben werden.
         */
        resonsePostBestellung = target.path("bestellung").queryParam("registrierungsnummer", "2003").request().post(Entity.entity("Neuer", MediaType.TEXT_PLAIN), String.class);
        System.out.println("Erstellen der Bestellung für Batic, Kunde Neuer:");
        System.out.println("Bestellung angelegt, Bestellnummer: " + resonsePostBestellung);
        System.out.println();
        System.out.println();

        /*
        * Für das vom Lieferanten „Batic“ gelieferte Buch sollen alle Bestellungen ermittelt und die zugehörigen Attributwerte ausgegeben werden.
         */
        Bestellung[] lieferantBestellung = target.path("/bestellung/2003").request().accept(MediaType.APPLICATION_XML).get(Bestellung[].class);
        System.out.println("Bestellungen des Lieferanten Batic:");
        for (int i = 0; i < lieferantBestellung.length; i++) {
            System.out.println(i + 1 + ". BestellNr.: " + lieferantBestellung[i].getBestellnr());
            System.out.println("   Kunde:      " + lieferantBestellung[i].getNameBesteller());
            System.out.println("   Buch RegNr: " + lieferantBestellung[i].getBuch().getRegistrierungsnummer());
            System.out.println("   Buch Preis: " + lieferantBestellung[i].getBuch().getPreis());
        }
        System.out.println();
        System.out.println();

        /*
        * Für das vom Lieferanten „Ballauf“ gelieferte Buch soll der Preis abgefragt und ausgegeben werden. 
         */
        preisResponce = target.path("buch").path("2001").request().accept(MediaType.TEXT_PLAIN).get(String.class);
        System.out.println("Bestellungen des Lieferanten Ballauf:");
        System.out.println("Preis:  " + preisResponce);
        System.out.println();
        System.out.println();

        /*
        * Es soll die Liste aller Bücher erfragt werden und dann die Preise und Registrierungsnummern der Bücher ausgegeben werden.
         */
        Buch[] buchArray = target.path("buch").request().accept(MediaType.APPLICATION_XML).get(Buch[].class);
        System.out.println("Anzeigen aller Bücher:");
        for (int i = 0; i < buchArray.length; i++) {
            System.out.println(i + 1 + ". RegNr.: " + buchArray[i].getRegistrierungsnummer());
            System.out.println("   Preis : " + buchArray[i].getPreis());

        }
        System.out.println();
        System.out.println();

        System.out.println("WADL-Datei: http://localhost:55321/buchservices/application.wadl");

    }

    public static void generiereWADL() throws IOException, URISyntaxException {
        if (Desktop.isDesktopSupported()) {
            Desktop.getDesktop().browse(new URI("http://localhost:55321/buchservices/application.wadl"));

        }
    }

}
