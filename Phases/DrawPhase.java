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
        pesca();
    }
    
    public void pesca(){
        g1.aggiungiCarta();
    }

    
}
