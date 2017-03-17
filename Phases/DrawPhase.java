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
public class DrawPhase implements Fase {

    @Override
    public void playFase() {
        Giocatore g1 = Gioco.getInstance().getCurrentPlayer();
        System.out.println("Draw Phase...");
        try {
            System.out.println("Hai pescato: " + pesca().getInfo());
            g1.getHand().stampaMano();
        } catch (NullPointerException e) {
            System.out.println("Giocatore " + g1.getNome() + " hai finito il mazzo \n" + Gioco.getInstance().getOpponentPlayer().getNome() + " HAI VINTO");
        }
    }

    public Carta pesca() {
        Giocatore g1 = Gioco.getInstance().getCurrentPlayer();
        return g1.aggiungiCarta();

    }
}
