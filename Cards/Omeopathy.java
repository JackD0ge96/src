/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cards;

import Magic.GenericaCarta;
import Magic.Istantanea;

/**
 *
 * @author Davide
 */
public class Omeopathy extends GenericaCarta implements Istantanea {

    public Omeopathy() {
        super("Omeopathy", "Non ha alcun effetto", "Istantanea",true);
    }

    @Override
    public void attivaEffetto() {
        //non fa niente
    }

}
