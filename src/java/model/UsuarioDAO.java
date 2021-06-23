package model;

import aplicacao.Usuario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

    public class UsuarioDAO {
    
    private Connection conexao = null;
    
    // Ao inves de montar manualmente em cada funcao, reutilizamos;    
    private Usuario instantiateUsuario(ResultSet rs) throws SQLException {
        Usuario dep = new Usuario(rs.getInt("id"), rs.getString("nome"), rs.getString("email"), rs.getString("cpf"), rs.getString("senha"), rs.getInt("papel"), rs.getString("aprovado"));
        return dep;
    }  

    public UsuarioDAO() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/blog", "root", "");
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
     public ArrayList<Usuario> getLista() {
        //Cria o objeto resultado que irá armazenar os registros retornados do BD
        ArrayList<Usuario> resultado = new ArrayList<>();
        try {            
            // Cria o objeto para quer será utilizado para enviar comandos SQL
            // para o BD
            Statement stmt = conexao.createStatement();
            // Armazena o resultado do comando enviado para o banco de dados
            ResultSet rs = stmt.executeQuery("select * from usuario");
            // rs.next() Aponta para o próximo registro do BD, se houver um 
            while( rs.next() ) {
                //Cria o objeto da classe Contato para armazenar os dados
                //que vieram do BD
                Usuario usuario = new Usuario();
                //Pega o conteúdo da coluna "id" do ResultSet (rs)
                usuario.setId(rs.getInt("id") );                
                //Pega o conteúdo da coluna "nome" do ResultSet (rs)
                usuario.setNome( rs.getString("nome") );
                //Pega o conteúdo da coluna "email" do ResultSet (rs)
                usuario.setEmail(rs.getString("email") );
                //Pega o conteúdo da coluna "cpf" do ResultSet (rs)
                usuario.setEmail(rs.getString("cpf") );                
                //Pega o conteúdo da coluna "papel" do ResultSet (rs)
                usuario.setPapel(rs.getInt("papel") );
                //Pega o conteúdo da coluna "aprovado" do ResultSet (rs)
                usuario.setAprovado(rs.getString("aprovado") );
                //Adiciona o objeto criado na ArrayList resultado
                resultado.add(usuario);
            }
        } catch( SQLException e ) {
            System.out.println("Erro de SQL: " + e.getMessage());
        }
        
        // Retorna a lista de Contatos encontrados no banco de dados.
        return resultado;
    }
     
     public ArrayList<Usuario> getListaCPF() {
        //Cria o objeto resultado que irá armazenar os registros retornados do BD
        ArrayList<Usuario> resultado = new ArrayList<>();
        try {            
            Usuario usuario = new Usuario();
            Statement stmt = conexao.createStatement();
            // Armazena o resultado do comando enviado para o banco de dados
            ResultSet rs = stmt.executeQuery("select * from usuario");
            // rs.next() Aponta para o próximo registro do BD, se houver um 
            while( rs.next() ) {
                //Cria o objeto da classe Contato para armazenar os dados
                //que vieram do BD                
                //Pega o conteúdo da coluna "cpf" do ResultSet (rs)
                usuario.setCpf(rs.getString("cpf") );
                resultado.add(usuario);
            }
        } catch( SQLException e ) {
            System.out.println("Erro de SQL: " + e.getMessage());
        }
        
        // Retorna a lista de cpfs encontrados no banco de dados.
        return resultado;
    }
     
     public Usuario getUsuarioPorID( int codigo ) {
        Usuario usuario = new Usuario();
        try {
            String sql = "SELECT * FROM usuario WHERE id = ?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, codigo);
            
            ResultSet rs = ps.executeQuery();
            
            if ( rs.next() ) {
                usuario.setId(rs.getInt("id"));
                usuario.setNome(rs.getString("nome"));
                usuario.setEmail(rs.getString("email"));
                usuario.setCpf(rs.getString("cpf"));
                usuario.setPapel( rs.getInt("papel") );
                usuario.setAprovado(rs.getString("aprovado") );
            }
            
        } catch( SQLException e ) {
            System.out.println("Erro de SQL: " + e.getMessage());
        }
        return usuario;
    }
     
         public Usuario aprovar( int id , Usuario usuario) {        
        try {
            // Realizar uma alteração
            String sql = "UPDATE usuario SET aprovado=? WHERE id=?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, "S");
            ps.setInt(2, id);
            ps.execute();
            return usuario;
        } catch( SQLException e ) {
            System.out.println("Erro de SQL: " + e.getMessage());
            return usuario;
        }    
    }
    
    //Usado para verificar login
    public Usuario getUsuario(String cpf, String senha) {
        try {
            String sql = "SELECT * FROM usuario WHERE cpf = ? and senha = ? limit 1";
            PreparedStatement ps = this.conexao.prepareStatement(sql);
            ps.setString(1, cpf);
            ps.setString(2, senha);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Usuario dep = instantiateUsuario(rs);
                return dep;
            }
        } catch (SQLException e) {
            System.out.println("Erro de SQL: " + e.getMessage());
        }
        return null;
    }  
    
      public boolean excluir( int id ) {
        try {
            String sql = "DELETE FROM usuario WHERE id = ?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
            return true;
        } catch( SQLException e ) {
            System.out.println("Erro de SQL: " + e.getMessage());
            return false;
        } 
    }
    
    public void editar(Usuario usuario){
        try{
        String sql;  
        // Realizar uma alteração
        sql = "UPDATE usuario SET nome=?, email=?, senha=?  WHERE id=?";              
        PreparedStatement ps = this.conexao.prepareStatement(sql);        
        ps.setString(1, usuario.getNome());
        ps.setString(2, usuario.getEmail());
        ps.setString(3, usuario.getSenha());        
        ps.setInt(4, usuario.getId());
        ps.executeUpdate(); 
        }catch(SQLException e) {
            System.out.println("Erro de SQL: " + e.getMessage());
        }    
    }
    
     public boolean  criarUsuario(Usuario usuario){
        ArrayList<Usuario> ListaCPF = getListaCPF();
        for(int i = 0; i < ListaCPF.size(); i++){
           Usuario aux = ListaCPF.get(i);
           if(usuario.getCpf().equals(aux.getCpf())){
            return false;
            } 
        }
         try {
            String sql = "INSERT INTO usuario (nome, senha, email, cpf, papel, aprovado) VALUES (?,?,?,?,?,?)";
            PreparedStatement ps = this.conexao.prepareStatement(sql);
            ps.setString(1, usuario.getNome());
                ps.setString(2, usuario.getSenha());
                ps.setString(3, usuario.getEmail());
                ps.setString(4, usuario.getCpf());
                ps.setInt(5, usuario.getPapel());
                ps.setString(6, usuario.getAprovado());
                ps.executeUpdate();
                return true;
            } catch (SQLException e) {
                System.out.println("Erro de SQL: " + e.getMessage());
                return false;
            }
         
    
    }
 }
  
 

    
    
    
