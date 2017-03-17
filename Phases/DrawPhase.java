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
    Giocatore g1 = Gioco.getInstance().getCurrentPlayer();
    
    @Override
    public void playFase() {
        System.out.println("Draw Phase...");
        System.out.println("Hai pescato: " + pesca().getInfo());
    }
    
    public Carta pesca(){
        return g1.aggiungiCarta();
    }
}
