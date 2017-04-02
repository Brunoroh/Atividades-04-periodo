package dao;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

public class AlunoDao {
    //adicionar metodo que trabalha com LIST
    public Iterator lerArquivoArrayList(String caminhoDoArquivo){
        ArrayList<String> linhas = new ArrayList<>();
        
        try {
            FileReader arquivo = new FileReader(caminhoDoArquivo);
            Scanner lerArquivo = new Scanner(arquivo);
            String linha;

            while(lerArquivo.hasNextLine()){
                linhas.add(lerArquivo.nextLine()); 
            }
            arquivo.close();
        } catch (IOException e) {
              e.printStackTrace();
        }
        return linhas.iterator();
    }
    
    public Iterator lerArquivoFila(String caminhoDoArquivo){
        Queue<String> linhas = new LinkedList<String>();
        
        try {
            FileReader arquivo = new FileReader(caminhoDoArquivo);
            Scanner lerArquivo = new Scanner(arquivo);
            String linha;

            while(lerArquivo.hasNextLine()){
                linhas.add(lerArquivo.nextLine()); 
            }
            arquivo.close();
        } catch (IOException e) {
              e.printStackTrace();
        }
        return linhas.iterator();
    }
    
    public Iterator lerArquivoPilha(String caminhoDoArquivo){
        Stack<String> linhas = new Stack<String>(); 
        
        try {
            FileReader arquivo = new FileReader(caminhoDoArquivo);
            Scanner lerArquivo = new Scanner(arquivo);
            String linha;
            while(lerArquivo.hasNextLine()){
                linhas.push(lerArquivo.nextLine()); 
            }
            arquivo.close();
        } catch (IOException e) {
              e.printStackTrace();
        }
        return linhas.iterator();
    }
    
    public Iterator lerArquivoSet(String caminhoDoArquivo){
        TreeSet<String> linhas = new TreeSet<>();
        
        try {
            FileReader arquivo = new FileReader(caminhoDoArquivo);
            Scanner lerArquivo = new Scanner(arquivo);
            String linha;

            while(lerArquivo.hasNextLine()){
                linhas.add(lerArquivo.nextLine()); 
            }

            arquivo.close();
        } catch (IOException e) {
              e.printStackTrace();
        }
        return linhas.iterator();
    }
    
    public Iterator lerArquivoArvore(String caminhoDoArquivo){
        Set<String> linhas = new TreeSet<>();
        
        try {
            FileReader arquivo = new FileReader(caminhoDoArquivo);
            Scanner lerArquivo = new Scanner(arquivo);
            String linha;

            while(lerArquivo.hasNextLine()){
                linhas.add(lerArquivo.nextLine()); 
            }

            arquivo.close();
        } catch (IOException e) {
              e.printStackTrace();
        }
        return linhas.iterator();
    }
    
    
}
