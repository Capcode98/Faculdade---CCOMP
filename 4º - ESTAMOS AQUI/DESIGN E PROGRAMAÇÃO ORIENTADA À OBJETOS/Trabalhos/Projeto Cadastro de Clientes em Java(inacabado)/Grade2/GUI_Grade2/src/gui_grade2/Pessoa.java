/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui_grade2;

/**
 *
 * @author ckenn
 */
public class Pessoa {
    private String nome;
    private String telefone;
    
    public String obterNome(){
        return nome;
    }
    
    public String obterTelefone(){
        return telefone;
    }
    
    public void atualizarNome(String  nome){
       this.nome = nome; 
    }
    
    public void atualizarTelefone(String telefone){
        this.telefone = telefone;
    }
    
}
