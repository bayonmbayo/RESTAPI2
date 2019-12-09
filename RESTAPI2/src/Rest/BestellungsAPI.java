package Rest;

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("bestellung")
public class BestellungsAPI {

    /*
    * Für ein Buecher mit gegebener Registrierungsnummer soll eine neue Bestellung erstellt werden. Es wird hierbei auch der Name des bestellenden Kunden
    * übergeben. Der Dienst liefert die Bestellnummer der neu angelegten Bestellung als String zurück. Eine Bestellnummer muss innerhalb der Bücherei eindeutig
    * sein. (Eine neue Ressource über eine Assoziation erstellen)
     */
    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.TEXT_PLAIN)
    public String neueBestellungen(String nameBesteller, @QueryParam("registrierungsnummer") String regNr) {
        Bestellungsliste bv = Bestellungsliste.getBestellungsliste();
        Buecherliste buecherv = Buecherliste.getBuecherliste();
        Buch b = buecherv.getBuecherByReg(regNr);
        Bestellung bestellungen = new Bestellung();
        bestellungen.setNameBesteller(nameBesteller);
        bestellungen.setBuch(b);
        String ret = String.valueOf(bestellungen.getBestellnr());
        bv.addBestellungen(bestellungen);
        return ret;
    }

    /*
    * Für ein Buecher mit gegebener Registrierungsnummer soll die Liste aller
    * Bestellungs-Objekte dieses Buches im Format XML geliefert werden. (Verfolgung einer Assoziation)
     */
    @GET
    @Path("registrierungsnummer")
    @Produces(MediaType.APPLICATION_XML)
    public Bestellung[] getBestellungenenByBuecherRegNr(@PathParam("registrierungsnummer") String regNr) {
        Bestellungsliste bv = Bestellungsliste.getBestellungsliste();
        List<Bestellung> bestellList = bv.getBestellungenList();
        List<Bestellung> bestellListTemp = bv.getBestellungenList();

        for (int i = 0; i < bestellList.size(); i++) {
            if (bestellList.get(i).getBuch().getRegistrierungsnummer().equals(regNr)) {
                bestellListTemp.add(bestellList.get(i));
            }
        }
        Bestellung[] kundenList = new Bestellung[bestellListTemp.size()];
        for (int j = 0; j < bestellListTemp.size(); j++) {
            kundenList[j] = bestellListTemp.get(j);
        }
        return kundenList;
    }

    /*
    * Es sollen alle Bestellungen für einen gegebenen Kunden abgefragt werden können. Der Kundenname wird hierbei als String übergeben. 
    * Rückgabe ist die Menge an entsprechenden Bestellungsobjekte in XML. (Selektion)
     */
    @GET
    @Path("{nameBesteller}")
    @Produces(MediaType.APPLICATION_XML)
    public Bestellung[] getBestellungenenByKundenName(@PathParam("nameBesteller") String bestellerName) {
        Bestellungsliste bv = Bestellungsliste.getBestellungsliste();
        List<Bestellung> bestellList = bv.getBestellungenList();
        Bestellung[] kundenList = new Bestellung[bestellList.size()];
        for (int i = 0; i < bestellList.size(); i++) {
            kundenList[i] = bestellList.get(i);
        }
        return kundenList;
    }

}
