package projetodecoratointernet;

public class ProjetoDecoratoInternet {

    public static void main(String[] args) {
        
        Plano plano1 = new PlanoPlus();
        
        System.out.println("**** Plano 1 ******");
        System.out.println("---------------");
        System.out.println("Plano : "+ plano1.getDescricao());
        System.out.println("Preco : "+ plano1.valor());
        System.out.println("---------------");
        
        plano1 = new CanaisBasicos(plano1);
        System.out.println("---------------");
        System.out.println("Plano : "+ plano1.getDescricao());
        System.out.println("Preco : "+ plano1.valor());
        System.out.println("---------------");
        
        
        plano1 = new CanaisDeFilme(plano1);
        System.out.println("---------------");
        System.out.println("Plano : "+ plano1.getDescricao());
        System.out.println("Preco : "+ plano1.valor());
        System.out.println("---------------");
        
        System.out.println("**** Plano 2 ******");
        
        Plano plano2 = new PlanoPremium();
        System.out.println("---------------");
        System.out.println("Plano : "+ plano2.getDescricao());
        System.out.println("Preco : "+ plano2.valor());
        System.out.println("---------------");
        
        plano2 = new CanaisDeEsporte(plano2);
        System.out.println("---------------");
        System.out.println("Plano : "+ plano2.getDescricao());
        System.out.println("Preco : "+ plano2.valor());
        System.out.println("---------------");

        plano2 = new CanaisDeFilme(plano2);
        System.out.println("---------------");
        System.out.println("Plano : "+ plano2.getDescricao());
        System.out.println("Preco : "+ plano2.valor());
        System.out.println("---------------");

    }
    
}
