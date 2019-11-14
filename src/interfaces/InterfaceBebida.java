package interfaces;

import classesBasicas.Bebida;
import java.sql.SQLException;
import java.util.ArrayList;

public interface InterfaceBebida {

    void cadastrarBebida(Bebida bebida) throws SQLException, Exception;

    void removerBebida(Bebida bebida) throws SQLException, Exception;

    void alterarBebida(Bebida bebida) throws SQLException, Exception;

    ArrayList<Bebida> listarBebida() throws SQLException, Exception;

    ArrayList<Bebida> consultarBebidaLike(Bebida bebida) throws Exception;
}
