/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Magic;

/**
 *
 * @author adelcont
 */
public interface Carta {
   // il nome di una carta è l'identificatore per la carta
    // poichè esso è univoco
    
    public String getNome();
    
    public String getEffetto();
    
    public abstract String getInfo();

}
