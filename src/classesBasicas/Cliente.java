/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classesBasicas;

import java.util.ArrayList;

/**
 *
 * @author thade
 */
public class Cliente {

    private String nome;
    private String cpf;
    private String endereco;
    private ArrayList<NotaFiscal> nota;

    public Cliente() {
        this.nota = new ArrayList<>();
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * @return the endereco
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     * @param endereco the endereco to set
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    /**
     * @return the nota
     */
    public ArrayList<NotaFiscal> getNota() {
        return nota;
    }

    /**
     * @param nota the nota to set
     */
    public void setNota(ArrayList<NotaFiscal> nota) {
        this.nota = nota;
    }
}
