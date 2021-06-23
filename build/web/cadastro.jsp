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
                    <form method="POST" action="UsuarioController" >
                        <h1 align="center">  CADASTRO </h1>
                        <p align="center"> Já tem uma conta no Blog? <a href="login.jsp">Login</a></p>
                        <div class="form-group mt-2">           
                            <label class="control-label requerido" for="nome">Nome*</label>
                            <input type="text" name="nome" id="nome" class="form-control " placeholder="Digite o nome" maxlength="10000"
                                   autocomplete="on" required>
                        </div>
                        <div class="form-group mt-2">           
                            <label class="control-label requerido" for="email">E-mail*</label>
                            <input type="email" name="email" id="email" class="form-control email" placeholder="nomedoemail@domino.com.br" maxlength="10000"
                                   autocomplete="on" required>
                        </div>
                        <div class="form-group mt-2">           
                            <label class="control-label requerido" for="cpf">CPF*</label>
                            <input type="text" name="cpf" id="cpf" class="form-control cpf" placeholder="000.000.000-00" maxlength="14"
                                   autocomplete="on" required>
                            
                        </div>
                        <div class="form-group">
                            <label class="control-label requerido" for="senha">Senha*</label>
                            <input type="password" class="form-control" name="senha" id="senha" placeholder="Digite a senha" required>
                        </div>
                        <div class="form-check-inline">                           
                            <select class="selectpicker" id="papel" name="papel" required>
                                <option title="Tipo de conta" disabled selected onclose>Papel</option>
                                <option value="0" data-content="<span class='badge badge-success'>Administrador</span>">0 - Administrador</option>
                                <option value="1" data-content="<span class='badge badge-danger'>Autor</span>">1 - Autor</option> 
                                <option value="2" data-content="<span class='badge badge-danger'>Comentarista</span>">2  - Comentarista</option>
                            </select>
                        </div><br><br>
                        <div class="form-group">
                            <input type="hidden" class="form-control" name="id" value="0">
                            <input type="hidden" class="form-control" name="aprovado" value="N">
                            <button type="submit" class="btn btn-secondary mr-2">Cadastrar</button>                            
                        </div>
                    </form>
                </div>
            </div>
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
