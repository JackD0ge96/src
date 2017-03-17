package Magic;

/**
 *
 * @author Davide
 */
public abstract class GenericaCarta implements Carta {

    private final String effetto;
    private final String nome;
    private final String tipo;

    public GenericaCarta(String nome, String effetto, String tipo) {
        this.nome = nome;
        this.effetto = effetto;
        this.tipo = tipo;
    }

    @Override
    public String getInfo() {
        if(this != null)
            return nome + ", " + effetto + ", " + tipo;
        else 
            return null;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public String getEffetto() {
        return effetto;
    }

    @Override
    public String getTipo() {
        return tipo;
    }
    
}
