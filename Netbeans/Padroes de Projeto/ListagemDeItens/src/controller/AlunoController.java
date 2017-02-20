/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import model.Aluno;
import model.Disciplina;
import model.Matricula;


public class AlunoController {
    
    MatriculaController matriculaController;
    DisciplinaController disciplinaController;
   
    public AlunoController() {
        matriculaController = new MatriculaController();
        disciplinaController = new DisciplinaController();
    }

    public Aluno criarAluno(String linha){
        String[] valoresLinha = linha.split(";");
        Matricula matricula = matriculaController.criarMatricula(valoresLinha[0]);
        String nome = valoresLinha[1];
        List<Disciplina> disciplina = disciplinaController.CriarListaDisciplinas(valoresLinha[2]);
        return new Aluno(matricula,nome,disciplina);
    };
}
