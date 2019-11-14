/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import classesBasicas.Cliente;
import dao.DaoCliente;
import interfaces.InterfaceCliente;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author thade
 */
public class NegocioCliente implements InterfaceCliente {

    private final DaoCliente cli = new DaoCliente();

    @Override
    public void cadastrarCliente(Cliente cliente) throws SQLException, Exception {
        validarNulo(cliente);
        validarNome(cliente);
        validarEndereco(cliente);
        validarCpf(cliente);
        existeCpf(cliente);

        cli.cadastrarCliente(cliente);
    }

    @Override
    public void removerCliente(Cliente cliente) throws SQLException, Exception {
        validarNome(cliente);
        existeNome(cliente);
        existeCpf(cliente);

        cli.removerCliente(cliente);
    }

    @Override
    public void alterarCliente(Cliente cliente) throws SQLException, Exception {
        validarNulo(cliente);
        validarNome(cliente);
        validarEndereco(cliente);
        validarCpf(cliente);
        existeCpf(cliente);

        cli.alterarCliente(cliente);
    }

    @Override
    public ArrayList<Cliente> listarCliente() throws SQLException, Exception {
        ArrayList<Cliente> c = cli.listarCliente();

        return c;
    }

    @Override
    public ArrayList<Cliente> consultarCliente(Cliente cliente) throws SQLException, Exception {
        validarNulo(cliente);
        validarCpf(cliente);

        ArrayList<Cliente> c = cli.consultarCliente(cliente);

        return c;
    }

    @Override
    public ArrayList<Cliente> consultarClienteLike(Cliente cliente) throws SQLException, Exception {
        validarNulo(cliente);
        validarNome(cliente);

        ArrayList<Cliente> c = cli.consultarClienteLike(cliente);

        return c;
    }

    private void validarNulo(Cliente cliente) throws Exception {
        if (cliente == null) {
            throw new Exception("Informe algum cliente");
        }
    }

    private void validarNome(Cliente cliente) throws Exception {
        if (cliente.getNome().equals("")) {

        } else {
            if (cliente.getNome().trim().isEmpty() == true || cliente.getNome().equals("-")) {
                throw new Exception("Digite o nome do cliente");
            }
            if (cliente.getNome().trim().length() > 100) {
                throw new Exception("O nome do cliente não pode ultrapassar 100 caracteres");
            }
        }
    }

    private void validarCpf(Cliente cliente) throws Exception {
        if (cliente.getCpf().trim().matches("^[0-9]") == true) {
            throw new Exception("Digite apenas números no CPF");
        }
        if (!(cliente.getCpf().trim().length() == 11)) {
            throw new Exception("O CPF deve ter 11 digitos");
        }
    }

    private void validarEndereco(Cliente cliente) throws Exception {
        if (cliente.getNome().trim().equals("")) {
            throw new Exception("Digite o nome do cliente");
        }
        if (cliente.getNome().trim().length() > 100) {
            throw new Exception("O nome do cliente não pode ultrapassar 100 caracteres");
        }
    }

    private void existeCpf(Cliente cliente) throws Exception {
        String nome = cliente.getNome();
        String cpf = cliente.getCpf();
        String endereco = cliente.getEndereco();

        ArrayList<Cliente> c = cli.consultarCliente(cliente);

        cliente.setNome(nome);
        cliente.setCpf(cpf);
        cliente.setEndereco(endereco);

        for (Cliente cl : c) {
            if (cpf.equals(cl.getCpf()) == true) { //se o cpf do select for igual ao cpf digitado
                if (nome.equals(cl.getNome()) == false) { //se o nome vinculado ao cpf for diferente do nome digitado,
                    //significa que o cpf pertence a outra pessoa e não deixa alterar
                    throw new Exception("O CPF informado já está cadastrado");
                }
            }
        }
    }

    private void existeNome(Cliente cliente) throws Exception {

        if (cli.consultarClienteLike(cliente).isEmpty() == false) {
        } else {
            throw new Exception("O cliente informado não existe");
        }
    }
}
