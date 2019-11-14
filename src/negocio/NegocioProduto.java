/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import classesBasicas.Produto;
import dao.DaoProduto;
import interfaces.InterfaceProduto;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author thade
 */
public class NegocioProduto implements InterfaceProduto {

    private final DaoProduto prod = new DaoProduto();

    @Override
    public ArrayList<Produto> listarProdutos() throws SQLException, Exception {
        ArrayList<Produto> p = prod.listarProdutos();

        return p;
    }

    @Override
    public ArrayList<Produto> consultarProdutoLike(Produto produto) throws Exception {
        validarNulo(produto);
        validarNome(produto);
        ArrayList<Produto> p = prod.consultarProdutoLike(produto);

        return p;
    }

    @Override
    public ArrayList<Produto> consultarItem(Produto produto) throws SQLException, Exception {
        validarNulo(produto);
        validarCodigo(produto);
        ArrayList<Produto> p = prod.consultarItem(produto);

        return p;
    }

    private void validarNulo(Produto produto) throws Exception {
        if (produto == null) {
            throw new Exception("O produto não pode ser vazio");
        }
    }

    private void validarCodigo(Produto produto) throws Exception {
        if (produto.getCodigo() < 0) {
            throw new Exception("O código do produto não pode ser negativo");
        }
    }

    private void validarNome(Produto produto) throws Exception {
        if (produto.getNome().equals("")) {

        } else {
            if (produto.getNome().trim().equals("")) {
                throw new Exception("Informe o nome do produto");
            }
            if (produto.getNome().trim().length() > 100) {
                throw new Exception("O nome do cliente não pode ultrapassar 100 caracteres");
            }
        }
    }
}
