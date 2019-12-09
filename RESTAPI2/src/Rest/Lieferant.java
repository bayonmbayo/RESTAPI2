package Rest;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="lieferant")
public class Lieferant {

    private String name;
    private String adresse;
    private List<Lieferant> lieferantenListe;
    private List<Buch> buchListe;

    public Lieferant() {
    }

    @XmlElement
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlElement
    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    @XmlElement
    public List<Lieferant> getLieferantenListe() {
        return lieferantenListe;
    }

    public void setLieferantenListe(List<Lieferant> lieferantenListe) {
        this.lieferantenListe = lieferantenListe;
    }

    @XmlElement
    public List<Buch> getBuchListe() {
        return buchListe;
    }

    public void setBuchListe(List<Buch> buchListe) {
        this.buchListe = buchListe;
    }

}
