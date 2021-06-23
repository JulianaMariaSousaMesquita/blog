<%@page import="aplicacao.Artigo"%>
<%@page import="java.util.ArrayList"%>
<% ArrayList<Artigo> ListaArtigo = (ArrayList<Artigo>) request.getAttribute("ListaArtigo");%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="cabecalho.html" />
    </head>
    <body>
        <jsp:include page="menu.jsp" />
         <div class="container">
            <div class="row">      
            <% 
                if (ListaArtigo !=null)  //acabar o teste se é null...
                for (int i = 0; i < ListaArtigo.size(); i++) {
                Artigo aux = ListaArtigo.get(i);
                int id = aux.getId();
                
            %>            
            <div class="col-sm-6 col-md-4">
              <div class="thumbnail">
                <img src="images/meditacao_guiada_vx_mindfulness.jpg" alt=" Imagem de Mulher meditando">
                <div class="caption">
                    <h1><%=aux.getTitulo()%></h1>              
                    <h5><%=aux.getConteudo()%></h5>
                  <p><a href="ArtigoController?acao=artigo&id=<%= id %>" class="btn btn-secondary" role="button">Leia Mais</a>
                </div>
              </div>
            </div>
           <%}%>       
    </div> 
  </div>
    <jsp:include page="rodape.html" />
    <jsp:include page="scripts.html" />
  </body>
</html>