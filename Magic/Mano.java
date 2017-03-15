package Magic;

import java.util.ArrayList;
import java.util.List;

public class Mano {

    private final List<Carta> mano = new ArrayList<>();
    public Mano() {
    }
    
    public int numeroCarte(){
        return mano.size();
    }

    public void aggiungiCarta(Mazzo deck) {
        mano.add(deck.pescaCarta());
    }

    public void rimuoviCarta(int i) {
        mano.remove(i);
    }

    public void inizializzaMano(Mazzo deck) {
        for (int i = 0; i < 5; i++) {
            aggiungiCarta(deck);
        }
    }

    public void stampaMano() {
        for (int i = 0; i < mano.size(); i++) {
            System.out.println("(" + (i + 1) + ")" + mano.get(i).getInfo());
        }
    }
    
}
