<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-dark bg-secondary ">
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="index.jsp"> Blog - Medite <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Categorias
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item" href="index.jsp">Meditação</a>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item" href="index.jsp">Yoga</a>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item" href="index.jsp">Ansiedade</a>
                </div>
            </li>
            <li class="nav-item">
                <a class="nav-link disabled" href="#"> Tudo Sobre Meditação, Bem-Estar e Relaxamento </a>
            </li>
        </ul>
        <ul>
            <% if(session.getAttribute("id") != null) { %>
                <li class="nav-link dropdown">               
                    <button type="button" class="btn btn-dark btn-sm nav-link dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          <span class="glyphicon"><svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-file-person-fill" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
  <path fill-rule="evenodd" d="M12 0H4a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h8a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2zm-1 7a3 3 0 1 1-6 0 3 3 0 0 1 6 0zm-3 4c2.623 0 4.146.826 5 1.755V14a1 1 0 0 1-1 1H4a1 1 0 0 1-1-1v-1.245C3.854 11.825 5.377 11 8 11z"/>
</svg> <%= session.getAttribute("NomeUsuarioLogado") %> </span> 
        </button>                
                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item" href="logado.jsp">Area Usuario</a>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item" href="Sair">Sair</a> 
                </div>
            </li>
            <%} else {%>
            <li class="nav-link dropdown">               
                    <button type="button" class="btn btn-dark btn-sm nav-link dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          <span class="glyphicon"><svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-file-person-fill" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
  <path fill-rule="evenodd" d="M12 0H4a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h8a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2zm-1 7a3 3 0 1 1-6 0 3 3 0 0 1 6 0zm-3 4c2.623 0 4.146.826 5 1.755V14a1 1 0 0 1-1 1H4a1 1 0 0 1-1-1v-1.245C3.854 11.825 5.377 11 8 11z"/>
</svg>Usuario </span> 
        </button>                
                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item" href="login.jsp">Entrar</a>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item" href="cadastro.jsp">Registre-se</a>                    
                </div>
            </li>            
            <% }%>
        </ul>        
    </div>
</nav>  
 <br><br>
    </body>
</html>
