<%@page import="aplicacao.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="cabecalho.html" />
</head>
<body>
	 <jsp:include page="menu.jsp" />
         
         <% Usuario aux = (Usuario)request.getAttribute("usuario"); %>
        <div class="container">
            <div class="row mb-3 mt-5">
                <div class="col-4 offset-4 card bg-ligth">
                    <form method="POST" action="UsuarioController" >
                        <h1 align="center">  Alterar Dados  </h1>
                        <div class="form-group mt-2">           
                            <label class="control-label requerido" for="nome">Nome*</label>
                            <input type="text" name="nome" id="nome" class="form-control " value="<%= aux.getNome() %>" maxlength="10000"
                                   autocomplete="on" required>
                        </div>
                        <div class="form-group mt-2">           
                            <label class="control-label requerido" for="email">E-mail*</label>
                            <input type="email" name="email" id="email" class="form-control email" value="<%= aux.getEmail() %>" maxlength="10000"
                                   autocomplete="on" required>
                        </div>
                        <div class="form-group">
                            <label class="control-label requerido" for="senha">Senha*</label>
                            <input type="password" class="form-control" name="senha" id="senha" value="<%= aux.getSenha() %>"  required>
                        </div>
                        <br><br>
                        <div class="form-group">
                            <input type="hidden" class="form-control" name="id" value="<%= aux.getId() %>">
                            <input type="hidden" class="form-control" name="cpf" value="<%= aux.getCpf() %>">
                            <input type="hidden" class="form-control" name="papel" value="<%= aux.getPapel() %>">
                            <input type="hidden" class="form-control" name="liberar" value="<%= aux.getAprovado()%>">                            
                            <button type="submit" class="btn btn-secondary mr-2">Alterar dados usuario</button>                            
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <jsp:include page="rodape.html" />
        <jsp:include page="scripts.html" />
    </body>
</html>
