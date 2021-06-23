package aplicacao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Artigo{
    private Integer id;
    private Integer id_usuario;
    private Integer id_categoria;
    private String titulo;
    private String conteudo;
    private String liberar;
    private String aprovado;   

    public Artigo(Integer id, Integer id_usuario, Integer id_categoria, String titulo, String conteudo, String liberar, String aprovado) {
        this.id = id;
        this.id_usuario = id_usuario;
        this.id_categoria = id_categoria;
        this.titulo = titulo;
        this.conteudo = conteudo;
        this.liberar = liberar;
        this.aprovado = aprovado;
    }
    
    public Artigo() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public int getIdUsuario() {
        return id_usuario;
    }

    public void setIdUsuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }
    
    public int getIdCategoria() {
        return id_categoria;
    }

    public void setIdCategoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }
    
     public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
     public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }
    
    public String getLiberar() {
        return liberar;
    }

    public void setLiberar(String liberar) {
        this.liberar = liberar;
    }
    
    public String getAprovado() {
        return aprovado;
    }

    public void setAprovado(String aprovado) {
        this.aprovado = aprovado;
    }

    public void forward(HttpServletRequest request, HttpServletResponse response) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   

}
