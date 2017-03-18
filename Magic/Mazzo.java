package Magic;

import java.util.Stack;

public class Mazzo {

    private final Stack<Carta> mazzo;

    public Mazzo() {
        this.mazzo = new Stack<>();
    }
    
    public Stack getMazzo() {
        return mazzo;
    }

    public void aggiungiCartaMazzo(Carta newCard) {
        mazzo.push(newCard);
    }

    public int dimensioneMazzo() {
        return mazzo.size();
    }

    public void riempiMazzo(Carta newCard) {
        this.aggiungiCartaMazzo(newCard);
    }

    public Carta pescaCarta() {
        return mazzo.pop();
    }

}
