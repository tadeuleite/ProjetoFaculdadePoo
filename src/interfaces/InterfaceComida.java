package interfaces;

import classesBasicas.Comida;
import java.sql.SQLException;
import java.util.ArrayList;

public interface InterfaceComida {

    void cadastrarComida(Comida comida) throws SQLException, Exception;

    void removerComida(Comida comida) throws SQLException, Exception;

    void alterarComida(Comida comida) throws SQLException, Exception;

    ArrayList<Comida> listarComida() throws SQLException, Exception;
    
    ArrayList<Comida> ConsultarComidaLike(Comida comida) throws Exception;
    
}
