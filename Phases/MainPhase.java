/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Phases;

import Magic.*;

/**
 *
 * @author Alessio
 */
public class MainPhase implements Fase {

    @Override
    public void playFase() {
        Giocatore currentPlayer = Gioco.getInstance().getCurrentPlayer();
        Giocatore opponentPlayer = Gioco.getInstance().getOpponentPlayer();
        Stack stack = Gioco.getInstance().getStackGioco();

        System.out.println("Main Phase del giocatore: " + currentPlayer.getNome());
        /*guardo se nella draw phase ho pescato troppe carte e ne scelgo una o piu da scartare*/
        currentPlayer.checkScarta();

        /*stampo la mano e faccio scegliere al giocatore quale carta giocare*/
        System.out.println("La tue carte in mano sono: ");
        currentPlayer.stampaMano();
        System.out.println("Scegli una carta da giocare: ");
        int x = Gioco.getInstance().rispostaGiocatore();

        /*ora che ho la carta la metto nello stack ed alterno la richiesta di aggiungere carte allo
        stack tra i giocatori*/
        Carta cartaGiocare = currentPlayer.getHand().rimuoviCarta(x - 1);
        stack.inserimentoStack(cartaGiocare, currentPlayer);
        stack.richiestaStack(currentPlayer, opponentPlayer);
        stack.risolviStack();
    }

}
