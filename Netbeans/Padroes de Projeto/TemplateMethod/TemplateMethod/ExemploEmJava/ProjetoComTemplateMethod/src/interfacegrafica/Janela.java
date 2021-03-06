/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package interfacegrafica;

import javax.swing.JOptionPane;
import java.util.Iterator;
import classededados.Aluno;
import javax.swing.table.DefaultTableModel;
import persistencia.AlunoPersistencia;
import persistencia.OrdenadoPorCursoEnfaseNome;
import persistencia.OrdenadoPorCursoNome;
import persistencia.OrdenadoPorCursoSituacaoEnfaseNome;
import persistencia.OrdenadoPorCursoSituacaoNome;
import persistencia.OrdenadoPorEnfaseSituacaoCursoNome;
import persistencia.OrdenadoPorNome;

/**
 *
 * @author eugeniojulio
 */
public class Janela extends javax.swing.JFrame {

    /**
     * Creates new form Janela
     */
    public Janela() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableGridAlunos = new javax.swing.JTable();
        btnOrdenarPorCursoENome = new javax.swing.JToggleButton();
        jToggleButton2 = new javax.swing.JToggleButton();
        btnOrdenarPorCursoENome1 = new javax.swing.JToggleButton();
        btnOrdenarPorCursoENome2 = new javax.swing.JToggleButton();
        btnOrdenarPorCursoENome3 = new javax.swing.JToggleButton();
        btnOrdenarPorCursoENome4 = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("LISTA DE ALUNOS");

