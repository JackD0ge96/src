package Phases;

import Magic.*;

/**
 * Viene creata la DrawPhase, il giocatore specificato rimuoverà la prima carta
 * dal suo mazzo e verrà inserita nella sua mano, se il mazzo è finito e si
 * tenta di pescare verrà generata una eccezione, che verrà però intercettata e
 * sarà dichiarato come vincitore l'opponetPlayer
 */
public class DrawPhase implements Fase {

    @Override
    public void playFase() {
        System.out.println("> DRAW PHASE");
        Giocatore g1 = Gioco.getInstance().getCurrentPlayer();
        try {
            // stampiamo la carta pescata e il numero di carte rimanenti nel mazzo
            System.out.println("Hai pescato: " + pesca().getInfo());
            System.out.println("Hai ancora: " + g1.dimensioneMazzo() + " carte");
        } catch (NullPointerException e) {
            // se fallisce la pescata significa che è terminato il mazzo e quindi l'avversario ha vinto
            System.out.println("Giocatore " + g1.getNome() + " hai finito il mazzo \n" + Gioco.getInstance().getOpponentPlayer().getNome() + " HAI VINTO");
        }
    }

    public Carta pesca() {
        Giocatore g1 = Gioco.getInstance().getCurrentPlayer();
        return g1.aggiungiCarta();
    }

}
