package classesBasicas;

import java.util.ArrayList;

public class Produto {

    private int codigo;
    private String nome;
    private ArrayList<NotaFiscalProduto> notaProduto;

    public Produto() {
        this.notaProduto = new ArrayList<>();
    }

    /**
     * @return the codigo
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
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
     * @return the notaProduto
     */
    public ArrayList<NotaFiscalProduto> getNotaProduto() {
        return notaProduto;
    }

    /**
     * @param notaProduto the notaProduto to set
     */
    public void setNotaProduto(ArrayList<NotaFiscalProduto> notaProduto) {
        this.notaProduto = notaProduto;
    }

}
