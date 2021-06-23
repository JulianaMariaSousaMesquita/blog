<%@page import="model.ArtigoDAO"%>
<%@page import="aplicacao.Artigo"%>
<%@page import="controller.ArtigoController"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>  
<!DOCTYPE html>
<html>
<head>
<jsp:include page="cabecalho.html" />
</head>
<body>
	<jsp:include page="menu.jsp" />        
        <div class="container">
            <div class="row mb-3 mt-5">
                <div class="col-4 offset-4 card bg-ligth">
                    <form method="POST" action="ComentarioController" >
                        <h2 align="center">  CADASTRO COMENTARIO </h2><br>
                        <div class="form-group mt-2">           
                            <label class="control-label requerido" for="comentario"> Comentario </label>
                            <textarea name="comentario" id="comentario" class="form-control" placeholder="Digite texto" rows="3" required></textarea>
                        </div>
                        
                        <label> Selecione o artigo </label>
                        <% ArtigoDAO artigodao = new ArtigoDAO();
                            ArrayList<Artigo> ListaArtigo = artigodao.getLista();
                            request.setAttribute("ListaArtigo",ListaArtigo);
                            if(ListaArtigo != null){
                            for (int i = 0; i < ListaArtigo.size(); i++) {
                                Artigo aux = ListaArtigo.get(i); %>     
                        <div class="form-check">
                            <input class="form-check-input" type="radio" name="id_artigo" id="id_artigo" value="<%= aux.getId()%>" checked>
                            <label class="form-check-label" for="id_artigo">
                              <%= aux.getTitulo()%>
                            </label>
                         </div>
                            <% }%>
                         <% }%>
                        <br><br>
                        <input type="hidden" class="form-control" name="id_usuario" value="<%= session.getAttribute("id") %>">
                        <input type="hidden" class="form-control" name="id" value="0">
                        <br>
                        <div class="form-group">
                            <button type="submit" class="btn btn-secondary mr-2">Cadastrar Comentario</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <jsp:include page="rodape.html" />
        <jsp:include page="scripts.html" />
       </body>
</html>