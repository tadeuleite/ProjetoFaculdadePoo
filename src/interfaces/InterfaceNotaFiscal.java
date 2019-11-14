package interfaces;

import classesBasicas.NotaFiscal;
import classesBasicas.NotaFiscalProduto;
import java.sql.SQLException;
import java.util.ArrayList;

public interface InterfaceNotaFiscal {

    void cadastrarNotaFiscal(NotaFiscal notaFiscal) throws SQLException, Exception;

    void removerNotaFiscal(NotaFiscal notaFiscal) throws SQLException, Exception;

    void alterarNotaFiscal(NotaFiscal notaFiscal) throws SQLException, Exception;

    ArrayList<NotaFiscal> listarNotaFiscal() throws SQLException, Exception;

    ArrayList<NotaFiscal> consultarNotaFiscal(NotaFiscal notaFiscal) throws SQLException, Exception;
    
    ArrayList<NotaFiscalProduto> consultarItensNota(NotaFiscal notaFiscal) throws SQLException, Exception;
}
