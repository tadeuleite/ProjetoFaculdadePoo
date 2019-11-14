/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import classesBasicas.NotaFiscal;
import classesBasicas.NotaFiscalProduto;
import dao.DaoNotaFiscal;
import interfaces.InterfaceNotaFiscal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.regex.Pattern;
import metodos.ConvercaoDate;

/**
 *
 * @author thade
 */
public class NegocioNotaFiscal implements InterfaceNotaFiscal {

    private final DaoNotaFiscal notaF = new DaoNotaFiscal();

    @Override
    public void cadastrarNotaFiscal(NotaFiscal notaFiscal) throws SQLException, Exception {
        validarNulo(notaFiscal);
        validarCodigo(notaFiscal);
        validarData(notaFiscal);

        notaF.cadastrarNotaFiscal(notaFiscal);
    }

    @Override
    public void removerNotaFiscal(NotaFiscal notaFiscal) throws SQLException, Exception {
        validarNulo(notaFiscal);

        notaF.removerNotaFiscal(notaFiscal);
    }

    @Override
    public void alterarNotaFiscal(NotaFiscal notaFiscal) throws SQLException, Exception {
        validarNulo(notaFiscal);
        validarCodigo(notaFiscal);
        validarData(notaFiscal);

        notaF.alterarNotaFiscal(notaFiscal);
    }

    @Override
    public ArrayList<NotaFiscal> listarNotaFiscal() throws SQLException, Exception {
        ArrayList<NotaFiscal> n = notaF.listarNotaFiscal();

        return n;
    }

    @Override
    public ArrayList<NotaFiscal> consultarNotaFiscal(NotaFiscal notaFiscal) throws SQLException, Exception {
        validarNulo(notaFiscal);

        ArrayList<NotaFiscal> n = notaF.consultarNotaFiscal(notaFiscal);

        return n;
    }

    @Override
    public ArrayList<NotaFiscalProduto> consultarItensNota(NotaFiscal notaFiscal) throws SQLException, Exception {
        validarNulo(notaFiscal);

        ArrayList<NotaFiscalProduto> n = notaF.consultarItensNota(notaFiscal);

        return n;
    }

    private void validarNulo(NotaFiscal notaFiscal) throws SQLException, Exception {

        if (notaFiscal == null) {
            throw new Exception("Preencha todos os campos da nota fiscal");
        }
    }

    private void validarCodigo(NotaFiscal notaFiscal) throws SQLException, Exception {
        if (notaFiscal.getCodigoNota() <= 0) {
            throw new Exception("O código da nota não pode ser um valor negativo");
        }
 
    }

    private void validarData(NotaFiscal notaFiscal) throws SQLException, Exception {
        Pattern DATE_PATTERN = Pattern.compile("^\\d{2}/\\d{2}/\\d{4}$");

        if (DATE_PATTERN.matcher(ConvercaoDate.parseDate(notaFiscal.getDataEmissao())).matches() == false) {
            throw new Exception("Insira uma data válida");
        }
    }
}
