/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import classededados.Aluno;

/**
 *
 * @author eugeniojulio
 */
public class OrdenadoPorCursoNome extends AlunoPersistencia {

    public OrdenadoPorCursoNome(String nome) {
        super(nome);
    }
    @Override
    public  boolean ePrimeiro(Aluno aluno1, Aluno aluno2){
        if (aluno1.getCurso().compareToIgnoreCase(aluno2.getCurso()) == 0){
            if(aluno1.getNome().compareToIgnoreCase(aluno2.getNome())<=0){
                return false;
            }
            else{
                return true;
            }
        }else if(aluno1.getCurso().compareToIgnoreCase(aluno2.getCurso()) < 0){
            return true;
        }else {
            return false;
        }
    }
}
