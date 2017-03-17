/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Magic;

/**
 *
 * @author Alessio
 */
public class Stack {

    private final java.util.Stack<Carta> myStack;

    public Stack() {
        this.myStack = new java.util.Stack<>();
    }

    public void inserimentoStack(Carta c1, Giocatore p) {
        myStack.push(c1);
    }

    /*verrà implementato in seguito quando ci saranno effetti da risolvere*/
    public void risolviStack() {
        while (!myStack.empty()) {
            Carta temp = myStack.pop();
            if(temp.getInfo().compareTo("Mostro") == 0 || temp.getInfo().compareTo("Stregoneria") == 0)
                //inserisci nel campo del giocatore 
                ;
        }
        System.out.println("Risoluzione Stack in corso...");
        //prendo la carta restituita dalla pop() ed eseguo il suo effetto
    }

    /*controllo se il player che deve rispondere ha delle istantanee, se si faccio richiesta
    se ne vuole giocare una, nel caso in cui la giochi il contatore non  aumenta, altrimenti si.
    In  caso non avesse carte istantanee in mano il contatore aumenterà automaticamente e si 
    invertono i turni per l'inserimento nello stack di una carta*/
    public void richiestaStack(Giocatore currentPlayer, Giocatore opponentPlayer) {
        int contatorePass = 0;
        while (contatorePass != 2) {
            if (opponentPlayer.getIstantanee() != 0) {
                System.out.println("Giocatore " + opponentPlayer.getNome() + " queste sono le tue carte istantanee");
                opponentPlayer.stampaIstantanee();
                System.out.println("Giocatore " + opponentPlayer.getNome() + " scegli una carta con cui rispondere");
                int x = Gioco.getInstance().rispostaGiocatore();
                if (x != 0) {
                    Carta cartaGiocare = opponentPlayer.getHand().rimuoviIstantanea(x - 1);
                    inserimentoStack(cartaGiocare, opponentPlayer);
                    contatorePass = 0;
                } else {
                    contatorePass++;
                }
            } else {
                contatorePass++;
            }
            /*ora inverto i ruoli e ricomincio il ciclo*/
            Giocatore temp = currentPlayer;
            currentPlayer = opponentPlayer;
            opponentPlayer = temp;
        }
    }
}
