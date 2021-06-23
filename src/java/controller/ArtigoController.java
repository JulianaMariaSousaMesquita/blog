package controller;

import aplicacao.Artigo;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.ArtigoDAO;

@WebServlet(name = "ArtigoController", urlPatterns = {"/ArtigoController"})
public class ArtigoController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Artigo artigo = new Artigo();
        ArtigoDAO artigodao = new ArtigoDAO();

        ArrayList<Artigo> ListaArtigo = artigodao.getLista();
        request.setAttribute("ListaArtigo",ListaArtigo);
        String acao = (String) request.getParameter("acao");
        int id;

        if (acao != null) {
            switch (acao) {
                case "mostrar":
                    ListaArtigo = artigodao.getListaAprovadosLiberados();
                    request.setAttribute("ListaArtigo", ListaArtigo);
                    RequestDispatcher mostrar = getServletContext().getRequestDispatcher("/artigos_aprovados.jsp");
                    mostrar.forward(request, response);
                    break;
                
                case "meuartigo":
                    ListaArtigo = artigodao.getLista();
                    request.setAttribute("ListaArtigo", ListaArtigo);
                    RequestDispatcher meuartigo = getServletContext().getRequestDispatcher("/meus_artigos.jsp");
                    meuartigo.forward(request, response);
                    break;
                    
                 case "artigo":
                     id = Integer.parseInt(request.getParameter("id"));
                     if (id != 0) {                        
                        artigo = artigodao.getArtigoPorID(id);
                        request.setAttribute("artigo", artigo);
                        RequestDispatcher artigoporid = getServletContext().getRequestDispatcher("/artigo.jsp");
                        artigoporid.forward(request, response);
                    }
                    break;

                case "aprovar":
                    id = Integer.parseInt(request.getParameter("id"));
                    artigo = artigodao.getArtigoPorID(id);
                    artigo = artigodao.aprovar(id, artigo);

                    if (artigo.getId() != 0) {
                        String mensagem = "Artigo aprovado com sucesso!";
                        request.setAttribute("mensagem", mensagem);
                        RequestDispatcher rd = getServletContext().getRequestDispatcher("/mensagem.jsp");
                        rd.forward(request, response);
                    } else {
                        String mensagem = "Erro ao gravar artigo!";
                        request.setAttribute("mensagem", mensagem);
                        RequestDispatcher rd = getServletContext().getRequestDispatcher("/mensagem.jsp");
                        rd.forward(request, response);
                    }
                    break;
                    
                    case "desaprovar":
                    id = Integer.parseInt(request.getParameter("id"));
                    artigo = artigodao.getArtigoPorID(id);
                    artigo = artigodao.desaprovar(id, artigo);

                    if (artigo.getId() != 0) {
                        String mensagem = "Artigo desaprovado com sucesso!";
                        request.setAttribute("mensagem", mensagem);
                        RequestDispatcher rd = getServletContext().getRequestDispatcher("/mensagem.jsp");
                        rd.forward(request, response);
                    } else {
                        String mensagem = "Erro ao desaprovar artigo!";
                        request.setAttribute("mensagem", mensagem);
                        RequestDispatcher rd = getServletContext().getRequestDispatcher("/mensagem.jsp");
                        rd.forward(request, response);
                    }
                    break;

                case "liberar":
                    id = Integer.parseInt(request.getParameter("id"));
                    artigo = artigodao.getArtigoPorID(id);
                    artigo = artigodao.liberar(id, artigo);

                    if (artigo.getId() != 0) {
                        String mensagem = "Artigo liberado com sucesso!";
                        request.setAttribute("mensagem", mensagem);
                        RequestDispatcher rd = getServletContext().getRequestDispatcher("/mensagem.jsp");
                        rd.forward(request, response);
                    } else {
                        String mensagem = "Erro ao liberar artigo!";
                        request.setAttribute("mensagem", mensagem);
                        RequestDispatcher rd = getServletContext().getRequestDispatcher("/mensagem.jsp");
                        rd.forward(request, response);
                    }
                    break;

              case "excluir":
                    id = Integer.parseInt(request.getParameter("id"));
                    artigodao.excluir(id);

                    ListaArtigo = artigodao.getLista();
                    request.setAttribute("ListaArtigo", ListaArtigo);
                    RequestDispatcher aposexcluir = getServletContext().getRequestDispatcher("/logado.jsp");
                    aposexcluir.forward(request, response);
                    break;
                    
              case "editar":
                id = Integer.parseInt(request.getParameter("id"));
                artigo = artigodao.getArtigoPorID(id);                
                if (artigo.getId() > 0) {
                    request.setAttribute("artigo", artigo);
                    RequestDispatcher editar = request.getRequestDispatcher("editar_artigo.jsp");
                    editar.forward(request, response);
                } else {
                    String mensagem = "Erro ao editar artigo!";
                    request.setAttribute("mensagem", mensagem);
                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/mensagem.jsp");
                    rd.forward(request, response);
                }
                break;
                
               case "incluir":
                artigo.setId(0); 
                artigo.setIdCategoria(0);
                artigo.setIdUsuario(0);                
                artigo.setTitulo("");                
                artigo.setConteudo("");
                artigo.setLiberar("N");
                artigo.setAprovado("N");                
                request.setAttribute("artigo", artigo);
                RequestDispatcher incluir = request.getRequestDispatcher("cadastro_artigo.jsp");
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
            Artigo artigo = new Artigo();
            ArtigoDAO dao = new ArtigoDAO();
            
            artigo.setId(Integer.parseInt(request.getParameter("id_artigo")));
            artigo.setIdUsuario(Integer.parseInt(request.getParameter("id_usuario")));
            artigo.setIdCategoria(Integer.parseInt(request.getParameter("id_categoria")));
            artigo.setTitulo(request.getParameter("titulo"));
            artigo.setConteudo(request.getParameter("conteudo"));
            artigo.setLiberar(request.getParameter("liberar"));
            artigo.setAprovado(request.getParameter("aprovado"));
            
            if(Integer.parseInt(request.getParameter("id_artigo")) == 0){
                dao.criarArtigo(artigo); 
            } else{
                dao.editar(artigo); 
            }          

            mensagem = "sucesso";
            request.setAttribute("mensagem", mensagem);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/mensagem.jsp");
            rd.forward(request, response);

        } catch (Exception e) {
            mensagem = "Erro ao gravar artigo!";
            request.setAttribute("mensagem", mensagem);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/mensagem.jsp");
            rd.forward(request, response);
        }        
    }
    
    }
