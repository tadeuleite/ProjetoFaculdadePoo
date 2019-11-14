package dao;

import classesBasicas.Cliente;
import interfaces.InterfaceCliente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DaoCliente extends Conexao implements InterfaceCliente {

    @Override
    public void cadastrarCliente(Cliente cliente) throws SQLException, Exception {

        String sql = "INSERT INTO Cliente (Cli_Cpf, Cli_Nome, Cli_Endereco) ";
        sql += " VALUES (?,?,?)";

        PreparedStatement preparedStatement = super.conectar().prepareStatement(sql);

        preparedStatement.setString(1, cliente.getCpf());
        preparedStatement.setString(2, cliente.getNome());
        preparedStatement.setString(3, cliente.getEndereco());

        preparedStatement.executeUpdate();

        super.desconectar();
    }

    @Override
    public void removerCliente(Cliente cliente) throws SQLException, Exception {
        if (existeClienteNota(cliente) == true) {
            throw new Exception("Não é possível deletar o cliente, pois está vinculado a uma Nota Fiscal");
        }

        String sql = "DELETE FROM Cliente WHERE Cli_Cpf = ? ";

        PreparedStatement preparedStatement = super.conectar().prepareStatement(sql);

        preparedStatement.setString(1, cliente.getCpf());

        preparedStatement.executeUpdate();

        super.desconectar();
    }

    @Override
    public void alterarCliente(Cliente cliente) throws SQLException, Exception {

        String sql = " UPDATE Cliente SET Cli_Nome = ?, Cli_Endereco = ?, Cli_Cpf = ? WHERE Cli_Cpf = ? ";

        PreparedStatement preparedStatement = super.conectar().prepareStatement(sql);

        preparedStatement.setString(1, cliente.getNome());
        preparedStatement.setString(2, cliente.getEndereco());
        preparedStatement.setString(3, cliente.getCpf()); //cpf novo
        
        ArrayList<Cliente> c = consultarClienteLike(cliente);
        for(Cliente cl : c){
            cliente.setCpf(cl.getCpf());
        }
        
        preparedStatement.setString(4, cliente.getCpf()); //cpf antigo

        int rows = preparedStatement.executeUpdate();
        
        if(rows == 0){
            throw new Exception("Cpf incorreto");
        }

        super.desconectar();
    }

    @Override
    public ArrayList<Cliente> listarCliente() throws Exception {
        ArrayList<Cliente> cliente = new ArrayList<>();

        String sql = " SELECT cli.Cli_Cpf, cli.Cli_Nome, cli.Cli_Endereco ";
        sql += " from cliente as cli ";

        PreparedStatement preparedStatement = super.conectar().prepareStatement(sql);

        ResultSet leitor = preparedStatement.executeQuery();

        while (leitor.next()) {
            Cliente cli = new Cliente();

            cli.setCpf(leitor.getString("Cli_Cpf"));
            cli.setNome(leitor.getString("Cli_Nome"));
            cli.setEndereco(leitor.getString("Cli_Endereco"));
            cliente.add(cli);
        }

        if (cliente.isEmpty()) {
            throw new Exception("Cliente não encontrado");
        }

        super.desconectar();
        return cliente;
    }

    @Override
    public ArrayList<Cliente> consultarCliente(Cliente cliente) throws Exception {
        ArrayList<Cliente> c = new ArrayList<>();

        String sql = "SELECT cli.Cli_Cpf, cli.Cli_Nome, cli.Cli_Endereco";
        sql += " FROM Cliente as cli ";
        sql += " WHERE cli.Cli_Cpf = ? ";

        PreparedStatement preparedStatement = super.conectar().prepareStatement(sql);

        preparedStatement.setString(1, cliente.getCpf());

        ResultSet leitor = preparedStatement.executeQuery();

        while (leitor.next()) {
            cliente.setCpf(leitor.getString("Cli_Cpf"));
            cliente.setNome(leitor.getString("Cli_Nome"));
            cliente.setEndereco(leitor.getString("Cli_Endereco"));
            c.add(cliente);
        }

        super.desconectar();
        return c;
    }

    @Override
    public ArrayList<Cliente> consultarClienteLike(Cliente cliente) throws SQLException, Exception {
        ArrayList<Cliente> retorno = new ArrayList<>();

        String sql = " SELECT cli.Cli_Nome, cli.Cli_Cpf, cli.Cli_Endereco ";
        sql += " FROM Cliente AS cli  ";
        sql += " WHERE cli.Cli_Nome LIKE ? ";

        PreparedStatement preparedStatement = super.conectar().prepareStatement(sql);

        preparedStatement.setString(1, "%" + cliente.getNome() + "%");

        ResultSet leitor = preparedStatement.executeQuery();

        while (leitor.next()) {
            Cliente c = new Cliente();
            c.setNome(leitor.getString("Cli_Nome"));
            c.setCpf(leitor.getString("Cli_Cpf"));
            c.setEndereco(leitor.getString("Cli_Endereco"));
            retorno.add(c);
        }

        super.desconectar();
        return retorno;
    }

    private boolean existeClienteNota(Cliente cliente) throws Exception {
        String sql = " SELECT cli.Cli_Cpf, notaF.Cli_Cpf ";
        sql += " FROM Cliente as cli ";
        sql += " JOIN NotaFiscal as notaF ";
        sql += " ON notaF.Cli_Cpf = ? ";
        
        boolean retorno;

        PreparedStatement preparedStatement = super.conectar().prepareStatement(sql);

        preparedStatement.setString(1, cliente.getCpf());

        ResultSet leitor = preparedStatement.executeQuery();

        retorno = leitor.isBeforeFirst();

        super.desconectar();

        return retorno;
    }
}
