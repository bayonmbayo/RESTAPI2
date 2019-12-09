package Rest;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="buch")
public class Buch {

    private String preis;
    private String registrierungsnummer;
    private static int neueNummer = 1;
    Lieferant lieferant;
    private ArrayList<Buch> buchListe;

    public Buch() {
        this.registrierungsnummer = String.valueOf(2000 + neueNummer);
        neueNummer++;
    }

    @XmlElement
    public String getPreis() {
        return preis;
    }

    public void setPreis(String preis) {
        this.preis = preis;
    }

    @XmlElement
    public String getRegistrierungsnummer() {
        return registrierungsnummer;
    }

    public void setRegistrierungsnummer(String registrierungsnummer) {
        this.registrierungsnummer = registrierungsnummer;
    }

    @XmlElement
    public ArrayList<Buch> getBuchListe() {
        return buchListe;
    }

    public void setBuchListe(ArrayList<Buch> buchListe) {
        this.buchListe = buchListe;
    }

    public Lieferant getLieferanten() {
        return lieferant;
    }

    public void setLieferanten(Lieferant lieferant) {
        this.lieferant = lieferant;
    }

}
