package projetodecoratointernet;

public class CanaisDeEsporte extends Canais {

    private Plano plano;

    public CanaisDeEsporte(Plano plano) {
        this.plano = plano;
    }
    
    @Override
    public String getDescricao() {
        return plano.getDescricao()+" + Pacote de Canais de Esporte";
    }

    @Override
    public double valor() {
        return plano.valor()+25;
    }
    
}
