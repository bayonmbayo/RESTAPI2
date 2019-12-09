package Rest;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("buch")
public class BuecherAPI {
    
    /*
    * Für einen Lieferanten mit gegebenem Namen soll ein neues Buch erstellt werden. Es wird hierbei der Preis des neuen Buches als String übergeben. Der
    * Dienst liefert die Registrierungsnummer des neu angelegten Buches als String zurück. Eine Registrierungsnummer muss innerhalb der Bücherei eindeutig sein.
    * (Eine neue Ressource über eine Assoziation erstellen)
    */
    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.TEXT_PLAIN)
    public String neuesBuecher(String preis, @QueryParam("name") String name) {
        Buecherliste bv = Buecherliste.getBuecherliste();
        Lieferantenliste lv = Lieferantenliste.getLieferantenliste();
        Lieferant l = lv.getLieferantenByName(name);
        Buch buecher = new Buch();
        buecher.setPreis(preis);
        buecher.setLieferanten(l);
        String regnr = buecher.getRegistrierungsnummer();
        bv.addBuecher(buecher);
    return regnr;
    }
    
    /*
    * Für ein Buch mit gegebener Registrierungsnummer soll der aktuelle Preis erfragt
    * werden. Der Preis wird vom Server als String geliefert. (Projektion)
    */
    @GET
    @Path("{registrierungsnummer}")
    @Produces(MediaType.TEXT_PLAIN)
      public String getBuecherByReg(@PathParam("registrierungsnummer")  String registrierungsnummer) {
        Buecherliste bv = Buecherliste.getBuecherliste();
        Buch buecher = bv.getBuecherByReg(registrierungsnummer);
        String regnr = buecher.getPreis();
        return regnr;   
    }   
    
    /*
    * Es soll die Liste aller Buch-Objekte im Format XML erfragt werden können. (Auf
    * alle Ressourcen eines Containers zugreifen)
    */
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public Buch[] getAlleBuecher() {
        Buecherliste bv = Buecherliste.getBuecherliste();
        List<Buch> buecherList = bv.getBuecherList();
        Buch[] returnList = new Buch[buecherList.size()];
        
        for (int i = 0; i < buecherList.size(); i++) {
            returnList[i] = buecherList.get(i);
        }
    return returnList;
    }    
    
}