        jTableGridAlunos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "CURSO", "NOME", "SITUACAO", "ENFASE"
            }
        ));
        jScrollPane1.setViewportView(jTableGridAlunos);

        btnOrdenarPorCursoENome.setText("Ordenar Por Curso e Nome");
        btnOrdenarPorCursoENome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrdenarPorCursoENomeActionPerformed(evt);
            }
        });

        jToggleButton2.setText("Ordenar Por Nome");
        jToggleButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton2ActionPerformed(evt);
            }
        });

        btnOrdenarPorCursoENome1.setText("Ordenar Por Curso, Situação e Nome");
        btnOrdenarPorCursoENome1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrdenarPorCursoENome1ActionPerformed(evt);
            }
        });

        btnOrdenarPorCursoENome2.setText("Ordenar Por Curso, Enfase e Nome");
        btnOrdenarPorCursoENome2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrdenarPorCursoENome2ActionPerformed(evt);
            }
        });

        btnOrdenarPorCursoENome3.setText("Ordenar Por Curso, Situação, Enfase e Nome");
        btnOrdenarPorCursoENome3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrdenarPorCursoENome3ActionPerformed(evt);
            }
        });

        btnOrdenarPorCursoENome4.setText("Ordenar Por Enfase, Situação, Curso, Nome");
        btnOrdenarPorCursoENome4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrdenarPorCursoENome4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jToggleButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnOrdenarPorCursoENome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnOrdenarPorCursoENome1))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnOrdenarPorCursoENome2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnOrdenarPorCursoENome3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnOrdenarPorCursoENome4)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jToggleButton2)
                    .addComponent(btnOrdenarPorCursoENome)
                    .addComponent(btnOrdenarPorCursoENome1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnOrdenarPorCursoENome2)
                    .addComponent(btnOrdenarPorCursoENome3)
                    .addComponent(btnOrdenarPorCursoENome4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void imprimirNaGrid(Iterator<Aluno> dados){
        try{
            DefaultTableModel model =  (DefaultTableModel) jTableGridAlunos.getModel();
            model.setNumRows(0);
            while(dados.hasNext()){
                String[] linha = new String[4];
                Aluno obj = dados.next();
                linha[0]= obj.getCurso();
                linha[1]= obj.getNome();
                linha[2]= obj.getSituacao();
                linha[3]= obj.getEnfase();
                model.addRow(linha);
            }
        }catch(Exception erro){
            JOptionPane.showMessageDialog(rootPane, erro);
        }
    }
    private void btnOrdenarPorCursoENomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrdenarPorCursoENomeActionPerformed
        // TODO add your handling code here:
        try{
            String nome = "/home/brunoroh/Documents/Atividades/Eugenio/TemplateMethod/TemplateMethod/ExemploEmJava/ProjetoComTemplateMethod/src/dados/RelatorioDasEnfases.csv";
            OrdenadoPorNome objeto = new OrdenadoPorNome(nome);
            imprimirNaGrid(objeto.listagemDeAlunosNome());
        }catch(Exception erro){
            JOptionPane.showMessageDialog(rootPane, erro);
        }
    }//GEN-LAST:event_btnOrdenarPorCursoENomeActionPerformed

    private void jToggleButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton2ActionPerformed
        try{
            String nome = "/home/brunoroh/Documents/Atividades/Eugenio/TemplateMethod/TemplateMethod/ExemploEmJava/ProjetoComTemplateMethod/src/dados/RelatorioDasEnfases.csv";
            AlunoPersistencia objeto = new OrdenadoPorCursoNome(nome);
            imprimirNaGrid(objeto.listagemDeAlunosNome());
        }catch(Exception erro){
            JOptionPane.showMessageDialog(rootPane, erro);
        }
    }//GEN-LAST:event_jToggleButton2ActionPerformed

    private void btnOrdenarPorCursoENome1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrdenarPorCursoENome1ActionPerformed
        try{
            String nome = "/home/brunoroh/Documents/Atividades/Eugenio/TemplateMethod/TemplateMethod/ExemploEmJava/ProjetoComTemplateMethod/src/dados/RelatorioDasEnfases.csv";
            AlunoPersistencia objeto = new OrdenadoPorCursoSituacaoNome(nome);
            imprimirNaGrid(objeto.listagemDeAlunosNome());
        }catch(Exception erro){
            JOptionPane.showMessageDialog(rootPane, erro);
        }
    }//GEN-LAST:event_btnOrdenarPorCursoENome1ActionPerformed

    private void btnOrdenarPorCursoENome2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrdenarPorCursoENome2ActionPerformed
        try{
            String nome = "/home/brunoroh/Documents/Atividades/Eugenio/TemplateMethod/TemplateMethod/ExemploEmJava/ProjetoComTemplateMethod/src/dados/RelatorioDasEnfases.csv";
            AlunoPersistencia objeto = new OrdenadoPorCursoEnfaseNome(nome);
            imprimirNaGrid(objeto.listagemDeAlunosNome());
        }catch(Exception erro){
            JOptionPane.showMessageDialog(rootPane, erro);
        }
    }//GEN-LAST:event_btnOrdenarPorCursoENome2ActionPerformed

    private void btnOrdenarPorCursoENome3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrdenarPorCursoENome3ActionPerformed
        try{
            String nome = "/home/brunoroh/Documents/Atividades/Eugenio/TemplateMethod/TemplateMethod/ExemploEmJava/ProjetoComTemplateMethod/src/dados/RelatorioDasEnfases.csv";
            AlunoPersistencia objeto = new OrdenadoPorCursoSituacaoEnfaseNome(nome);
            imprimirNaGrid(objeto.listagemDeAlunosNome());
        }catch(Exception erro){
            JOptionPane.showMessageDialog(rootPane, erro);
        }
    }//GEN-LAST:event_btnOrdenarPorCursoENome3ActionPerformed

    private void btnOrdenarPorCursoENome4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrdenarPorCursoENome4ActionPerformed
        try{
            String nome = "/home/brunoroh/Documents/Atividades/Eugenio/TemplateMethod/TemplateMethod/ExemploEmJava/ProjetoComTemplateMethod/src/dados/RelatorioDasEnfases.csv";
            AlunoPersistencia objeto = new OrdenadoPorEnfaseSituacaoCursoNome(nome);
            imprimirNaGrid(objeto.listagemDeAlunosNome());
        }catch(Exception erro){
            JOptionPane.showMessageDialog(rootPane, erro);
        }
    }//GEN-LAST:event_btnOrdenarPorCursoENome4ActionPerformed

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
            java.util.logging.Logger.getLogger(Janela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Janela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Janela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Janela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Janela().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnOrdenarPorCursoENome;
    private javax.swing.JToggleButton btnOrdenarPorCursoENome1;
    private javax.swing.JToggleButton btnOrdenarPorCursoENome2;
    private javax.swing.JToggleButton btnOrdenarPorCursoENome3;
    private javax.swing.JToggleButton btnOrdenarPorCursoENome4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableGridAlunos;
    private javax.swing.JToggleButton jToggleButton2;
    // End of variables declaration//GEN-END:variables
}
