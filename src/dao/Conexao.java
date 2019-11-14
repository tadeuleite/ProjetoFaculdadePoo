package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    private Connection conn;
    private final String DRIVER_MYSQL = "com.mysql.jdbc.Driver";
    private final String LOCAL_SERVIDOR = "localhost";
    private final String BANCO_DE_DADOS = "cervejaria";
    private final String PORTA_BANCO = "3306";
    private final String USUARIO = "root";
    private final String SENHA = "";

    public Connection conectar() throws Exception {
        return this.conectarMySql();
    }

    public void desconectar() throws SQLException {
        conn.close();
    }

    private Connection conectarMySql() throws Exception {
        Class.forName(DRIVER_MYSQL).newInstance();
        String url = "jdbc:mysql://"+LOCAL_SERVIDOR+":"+PORTA_BANCO+"/"+BANCO_DE_DADOS;
        conn = (Connection) DriverManager.getConnection(url , USUARIO, SENHA);
        return conn;
    }
}
