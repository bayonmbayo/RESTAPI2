package Rest;

import java.util.List;
import java.util.ArrayList;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="bestellung")
public class Bestellung {

    private int bestellnr;
    private static int neueNummer = 1;
    private String nameBesteller;
    private Buch buch;
    private List<Bestellung> bestellungenListe;

    public Bestellung() {
        this.bestellnr = 1000 + neueNummer;
        neueNummer++;
    }

    @XmlElement
    public int getBestellnr() {
        return bestellnr;
    }

    public void setBestellnr(int bestellnr) {
        this.bestellnr = bestellnr;
    }

    @XmlElement
    public String getNameBesteller() {
        return nameBesteller;
    }

    public void setNameBesteller(String nameBesteller) {
        this.nameBesteller = nameBesteller;
    }

    @XmlElement
    public Buch getBuch() {
        return buch;
    }

    public void setBuch(Buch buch) {
        this.buch = buch;
    }

    @XmlElement
    public List<Bestellung> getBestellungenListe() {
        return bestellungenListe;
    }

    public void setBestellungenListe(List<Bestellung> bestellungenListe) {
        this.bestellungenListe = bestellungenListe;
    }

}
