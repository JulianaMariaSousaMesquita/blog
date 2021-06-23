<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="controller.*" %>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <jsp:include page="cabecalho.html" />
    </head>
    <body>
        <jsp:include page="menu.jsp" />
        <div class="container">
           <div class="row mb-3 mt-5">
                <div class="col-4 offset-4 card bg-ligth">
                    <form method="POST" action="VerificarLogin" >
                        <h1 align="center">  LOGIN  </h1>
                        <p align="center"> Novo no Blog? <a href="cadastro.jsp">Registre-se</a></p>
                        <div class="form-group mt-2">           
                            <label class="control-label requerido" for="cpf">CPF*</label>
                            <input type="text" name="cpf" id="cpf" class="form-control cpf" placeholder="000.000.000-00" maxlength="14"
                                   autocomplete="on" required>
                        </div>
                        <div class="form-group">
                            <label class="control-label requerido" for="senha">Senha*</label>
                            <input type="password" class="form-control" name="senha" id="senha" placeholder="Digite a senha" required>
                        </div>
                        <p></p>
                        <div class="form-group">
                            <button type="submit" class="btn btn-secondary mr-2">Entrar</button>
                        </div>
                    </form>
                </div>
            </div>
            <br><br><br><br>
        </div>
        <jsp:include page="rodape.html" />
        <jsp:include page="scripts.html" />
<script>
    $(document).ready(function () {
        $(function () {
            $('.cpf').mask('000.000.000-00');
        });
    });
    
</script>
    </body>

</html>
