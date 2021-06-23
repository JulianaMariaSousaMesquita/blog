<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.*,aplicacao.*" %>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="cabecalho.html" %>
    </head>
    <body>
    <jsp:include page="menu.jsp" />
    <% String link_lista_artigos = "ArtigoController?acao=lista&id=";%>
    
    <% if ( session.getAttribute("aprovado").equals("S")) {%>
        <div class="alert alert-success" role="alert">
           <br>Seja Bem-vindo <%= session.getAttribute("NomeUsuarioLogado") %> ! <br> Você está logado com 
           papel <%= session.getAttribute("papel") %> <br>
            Dados conta <br> 
           Nome = <%= session.getAttribute("NomeUsuarioLogado") %> <br>
           Id de usuario =  <%= session.getAttribute("id") %>  <br>
            <br>
          </div>
          <%  if (session.getAttribute("papel").equals(0)) {%>
              <div class="container mt-2">
                  <br> <br>      
                  <a href="lista_artigos.jsp" class="btn btn-lg btn-block btn-block btn-outline-success" > Artigos aguardando aprovação </a>
                  <br>     
                  <a href="ArtigoController?acao=meuartigo" class="btn btn-outline-danger" > Meus Artigos </a>    
                 
                  <a href="ArtigoController?acao=incluir" class="btn btn-outline-secondary"> Incluir novo Artigo </a>
                  <br><br><br><br>
                  
                  <a href="lista_usuarios.jsp" class="btn btn-outline-primary btn-lg btn-block btn-block" > Usuarios aguardando aprovação</a><br>
                  <a href="UsuarioController?acao=incluir" class="btn btn-outline-secondary">Incluir novo usuario</a>
                  <br><br><br><br>
                  
                  <a href="lista_comentarios.jsp" class="btn btn-outline-warning btn-lg btn-block" > Lista de comentarios </a> <br>
                  
                  <a href="ComentarioController?acao=meucomentario" class="btn btn-outline-danger" > Meus Comentarios</a>
                  
                 <a href="cadastro_comentario.jsp" class="btn btn-outline-secondary">Incluir comentario</a>
                  <br><br><br><br>

                  </div>
          <%}else if(session.getAttribute("papel") .equals(1)){%>
          <div class="container mt-2">                 
                  <br> <br>      
                  <a href="ArtigoController?acao=meuartigo" class="btn btn-outline-warning btn-lg btn-block btn-block" > Meus Artigos </a> 
                  <br> <br>
                  <a href="cadastro_artigo.jsp" class="btn btn-outline-primary btn-lg btn-block"> Incluir novo Artigo </a>
                  <br><br><br><br>
                  
                 <%-- <a href="ComentarioController?acao=meucomentario" class="btn btn-outline-warning btn-lg btn-block" > Meus Comentarios</a>
                  <br> <br>
                 <a href="cadastro_comentario.jsp" class="btn btn-outline-primary btn-lg btn-block">Incluir comentario</a>--%>
                  <br><br><br><br>

                  </div>
       <%}else if(session.getAttribute("papel").equals(2)){%>
          <div class="container mt-2">
                  <a href="ComentarioController?acao=meucomentario" class="btn btn-outline-warning btn-lg btn-block" > Meus Comentarios</a>
                  <br> <br>
                 <a href="cadastro_comentario.jsp" class="btn btn-outline-primary btn-lg btn-block">Incluir comentario</a>
                  <br><br><br><br>
                  
           </div>
   <% }} else {%>
        <div class="alert alert-danger" role="alert">
           Usuario <%= session.getAttribute("NomeUsuarioLogado") %>  ainda não foi aprovado pelo administrador! 
           <br><br>
           <h2>Aguarde administrador aprovar seu cadastro!</h2> <br>
           <br>
           Dados conta <br> 
           Nome = <%= session.getAttribute("NomeUsuarioLogado") %> <br>
           Papel =  <%= session.getAttribute("papel") %>   <br>
           Status = Aguardando aprovação<br>
          </div>
    <%}%>
        <%@include file="rodape.html" %>
        <%@include file="scripts.html" %>
    </body>
</html>          