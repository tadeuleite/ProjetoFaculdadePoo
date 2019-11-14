/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import classesBasicas.Bebida;
import dao.DaoBebida;
import interfaces.InterfaceBebida;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author thade
 */
public class NegocioBebida implements InterfaceBebida {

    private DaoBebida beb = new DaoBebida();

    @Override
    public void cadastrarBebida(Bebida bebida) throws SQLException, Exception {

        validarNulo(bebida);
        validarNome(bebida);
        validarCapacidade(bebida);
        validarMarca(bebida);
        validarTipoBebida(bebida);

        beb.cadastrarBebida(bebida);
    }

    @Override
    public void removerBebida(Bebida bebida) throws SQLException, Exception {

        validarNulo(bebida);

        beb.removerBebida(bebida);
    }

    @Override
    public void alterarBebida(Bebida bebida) throws SQLException, Exception {

        validarNulo(bebida);
        validarNome(bebida);
        validarCapacidade(bebida);
        validarMarca(bebida);
        validarTipoBebida(bebida);

        beb.alterarBebida(bebida);
    }

    @Override
    public ArrayList<Bebida> listarBebida() throws SQLException, Exception {
        DaoBebida bebida = new DaoBebida();
        ArrayList<Bebida> b = bebida.listarBebida();

        return b;
    }

    @Override
    public ArrayList<Bebida> consultarBebidaLike(Bebida bebida) throws Exception {
        validarNulo(bebida);
        validarNome(bebida);

        ArrayList<Bebida> b = beb.consultarBebidaLike(bebida);

        return b;
    }

    private void validarNulo(Bebida bebida) throws Exception {
        if (bebida == null) {
            throw new Exception("Informe uma bebida");
        }
    }

    private void validarNome(Bebida bebida) throws Exception {
        if (bebida.getNome().equals("")) {

        } else {
            if (bebida.getNome().trim().equals("") == true) {
                throw new Exception("O nome deve ser informado");
            }
            if (bebida.getNome().trim().length() > 100) {
                throw new Exception("O nome da bebida não pode ultrapassar 100 caracteres");
            }
        }
    }

    private void validarCapacidade(Bebida bebida) throws Exception {
        if (bebida.getCapacidade() == 0) {
            throw new Exception("A capacidade da bebida deve ser informado");
        }
        if (bebida.getCapacidade() < 0) {
            throw new Exception("Digite uma capacidade de bebida válida");
        }
    }

    private void validarMarca(Bebida bebida) throws Exception {
        if (bebida.getMarca().trim().equals("") == true) {
            throw new Exception("A marca da bebida deve ser informado");
        }
        if (bebida.getMarca().trim().length() > 100) {
            throw new Exception("A marca não pode ultrapassar 100 caracteres");
        }
    }

    private void validarTipoBebida(Bebida bebida) throws Exception {
        if (bebida.getTipo().trim().equals("") == true) {
            throw new Exception("O tipo da bebida deve ser informado");
        }
        if (bebida.getTipo().trim().length() > 100) {
            throw new Exception("O tipo da bebida não pode ultrapassar 100 caracteres");
        }
    }
}
