package Rest;

import java.util.ArrayList;
import java.util.List;

public class Lieferantenliste {

    private static Lieferantenliste lieferantenliste = null;
    private List<Lieferant> lieferantenList = new ArrayList<Lieferant>();

    private Lieferantenliste() {
    }

    public static Lieferantenliste getLieferantenliste() {
        if (lieferantenliste == null) {
            lieferantenliste = new Lieferantenliste();
        }
        return lieferantenliste;
    }

    public boolean addLieferanten(Lieferant l) {
        boolean exist = false;
        if (l != null) {
            Lieferant lieferanten = getLieferantenByName(l.getName());
            if (lieferanten == null) {
                lieferantenList.add(l);
                exist = true;
            }
        }
        return exist;
    }

    public List<Lieferant> getLieferantenList() {
        return lieferantenList;
    }

    public Lieferant getLieferantenByName(String name) {
        Lieferant l = null;
        for (Lieferant lieferanten : lieferantenList) {
            if (lieferanten.getName().equals(name)) {
                l = lieferanten;
            }
        }
        return l;
    }

}
