<%@page import="aplicacao.Comentario"%>
<%@page import="controller.ComentarioController"%>
<%@page import="controller.ArtigoController"%>
<%@page import="java.util.ArrayList"%>
<% ArrayList<Comentario> ListaComentario = (ArrayList<Comentario>) request.getAttribute("ListaComentario");%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>  

<!DOCTYPE html>
<html>
    <head>
        <%@include file="cabecalho.html" %>
    </head>
    <body>
        <jsp:include page="menu.jsp" />
        <div class="container mt-2">            
            <br><br>                   
            <h1> Comentarios </h1>     
            <p></p>
            <a href="cadastro_comentario.jsp" class="btn btn-outline-primary">Incluir</a>
            <p></p>
            <div class="table-responsive">
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th scope="col">Id</th>
                            <th scope="col">Comentario</th>
                            <th scope="col">Id Artigo</th>
                            <th scope="col">Id Usuario</th>
                        </tr>
                    </thead> 
                    <tbody>
          <div class="row">      
        <% int inteiro = (Integer)session.getAttribute("id");
        for (int i = 0; i < ListaComentario.size(); i++) {
            Comentario aux = ListaComentario.get(i);
            if(aux.getIdUsuario() == inteiro){
                String link_excluir = "ComentarioController?acao=excluir&id="+aux.getId();
                String link_editar = "ComentarioController?acao=editar&id="+aux.getId();
        %>            
                <div class="col-sm-6 col-md-4">
                    <tr>
                        <td><%= aux.getId()%></td>                
                        <td><%= aux.getComentario()%></td>
                        <td><%= aux.getIdArtigo()%></td>
                        <td><%= aux.getIdUsuario()%></td>
                        <td>  <br><br><br> 
                            <a href="<%=link_editar%>" class="btn btn-outline-warning float-right">Editar</a> <br><br><br>                        
                          <a href="<%=link_excluir%>" class="btn btn-outline-danger float-right">Excluir</a> 
                    </td>
                    </tr>
                </div>         
           <%}%>
        <%}%>
  </div> 
                    </tbody>
                </table>
            </div>
        </div>
        <%@include file="rodape.html" %>
        <%@include file="scripts.html" %>
    </body>
</html>


