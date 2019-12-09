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

@Path("lieferant")
public class LieferantenAPI {

    /*
    * Erzeugung eines neuen Lieferanten. Hierbei werden der Name und die Adresse
    * des neuen Lieferanten in XML angegeben. (Eine neue Ressource erzeugen)
     */
    @POST
    @Produces(MediaType.APPLICATION_XML)
    @Consumes(MediaType.APPLICATION_XML)
    public String neuerLieferanten(String name, @QueryParam("adresse") String adresse) {
        String exist = "false";
        Lieferant l = new Lieferant();
        l.setName(name);
        l.setAdresse(adresse);
        Lieferantenliste lv = Lieferantenliste.getLieferantenliste();
        if (lv.addLieferanten(l)) {
            exist = "true";
        }
        if (exist.equals("false")) {
        }

        return exist;
    }

    /*
    * Abfrage der Lieferanten-Ressource fuer einen Lieferanten mit gegebenem Namen. Als Rueckgabe soll 
    eine XML-Beschreibung der Ressource geliefert werden. (Eine einzelne Ressource adressieren)
     */
    @GET
    @Path("{name}")
    @Produces(MediaType.APPLICATION_XML)
    public Lieferant getLieferanten(@PathParam("name") String name) {
        Lieferant l1 = null;
        Lieferantenliste lv = Lieferantenliste.getLieferantenliste();
        Lieferant l2 = lv.getLieferantenByName(name);

        if (l2 != null) {
            l1 = l2;
        }
        return l1;
    }
    
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public Lieferant[] getAlleLieferanten() {
        Lieferantenliste bv = Lieferantenliste.getLieferantenliste();
        List<Lieferant> LieferantList = bv.getLieferantenList();
        Lieferant[] returnList = new Lieferant[LieferantList.size()];
        
        for (int i = 0; i < LieferantList.size(); i++) {
            returnList[i] = LieferantList.get(i);
        }
    return returnList;
    }
}
