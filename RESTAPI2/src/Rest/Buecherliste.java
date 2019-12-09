package Rest;

import java.util.ArrayList;
import java.util.List;

public class Buecherliste {
    
    private static Buecherliste buecherliste = null;
    private List<Buch> buecherList = new ArrayList<Buch>();

    Buecherliste() {
    }
    
    public static Buecherliste getBuecherliste(){
        if(buecherliste == null){
            buecherliste = new Buecherliste();
        }
        return buecherliste;
    }
    
    public void addBuecher(Buch b) {
        buecherList.add(b);
    }
    
    public List<Buch> getBuecherList(){
        return buecherList;
    }
    
    public Buch getBuecherByReg(String regNr) {
        Buch b = null;
        for (Buch buecher : buecherList) {
            if (buecher.getRegistrierungsnummer().equals(regNr)) {
            b = buecher;
            }
        }
        return b;
    }
    
    public String getPreisByReg(String regNr) {
        Buch b = null;
        List<Buch> buecherlist = b.getBuchListe();
        for (int i=0;i<buecherlist.size();i++) {
            if (buecherlist.get(i).getRegistrierungsnummer().equals(regNr)) {
            b = buecherlist.get(i);
            }
        }
        String ret=b.getPreis();
        return ret;
    }
    
}
