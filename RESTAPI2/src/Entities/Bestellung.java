package Entities;

import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Bestellung {

    private int bestellnr;
    private String nameBesteller;
    private Buch buch;
    private List<Bestellung> bestellungList;

    public Bestellung() {
    }

    public int getBestellnr() {
        return bestellnr;
    }

    public void setBestellnr(int bestellnr) {
        this.bestellnr = bestellnr;
    }

    public String getNameBesteller() {
        return nameBesteller;
    }

    public void setNameBesteller(String nameBesteller) {
        this.nameBesteller = nameBesteller;
    }

    public Buch getBuch() {
        return buch;
    }

    public void setBuch(Buch buch) {
        this.buch = buch;
    }

    public List<Bestellung> getBestellungList() {
        return bestellungList;
    }

    public void setBestellungList(List<Bestellung> bestellungList) {
        this.bestellungList = bestellungList;
    }

}
