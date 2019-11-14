package classesBasicas;

import java.util.ArrayList;

public class Vendedor {
    private String nome;
    private int codigo;
    private String cpf;
    private ArrayList<NotaFiscal> nota;
    
    public Vendedor(){
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
     * @return the codigoVendedor
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * @param codigoVendedor the codigoVendedor to set
     */
    public void setCodigo(int codigoVendedor) {
        this.codigo = codigoVendedor;
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
