/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Magic;

/**
 *
 * @author Davide
 */
public interface Mostro {
    public int getHealth();
    public int getAttack();
    public int getEffetto();
    public boolean isTap();
    public boolean setTap(boolean tap);
}
