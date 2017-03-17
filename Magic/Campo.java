/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Magic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Campo  {
    private List<Mostro> monsterBoard = new ArrayList<Mostro>();
    //va aggiunta la lista per le stregonerie permanenti
    public void inserisci (Mostro card){
        monsterBoard.add(card);
        
    }
    public void rimuovi(Mostro card){
        monsterBoard.remove(card);
       
    }
  /*  public void stampaCreature(){
        for(int i=0; i<board.size();i++){
            System.out.println("creatura")
        }
    }*/
    
    
    
}
