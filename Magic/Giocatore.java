package Magic;

import java.util.Scanner;

public class Giocatore {

    final String nome;
    private int hp = 10;
    Mazzo deck = new Mazzo();
    Mano hand = new Mano();
    
    public Giocatore(String nome) {
        this.nome = nome;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int dimensioneMazzo() {
        return deck.dimensioneMazzo();
    }

    void riempiMazzo(Carta newCard) {
        deck.riempiMazzo(newCard);
    }

    void pescaInizio() {
        hand.inizializzaMano(deck);
    }

    int numeroCarteMano() {
        return hand.numeroCarte();
    }

    void aggiungiCarta() {
        if (deck.dimensioneMazzo() == 0) {
            hp = 0;
        } else {
            hand.aggiungiCarta(deck);
        }
    }

    void checkScarta() {
        while (hand.numeroCarte() > 7) {
            Scanner input = new Scanner(System.in);
            System.out.println("Hai troppe carte in mano, la tua mano è:");
            hand.stampaMano();
            System.out.println("Scegli la carta da scartare:");
            int x = input.nextInt();
            hand.rimuoviCarta(x - 1);
        }
    }
}
