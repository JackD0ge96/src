package Magic;

import Cards.*;
import Phases.Fase;
import java.util.Scanner;
/**creato da : -Alessio Del Conte
 *            -Marco Murador
 *            -Davide Bassetto
 *            -Sara Ferro
 *            -Martina Donadi
 * Gruppo 4
 * Nota: Davide Bassetto, Sara Fesrro e Martina Donadi sono gli studenti che 
 *       seguono soltanto il 50% delle ore del corso
*/
/**
 * L'idea implementativa di questa prima fase del progetto è stata quella di
 * partire dalle funzioni più di base per ogni struttura che ci sarebbe poi
 * servita nella realizzazione del progetto. Abbiamo pensato di utilizzare per
 * il mazzo e per lo stack di gioco la classe Stack fornita da Java,
 * implementando poi le funzioni in modo che potessero servirci per la
 * realizzazione delle funzioni più grandi. Per la mano e per il campo di gioco
 * utilizziamo invece delle ArrayList dato che bisognerà scorrere queste
 * strutture in lettura e scrittura per lo svolgimento del gioco. Ogni giocatore
 * ha quindi il suo mazzo, la sua mano, il suo campo ed inoltre il suo gestore
 * di fasi, anche questo implementato attraverso una ArrayList. Il gestore di
 * fasi serve per tenere traccia di che fasi il giocatore deve o dovrà eseguire
 * le corso del suo turno o del turno successivo. Attraverso questa struttura
 * infatti se abbiamo una carta che aggiunge o rimuove fasi del nostro turno o
 * del turno avversario sarà proprio l'effetto di quella carta che quando si
 * attiverà andrà a modificare la struttura del gestore fasi del giocatore
 * indicato. Abbiamo poi proceduto a sviluppare le funzioni più grandi, come
 * quelle delle fasi di gioco attraverso l'utilizzo delle "sottofunzioni" che
 * abbiamo dichiarato in precedenza, in questo modo la scrittura del codice, il
 * debug ed il testing è risultato molto più naturale e semplice. Inoltre non
 * sono stati inseriti per ora controlli sull'imput da tastiera, quindi ci si
 * aspetta sempre che gli imput immessi siano corretti e coerenti con quello che
 * è viene stampato dal gioco.
 */
/**
 * Instanziamento della classe Gioco, la quale crea i due giocatori, lo stack di
 * gioco e riempie i mazzi della carta test Omeopathy e pesca le prime 5 carte
 * dal mazzo di ciascun giocatore. Dopo aver fatto questo viene avviato il gioco
 * vero e proprio con la funzione play
 */
// SINGLETON
public class Gioco {

    private Giocatore player1 = new Giocatore("player1");
    private Giocatore player2 = new Giocatore("player2");
    private Giocatore currentPlayer;
    private Giocatore opponentPlayer;
    private Stack stackGioco = new Stack();

    // costruttore privato
    private Gioco() {
    }

    // inizializzazione dei giocatori, dei loro mazzi e della mano iniziale di ciascun giocatore
    public void prepare() {
        // riempio mazzo player 1 e 2 con 20 carte
        for (int i = 0; i < 20; i++) {
            player1.riempiMazzo(new Omeopathy());
            player2.riempiMazzo(new Omeopathy());
        }

        player1.pescaInizio();   // pesco 5 carte player 1
        player2.pescaInizio();   // pesco 5 carte player 2
        currentPlayer = player1;
        opponentPlayer = player2;
        play();
        /* COMINCIA IL GIOCO */
    }

    /**
     * I giocatori alternano i loro turni inserendo le varie fasi di gioco che
     * andranno poi ad eseguire estraendole una alla volta dall'oggetto
     * GestoreFasi che hanno come proprietà, inoltre alla fine di ogni fase
     * viene controllato se uno dei due giocatori ha la vita minore o uguale a
     * 0, quindi se uno dei due player ha perso. Dopo il "reset delle fasi i
     * trigger che conterranno gli effetti delle carte di ciascun giocatore che
     * influenzano il gioco verranno attivate. Questa parte non è stata ancora
     * implementata dato che non avendo gli effetti di nessuna carta e quindi la
     * possibilità di testare questa funzionalità non ci sembra una cosa
     * importante per lo sviluppo di questa prima parte
     */
    public void play() {
        boolean end = false;
        currentPlayer.fasi.fasiNormali();
        opponentPlayer.fasi.fasiNormali();

        while (!end) {
            System.out.println("\nGiocatore " + currentPlayer.getNome() + " è il tuo turno!");
            Fase f1 = currentPlayer.fasi.popFase();
            while (f1 != null) {
                f1.playFase();
                f1 = currentPlayer.fasi.popFase();
                if (currentPlayer.getHp() <= 0 || opponentPlayer.getHp() <= 0) {
                    f1 = null;
                    end = true;
                }
            }

            if (!end) {
                Giocatore tmp = currentPlayer;
                currentPlayer = opponentPlayer;
                opponentPlayer = tmp;
            }
            opponentPlayer.fasi.fasiNormali();

            /*TRIGGER EFFETTI*/
        }
    }

    // funzione per prendere un input dalla tastiera di tipo int per la selezione nei menu
    public int rispostaGiocatore() {
        Scanner input = new Scanner(System.in);
        int x = input.nextInt();
        return x;
    }

    private static class Instance {

        private static final Gioco istanza = new Gioco();

    }

    public static Gioco getInstance() {
        return Instance.istanza;
    }

    public Giocatore getPlayer1() {
        return player1;
    }

    public Giocatore getPlayer2() {
        return player2;
    }

    public Giocatore getCurrentPlayer() {
        return currentPlayer;
    }

    public Giocatore getOpponentPlayer() {
        return opponentPlayer;
    }

    public Stack getStackGioco() {
        return stackGioco;
    }

}
