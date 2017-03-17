package Magic;

import Cards.Omeopathy;
import Phases.Fase;
import java.util.Scanner;

public class Gioco {   // SINGLETON

    private Giocatore player1 = new Giocatore("player1");
    private Giocatore player2 = new Giocatore("player2");
    private Giocatore currentPlayer;
    private Giocatore opponentPlayer;
    private Stack stackGioco = new Stack();

    private Gioco() {
    }  //COSTRUTTORE PRIVATO

    /*inizializzazione dei giocatori, dei loro mazzi e della mano iniziale di ciascun giocatore*/
    public void prepare() {
        //riempio mazzo player 1-2
        for (int i = 0; i < 20; i++) {
            player1.riempiMazzo(new Omeopathy());
            player2.riempiMazzo(new Omeopathy());
        }

        player1.pescaInizio();   // pesco 5 carte player 1
        player2.pescaInizio();   // pesco 5 carte player 2
        currentPlayer = player1;
        opponentPlayer = player2;
        play();
        /*COMINCIA IL GIOCO*/
    }

    /*i giocatori si alternano inserendo le varie fasi di gioco che andranno poi
    ad eseguire estraendole dall'oggetto GestoreFasi che hanno come proprietà, inoltre 
    alla fine di ogni fase viene controllato se uno dei due giocatori ha la vita <= 0, quindi
    se uno dei due player ha perso*/
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

    /*funzione per prendere un input dalla tastiera di tipo int per la selezione nei menu*/
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
