package Magic;

/**
 * Nel giocatore troviamo le proprietà che abbiamo descritto in precedenza,
 * insieme alle funzioni che demandano a loro volta la risoluzione di queste
 * nella maggior parte dei casi alla struttura dati nella classe di competenza.
 * In questo modo sarà la classe che contiene la mano del giocatore a dire
 * quante carte contiene, diminuendo il lavoro di ogni singola funzione
 * demandandolo ad altre funzioni più piccole e di più facile lettura/scrittura
 */
public class Giocatore {

    private final String nome;
    private int hp = 10;
    Mazzo deck = new Mazzo();
    Mano hand = new Mano();
    GestoreFasi fasi = new GestoreFasi();
    Campo board = new Campo();

    public Giocatore(String nome) {
        this.nome = nome;
    }

    public int dimensioneMazzo() {
        return deck.dimensioneMazzo();
    }

    public void riempiMazzo(Carta newCard) {
        deck.riempiMazzo(newCard);
    }

    public void pescaInizio() {
        hand.inizializzaMano(deck);
    }

    public int numeroCarteMano() {
        return hand.numeroCarte();
    }

    public Carta aggiungiCarta() {
        if (deck.dimensioneMazzo() == 0) {
            hp = 0;
            return null;
        } else {
            return hand.aggiungiCarta(deck);
        }
    }

    public void stampaMano() {
        hand.stampaMano();
    }

    public void checkScarta() {
        while (hand.numeroCarte() > 7) {
            System.out.println("Hai troppe carte in mano, la tua mano è:");
            stampaMano();
            System.out.println("Scegli la carta da scartare:");
            int x = Gioco.getInstance().rispostaGiocatore();
            hand.rimuoviCarta(x - 1);
        }
    }

    int getIstantanee() {
        int cont = 0;
        for (Carta tmp : hand.getMano()) {
            if (tmp.getTipo().compareTo("Istantanea") == 0) {
                cont++;
            }
        }
        return cont;
    }

    void stampaIstantanee() {
        hand.stampaIstantanee();
    }

    public Campo getBoard() {
        return board;
    }

    public String getNome() {
        return nome;
    }

    public Mazzo getDeck() {
        return deck;
    }

    public Mano getHand() {
        return hand;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }
}
