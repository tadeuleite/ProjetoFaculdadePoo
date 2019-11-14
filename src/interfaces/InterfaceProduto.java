/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import classesBasicas.Produto;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author thade
 */
public interface InterfaceProduto {

    ArrayList<Produto> listarProdutos() throws SQLException, Exception;

    ArrayList<Produto> consultarProdutoLike(Produto produto) throws Exception;

    ArrayList<Produto> consultarItem(Produto produto) throws SQLException, Exception;
}
