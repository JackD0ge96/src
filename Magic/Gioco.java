package Magic;

import Cards.Omeopathy;
import Phases.Fase;

public class Gioco {   // SINGLETON

    private Giocatore player1 = new Giocatore("player1");
    private Giocatore player2 = new Giocatore("player2");
    private Giocatore currentPlayer;
    private Giocatore opponentPlayer;

    private Gioco() {
    }  //COSTRUTTORE PRIVATO

    public void prepare() {
        //riempio mazzo player 1-2
        for (int i = 0; i < 20; i++) {
            player1.riempiMazzo(new Omeopathy());
            player2.riempiMazzo(new Omeopathy());
        }

        player1.pescaInizio();   // pesco 5 carte player 1
        player2.pescaInizio();   // pesco 5 carte player 2
        player1.hand.stampaMano();
        currentPlayer = player1;
        opponentPlayer = player2;
        play();
    }

    private static class Instance {

        private static Gioco istanza = new Gioco();
    }

    public static Gioco getInstance() {
        return Instance.istanza;
    }

    public Giocatore getPlayer1() {
        return player1;
    }

    public void setPlayer1(Giocatore player1) {
        this.player1 = player1;
    }

    public Giocatore getPlayer2() {
        return player2;
    }

    public void setPlayer2(Giocatore player2) {
        this.player2 = player2;
    }

    public Giocatore getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(Giocatore currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public Giocatore getOpponentPlayer() {
        return opponentPlayer;
    }

    public void setOpponentPlayer(Giocatore opponentPlayer) {
        this.opponentPlayer = opponentPlayer;
    }

    public void play() {
        boolean end = false;
        currentPlayer.fasi.fasiNormali();
        opponentPlayer.fasi.fasiNormali();
        while (!end) {
            Fase f1 = currentPlayer.fasi.popFase();
            while (f1 != null) {
                f1.playFase();
                f1 = currentPlayer.fasi.popFase();
                if (currentPlayer.getHp() <= 0 || opponentPlayer.getHp() <= 0) {
                    f1 = null;
                    end = true;
                }
            }
            
            /* DEBUG
            System.out.println("current player:" + currentPlayer.getNome());
            currentPlayer.hand.stampaMano();
            System.out.println();*/
            
            if (!end) {
                Giocatore player = currentPlayer;
                currentPlayer = opponentPlayer;
                opponentPlayer = player;
            }
            currentPlayer.fasi.fasiNormali();
            opponentPlayer.fasi.fasiNormali();
            
            /*TRIGGER EFFETTI*/
        }
    }
}
