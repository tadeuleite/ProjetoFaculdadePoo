package interfaces;

import classesBasicas.Cliente;
import java.sql.SQLException;
import java.util.ArrayList;

public interface InterfaceCliente {

    void cadastrarCliente(Cliente cliente) throws SQLException, Exception;

    void removerCliente(Cliente cliente) throws SQLException, Exception;

    void alterarCliente(Cliente cliente) throws SQLException, Exception;

    ArrayList<Cliente> listarCliente() throws SQLException, Exception;

    ArrayList<Cliente> consultarCliente(Cliente cliente) throws SQLException, Exception;

    ArrayList<Cliente> consultarClienteLike(Cliente cliente) throws SQLException, Exception;
}
