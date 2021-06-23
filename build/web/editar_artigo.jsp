<%@page import="aplicacao.Artigo"%>
<%@page import="controller.ArtigoController"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>  
<!DOCTYPE html>
<html>
<head>
<jsp:include page="cabecalho.html" />
</head>
<body>
	<jsp:include page="menu.jsp" />    
        
        <% Artigo aux = (Artigo)request.getAttribute("artigo"); %>
        <div class="container">
            <div class="row mb-3 mt-5">
                <div class="col-4 offset-4 card bg-ligth">
                    <form method="POST" action="ArtigoController" >
                        <h2 align="center">  Editar Artigo </h2><br>
                        <div class="form-check-inline">      
                            <label class="control-label requerido" for="id_artigo">ID Artigo =  <%= aux.getId() %></label>
                            <input type="hidden" class="form-control" name="id_artigo" value="<%= aux.getId() %>">
                            <br><br>
                        </div>
                        <div class="form-check-inline">  
                            <label class="control-label requerido" for="id_usuario">ID Usuario = <%= aux.getIdUsuario() %></label>
                            <input type="hidden" class="form-control" name="id_usuario" value="<%= aux.getIdUsuario() %>">
                            <br>
                        </div>
                            <div class="form-check-inline"> 
                                <br><br>
                            <!--<select class="selectpicker" id="id_categoria" name="id_categoria" required>
                                <option title="Tipo de categoria" disabled selected onclose>Categoria</option>
                                <option value="1" data-content="<span class='badge badge-success'>Politica</span>">1 - Politica</option>
                                <option value="2" data-content="<span class='badge badge-danger'>Atualidade</span>">2 - Atualidade</option> 
                                <option value="3" data-content="<span class='badge badge-danger'>Artes</span>">3  - Artes</option>
                            </select>-->
                            <input type="hidden" class="form-control" name="id_categoria" value="<%= aux.getIdCategoria() %>">
                        </div>
                        <br><br>
                        <div class="form-group mt-2">           
                            <label class="control-label requerido" for="titulo">Titulo*</label>
                            <input type="text" name="titulo" id="nome" class="form-control " placeholder="Digite o titulo" maxlength="10000"
                                   autocomplete="on" value="<%= aux.getTitulo() %>" required>
                        </div>
                        
                        <div class="form-group mt-2">           
                            <label class="control-label requerido" for="conteudo">Conteudo*</label>
                            <textarea name="conteudo" id="conteudo" class="form-control" placeholder="Digite texto" rows="3" required><%= aux.getConteudo() %></textarea>
                        </div>
                        
                        <br>
                        <div class="form-group">
                            <button  type="submit" class="btn btn-secondary mr-2">Alterar Artigo</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <jsp:include page="rodape.html" />
        <jsp:include page="scripts.html" />
       </body>
</html>