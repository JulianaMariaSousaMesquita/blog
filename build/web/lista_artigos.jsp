<%@page import="aplicacao.Artigo"%>
<%@page import="java.util.ArrayList"%>
<jsp:include page="/ArtigoController" />
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
            <h1> Lista artigos </h1>     
            <p></p>
            <a href="cadastro_artigo.jsp" class="btn btn-outline-primary">Incluir</a>
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
                            <th scope="col"><div class="float-right">Ações</div><br></th>
                        </tr>
                    </thead> 
                    <tbody>
          <div class="row">      
        <% for (int i = 0; i < ListaArtigo.size(); i++) {
            Artigo aux = ListaArtigo.get(i);            
            String link_aprovar = "ArtigoController?acao=aprovar&id="+aux.getId();
            String link_desaprovar = "ArtigoController?acao=desaprovar&id="+aux.getId();
            String link_excluir = "ArtigoController?acao=excluir&id="+aux.getId();
        %>            
        <div class="col-sm-6 col-md-4">
            <tr>
                <td><%= aux.getId()%></td>     
                <td><%= aux.getIdUsuario()%></td> 
                <td><%= aux.getTitulo()%></td>
                <td><%= aux.getConteudo()%></td>
                <td><%= aux.getAprovado()%></td>
                <td>  <br><br><br> <a href="<%=link_aprovar%>" class="btn btn-outline-success float-right">Aprovar</a> <br><br><br>
                    <a href="<%=link_desaprovar%>" class="btn btn-outline-warning float-right">Desaprovar</a> <br><br><br>
                      <a href="<%=link_excluir%>" class="btn btn-outline-danger float-right">Excluir</a> 
                </td>
            </tr>
            </div>         
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


