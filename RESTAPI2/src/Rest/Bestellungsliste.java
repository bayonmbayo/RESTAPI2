package Rest;

import java.util.ArrayList;
import java.util.List;

public class Bestellungsliste {

    private static Bestellungsliste bestellungsliste = null;
    private List<Bestellung> bestellungenList = new ArrayList<Bestellung>();

    public Bestellungsliste() {
    }

    public static Bestellungsliste getBestellungsliste() {
        if (bestellungsliste == null) {
            bestellungsliste = new Bestellungsliste();
        }
        return bestellungsliste;
    }

    public void addBestellungen(Bestellung bestellungen) {
        bestellungenList.add(bestellungen);
    }

    public List<Bestellung> getBestellungenList() {
        return bestellungenList;
    }

}
