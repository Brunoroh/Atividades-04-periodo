package controller;

import java.util.ArrayList;
import java.util.List;
import model.Disciplina;

public class DisciplinaController {
    
    private Disciplina criarDisciplina(String linha){
        Disciplina disciplina = new Disciplina();
        String[] valoresString = linha.split("-");
        disciplina.setCodigo(valoresString[0]);
        disciplina.setTurma(valoresString[1]);
        return disciplina;
    }
    
    public List<Disciplina> CriarListaDisciplinas(String linha){
        List<Disciplina> lista = new ArrayList<>();
        String[] valoresString = linha.split("  ");
        for (String disciplina : valoresString) {
            lista.add(criarDisciplina(disciplina));
        }
        return lista;
    };
    
    
}
