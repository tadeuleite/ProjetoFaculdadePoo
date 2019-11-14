package dao;

import metodos.ConvercaoDate;
import classesBasicas.NotaFiscal;
import classesBasicas.NotaFiscalProduto;
import interfaces.InterfaceNotaFiscal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DaoNotaFiscal extends Conexao implements InterfaceNotaFiscal {

    @Override
    public void cadastrarNotaFiscal(NotaFiscal notaFiscal) throws SQLException, Exception {

        String sql = " INSERT INTO NotaFiscal (Nota_codigo, Data_Emissao, Cli_Cpf, Vend_Codigo) ";
        sql += " VALUES ( ? ,? ,? ,? ) ";

        PreparedStatement preparedStatement = super.conectar().prepareStatement(sql);

        preparedStatement.setInt(1, notaFiscal.getCodigoNota());
        preparedStatement.setDate(2, ConvercaoDate.getSqlDate(notaFiscal.getDataEmissao()));
        preparedStatement.setString(3, notaFiscal.getCliente().getCpf());
        preparedStatement.setInt(4, notaFiscal.getVendedor().getCodigo());

        preparedStatement.executeUpdate();

        for (NotaFiscalProduto notaProd : notaFiscal.getNotaProduto()) {

            String sql2 = " INSERT INTO NotaFiscal_Produto(Nota_Codigo, Prod_Codigo, Quantidade, Preco) ";
            sql2 += " VALUES (?, ?, ?, ?) ";
            PreparedStatement preparedStatement2 = super.conectar().prepareStatement(sql2);

            preparedStatement2.setInt(1, notaFiscal.getCodigoNota());
            preparedStatement2.setInt(2, notaProd.getProduto().getCodigo());
            preparedStatement2.setInt(3, notaProd.getQuantidade());
            preparedStatement2.setFloat(4, notaProd.getPreco());

            preparedStatement2.executeUpdate();
        }

        super.desconectar();
    }

    @Override
    public void removerNotaFiscal(NotaFiscal notaFiscal) throws SQLException, Exception {

        String sql = " DELETE FROM NotaFiscal ";
        sql += " WHERE Nota_Codigo = ? ";

        PreparedStatement preparedStatement = super.conectar().prepareStatement(sql);

        preparedStatement.setInt(1, notaFiscal.getCodigoNota());

        int linhas = preparedStatement.executeUpdate();

        super.desconectar();

        if (linhas == 0) {
            throw new Exception("Nota Fiscal não removida, verifique se digitou o código correto");
        }
    }

    @Override
    public void alterarNotaFiscal(NotaFiscal notaFiscal) throws SQLException, Exception {

        String sql = " UPDATE NotaFiscal SET Data_Emissao = ?, Cli_Cpf = ?, Vend_Codigo = ? ";
        sql += " WHERE Nota_Codigo = ? ";

        PreparedStatement preparedStatement = super.conectar().prepareStatement(sql);

        preparedStatement.setDate(1, ConvercaoDate.getSqlDate(notaFiscal.getDataEmissao()));
        preparedStatement.setString(2, notaFiscal.getCliente().getCpf());
        preparedStatement.setInt(3, notaFiscal.getVendedor().getCodigo());
        preparedStatement.setInt(4, notaFiscal.getCodigoNota());

        int linhas = preparedStatement.executeUpdate();

        super.desconectar();

        if (linhas == 0) {
            throw new Exception("Nota Fiscal não atualizada, verifique se digitou o código correto");
        }
    }

    @Override
    public ArrayList<NotaFiscal> listarNotaFiscal() throws SQLException, Exception {
        ArrayList<NotaFiscal> retorno = new ArrayList<>();
        String sql = " SELECT notaf.Nota_Codigo, notaf.Data_Emissao, c.Cli_Nome, v.Vend_Nome ";
        sql += " FROM NotaFiscal as notaf ";
        sql += " JOIN Cliente as c ";
        sql += " JOIN Vendedor as v ";
        sql += " ON notaf.Cli_Cpf = c.Cli_Cpf ";
        sql += " AND notaf.Vend_Codigo = v.Vend_Codigo "; 

        PreparedStatement preparedStatement = super.conectar().prepareStatement(sql);

        ResultSet leitor = preparedStatement.executeQuery();

        while (leitor.next()) {
            NotaFiscal notaf = new NotaFiscal();

            notaf.setCodigoNota(leitor.getInt("Nota_Codigo"));
            notaf.setDataEmissao(leitor.getDate("Data_Emissao"));
            notaf.getCliente().setNome(leitor.getString("Cli_Nome"));
            notaf.getVendedor().setNome(leitor.getString("Vend_Nome"));

            retorno.add(notaf);
        }

        super.desconectar();
        return retorno;
    }

    @Override
    public ArrayList<NotaFiscal> consultarNotaFiscal(NotaFiscal notaFiscal) throws SQLException, Exception {
        ArrayList<NotaFiscal> retorno = new ArrayList<>();

        String sql = " SELECT n.Nota_Codigo, n.Data_Emissao, c.Cli_Nome, v.Vend_Nome ";
        sql += "  FROM NotaFiscal as n ";
        sql += " JOIN Cliente as c ";
        sql += " JOIN Vendedor as v ";
        sql += " ON n.Cli_Cpf = c.Cli_Cpf ";
        sql += " AND n.Vend_Codigo = v.Vend_Codigo ";
        sql += " WHERE n.Nota_Codigo = ? ";

        PreparedStatement preparedStatement = super.conectar().prepareStatement(sql);

        preparedStatement.setInt(1, notaFiscal.getCodigoNota());

        ResultSet leitor = preparedStatement.executeQuery();

        while (leitor.next()) {
            NotaFiscal notafiscal = new NotaFiscal();

            notafiscal.setCodigoNota(leitor.getInt("Nota_Codigo"));
            notafiscal.setDataEmissao(leitor.getDate("Data_Emissao"));
            notafiscal.getCliente().setNome(leitor.getString("Cli_Nome"));
            notafiscal.getVendedor().setNome(leitor.getString("Vend_Nome"));

            retorno.add(notafiscal);
        }

        super.desconectar();
        return retorno;
    }

    @Override
    public ArrayList<NotaFiscalProduto> consultarItensNota(NotaFiscal notaFiscal) throws SQLException, Exception {
        ArrayList<NotaFiscalProduto> notaProd = new ArrayList<>();

        String sql2 = " SELECT p.Prod_Nome, nfp.Quantidade, nfp.Preco ";
        sql2 += " FROM NotaFiscal_Produto as nfp ";
        sql2 += " JOIN NotaFiscal as n ";
        sql2 += " JOIN Produto as p ";
        sql2 += " ON n.Nota_codigo = nfp.Nota_Codigo ";
        sql2 += " AND p.Prod_Codigo = nfp.Prod_Codigo ";
        sql2 += " AND n.Nota_Codigo = ? ";

        PreparedStatement preparedStatement2 = super.conectar().prepareStatement(sql2);

        preparedStatement2.setInt(1, notaFiscal.getCodigoNota());

        ResultSet leitor2 = preparedStatement2.executeQuery();

        while (leitor2.next()) {
            NotaFiscalProduto notaFiscalProd = new NotaFiscalProduto();

            notaFiscalProd.getProduto().setNome(leitor2.getString("Prod_Nome"));
            notaFiscalProd.setQuantidade(leitor2.getInt("Quantidade"));
            notaFiscalProd.setPreco(leitor2.getFloat("Preco"));

            notaProd.add(notaFiscalProd);
        }

        return notaProd;
    }

}
