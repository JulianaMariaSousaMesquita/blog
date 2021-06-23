package model;

import aplicacao.Comentario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ComentarioDAO {
    private Connection conexao = null;

    // Ao inves de montar manualmente em cada funcao, reutilizamos;    
    private Comentario instantiateComentario(ResultSet rs) throws SQLException {
        Comentario dep = new Comentario(rs.getInt("id"),rs.getString("comentario"),rs.getInt("id_artigo"), rs.getInt("id_usuario"));
        return dep;
    }
    
    public ComentarioDAO() {
         try {
            // Cria a conexão com o banco de dados
            conexao = Conexao.criaConexao();
        }
        catch( Exception e ) {
            System.out.println("Erro criação de conexao DAO");
            System.out.println(e);
        }
    }
    
    public ArrayList<Comentario> getLista() {
        //Cria o objeto resultado que irá armazenar os registros retornados do BD
        ArrayList<Comentario> resultado = new ArrayList<>();
        try {            
            // Cria o objeto para quer será utilizado para enviar comandos SQL
            // para o BD
            Statement stmt = conexao.createStatement();
            // Armazena o resultado do comando enviado para o banco de dados
            ResultSet rs = stmt.executeQuery("select * from comentario");
            // rs.next() Aponta para o próximo registro do BD, se houver um 
            while( rs.next() ) {
                //Cria o objeto da classe Contato para armazenar os dados
                //que vieram do BD
                Comentario comentario = new Comentario();
                //Pega o conteúdo da coluna "id" do ResultSet (rs)
                comentario.setId(rs.getInt("id") );                
                //Pega o conteúdo da coluna "comentario" do ResultSet (rs)
                comentario.setComentario( rs.getString("comentario") );
                //Pega o conteúdo da coluna "id artigo" do ResultSet (rs)
                comentario.setIdArtigo(rs.getInt("id_artigo") );
                 //Pega o conteúdo da coluna "id usuario" do ResultSet (rs)
                comentario.setIdUsuario(rs.getInt("id_usuario") );                
                //Adiciona o objeto criado na ArrayList resultado
                resultado.add(comentario);
            }
        } catch( SQLException e ) {
            System.out.println("Erro de SQL: " + e.getMessage());
        }        
        // Retorna a lista de Contatos encontrados no banco de dados.
        return resultado;
    }
        
    public Comentario getComentarioPorID( int codigo ) {
        Comentario comentario = new Comentario();
        try {
            String sql = "SELECT * FROM comentario WHERE id = ?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, codigo);
            
            ResultSet rs = ps.executeQuery();
            
            if ( rs.next() ) {
                comentario.setId(rs.getInt("id"));
                comentario.setComentario( rs.getString("comentario") );
                comentario.setIdArtigo(rs.getInt("id_artigo"));
                comentario.setIdUsuario(rs.getInt("id_usuario"));
            }            
        } catch( SQLException e ) {
            System.out.println("Erro de SQL: " + e.getMessage());
        }
        return comentario;
    }   
       
    public boolean excluir( int id ) {
        try {
            String sql = "DELETE FROM comentario WHERE id = ?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
            return true;
        } catch( SQLException e ) {
            System.out.println("Erro de SQL: " + e.getMessage());
            return false;
        } 
    }
     public void editar(Comentario comentario){
        try{
        String sql;  
        // Realizar uma alteração
        sql = "UPDATE comentario SET  comentario=? WHERE id=?";              
        PreparedStatement ps = this.conexao.prepareStatement(sql);        
        ps.setString(1, comentario.getComentario());
        ps.setInt(2, comentario.getId());
        ps.executeUpdate(); 
        }catch(SQLException e) {
            System.out.println("Erro de SQL: " + e.getMessage());
        }    
    }
     
     public void criarComentario(Comentario comentario){
        try {            
                String sql = "INSERT INTO comentario (comentario, id_artigo, id_usuario) VALUES (?,?,?)";
                PreparedStatement ps = this.conexao.prepareStatement(sql);
                ps.setString(1, comentario.getComentario());
                ps.setInt(2, comentario.getIdArtigo());
                ps.setInt(3, comentario.getIdUsuario());
                ps.execute();
        } catch (SQLException e) {
            System.out.println("Erro de SQL: " + e.getMessage());
        }
    }
    
}
