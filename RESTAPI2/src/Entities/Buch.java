package Entities;

import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Buch {

    private String preis;
    private String registrierungsnummer;
    private Lieferant lieferant;
    private List<Buch> buchList;

    public Buch() {
    }

    public String getPreis() {
        return preis;
    }

    public void setPreis(String preis) {
        this.preis = preis;
    }

    public String getRegistrierungsnummer() {
        return registrierungsnummer;
    }

    public void setRegistrierungsnummer(String registrierungsnummer) {
        this.registrierungsnummer = registrierungsnummer;
    }

    public Lieferant getLieferant() {
        return lieferant;
    }

    public void setLieferant(Lieferant lieferant) {
        this.lieferant = lieferant;
    }

    public List<Buch> getBuchList() {
        return buchList;
    }

    public void setBuchList(List<Buch> buchList) {
        this.buchList = buchList;
    }

}
