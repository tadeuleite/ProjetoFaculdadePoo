package dao;

import classesBasicas.Vendedor;
import interfaces.InterfaceVendedor;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DaoVendedor extends Conexao implements InterfaceVendedor {

    @Override
    public void cadastrarVendedor(Vendedor vendedor) throws SQLException, Exception {

        String sql = "INSERT INTO Vendedor (Vend_Cpf, Vend_Nome) ";
        sql += " VALUES (?,?)";

        PreparedStatement preparedStatement = super.conectar().prepareStatement(sql);

        preparedStatement.setString(1, vendedor.getCpf());
        preparedStatement.setString(2, vendedor.getNome());

        preparedStatement.executeUpdate();

        super.desconectar();
    }

    @Override
    public void removerVendedor(Vendedor vendedor) throws SQLException, Exception {
        if (existeVendedorNota(vendedor) == true) {
            throw new Exception("Não é possível deletar o cliente, pois está vinculado a uma Nota Fiscal");
        }

        String sql = "DELETE FROM Vendedor WHERE Vend_Codigo = ? ";

        PreparedStatement preparedStatement = super.conectar().prepareStatement(sql);

        preparedStatement.setInt(1, vendedor.getCodigo());

        preparedStatement.executeUpdate();

        super.desconectar();
    }

    @Override
    public void alterarVendedor(Vendedor vendedor) throws SQLException, Exception {

        String sql = " UPDATE Vendedor SET Vend_Nome = ?, Vend_Cpf = ? WHERE Vend_Codigo = ? ";

        PreparedStatement preparedStatement = super.conectar().prepareStatement(sql);

        preparedStatement.setString(1, vendedor.getNome());
        preparedStatement.setString(2, vendedor.getCpf());
        preparedStatement.setInt(3, vendedor.getCodigo());

        preparedStatement.executeUpdate();

        super.desconectar();
    }

    @Override
    public ArrayList<Vendedor> listarVendedor() throws SQLException, Exception {
        ArrayList<Vendedor> vendedores = new ArrayList<>();

        String sql = " SELECT vend.Vend_Codigo, vend.Vend_Cpf, vend.Vend_Nome ";
        sql += " FROM Vendedor as vend ";

        PreparedStatement preparedStatement = super.conectar().prepareStatement(sql);

        ResultSet leitor = preparedStatement.executeQuery();

        while (leitor.next()) {
            Vendedor Vend = new Vendedor();

            Vend.setCodigo(leitor.getInt("Vend_Codigo"));
            Vend.setCpf(leitor.getString("Vend_Cpf"));
            Vend.setNome(leitor.getString("Vend_Nome"));
            vendedores.add(Vend);
        }

        super.desconectar();
        return vendedores;
    }

    @Override
    public ArrayList<Vendedor> consultarVendedor(Vendedor vendedor) throws SQLException, Exception {
        ArrayList<Vendedor> vendedores = new ArrayList<>();
        String sql = "SELECT Vend.Vend_Cpf, Vend.Vend_Nome";
        sql += " from Vendedor as Vend ";
        sql += " where Vend.Vend_Codigo = ? ";

        PreparedStatement preparedStatement = super.conectar().prepareStatement(sql);

        preparedStatement.setInt(1, vendedor.getCodigo());

        ResultSet leitor = preparedStatement.executeQuery();

        while (leitor.next()) {
            vendedor.setCpf(leitor.getString("Vend_Cpf"));
            vendedor.setNome(leitor.getString("Vend_Nome"));
            vendedores.add(vendedor);
        }

        super.desconectar();
        return vendedores;
    }

    @Override
    public ArrayList<Vendedor> consultarVendedorLike(Vendedor vendedor) throws SQLException, Exception {
        ArrayList<Vendedor> retorno = new ArrayList<>();

        String sql = " SELECT vend.Vend_Codigo, vend.Vend_Nome, vend.Vend_Cpf ";
        sql += " FROM Vendedor AS vend  ";
        sql += " WHERE vend.Vend_Nome LIKE ? ";

        PreparedStatement preparedStatement = super.conectar().prepareStatement(sql);

        preparedStatement.setString(1, "%" + vendedor.getNome() + "%");

        ResultSet leitor = preparedStatement.executeQuery();

        while (leitor.next()) {
            Vendedor v = new Vendedor();
            v.setCodigo(leitor.getInt("Vend_Codigo"));
            v.setNome(leitor.getString("Vend_Nome"));
            v.setCpf(leitor.getString("Vend_Cpf"));

            retorno.add(v);
        }
        return retorno;
    }

    private boolean existeVendedorNota(Vendedor vendedor) throws Exception {
        String sql = " SELECT vend.Vend_Codigo, notaF.Vend_Codigo ";
        sql += " FROM Vendedor as vend ";
        sql += " JOIN NotaFiscal as notaF ";
        sql += " ON notaF.Vend_Codigo = ? ";

        boolean retorno;

        PreparedStatement preparedStatement = super.conectar().prepareStatement(sql);

        preparedStatement.setInt(1, vendedor.getCodigo());

        ResultSet leitor = preparedStatement.executeQuery();

        retorno = leitor.isBeforeFirst();

        super.desconectar();

        return retorno;
    }

}
