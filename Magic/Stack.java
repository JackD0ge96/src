/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Magic;
/**
 *
 * @author marco
 */
public class Stack {
    private final java.util.Stack<Carta> myStack;

    public Stack() {
        this.myStack = new java.util.Stack<>();
    }

    public void inserimentoStack(Carta c1, Giocatore p){
        myStack.push(c1);
    }
    
    public void risolviStack(){
        while(!myStack.empty())
            myStack.pop().getInfo();
            //prendo la carta restituita dalla pop() ed eseguo il suo effetto
    }
}
