package projetodecoratointernet;

public class CanaisDeFilme extends Canais {

    private Plano plano;

    public CanaisDeFilme(Plano plano) {
        this.plano = plano;
    }
    
    @Override
    public String getDescricao() {
        return plano.getDescricao()+" + Pacote de canais de Filme";
    }

    @Override
    public double valor() {
        return plano.valor()+40;
    }
    
}
