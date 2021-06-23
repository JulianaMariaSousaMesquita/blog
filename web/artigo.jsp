<%@page import="model.ComentarioDAO"%>
<%@page import="aplicacao.Artigo"%>
<%@page import="aplicacao.Comentario"%>
<%@page import="controller.ArtigoController"%>
<%@page import="controller.ComentarioController"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>  
<head>
        <jsp:include page="cabecalho.html" />
    </head>
    <body>
        <jsp:include page="menu.jsp" />
        <div class="container">
            <% Artigo aux = ((Artigo) request.getAttribute("artigo")); %>
            <div class="lg">
                <img src="images/meditacao_guiada_vx_mindfulness.jpg" class="img-thumbnail container-fluid" alt="Imagem responsiva">
                    <br><br>
                    <h1><%=aux.getTitulo()%></h1>              
                    <h5><%=aux.getConteudo()%></h5>
                    <br><br>
            </div>
                   
                    <br>
                    <h2> Comentarios: </h2>
            <div class="lg">
              <%  ComentarioDAO comentariodao = new ComentarioDAO();                  
                  ArrayList<Comentario> ListaComentario = (ArrayList<Comentario>) request.getAttribute("ListaComentario");
                  ListaComentario = comentariodao.getLista();
                  for (int i = 0; i < ListaComentario.size(); i++) {
                        Comentario comentario = ListaComentario.get(i);
                        if((Integer)comentario.getIdArtigo() == (Integer) aux.getId()){
                 %>
                 <%=comentario.getComentario()%> <br>
                 <b> Postado por Id Usuario </b> <%=comentario.getIdUsuario()%>                 
                 <br><br>
                 <div class="dropdown-divider"></div>
                    <%}%>
                <%}%>                
              <br><br>                
            </div>
        </div> 
    <jsp:include page="rodape.html" />
    <jsp:include page="scripts.html" />
  </body>
</html>