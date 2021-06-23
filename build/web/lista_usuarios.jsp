<%@page import="aplicacao.Usuario"%>
<%@page import="java.util.ArrayList"%>
<jsp:include page="/UsuarioController" />
<% ArrayList<Usuario> ListaUsuario = (ArrayList<Usuario>) request.getAttribute("ListaUsuario");%>
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
            <h1>Lista de Usuarios </h1>     
            <p></p>
            <a href="UsuarioController?acao=incluir" class="btn btn-outline-primary">Incluir novo usuario</a>
            <p></p>
            <div class="table-responsive">
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th scope="col">Id</th>
                            <th scope="col">Nome</th>
                            <th scope="col">E-mail</th>
                            <th scope="col">Papel</th>
                            <th scope="col">Status aprovação</th>
                            <th scope="col"><div class="float-right">Ações</div><br></th>
                        </tr>
                    </thead> 
                    <tbody>
          <div class="row">      
        <% for (int i = 1; i < ListaUsuario.size(); i++) {
            Usuario aux = ListaUsuario.get(i);            
            String link_aprovar = "UsuarioController?acao=aprovar&id="+aux.getId();
            String link_editar = "UsuarioController?acao=editar&id="+aux.getId();
            String link_excluir = "UsuarioController?acao=excluir&id="+aux.getId();
        %>            
        <div class="col-sm-6 col-md-4">
            <tr>
                <td><%= aux.getId()%></td>                
                <td><%= aux.getNome()%></td>
                <td><%= aux.getEmail()%></td>
                <td><%= aux.getPapel()%></td>
                <td><%= aux.getAprovado()%></td>
                <td> <% if(aux.getAprovado().equals("N")){ %> <a href="<%=link_aprovar%>" class="btn btn-outline-success float-right">Aprovar</a><br><br> <% }%>
                     <a href="<%=link_editar%>" class="btn btn-outline-warning float-right">Editar</a> <br><br>
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


