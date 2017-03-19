package Magic;

/*Avvio del gioco, chiamata del metodo principale Gioco creato con un singleton*/
public class Magic {

    public static void main(String argv[]) {
        Gioco gioco = Gioco.getInstance();
        gioco.prepare();
    }

}
