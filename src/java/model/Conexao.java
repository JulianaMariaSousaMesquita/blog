package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet(name = "Conexao", urlPatterns = {"/Conexao"})
public class Conexao extends HttpServlet {

     //Atributo que irÃ¡ armazenar a conexÃ£o com o banco de dados
    private static Connection conexao = null;
    
    //MÃ©todo que realiza a conexÃ£o com o banco de dados
    public static Connection criaConexao() throws SQLException {
        //Verifica se jÃ¡ exite uma conexÃ£o com o banco de dados
        if ( conexao == null ) {
            try {
                //Carrega o Driver JDBC na memÃ³ria
                Class.forName("com.mysql.jdbc.Driver"); //load driver                       
                System.out.println("Driver foi carregado!");
                //Abre a conexÃ£o com o banco de dados via JDBC
                conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/blog", "root", "");
                System.out.println("Conexão realizada com sucesso!");
            }
            catch( ClassNotFoundException e ) {
                System.out.println("Driver não foi localizado!");
            }
        }
        // Retorna um objeto Connection, contendo a conexÃ£o aberta com o BD
        return conexao;
    }
}