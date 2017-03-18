package Phases;

import Magic.*;

public class UntapPhase implements Fase {

    @Override
    public void playFase() {
        System.out.println("> UNTAP PHASE");
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
