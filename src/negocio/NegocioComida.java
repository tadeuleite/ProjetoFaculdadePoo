/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import classesBasicas.Comida;
import dao.DaoComida;
import interfaces.InterfaceComida;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author thade
 */
public class NegocioComida implements InterfaceComida {

    private final DaoComida com = new DaoComida();

    @Override
    public void cadastrarComida(Comida comida) throws SQLException, Exception {
        validarNulo(comida);
        validarNome(comida);
        validarCategoria(comida);

        com.cadastrarComida(comida);
    }

    @Override
    public void removerComida(Comida comida) throws SQLException, Exception {
        validarNulo(comida);

        com.removerComida(comida);
    }

    @Override
    public void alterarComida(Comida comida) throws SQLException, Exception {
        validarNulo(comida);
        validarNome(comida);
        validarCategoria(comida);

        com.alterarComida(comida);
    }

    @Override
    public ArrayList<Comida> listarComida() throws SQLException, Exception {
        ArrayList<Comida> c = com.listarComida();

        return c;
    }

    @Override
    public ArrayList<Comida> ConsultarComidaLike(Comida comida) throws Exception {
        validarNulo(comida);
        validarNome(comida);

        ArrayList<Comida> c = com.ConsultarComidaLike(comida);

        return c;
    }

    private void validarNome(Comida comida) throws Exception {
        if (comida.getNome().equals("")) {

        } else {
            if (comida.getNome().trim().equals("") == true) {
                throw new Exception("O nome deve ser informado");
            }
            if (comida.getNome().trim().length() > 100) {
                throw new Exception("O nome da bebida não pode ultrapassar 100 caracteres");
            }
        }
    }

    private void validarNulo(Comida comida) throws Exception {
        if (comida == null) {
            throw new Exception("Insira uma comida");
        }
    }

    private void validarCategoria(Comida comida) throws Exception {
        if (comida.getCategoria().trim().equals("")) {
            throw new Exception("A categoria da comida deve ser informada\n *(Petisco, hamburguer, etc)");
        }
        if (comida.getCategoria().trim().equals("")) {
            throw new Exception("O nome da bebida não pode ultrapassar 100 caracteres");
        }
    }
}
