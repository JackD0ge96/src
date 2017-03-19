package Phases;

import Magic.*;

/**
 * Nella Main Phase per prima cosa si controlla se il giocatore ha più carte del
 * dovuto, in quel caso verrano scartate. Poi si sceglie la carta da giocare e
 * verrà messa nello stack per la sua risoluzione, chiedendo poi con la funzione
 * della classe Stack al giocatore avversario se vuole rispondere a questa mossa
 */
public class MainPhase implements Fase {

    @Override
    public void playFase() {
        Giocatore currentPlayer = Gioco.getInstance().getCurrentPlayer();
        Giocatore opponentPlayer = Gioco.getInstance().getOpponentPlayer();
        Stack stack = Gioco.getInstance().getStackGioco();

        System.out.println("> MAIN PHASE");
        //guardo se nella draw phase ho pescato troppe carte e ne scelgo una o piu da scartare
        currentPlayer.checkScarta();

        //stampo la mano e faccio scegliere al giocatore quale carta giocare
        System.out.println(currentPlayer.getNome() + " le tue carte in mano sono: ");
        currentPlayer.stampaMano();
        System.out.println(currentPlayer.getNome() + " scegli una carta da giocare: ");

        int x = Gioco.getInstance().rispostaGiocatore();

        /**
         * ora che ho la carta la metto nello stack ed alterno la richiesta di
         * aggiungere carte allo stack tra i giocatori
         */
        if (x != 0) {
            Carta cartaGiocare = currentPlayer.getHand().rimuoviCarta(x - 1);
            stack.inserimentoStack(cartaGiocare, currentPlayer);
            stack.richiestaStack(currentPlayer, opponentPlayer);
            stack.risolviStack();
        }
    }

}
