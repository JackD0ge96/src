package Phases;

import Magic.*;

/**
 * i mostri che sono stati tappati nella fase di combat verrano untappati in
 * questa fase, le carte hanno la proprietà boolean tap che verrà qui gestita
 */
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
