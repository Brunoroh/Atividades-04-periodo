    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author brunoroh
 */
public class AlunoDao {
    
    
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
        LinkedList<String> linhas = new LinkedList<>();
        
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
        LinkedList<String> linhas = new LinkedList<>();
        
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
        Set<String> linhas = new LinkedHashSet<>();
        
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
