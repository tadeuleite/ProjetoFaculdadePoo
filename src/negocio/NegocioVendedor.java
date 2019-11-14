/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import classesBasicas.Vendedor;
import dao.DaoVendedor;
import interfaces.InterfaceVendedor;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author thade
 */
public class NegocioVendedor implements InterfaceVendedor {

    private final DaoVendedor vend = new DaoVendedor();

    @Override
    public void cadastrarVendedor(Vendedor vendedor) throws SQLException, Exception {
        validarNulo(vendedor);
        validarNome(vendedor);
        validarCpf(vendedor);
        existeCpf(vendedor);

        vend.cadastrarVendedor(vendedor);
    }

    @Override
    public void removerVendedor(Vendedor vendedor) throws SQLException, Exception {
        validarNulo(vendedor);
        validarNome(vendedor);
        existeNome(vendedor);
        vend.removerVendedor(vendedor);
    }

    @Override
    public void alterarVendedor(Vendedor vendedor) throws SQLException, Exception {
        validarNulo(vendedor);
        validarNome(vendedor);
        validarCpf(vendedor);
        existeCpf(vendedor);

        vend.alterarVendedor(vendedor);
    }

    @Override
    public ArrayList<Vendedor> listarVendedor() throws SQLException, Exception {
        ArrayList<Vendedor> v = vend.listarVendedor();

        return v;
    }

    @Override
    public ArrayList<Vendedor> consultarVendedor(Vendedor vendedor) throws SQLException, Exception {
        validarNulo(vendedor);
        ArrayList<Vendedor> v = vend.consultarVendedor(vendedor);

        return v;
    }

    @Override
    public ArrayList<Vendedor> consultarVendedorLike(Vendedor vendedor) throws SQLException, Exception {
        validarNome(vendedor);

        ArrayList<Vendedor> v = vend.consultarVendedorLike(vendedor);

        return v;
    }

    private void validarNulo(Vendedor vendedor) throws Exception {
        if (vendedor == null) {
            throw new Exception("Informe algum vendedor");
        }
    }

    private void validarNome(Vendedor vendedor) throws Exception {
        if (vendedor.getNome().equals("")) {

        } else {
            if (vendedor.getNome().trim().isEmpty() == true || vendedor.getNome().equals("-")) {
                throw new Exception("Digite o nome do vendedor");
            }
            if (vendedor.getNome().trim().length() > 100) {
                throw new Exception("O nome do vendedor não pode ultrapassar 100 caracteres");
            }
        }
    }

    private void validarCpf(Vendedor vendedor) throws Exception {
        if (vendedor.getCpf().trim().matches("^[0-9]") == true) {
            throw new Exception("Digite apenas números no CPF");
        }
        if (!(vendedor.getCpf().trim().length() == 11)) {
            throw new Exception("O CPF deve ter 11 digitos");
        }
    }

    private void existeCpf(Vendedor vendedor) throws Exception {
        String nome = vendedor.getNome();
        int codigo = vendedor.getCodigo();
        String cpf = vendedor.getCpf();

        ArrayList<Vendedor> v = vend.consultarVendedor(vendedor);

        vendedor.setCpf(cpf);
        vendedor.setNome(nome); //tive de fazer isso, pq sempre que eu chamava o metodo, ele sobrescrevia

        for (Vendedor ven : v) {
            if (codigo == (ven.getCodigo())) {
                if (nome.equals(ven.getNome()) == false) {
                    throw new Exception("O CPF informado já está cadastrado");
                }
            }
        }
    }

    private void existeNome(Vendedor cliente) throws Exception {
        if (vend.consultarVendedorLike(cliente).isEmpty() == false) {
        } else {
            throw new Exception("O cliente informado não existe");
        }
    }
}
