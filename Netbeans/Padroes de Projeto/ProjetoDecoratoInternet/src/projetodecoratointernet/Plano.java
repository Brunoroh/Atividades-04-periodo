package projetodecoratointernet;

public abstract class Plano {
    
    protected String descricao = "Internet";

    public String getDescricao() {
        return descricao;
    }
    
    public abstract double valor();
}
