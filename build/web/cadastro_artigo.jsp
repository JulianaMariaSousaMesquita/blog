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
                    <form method="POST" action="ArtigoController" >
                        <h2 align="center">  CADASTRO ARTIGO </h2><br>
                        <div class="form-check-inline">                            
                            <input type="hidden" class="form-control" name="id_usuario" value="<%= session.getAttribute("id") %>">
                            <select class="selectpicker" id="id_categoria" name="id_categoria" required>
                                <option title="Tipo de categoria" disabled selected onclose>Categoria</option>
                                <option value="1" data-content="<span class='badge badge-success'>Politica</span>">1 - Politica</option>
                                <option value="2" data-content="<span class='badge badge-danger'>Atualidade</span>">2 - Atualidade</option> 
                                <option value="3" data-content="<span class='badge badge-danger'>Artes</span>">3  - Artes</option>
                            </select>
                        </div>
                        <br><br>
                        <div class="form-group mt-2">           
                            <label class="control-label requerido" for="titulo">Titulo*</label>
                            <input type="text" name="titulo" id="nome" class="form-control " placeholder="Digite o titulo" maxlength="10000"
                                   autocomplete="on" required>
                        </div>
                        
                        <div class="form-group mt-2">           
                            <label class="control-label requerido" for="conteudo">Conteudo*</label>
                            <textarea name="conteudo" id="conteudo" class="form-control" placeholder="Digite texto" rows="3" required></textarea>
                        </div>
                        
                        <br>
                        <input type="hidden" class="form-control" name="id_artigo" value="0">
                        <input type="hidden" class="form-control" name="liberar" value="N">
                        <input type="hidden" class="form-control" name="aprovado" value="N">
                        <div class="form-group">
                            <button type="submit" class="btn btn-secondary mr-2">Cadastrar Artigo</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <jsp:include page="rodape.html" />
        <jsp:include page="scripts.html" />
       </body>
</html>