package Magic;

/**
 *
 * @author Davide
 */
public abstract class GenericaCarta implements Carta {

    private String effetto;
    private final String nome;
    private String tipo;

    public GenericaCarta(String nome, String effetto, String tipo) {
        this.nome = nome;
        this.effetto = effetto;
        this.tipo = tipo;
    }

    @Override
    public String getInfo() {
        return this.getNome() + ", " + "Istantanea" + ", " + effetto;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public String getEffetto() {
        return effetto;
    }

}
