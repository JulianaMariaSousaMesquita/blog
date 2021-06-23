package controller;

import aplicacao.Comentario;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.ComentarioDAO;

@WebServlet(name = "ComentarioController", urlPatterns = {"/ComentarioController"})
public class ComentarioController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        Comentario comentario = new Comentario();
        ComentarioDAO comentariodao = new ComentarioDAO();

        ArrayList<Comentario> ListaComentario = comentariodao.getLista();
        request.setAttribute("ListaComentario",ListaComentario);
        String acao = (String) request.getParameter("acao");
        int id;
        
        if (acao != null) {
            switch (acao) {
                case "mostrar":
                    ListaComentario = comentariodao.getLista();
                    request.setAttribute("ListaComentario", ListaComentario);
                    RequestDispatcher mostrar = getServletContext().getRequestDispatcher("/lista_comentarios.jsp");
                    mostrar.forward(request, response);
                    break;
                    
                case "meucomentario":
                    ListaComentario = comentariodao.getLista();
                    request.setAttribute("ListaComentario", ListaComentario);
                    RequestDispatcher meucomentario = getServletContext().getRequestDispatcher("/meus_comentarios.jsp");
                    meucomentario.forward(request, response);
                    break;
                
                case "excluir":
                    id = Integer.parseInt(request.getParameter("id"));
                    comentariodao.excluir(id);

                    ListaComentario = comentariodao.getLista();
                    request.setAttribute("ListaComentario", ListaComentario);
                    RequestDispatcher aposexcluir = getServletContext().getRequestDispatcher("/logado.jsp");
                    aposexcluir.forward(request, response);
                    break;   
                    
                case "editar":
                    comentario = comentariodao.getComentarioPorID(Integer.parseInt(request.getParameter("id")));                
                    request.setAttribute("comentario", comentario);
                    RequestDispatcher editar = request.getRequestDispatcher("editar_comentario.jsp");
                    editar.forward(request, response);                    
                    break;
                
                case "incluir":
                 comentario.setId(0);           
                 request.setAttribute("comentario", comentario);
                 RequestDispatcher incluir = request.getRequestDispatcher("cadastro_comentario.jsp");
                 incluir.forward(request, response);                
                 break;
            }
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String mensagem;
        try {
            Comentario comentario = new Comentario();
            ComentarioDAO dao = new ComentarioDAO();
            
            comentario.setId(Integer.parseInt(request.getParameter("id")));
            comentario.setComentario(request.getParameter("comentario"));
            comentario.setIdArtigo(Integer.parseInt(request.getParameter("id_artigo")));
            comentario.setIdUsuario(Integer.parseInt(request.getParameter("id_usuario")));
                        
            if(Integer.parseInt(request.getParameter("id")) == 0){
                dao.criarComentario(comentario); 
            } else{
                dao.editar(comentario); 
            }  
            
            mensagem = "sucesso";
            request.setAttribute("mensagem", mensagem);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/mensagem.jsp");
            rd.forward(request, response);

        } catch (Exception e) {
            mensagem = "Erro ao gravar comentario!";
            request.setAttribute("mensagem", mensagem);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/mensagem.jsp");
            rd.forward(request, response);
        }

    }
}
