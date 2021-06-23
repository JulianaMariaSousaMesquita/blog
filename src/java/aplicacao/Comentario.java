package aplicacao;

public class Comentario{
    private int id;    
    private String comentario;   
    private int id_artigo;
    private int id_usuario; 

    public Comentario(int id, String comentario, int id_artigo, int id_usuario){
        this.id = id;
        this.comentario = comentario;
        this.id_artigo = id_artigo;
        this.id_usuario = id_usuario;
    }
    
    public Comentario() {        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
  
    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
    
    public int getIdArtigo() {
        return id_artigo;
    }

    public void setIdArtigo(int id_artigo) {
        this.id_artigo = id_artigo;
    }
    
    public int getIdUsuario() {
        return id_usuario;
    }

    public void setIdUsuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }
}
