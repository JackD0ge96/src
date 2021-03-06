package Magic;

import Phases.*;
import java.util.ArrayList;
import java.util.List;

public class GestoreFasi {

    private final List<Fase> fasi;

    public GestoreFasi() {
        this.fasi = new ArrayList<>();
    }

    public void fasiNormali() {
        fasi.clear();
        addDraw();
        addUntap();
        addCombat();
        addMain();
        addEnd();
    }
    
    public void addDraw() {
        Fase f = new DrawPhase();
        fasi.add(f);
    }

    public void addUntap() {
        Fase f = new UntapPhase();
        fasi.add(f);
    }

    public void addCombat() {
        Fase f = new CombatPhase();
        fasi.add(f);
    }

    public void addMain() {
        Fase f = new MainPhase();
        fasi.add(f);
    }

    public void addEnd() {
        Fase f = new EndPhase();
        fasi.add(f);
    }
    
    public void removeDraw(){
        for(Fase f : fasi) {
            if(f instanceof DrawPhase) {
                fasi.remove(f);
            }
        }
    }
    
    public void removeUntap() {
        for(Fase f : fasi) {
            if(f instanceof UntapPhase) {
                fasi.remove(f);
            }
        }
    }

    public void removeCombat() {
        for(Fase f : fasi) {
            if(f instanceof CombatPhase) {
                fasi.remove(f);
            }
        }
    }

    public void removeMain() {
        for(Fase f : fasi) {
            if(f instanceof MainPhase) {
                fasi.remove(f);
            }
        }
    }

    public void removeEnd() {
        for(Fase f : fasi) {
            if(f instanceof EndPhase) {
                fasi.remove(f);
            }
        }
    }
    
    public Fase popFase(){
        if(!fasi.isEmpty()) {
            return fasi.remove(0);
        }
        else {
            return null;
        }
    }   
}