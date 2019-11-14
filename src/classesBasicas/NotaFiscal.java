package classesBasicas;

import java.util.ArrayList;
import java.util.Date;

public class NotaFiscal {

    private int codigoNota;
    private Cliente cliente;
    private Vendedor vendedor;
    private ArrayList<NotaFiscalProduto> notaProduto;
    private Date dataEmissao;

    public NotaFiscal() {
        this.notaProduto = new ArrayList<>();
        this.cliente = new Cliente();
        this.vendedor = new Vendedor();
        this.dataEmissao = new Date();
    }

    /**
     * @return the codigoNota
     */
    public int getCodigoNota() {
        return codigoNota;
    }

    /**
     * @param codigoNota the codigoNota to set
     */
    public void setCodigoNota(int codigoNota) {
        this.codigoNota = codigoNota;
    }

    /**
     * @return the cliente
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     * @return the vendedor
     */
    public Vendedor getVendedor() {
        return vendedor;
    }

    /**
     * @param vendedor the vendedor to set
     */
    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    /**
     * @return the dataEmissao
     */
    public Date getDataEmissao() {
        return dataEmissao;
    }

    /**
     * @param dataEmissao the dataEmissao to set
     */
    public void setDataEmissao(Date dataEmissao) {
        this.dataEmissao = dataEmissao;
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
