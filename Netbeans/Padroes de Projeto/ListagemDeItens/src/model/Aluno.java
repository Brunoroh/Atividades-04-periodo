package model;

import java.util.List;

public class Aluno implements Comparable<Aluno> {
    // matricula - ano , semestre , curso e numero
    //2001.1.028.2017;ROBERTO MENDONCA VASCONCELLOS;CMP1062-C01
    private Matricula matricula;
    private String nome;
    private List<Disciplina> disciplinas;
    
    public Aluno(){}

    public Aluno(Matricula matricula, String nome, List<Disciplina> disciplinas) {
        this.matricula = matricula;
        this.nome = nome;
        this.disciplinas = disciplinas;
    }

    public Matricula getMatricula() {
        return matricula;
    }

    public void setMatricula(Matricula matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

    @Override
    public String toString() {
        return "Aluno{" + "matricula=" + matricula + ", nome=" + nome + ", disciplinas=" + disciplinas + '}';
    }

    @Override
    public int compareTo(Aluno o) {
        return  nome.compareTo(o.getNome());
    }
}
