package Magic;

import java.util.ArrayList;
import java.util.List;

public class Mano {
    
    private List<Carta> mano = new ArrayList<>();
    
    public Mano() {
    }
    
    public int numeroCarte() {
        return mano.size();
    }
    
    public Carta aggiungiCarta(Mazzo deck) {
        Carta c = deck.pescaCarta();
        mano.add(c);
        return c;
    }
    
    public Carta rimuoviCarta(int i) {
        return mano.remove(i);
    }
    
    public void inizializzaMano(Mazzo deck) {
        for (int i = 0; i < 5; i++) {
            aggiungiCarta(deck);
        }
    }
    
    public void stampaMano() {
        int i = 0;
        for (Carta c : mano) {
            System.out.println("(" + (i + 1) + ")" + c.getInfo());
            i++;
        }
    }
    
    Carta rimuoviIstantanea(int i) {
        int j = 0;
        for (Carta c : mano) {
            if (c.getTipo().compareTo("Istantanea") == 0) {
                if (i == 0) {
                    return mano.remove(j);
                } else {
                    i--;
                }
            }
            j++;
        }
        /*input errato*/
        return null;
    }
    
    public List<Carta> getMano() {
        return mano;
    }
    
    void stampaIstantanee() {
        int i = 0;
        System.out.println("(0) Non voglio giocare nessuna carta");
        if(!mano.isEmpty()){
            for (Carta c : mano) {
                if (c.getTipo().compareTo("Istantanea") == 0) {
                    System.out.println("(" + (i + 1) + ")" + c.getInfo());
                    i++;
                }
            }
        }
    }
}
