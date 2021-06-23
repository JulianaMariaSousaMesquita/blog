<%@page import="aplicacao.Comentario"%>
<%@page import="controller.ComentarioController"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>  
<!DOCTYPE html>
<html>
<head>
<jsp:include page="cabecalho.html" />
</head>
<body>
	<jsp:include page="menu.jsp" />  
        
        <% Comentario comentario = (Comentario)request.getAttribute("comentario"); %>
        <div class="container">
            <div class="row mb-3 mt-5">
                <div class="col-4 offset-4 card bg-ligth">
                    <form method="POST" action="ComentarioController" >
                        <h2 align="center">  EDITAR COMENTARIO </h2><br>
                        <input type="hidden" class="form-control" name="id" value="<%= comentario.getId()%>">
                        <div class="form-group mt-2">           
                            <label class="control-label requerido" for="comentario"> Comentario </label>
                            <textarea name="comentario" id="comentario" class="form-control" placeholder="Digite texto" rows="3" required><%= comentario.getComentario()%></textarea>
                        </div>
                        
                        <br><br>
                        
                        <input type="hidden" class="form-control" name="id_artigo" value="<%= comentario.getIdArtigo()%>">
                        <input type="hidden" class="form-control" name="id_usuario" value="<%= comentario.getIdUsuario()%>">                  
                        <br>
                        <div class="form-group">
                            <button type="submit" class="btn btn-primary">Alterar</button>
                            <a href="ComentarioController?acao=meucomentario" class="btn btn-secondary mr-2" > Retornar </a>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <jsp:include page="rodape.html" />
        <jsp:include page="scripts.html" />
       </body>
</html>