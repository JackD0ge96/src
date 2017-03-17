/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Magic;

import java.util.ArrayList;
import java.util.List;

public class Campo  {
    private final List<Carta> board = new ArrayList<>();
    public void inserisci (Carta card){
        board.add(card);
        
    }
    public void rimuovi(Carta card){
        board.remove(card);
       
    }
  /*  public void stampaCreature(){
        for(int i=0; i<board.size();i++){
            System.out.println("creatura")
        }
    }*/
    
    
    
}
