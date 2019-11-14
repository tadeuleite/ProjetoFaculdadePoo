package dao;

import classesBasicas.Comida;
import interfaces.InterfaceComida;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DaoComida extends Conexao implements InterfaceComida {

    @Override
    public void cadastrarComida(Comida comida) throws SQLException, Exception {
//tipo 0 = comida
        String sql = " INSERT INTO Produto (Prod_Nome, Prod_Com_Categoria, Prod_Tipo) ";
        sql += " VALUES (?,?,0) ";

        PreparedStatement preparedStatement = super.conectar().prepareStatement(sql);

        preparedStatement.setString(1, comida.getNome());
        preparedStatement.setString(2, comida.getCategoria());

        preparedStatement.executeUpdate();

        super.desconectar();
    }

    @Override
    public void removerComida(Comida comida) throws SQLException, Exception {

        String sql = " DELETE FROM Produto WHERE Prod_Codigo = ? ";

        PreparedStatement preparedStatement = super.conectar().prepareStatement(sql);

        preparedStatement.setInt(1, comida.getCodigo());

        int linhas = preparedStatement.executeUpdate();

        super.desconectar();

        if (linhas == 0) {
            throw new Exception("Produto não removido, verifique se digitou o código correto");
        }
    }

    @Override
    public void alterarComida(Comida comida) throws SQLException, Exception {

        String sql = " UPDATE Produto SET Prod_Nome = ?, Prod_Com_Categoria = ?";
        sql += "WHERE Prod_Codigo = ? AND Prod_Tipo = 0";

        PreparedStatement preparedStatement = super.conectar().prepareStatement(sql);

        preparedStatement.setString(1, comida.getNome());
        preparedStatement.setString(2, comida.getCategoria());
        preparedStatement.setInt(3, comida.getCodigo());

        int linhas = preparedStatement.executeUpdate();

        super.desconectar();

        if (linhas == 0) {
            throw new Exception("Produto não atualizado, verifique se digitou o produto correto");
        }
    }

    @Override
    public ArrayList<Comida> listarComida() throws SQLException, Exception {
        ArrayList<Comida> retorno = new ArrayList<>();

        String sql = " SELECT com.Prod_Codigo, com.Prod_Nome, com.Prod_Com_Categoria ";
        sql += " from Produto as com WHERE Prod_Tipo = 0";

        PreparedStatement preparedStatement = super.conectar().prepareStatement(sql);

        ResultSet leitor = preparedStatement.executeQuery();

        while (leitor.next()) {
            Comida com = new Comida();

            com.setCodigo(leitor.getInt("Prod_Codigo"));
            com.setNome(leitor.getString("Prod_Nome"));
            com.setCategoria(leitor.getString("Prod_Com_Categoria"));

            retorno.add(com);
        }

        super.desconectar();
        return retorno;
    }

    @Override
    public ArrayList<Comida> ConsultarComidaLike(Comida comida) throws Exception {
        ArrayList<Comida> retorno = new ArrayList<>();

        String sql = " SELECT com.Prod_Codigo, com.Prod_Nome, com.Prod_Com_Categoria ";
        sql += "FROM Produto AS com  ";
        sql += " WHERE com.Prod_Nome LIKE ? AND com.Prod_Tipo = 0";

        PreparedStatement preparedStatement = super.conectar().prepareStatement(sql);

        preparedStatement.setString(1, "%" + comida.getNome() + "%");

        ResultSet leitor = preparedStatement.executeQuery();

        while (leitor.next()) {
            Comida c = new Comida();
            c.setCodigo(leitor.getInt("Prod_Codigo"));
            c.setNome(leitor.getString("Prod_Nome"));
            c.setCategoria(leitor.getString("Prod_Com_Categoria"));
            retorno.add(c);
        }

        super.desconectar();
        return retorno;
    }

}
