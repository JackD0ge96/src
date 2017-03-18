/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Phases;

import Magic.*;

public class UntapPhase implements Fase {

    @Override
    public void playFase() {
        unTap();
    }

    public void unTap() {
        for (Mostro m : Gioco.getInstance().getCurrentPlayer().getBoard().getMonsterBoard()) {
            if (m.isTap() == true) {
                m.setTap(false);
            }
        }
    }
}
