package dao;

import classesBasicas.Bebida;
import interfaces.InterfaceBebida;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DaoBebida extends Conexao implements InterfaceBebida {

    @Override
    public void cadastrarBebida(Bebida bebida) throws SQLException, Exception {
//tipo 1 = Bebida
        String sql = "INSERT INTO Produto (Prod_Nome, Prod_Beb_Capacidade, Prod_Beb_Marca, "
                + "Prod_Beb_TipoBebida, Prod_Tipo) ";
        sql += " VALUES (?,?,?,?,1)";

        PreparedStatement preparedStatement = super.conectar().prepareStatement(sql);

        preparedStatement.setString(1, bebida.getNome());
        preparedStatement.setInt(2, bebida.getCapacidade());
        preparedStatement.setString(3, bebida.getMarca());
        preparedStatement.setString(4, bebida.getTipo());

        preparedStatement.executeUpdate();

        super.desconectar();
    }

    @Override
    public void removerBebida(Bebida bebida) throws SQLException, Exception {

        String sql = "DELETE FROM Produto WHERE Prod_Codigo = ? ";

        PreparedStatement preparedStatement = super.conectar().prepareStatement(sql);

        preparedStatement.setInt(1, bebida.getCodigo());

        int linhas = preparedStatement.executeUpdate();

        super.desconectar();

        if (linhas == 0) {
            throw new Exception("Produto não removido, verifique se digitou o código correto");
        }
    }

    @Override
    public void alterarBebida(Bebida bebida) throws SQLException, Exception {

        String sql = "UPDATE Produto SET Prod_Nome = ?, Prod_Beb_Capacidade = ?, Prod_Beb_Marca = ?, Prod_Beb_TipoBebida = ?";
        sql += "WHERE Prod_Codigo = ? AND Prod_Tipo = 1";

        PreparedStatement preparedStatement = super.conectar().prepareStatement(sql);

        preparedStatement.setString(1, bebida.getNome());
        preparedStatement.setInt(2, bebida.getCapacidade());
        preparedStatement.setString(3, bebida.getMarca());
        preparedStatement.setString(4, bebida.getTipo());
        preparedStatement.setInt(5, bebida.getCodigo());

        int linhas = preparedStatement.executeUpdate();

        super.desconectar();

        if (linhas == 0) {
            throw new Exception("Produto não atualizado, verifique se digitou o código correto");
        }
    }

    @Override
    public ArrayList<Bebida> listarBebida() throws SQLException, Exception {
        ArrayList<Bebida> retorno = new ArrayList<>();

        String sql = " SELECT beb.Prod_Codigo, beb.Prod_Nome, beb.Prod_Beb_Capacidade,"
                + "Prod_Beb_Marca, beb.Prod_Beb_TipoBebida, beb.Prod_Tipo";
        sql += " FROM Produto as beb ";
        sql += " WHERE beb.Prod_Tipo = 1";

        PreparedStatement preparedStatement = super.conectar().prepareStatement(sql);

        ResultSet leitor = preparedStatement.executeQuery();

        while (leitor.next()) {
            Bebida beb = new Bebida();

            beb.setCodigo(leitor.getInt("Prod_Codigo"));
            beb.setNome(leitor.getString("Prod_Nome"));
            beb.setCapacidade(leitor.getInt("Prod_Beb_Capacidade"));
            beb.setMarca(leitor.getString("Prod_Beb_Marca"));
            beb.setTipo(leitor.getString("Prod_Beb_TipoBebida"));
            retorno.add(beb);
        }

        super.desconectar();
        return retorno;
    }

    @Override
    public ArrayList<Bebida> consultarBebidaLike(Bebida bebida) throws Exception {
        ArrayList<Bebida> retorno = new ArrayList<>();

        String sql = " SELECT com.Prod_Codigo, com.Prod_Nome, Prod_Beb_Capacidade, Prod_Beb_Marca, Prod_Beb_TipoBebida ";
        sql += " FROM Produto AS com  ";
        sql += " WHERE com.Prod_Nome LIKE ? AND Prod_Tipo = 1 ";

        PreparedStatement preparedStatement = super.conectar().prepareStatement(sql);

        preparedStatement.setString(1, "%" + bebida.getNome() + "%");

        ResultSet leitor = preparedStatement.executeQuery();

        while (leitor.next()) {
            Bebida b = new Bebida();
            b.setCodigo(leitor.getInt("Prod_Codigo"));
            b.setNome(leitor.getString("Prod_Nome"));
            b.setCapacidade(leitor.getInt("Prod_Beb_Capacidade"));
            b.setMarca(leitor.getString("Prod_Beb_Marca"));
            b.setTipo(leitor.getString("Prod_Beb_TipoBebida"));

            retorno.add(b);
        }

        super.desconectar();
        return retorno;
    }
}
