/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui_grade2;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ckenn
 */
public class ModeloTabelaPessoa extends AbstractTableModel {
   private static final int COLUNA_NOME = 0;
   private static final int COLUNA_TELEFONE =1;
   
   private String colunas[] = new String[]{"Nome","Telefone"};
   private ArrayList<Pessoa> pessoas;
   
   public ModeloTabelaPessoa(ArrayList<Pessoa> pessoas){
       this.pessoas = new ArrayList<Pessoa>(pessoas);
   }
   
   @Override
   public int getColumnCount(){
       return colunas.length;
   }
   
   @Override
   public int getRowCount(){
       return pessoas.size();
   }
   
   @Override
   public String getColumnName(int indiceColuna){
       return colunas[indiceColuna];
   }
   
   @Override
   public boolean isCellEditable(int indiceLinha, int indiceColuna){
       return false;
   }
   
   @Override
   public Object getValueAt(int indiceLinha, int indiceColuna){
       Pessoa pessoa = pessoas.get(indiceLinha);
       switch (indiceColuna){
           case COLUNA_NOME :
               return pessoa.obterNome();
           case COLUNA_TELEFONE:
               return pessoa.obterTelefone();
       }
       return "";
   }
   
   @Override
   public void setValueAt(Object valor, int indiceLinha, int indiceColuna){
       Pessoa pessoa = pessoas.get(indiceLinha);
       switch (indiceColuna){
           case COLUNA_NOME:
               pessoa.atualizarNome(valor.toString());
               break;
           case COLUNA_TELEFONE:
               pessoa.atualizarTelefone(valor.toString());
               break;
       }
   }
   
   public Pessoa obterPessoa(int indicePessoa){
       return pessoas.get(indicePessoa);
   }
   
   public void incluirPessoa(Pessoa pessoa){
       pessoas.add(pessoa);
       int ultimo = getRowCount()-1;
       fireTableRowsInserted (ultimo, ultimo);
   }
   
   public void atualizarPessoa(int indicePessoa, Pessoa pessoa){
       pessoas.set(indicePessoa, pessoa);
       fireTableRowsUpdated(indicePessoa,indicePessoa);
   }
   
   public void excluirPessoa(int indicePessoa){
       pessoas.remove(indicePessoa);
       fireTableRowsDeleted(indicePessoa, indicePessoa);
   }
   
   
}
