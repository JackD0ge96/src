package Magic;

import Cards.Omeopathy;

public class Gioco {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Giocatore player1 = new Giocatore("Giocatore1");
        
        for (int i = 0; i < 20; i++) {
            Carta temp = new Omeopathy();
            player1.riempiMazzo(temp);
        }
        
        player1.pescaInizio();
        
        while(player1.getHp() > 0){
            player1.checkScarta();
            System.out.println(player1.dimensioneMazzo());
            System.out.println(player1.numeroCarteMano());
            player1.aggiungiCarta();
            player1.checkScarta();
        }    
    }
}
