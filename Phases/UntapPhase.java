/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Phases;
import Magic.*;
import java.util.ArrayList;
import java.util.List;

public class UntapPhase implements Fase{
    Giocatore g1=Gioco.getInstance().getCurrentPlayer();
    Gioco.getInstance();
    @Override
    public void playFase() {
        unTap();
    }
    
     public void unTap(){
         boolean tap=false;
        for(Mostro m : board){
            if(m.isTap()==true)
                m.setTap(false);
                
            
        }
           
     } 
 
    
}
