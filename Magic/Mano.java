package Magic;

import java.util.ArrayList;
import java.util.List;

public class Mano {

    private final List<Carta> mano = new ArrayList<>();

    public Mano() { }

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
        
        if (numeroCarte() == 0) {
            System.out.println("(0) Nessuna carta");
        } 
        else {
            for (Carta c : mano) {
                System.out.println("(" + (i + 1) + ") " + c.getInfo());
                i++;
            }
        }
    }

    Carta rimuoviIstantanea(int i) {
        int j = 0;
        
        for (Carta c : mano) {
            if (c.getTipo().compareTo("Istantanea") == 0) {
                if (i == 0) {
                    return mano.remove(j);
                } 
                else {
                    i--;
                }
            }
            j++;
        }
        
        return null; //input errato
    }

    public List<Carta> getMano() {
        return mano;
    }

    void stampaIstantanee() {
        int i = 0;
        System.out.println("(0) Non voglio giocare nessuna carta");
        
        if (!mano.isEmpty()) {
            for (Carta c : mano) {
                if (c.getTipo().compareTo("Istantanea") == 0) {
                    System.out.println("(" + (i + 1) + ")" + c.getInfo());
                    i++;
                }
            }
        }
    }
}
