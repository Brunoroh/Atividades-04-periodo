/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.TelaPrincipalController;
import java.io.File;
import java.util.Iterator;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Aluno;

/**
 *
 * @author brunoroh
 */
public class TelaPrincipal extends javax.swing.JFrame {

    private JFileChooser chooser;
    private String caminhoDoArquivo = "";
    private File arquivo = null;
    private TelaPrincipalController controller;
    private DefaultTableModel model;
    
    public TelaPrincipal() {
        initComponents();
        chooser = new JFileChooser("/home/brunoroh/Documents/Workspace/Faculdade/Netbeans/Padroes de Projeto/ListagemDeItens/src/dados/");
        controller = new TelaPrincipalController();
        model = (DefaultTableModel) tbAlunos.getModel();  
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnListarArrayList = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbAlunos = new javax.swing.JTable();
        ListarArvore = new javax.swing.JButton();
        ListarPilha = new javax.swing.JButton();
        ListarFila = new javax.swing.JButton();
        ListarSet = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Listagem de Itens");

        btnListarArrayList.setText("Listar ArrayList");
        btnListarArrayList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarArrayListActionPerformed(evt);
            }
        });

        tbAlunos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Matricula", "Curso", "Nome", "Disciplina"
            }
        ));
        jScrollPane2.setViewportView(tbAlunos);

        ListarArvore.setText("Listar Arvore");
        ListarArvore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ListarArvoreActionPerformed(evt);
            }
        });

        ListarPilha.setText("Listar Pilha");
        ListarPilha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ListarPilhaActionPerformed(evt);
            }
        });

        ListarFila.setText("Listar Fila");
        ListarFila.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ListarFilaActionPerformed(evt);
            }
        });

        ListarSet.setText("Listar Set");
        ListarSet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ListarSetActionPerformed(evt);
            }
        });

        btnLimpar.setText("Limpar");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 811, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnLimpar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ListarSet)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ListarFila)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ListarPilha)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ListarArvore)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnListarArrayList, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnListarArrayList)
                    .addComponent(ListarArvore)
                    .addComponent(ListarPilha)
                    .addComponent(ListarFila)
                    .addComponent(ListarSet)
                    .addComponent(btnLimpar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnListarArrayListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarArrayListActionPerformed
        int retorno = chooser.showOpenDialog(null);
        if (retorno==JFileChooser.APPROVE_OPTION){
            caminhoDoArquivo = chooser.getSelectedFile().getAbsolutePath(); 
        }
        Iterator alunos = controller.lerArquivoArrayList(caminhoDoArquivo);
        carregarTable(alunos);
    }//GEN-LAST:event_btnListarArrayListActionPerformed

    private void ListarArvoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ListarArvoreActionPerformed
        int retorno = chooser.showOpenDialog(null);
        if (retorno==JFileChooser.APPROVE_OPTION){
            caminhoDoArquivo = chooser.getSelectedFile().getAbsolutePath(); 
        }
        Iterator alunos = controller.lerArquivoArvore(caminhoDoArquivo);
        carregarTable(alunos);
    }//GEN-LAST:event_ListarArvoreActionPerformed

    private void ListarPilhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ListarPilhaActionPerformed
        int retorno = chooser.showOpenDialog(null);
        if (retorno==JFileChooser.APPROVE_OPTION){
            caminhoDoArquivo = chooser.getSelectedFile().getAbsolutePath(); 
        }
        Iterator alunos = controller.lerArquivoPilha(caminhoDoArquivo);
        carregarTable(alunos);
    }//GEN-LAST:event_ListarPilhaActionPerformed

    private void ListarFilaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ListarFilaActionPerformed
        int retorno = chooser.showOpenDialog(null);
        if (retorno==JFileChooser.APPROVE_OPTION){
            caminhoDoArquivo = chooser.getSelectedFile().getAbsolutePath(); 
        }
        Iterator alunos = controller.lerArquivoFila(caminhoDoArquivo);
        carregarTable(alunos);
    }//GEN-LAST:event_ListarFilaActionPerformed

    private void ListarSetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ListarSetActionPerformed
        int retorno = chooser.showOpenDialog(null);
        if (retorno==JFileChooser.APPROVE_OPTION){
            caminhoDoArquivo = chooser.getSelectedFile().getAbsolutePath(); 
        }
        Iterator alunos = controller.lerArquivoSet(caminhoDoArquivo);
        carregarTable(alunos);
    }//GEN-LAST:event_ListarSetActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        limparTable();
    }//GEN-LAST:event_btnLimparActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }
    
    private void carregarTable(Iterator alunos){
        limparTable();
        while(alunos.hasNext()){
            Aluno aluno = (Aluno)alunos.next();
            model.addRow(new Object[]{aluno.getMatricula(),
                aluno.getMatricula().getNomeCurso(),
                aluno.getNome(),
                aluno.getDisciplinas()});
        }
    }
    
    private void limparTable(){
        model.setNumRows(0);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ListarArvore;
    private javax.swing.JButton ListarFila;
    private javax.swing.JButton ListarPilha;
    private javax.swing.JButton ListarSet;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnListarArrayList;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tbAlunos;
    // End of variables declaration//GEN-END:variables
}
