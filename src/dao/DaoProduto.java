package dao;

import classesBasicas.Produto;
import interfaces.InterfaceProduto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DaoProduto extends Conexao implements InterfaceProduto {

    @Override
    public ArrayList<Produto> listarProdutos() throws SQLException, Exception {
        ArrayList<Produto> retorno = new ArrayList<>();

        String sql = " SELECT com.Prod_Codigo, com.Prod_Nome ";
        sql += " from Produto as com";

        PreparedStatement preparedStatement = super.conectar().prepareStatement(sql);

        ResultSet leitor = preparedStatement.executeQuery();

        while (leitor.next()) {
            Produto prod = new Produto();

            prod.setCodigo(leitor.getInt("Prod_Codigo"));
            prod.setNome(leitor.getString("Prod_Nome"));

            retorno.add(prod);
        }

        super.desconectar();
        return retorno;
    }

    @Override
    public ArrayList<Produto> consultarProdutoLike(Produto produto) throws Exception {
        ArrayList<Produto> retorno = new ArrayList<>();

        String sql = " SELECT com.Prod_Codigo, com.Prod_Nome ";
        sql += " FROM Produto AS com  ";
        sql += " WHERE com.Prod_Nome LIKE ? ";

        PreparedStatement preparedStatement = super.conectar().prepareStatement(sql);

        preparedStatement.setString(1, "%" + produto.getNome() + "%");

        ResultSet leitor = preparedStatement.executeQuery();

        while (leitor.next()) {
            Produto c = new Produto();
            c.setCodigo(leitor.getInt("Prod_Codigo"));
            c.setNome(leitor.getString("Prod_Nome"));

            retorno.add(c);
        }

        super.desconectar();
        return retorno;
    }

    @Override
    public ArrayList<Produto> consultarItem(Produto produto) throws SQLException, Exception {
        ArrayList<Produto> retorno = new ArrayList<>();

        String sql = " SELECT com.Prod_Codigo, com.Prod_Nome ";
        sql += " FROM Produto AS com ";
        sql += " WHERE Prod_Codigo = ? ";

        PreparedStatement preparedStatement = super.conectar().prepareStatement(sql);

        preparedStatement.setInt(1, produto.getCodigo());

        ResultSet leitor = preparedStatement.executeQuery();

        while (leitor.next()) {
            Produto prod = new Produto();

            prod.setCodigo(leitor.getInt("Prod_Codigo"));
            prod.setNome(leitor.getString("Prod_Nome"));

            retorno.add(prod);
        }

        super.desconectar();
        return retorno;
    }
}
