package Cards;

import Magic.GenericaCarta;
import Magic.Istantanea;

/**
 * Carta di prova Omeopathy, istantanea senza alcun effetto
 */
public class Omeopathy extends GenericaCarta implements Istantanea {

    public Omeopathy() {
        super("Omeopathy", "Non ha alcun effetto", "Istantanea", true);
    }

    @Override
    public void attivaEffetto() {
        // non fa niente
    }

}
