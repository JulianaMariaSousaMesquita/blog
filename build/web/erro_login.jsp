<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
     <head>
        <%@include file="cabecalho.html" %>
    </head>
    <body>
    <jsp:include page="menu.jsp" />
        <div class="alert alert-danger" role="alert">
        <h1> Usuario não encontrado! <a href="login.jsp"><br>Tente novamente!</a><br><a href="cadastro.jsp">Ou Registre-se</a> </h1> <br><br>
        <h4> <a href="login.jsp" class="btn btn-outline-success btn-lg">Entrar</a> </h4>
        <h4> <a href="cadastro.jsp" class="btn btn-outline-info btn-lg">Registre-se</a> </h4>
        </div>
        <%@include file="rodape.html" %>
        <%@include file="scripts.html" %>
    </body>
</html>
