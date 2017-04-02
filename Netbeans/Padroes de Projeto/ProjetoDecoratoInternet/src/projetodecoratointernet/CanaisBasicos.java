package projetodecoratointernet;

public class CanaisBasicos extends Canais {

    private Plano plano;

    public CanaisBasicos(Plano plano) {
        this.plano = plano;
    }
    
    @Override
    public String getDescricao() {
        return plano.getDescricao()+" + Pacote básico de canais";
    }

    @Override
    public double valor() {
        return plano.valor()+20;
    }


    
}
