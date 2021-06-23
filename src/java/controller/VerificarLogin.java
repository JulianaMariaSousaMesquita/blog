package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.UsuarioDAO;
import aplicacao.Usuario;


@WebServlet(name = "VerificarLogin", urlPatterns = {"/VerificarLogin"})
public class VerificarLogin extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String cpf_user = request.getParameter("cpf");
        String senha_user = request.getParameter("senha");

        UsuarioDAO usuariodao = new UsuarioDAO();        
        Usuario usuario = usuariodao.getUsuario(cpf_user, senha_user);
        
        if (usuario != null){            
            HttpSession session = request.getSession();
            session.setAttribute("NomeUsuarioLogado", usuario.getNome());
            session.setAttribute("id", usuario.getId());
            session.setAttribute("papel", usuario.getPapel());
            session.setAttribute("aprovado", usuario.getAprovado());
            session.setAttribute("logado", "S");

            RequestDispatcher resposta = request.getRequestDispatcher("logado.jsp");
            resposta.forward(request, response);
        } else {
            response.sendRedirect("erro_login.jsp");
        }
    }

}
