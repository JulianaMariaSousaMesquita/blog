package model;

import aplicacao.Artigo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ArtigoDAO {
    private Connection conexao = null;

    // Ao inves de montar manualmente em cada funcao, reutilizamos;    
    private Artigo instantiateArtigo(ResultSet rs) throws SQLException {
        Artigo dep = new Artigo(rs.getInt("id"),rs.getInt("id_usuario"),rs.getInt("id_categoria"), rs.getString("titulo"), rs.getString("conteudo"), rs.getString("liberar"), rs.getString("aprovado"));
        return dep;
    }
    
    public ArtigoDAO() {
         try {
            // Cria a conexão com o banco de dados
            conexao = Conexao.criaConexao();
        }
        catch( Exception e ) {
            System.out.println("Erro criação de conexao DAO");
            System.out.println(e);
        }
    }
    
    public ArrayList<Artigo> getLista() {
        //Cria o objeto resultado que irá armazenar os registros retornados do BD
        ArrayList<Artigo> resultado = new ArrayList<>();
        try {            
            // Cria o objeto para quer será utilizado para enviar comandos SQL
            // para o BD
            Statement stmt = conexao.createStatement();
            // Armazena o resultado do comando enviado para o banco de dados
            ResultSet rs = stmt.executeQuery("select * from artigo");
            // rs.next() Aponta para o próximo registro do BD, se houver um 
            while( rs.next() ) {
                //Cria o objeto da classe Contato para armazenar os dados
                //que vieram do BD
                Artigo artigo = new Artigo();
                //Pega o conteúdo da coluna "id" do ResultSet (rs)
                artigo.setId(rs.getInt("id") );       
                //Pega o conteúdo da coluna "id_usuario" do ResultSet (rs)
                artigo.setIdUsuario(rs.getInt("id_usuario") ); 
                //Pega o conteúdo da coluna "id_categoria" do ResultSet (rs)
                artigo.setIdCategoria(rs.getInt("id_categoria") ); 
                //Pega o conteúdo da coluna "titulo" do ResultSet (rs)
                artigo.setTitulo( rs.getString("titulo") );
                //Pega o conteúdo da coluna "conteudo" do ResultSet (rs)
                artigo.setConteudo(rs.getString("conteudo") );
                 //Pega o conteúdo da coluna "liberar" do ResultSet (rs)
                artigo.setLiberar(rs.getString("liberar") );
                //Pega o conteúdo da coluna "aprovado" do ResultSet (rs)
                artigo.setAprovado(rs.getString("aprovado") );
                //Adiciona o objeto criado na ArrayList resultado
                resultado.add(artigo);
            }
        } catch( SQLException e ) {
            System.out.println("Erro de SQL: " + e.getMessage());
        }        
        // Retorna a lista de Contatos encontrados no banco de dados.
        return resultado;
    }
    
    
    public Artigo getArtigoPorID( int codigo ) {
        Artigo artigo = new Artigo();
        try {
            String sql = "SELECT * FROM artigo WHERE id = ?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, codigo);
            
            ResultSet rs = ps.executeQuery();
            
            if ( rs.next() ) {
                artigo.setId(rs.getInt("id"));
                artigo.setIdUsuario(rs.getInt("id_usuario"));
                artigo.setIdCategoria(rs.getInt("id_categoria"));
                artigo.setTitulo( rs.getString("titulo") );
                artigo.setConteudo(rs.getString("conteudo") );
                artigo.setLiberar(rs.getString("liberar") );
                artigo.setAprovado(rs.getString("aprovado") );
            }
            
        } catch( SQLException e ) {
            System.out.println("Erro de SQL: " + e.getMessage());
        }
        return artigo;
    }
    
    public ArrayList<Artigo> getListaAprovadosLiberados() {
        //Cria o objeto resultado que irá armazenar os registros retornados do BD
        ArrayList<Artigo> resultado = new ArrayList<>();
        try {            
            // Cria o objeto para quer será utilizado para enviar comandos SQL
            // para o BD
            Statement stmt = conexao.createStatement();
            // Armazena o resultado do comando enviado para o banco de dados
            ResultSet rs = stmt.executeQuery("select * from artigo  where liberar='S' and aprovado='S'");
            // rs.next() Aponta para o próximo registro do BD, se houver um 
            while( rs.next() ) {
                //Cria o objeto da classe Contato para armazenar os dados
                //que vieram do BD
                Artigo artigo = new Artigo();
                //Pega o conteúdo da coluna "id" do ResultSet (rs)
                artigo.setId(rs.getInt("id") );                
                //Pega o conteúdo da coluna "titulo" do ResultSet (rs)
                artigo.setTitulo( rs.getString("titulo") );
                //Pega o conteúdo da coluna "conteudo" do ResultSet (rs)
                artigo.setConteudo(rs.getString("conteudo") );
                 //Pega o conteúdo da coluna "liberar" do ResultSet (rs)
                artigo.setAprovado(rs.getString("liberar") );
                //Pega o conteúdo da coluna "aprovado" do ResultSet (rs)
                artigo.setAprovado(rs.getString("aprovado") );
                //Adiciona o objeto criado na ArrayList resultado
                resultado.add(artigo);
            }
        } catch( SQLException e ) {
            System.out.println("Erro de SQL: " + e.getMessage());
        }        
        // Retorna a lista de Contatos encontrados no banco de dados.
        return resultado;
    }   

    public Artigo aprovar( int id , Artigo artigo) {        
        try {
            // Realizar uma alteração
            String sql = "UPDATE artigo SET aprovado=? WHERE id=?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, "S");
            ps.setInt(2, id);
            ps.execute();
            return artigo;
        } catch( SQLException e ) {
            System.out.println("Erro de SQL: " + e.getMessage());
            return artigo;
        }    
    }
    
    public Artigo desaprovar( int id , Artigo artigo) {        
        try {
            // Realizar uma alteração
            String sql = "UPDATE artigo SET aprovado=? WHERE id=?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, "N");
            ps.setInt(2, id);
            ps.execute();
            return artigo;
        } catch( SQLException e ) {
            System.out.println("Erro de SQL: " + e.getMessage());
            return artigo;
        }    
    }
    
    public Artigo liberar( int id , Artigo artigo) {        
        try {
            // Realizar uma alteração
            String sql = "UPDATE artigo SET liberar=? WHERE id=?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, "S");
            ps.setInt(2, id);
            ps.execute();
            return artigo;
        } catch( SQLException e ) {
            System.out.println("Erro de SQL: " + e.getMessage());
            return artigo;
        }    
    }   
        
    
    public boolean excluir( int id ) {
        try {
            String sql = "DELETE FROM artigo WHERE id = ?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
            return true;
        } catch( SQLException e ) {
            System.out.println("Erro de SQL: " + e.getMessage());
            return false;
        } 
    }
    
    public void editar(Artigo artigo){
        try{
        String sql;  
        // Realizar uma alteração
        sql = "UPDATE artigo SET titulo=?, conteudo=? WHERE id=?";              
        PreparedStatement ps = this.conexao.prepareStatement(sql);        
        ps.setString(1, artigo.getTitulo());
        ps.setString(2, artigo.getConteudo());
        ps.setInt(3, artigo.getId());
        ps.executeUpdate(); 
        }catch(SQLException e) {
            System.out.println("Erro de SQL: " + e.getMessage());
        }    
    }
       
    public void criarArtigo(Artigo artigo){
        try {// Realizar uma inclusão
            String sql;        
            sql = "INSERT INTO artigo (id_usuario, id_categoria, titulo, conteudo, liberar, aprovado) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = this.conexao.prepareStatement(sql);
            ps.setInt(1, artigo.getIdUsuario());
            ps.setInt(2, artigo.getIdCategoria());
            ps.setString(3, artigo.getTitulo());
            ps.setString(4, artigo.getConteudo());
            ps.setString(5, artigo.getLiberar());
            ps.setString(6, artigo.getAprovado());
            ps.execute();            
        } catch (SQLException e) {
            System.out.println("Erro de SQL: " + e.getMessage());
        } 
    }    
    
        
    
}
