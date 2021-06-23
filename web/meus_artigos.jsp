<%@page import="aplicacao.Artigo"%>
<%@page import="controller.ArtigoController"%>
<%@page import="java.util.ArrayList"%>
<% ArrayList<Artigo> ListaArtigo = (ArrayList<Artigo>) request.getAttribute("ListaArtigo");%>
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
            <h1> Meus artigos </h1>     
            <p></p>
            <a href="ArtigoController?acao=incluir" class="btn btn-outline-primary">Incluir</a>
            <p></p>
            <div class="table-responsive">
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th scope="col">Id Artigo</th>
                            <th scope="col">Id Usuario</th>
                            <th scope="col">Titulo</th>
                            <th scope="col">Conteudo</th>
                            <th scope="col">Status aprovação</th>
                            <th scope="col">Status Liberar</th>
                            <th scope="col"><div class="float-right">Ações</div><br></th>
                        </tr>
                    </thead> 
                    <tbody>
          <div class="row">      
        <% 
        int inteiro = (Integer)session.getAttribute("id");
        for (int i = 0; i < ListaArtigo.size(); i++) {
            Artigo aux = ListaArtigo.get(i);
            if(aux.getIdUsuario() == inteiro){
                String link_excluir = "ArtigoController?acao=excluir&id="+aux.getId();
                String link_liberar = "ArtigoController?acao=liberar&id="+aux.getId();
                String link_editar = "ArtigoController?acao=editar&id="+aux.getId();
            %>            
            <div class="col-sm-6 col-md-4">
                <tr>
                    <td><%= aux.getId()%></td>      
                    <td><%= aux.getIdUsuario()%></td> 
                    <td><%= aux.getTitulo()%></td>
                    <td><%= aux.getConteudo()%></td>
                    <td><%= aux.getAprovado()%></td>
                    <td><%= aux.getLiberar()%></td>
                    <td>  <br><br><br>
                        <a href="<%=link_liberar%>" class="btn btn-outline-success float-right">Liberar</a> <br><br><br>
                        <% if(aux.getAprovado().equals("N")){ %> <a href="<%=link_editar%>" class="btn btn-outline-warning float-right">Editar</a> <br><br><br> 
                          <a href="<%=link_excluir%>" class="btn btn-outline-danger float-right">Excluir</a> <% } %>
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







