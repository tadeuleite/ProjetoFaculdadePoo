package classesBasicas;

public class NotaFiscalProduto {

    private Produto produto;
    private NotaFiscal notaFiscal;
    private int Quantidade;
    private float Preco;

    public NotaFiscalProduto(){
       this.produto = new Produto();
       this.notaFiscal = new NotaFiscal();
    }
    
    /**
     * @return the produto
     */
    public Produto getProduto() {
        return produto;
    }

    /**
     * @param produto the produto to set
     */
    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    /**
     * @return the notaFiscal
     */
    public NotaFiscal getNotaFiscal() {
        return notaFiscal;
    }

    /**
     * @param notaFiscal the notaFiscal to set
     */
    public void setNotaFiscal(NotaFiscal notaFiscal) {
        this.notaFiscal = notaFiscal;
    }
    /**
     * @return the Quantidade
     */
    public int getQuantidade() {
        return Quantidade;
    }

    /**
     * @param Quantidade the Quantidade to set
     */
    public void setQuantidade(int Quantidade) {
        this.Quantidade = Quantidade;
    }

    /**
     * @return the Preco
     */
    public float getPreco() {
        return Preco;
    }

    /**
     * @param Preco the Preco to set
     */
    public void setPreco(float Preco) {
        this.Preco = Preco;
    }
}
