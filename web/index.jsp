<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="cabecalho.html" />
    </head>
    <body>
    <jsp:include page="menu.jsp" />
        <div class="container">
            <jsp:include page="ArtigoController?acao=mostrar" />
        </div>
            <jsp:include page="rodape.html" />
            <jsp:include page="scripts.html" />
    </body>    
</html>