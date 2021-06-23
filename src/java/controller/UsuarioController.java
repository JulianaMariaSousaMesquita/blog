package controller;

import aplicacao.Usuario;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.UsuarioDAO;

@WebServlet(name = "UsuarioController", urlPatterns = {"/UsuarioController"})
public class UsuarioController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Usuario usuario = new Usuario();
        UsuarioDAO usuariodao = new UsuarioDAO();

        ArrayList<Usuario> ListaUsuario = usuariodao.getLista();
        request.setAttribute("ListaUsuario",ListaUsuario);
        String acao = (String) request.getParameter("acao");
        int id;

        if (acao != null) {
            switch (acao) {
                case "mostrar":
                    ListaUsuario = usuariodao.getLista();
                    request.setAttribute("ListaUsuario", ListaUsuario);
                    RequestDispatcher mostrar = getServletContext().getRequestDispatcher("/lista_usuarios.jsp");
                    mostrar.forward(request, response);
                    break;     
                    
                case "aprovar":
                    id = Integer.parseInt(request.getParameter("id"));
                    usuario = usuariodao.getUsuarioPorID(id);
                    usuario = usuariodao.aprovar(id, usuario);

                    if (usuario.getId() != 0) {
                        String mensagem = "Usuario aprovado com sucesso!";
                        request.setAttribute("mensagem", mensagem);
                        RequestDispatcher rd = getServletContext().getRequestDispatcher("/mensagem.jsp");
                        rd.forward(request, response);
                    } else {
                        String mensagem = "Erro ao gravar usuario!";
                        request.setAttribute("mensagem", mensagem);
                        RequestDispatcher rd = getServletContext().getRequestDispatcher("/mensagem.jsp");
                        rd.forward(request, response);
                    }
                    break;

                case "excluir":
                    id = Integer.parseInt(request.getParameter("id"));
                    usuariodao.excluir(id);

                    ListaUsuario = usuariodao.getLista();
                    request.setAttribute("ListaUsuario", ListaUsuario);
                    RequestDispatcher excluir = getServletContext().getRequestDispatcher("/logado.jsp");
                    excluir.forward(request, response);
                    break;
                    
              case "editar":
                id = Integer.parseInt(request.getParameter("id"));
                usuario = usuariodao.getUsuarioPorID(id);                
                if (usuario.getId() > 0) {
                    request.setAttribute("usuario", usuario);
                    RequestDispatcher editar = request.getRequestDispatcher("editar_usuario.jsp");
                    editar.forward(request, response);
                } else {
                    String mensagem = "Erro ao editar usuario!";
                    request.setAttribute("mensagem", mensagem);
                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/mensagem.jsp");
                    rd.forward(request, response);
                }
                break;
                
               case "incluir":
                usuario.setId(0);
                usuario.setAprovado("N");                
                request.setAttribute("usuario", usuario);
                RequestDispatcher incluir = request.getRequestDispatcher("cadastro.jsp");
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
            Usuario usuario = new Usuario();
            UsuarioDAO dao = new UsuarioDAO();
            
            usuario.setId(Integer.parseInt(request.getParameter("id")));
            usuario.setNome(request.getParameter("nome"));
            usuario.setEmail(request.getParameter("email"));
            usuario.setCpf(request.getParameter("cpf"));
            usuario.setSenha(request.getParameter("senha"));
            usuario.setPapel(Integer.parseInt(request.getParameter("papel")));
            usuario.setAprovado(request.getParameter("aprovado"));
            
            if(Integer.parseInt(request.getParameter("id")) == 0){
               boolean r = dao.criarUsuario(usuario);
                if(r == true){
                    dao.criarUsuario(usuario);
                    mensagem =  "Usuario cadastrado com sucesso!";
                    request.setAttribute("mensagem", mensagem);
                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/mensagem.jsp");
                    rd.forward(request, response);
                }else{
                    mensagem =  " CPF já cadastrado!";
                    request.setAttribute("mensagem", mensagem);
                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/mensagem.jsp");
                    rd.forward(request, response);
                }
            }else{
                dao.editar(usuario); 
            }          

            mensagem = "sucesso ";          
            request.setAttribute("mensagem", mensagem);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/mensagem.jsp");
            rd.forward(request, response);

        } catch (Exception e) {
            mensagem = "Erro ao gravar usuario!";
            request.setAttribute("mensagem", mensagem);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/mensagem.jsp");
            rd.forward(request, response);
        }        
    }
    
    }
