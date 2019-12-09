package Entities;

import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Lieferant {

    private String name;
    private String adresse;
    private List<Buch> buchList;
    private List<Lieferant> lieferantList;

    public Lieferant() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public List<Buch> getBuchList() {
        return buchList;
    }

    public void setBuchList(List<Buch> buchList) {
        this.buchList = buchList;
    }

    public List<Lieferant> getLieferantList() {
        return lieferantList;
    }

    public void setLieferantList(List<Lieferant> lieferantList) {
        this.lieferantList = lieferantList;
    }

}
