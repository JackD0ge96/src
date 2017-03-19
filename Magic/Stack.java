package Magic;

/**
 * Classe che gestisce lo stack di gioco, verrà ampliata in seguito, per ora si
 * occupa di inserire una carta nello stack o di rimuovere tutte quelle che ci
 * sono per la risoluzione degli effetti. La funzione più importante è la
 * richiestaStack che dato un giocatre currentPlayer ed il suo avversario si
 * occupa di chiedere ad uno e all'altro giocatore se vogliono inserire una
 * carta di tipo istantaneo nello stack di gioco finchè non rileva che ci sono
 * stati due passo di seguito e che quindi nessuno dei due giocatori vuole o non
 * può più inserire una carta. Infatti si occupa anche di controllare che se un
 * giocatore non ha più carte istantanee in mano il passo sarà automatico senza
 * richiedere nulla al giocatore.
 */
public class Stack {

    private final java.util.Stack<Carta> myStack;

    public Stack() {
        this.myStack = new java.util.Stack<>();
    }

    public void inserimentoStack(Carta c1, Giocatore p) {
        myStack.push(c1);
    }

    // verrà implementato in seguito quando ci saranno effetti da risolvere
    public void risolviStack() {
        while (!myStack.empty()) {
            Carta temp = myStack.pop();
            if (temp.getInfo().compareTo("Mostro") == 0 || temp.getInfo().compareTo("Stregoneria") == 0) {
                //inserisci nel campo del giocatore 
            }
        }
        System.out.println("Risoluzione Stack in corso...");
        //prendo la carta restituita dalla pop() ed eseguo il suo effetto
    }

    /**
     * controllo se il player che deve rispondere ha delle istantanee, se si
     * faccio richiesta se ne vuole giocare una, nel caso in cui la giochi il
     * contatore non aumenta, altrimenti si. In caso non avesse carte istantanee
     * in mano il contatore aumenterà automaticamente e si invertono i turni per
     * l'inserimento nello stack di una carta
     */
    public void richiestaStack(Giocatore currentPlayer, Giocatore opponentPlayer) {
        int contatorePass = 0;

        while (contatorePass != 2) {
            if (opponentPlayer.getIstantanee() != 0) {
                System.out.println("\nGiocatore " + opponentPlayer.getNome() + " queste sono le tue carte istantanee");
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

            //ora inverto i ruoli e ricomincio il ciclo
            Giocatore temp = currentPlayer;
            currentPlayer = opponentPlayer;
            opponentPlayer = temp;
        }
    }
}
