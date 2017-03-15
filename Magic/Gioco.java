package Magic;

import Cards.Omeopathy;

    public class Gioco {   // SINGLETON
    private Giocatore player1 = new Giocatore("player1");
    private Giocatore player2 = new Giocatore("player2");
    
    private Gioco() {  //COSTRUTTORE PRIVATO
       
    }
    public void prepare(){
        //riempio mazzo player 1
        for (int i=0; i<20;i++){
            Carta temp1=new Omeopathy();
            player1.riempiMazzo(temp1);     
        }
        // riempio mazzo player 2
        for(int i=0; i<20;i++){
            Carta temp2=new Omeopathy();
            player2.riempiMazzo(temp2);
        }
        player1.pescaInizio();   // pesco 5 carte player 1
        player2.pescaInizio();   // pesco 5 carte player 2
        player1.hand.stampaMano();
        
        
       
    }
    private static class Instance {

        private static Gioco istanza = new Gioco();
    }

    public static Gioco getInstance() {
       return Instance.istanza;
    }
}
