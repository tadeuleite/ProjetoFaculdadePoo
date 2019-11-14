/*
CREATE DATABASE Cervejaria;
USE Cervejaria;
--
CREATE TABLE Vendedor (
                        Vend_Codigo INTEGER       PRIMARY KEY AUTO_INCREMENT,
                        Vend_Nome   VARCHAR(50)   NOT NULL                  ,
                        Vend_Cpf    VARCHAR(11)   NOT NULL UNIQUE           
);
--
-- 
CREATE TABLE Cliente (
                       Cli_Cpf      VARCHAR(11)   PRIMARY KEY,
                       Cli_Nome     VARCHAR(100)  NOT NULL   ,
                       Cli_Endereco VARCHAR(100)  NOT NULL
);
-- 
-- 
CREATE TABLE NotaFiscal (
                          Nota_Codigo      INTEGER     PRIMARY KEY,
                          Data_Emissao     DATE        NOT NULL   ,
                          Cli_Cpf          VARCHAR(11) NOT NULL   ,
                          Vend_Codigo      INTEGER     NOT NULL   ,
             FOREIGN KEY (Cli_Cpf)
                 REFERENCES Cliente(Cli_Cpf)                      ,
             FOREIGN KEY (Vend_Codigo)
                  REFERENCES Vendedor(Vend_Codigo)
 );
--
--
CREATE TABLE Produto (
                     Prod_Codigo         INTEGER      PRIMARY KEY AUTO_INCREMENT, 
                     Prod_Nome           VARCHAR(100) NOT NULL                  , 
                     Prod_Beb_Capacidade INTEGER                                ,
                     Prod_Beb_Marca      VARCHAR(50)                            ,
                     Prod_Com_Categoria  VARCHAR(50)                            ,
                     Prod_Tipo           CHAR(1)                                ,
                     Prod_Beb_TipoBebida VARCHAR(50)                            
);
--
-- 
CREATE TABLE NotaFiscal_Produto (
                                Quantidade  INTEGER          ,
                                Preco       FLOAT            ,
                                Nota_Codigo INTEGER          ,
                                Prod_Codigo INTEGER          ,
                   FOREIGN KEY (Nota_Codigo)
                       REFERENCES NotaFiscal(Nota_Codigo)
                          ON DELETE CASCADE                  ,
                   FOREIGN KEY (Prod_Codigo)
                       REFERENCES Produto(Prod_Codigo)
                          ON DELETE CASCADE
);
*/
