
package controller;

import model.Matricula;

public class MatriculaController {
    
    
    public Matricula criarMatricula(String linha){
        Matricula matricula = new Matricula();
        String[] valoresString = linha.split("\\.");
        matricula.setAno(Integer.parseInt(valoresString[0]));
        matricula.setSemestre(Integer.parseInt(valoresString[1]));
        matricula.setCurso(Integer.parseInt(valoresString[2]));
        matricula.setNumero(Integer.parseInt(valoresString[3]));
        return matricula;
    }
}
