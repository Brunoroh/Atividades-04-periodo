
package model;
//28 - ciencia da computação
//33 - Engenharia da Computação
//48 - Engenharia de Software
public class Matricula {
   
    private int ano;
    private int semestre;
    private int curso;
    private int numero;

    public String getNomeCurso(){
        if(curso == 28){
            return "Ciencia da Computação";
        }else if(curso == 33){
            return "Engenharia da Computação";
        }else if(curso == 48){
            return "Engenharia de Software";
        }else{
            return "Codigo de curso inválido.";
        }
    }
    
    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public int getCurso() {
        return curso;
    }

    public void setCurso(int curso) {
        this.curso = curso;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return ano+"."+semestre+"."+curso+"."+numero;
    }
    
    
}
