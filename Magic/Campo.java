package Magic;

import java.util.ArrayList;
import java.util.List;

public class Campo {

    private List<Mostro> monsterBoard = new ArrayList<>();
    
    public List<Mostro> getMonsterBoard() {
        return monsterBoard;
    }

    // va aggiunta la lista per le stregonerie permanenti
    public void inserisci(Mostro card) {
        monsterBoard.add(card);
    }

    public void rimuovi(Mostro card) {
        monsterBoard.remove(card);
    }

    /*  
    public void stampaCreature(){
        for(int i=0; i<board.size();i++){
            System.out.println("creatura")
        }
    }
    */


}
