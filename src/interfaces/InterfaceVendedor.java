package interfaces;

import classesBasicas.Vendedor;
import java.sql.SQLException;
import java.util.ArrayList;

public interface InterfaceVendedor {

    void cadastrarVendedor(Vendedor vendedor) throws SQLException, Exception;

    void removerVendedor(Vendedor vendedor) throws SQLException, Exception;

    void alterarVendedor(Vendedor vendedor) throws SQLException, Exception;

    ArrayList<Vendedor> listarVendedor() throws SQLException, Exception;

    ArrayList<Vendedor> consultarVendedor(Vendedor vendedor) throws SQLException, Exception;

    ArrayList<Vendedor> consultarVendedorLike(Vendedor vendedor) throws SQLException, Exception;
}
