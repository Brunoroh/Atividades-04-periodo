package controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import model.Aluno;
import dao.AlunoDao;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;


public class TelaPrincipalController {

    
    MatriculaController matriculaController;
    DisciplinaController disciplinaController;
    AlunoController alunoController;
    
    public TelaPrincipalController() {
        
        matriculaController = new MatriculaController();
        disciplinaController = new DisciplinaController();
        alunoController = new AlunoController();
    }
    
    public Iterator lerArquivoArrayList(String caminhoDoArquivo) {
        
        AlunoDao dao = new AlunoDao();
        Iterator iterator = dao.lerArquivoArrayList(caminhoDoArquivo);
        return ordenarArrayList(iterator);
    }
    
    public Iterator lerArquivoFila(String caminhoDoArquivo) {
        
        AlunoDao dao = new AlunoDao();
        Iterator iterator = dao.lerArquivoFila(caminhoDoArquivo);
        return ordenarFila(iterator);
    } 
    
    public Iterator lerArquivoPilha(String caminhoDoArquivo) {
        
        AlunoDao dao = new AlunoDao();
        Iterator iterator = dao.lerArquivoPilha(caminhoDoArquivo);
        return ordenarPilha(iterator);
    } 
    
    public Iterator lerArquivoSet(String caminhoDoArquivo) {
        
        AlunoDao dao = new AlunoDao();
        Iterator iterator = dao.lerArquivoSet(caminhoDoArquivo);
        return ordenarSet(iterator);
    } 
    
    public Iterator lerArquivoArvore(String caminhoDoArquivo) {
        
        AlunoDao dao = new AlunoDao();
        Iterator iterator = dao.lerArquivoArvore(caminhoDoArquivo);
        return ordenarArvore(iterator);
    }
    
    public Iterator ordenarArrayList(Iterator iterator){
        ArrayList<Aluno> alunos = new ArrayList<>();
        while(iterator.hasNext()){
            alunos.add(alunoController.criarAluno((String)iterator.next())); 
        }
        Collections.sort(alunos);
        return alunos.iterator();
    }
    
    
    
    public Iterator ordenarFila(Iterator iterator){
        Queue<Aluno> alunos = new LinkedList<Aluno>();
        while(iterator.hasNext()){
            alunos.add(alunoController.criarAluno((String)iterator.next())); 
        }
        //Collections.sort(alunos);
        return alunos.iterator();
    }
    
    public Iterator ordenarPilha(Iterator iterator){
        Stack<Aluno> alunos = new Stack<Aluno>();
        while(iterator.hasNext()){
            alunos.add(alunoController.criarAluno((String)iterator.next())); 
        }
        Collections.sort(alunos);
        return alunos.iterator();
    }
    
    public Iterator ordenarSet(Iterator iterator){
        Set<Aluno> alunos = new LinkedHashSet<>();
        while(iterator.hasNext()){
            alunos.add(alunoController.criarAluno((String)iterator.next())); 
        }
        return alunos.iterator();
    }
    
    public Iterator ordenarArvore(Iterator iterator){
        Set<Aluno> alunos = new TreeSet<>();
        while(iterator.hasNext()){
            alunos.add(alunoController.criarAluno((String)iterator.next())); 
        }
        return alunos.iterator();
    }
}
