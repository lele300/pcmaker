<%-- 
    Document   : principal
    Created on : 07/04/2017, 19:34:39
    Author     : Leonardo
--%>

<%@page import="Modelo.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <% Usuario usuario = (Usuario) session.getAttribute("usuarioAutenticado");

        if (usuario != null) {


    %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bem-vindo, <%=usuario.getNomeCompleto()%></title>

        <!--Import Google Icon Font-->
        <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <!--Import materialize.css-->
        <link type="text/css" rel="stylesheet" href="css/materialize.css"  media="screen,projection"/>
        <link type="text/css" rel="stylesheet" href="css/custom.css"  media="screen,projection"/>        
        <!--Let browser know website is optimized for mobile-->
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    </head>
    <body>

        <!-- Dropdown das peças -->
        <ul id="dropdown1" class="dropdown-content">
            <li><a class="grey darken-4 grey-text text-lighten-5 hoverable" href="#!"><i class="material-icons left red-text text-darken-4">memory</i>Processador</a></li>
            <li class="divider"></li>
            <li><a class="grey darken-4 grey-text text-lighten-5" href="#!"><i class="material-icons left red-text text-darken-4">developer_board</i>Placa-mãe</a></li>
            <li class="divider"></li>
            <li><a class="grey darken-4 grey-text text-lighten-5" href="#!"><i class="material-icons left red-text text-darken-4">hd</i>Placa de Vídeo</a></li>
            <li class="divider"></li>
            <li><a class="grey darken-4 grey-text text-lighten-5" href="#!"><i class="material-icons left red-text text-darken-4">local_laundry_service</i>HD</a></li>
            <li class="divider"></li>
            <li><a class="grey darken-4 grey-text text-lighten-5" href="#!"><i class="material-icons left red-text text-darken-4">settings_input_hdmi</i>Fonte</a></li>
            <li class="divider"></li>
            <li><a class="grey darken-4 grey-text text-lighten-5" href="#!"><i class="material-icons left red-text text-darken-4">kitchen</i>Gabinete</a></li>
            <li class="divider"></li>
            <li><a class="grey darken-4 grey-text text-lighten-5" href="#!"><i class="material-icons left red-text text-darken-4">straighten</i>Memória</a></li>
        </ul>
        <!-- Inicío Barra de Navegação -->
        <div class="navbar-fixed">


            <nav> 
                <div class="nav-wrapper grey darken-4">
                    <a href="#" class="brand-logo">Logo</a>
                    <ul id="nav-mobile" class="right hide-on-med-and-down grey darken-4">
                        <li><a class="hoverable grey-text text-lighten-1"><i class="material-icons left red-text text-darken-4">group</i><%=usuario.getLogin()%></a></li>
                        <li><a class="dropdown-button hoverable grey-text text-lighten-1" href="#!" data-activates="dropdown1">Componentes<i class="material-icons left red-text text-darken-4">layers</i><i class="material-icons right red-text text-darken-4">arrow_drop_down</i></a></li>
                        <li><a href="" class="hoverable grey-text text-lighten-1"><i class="material-icons left red-text text-darken-4">home</i>Home</a></li>
                    </ul>
                </div>
            </nav>
        </div>    <br>
        <!-- Fim da Barra de Navegação --> 

        <div class="container">
            <div class="row">
                <div class="col s4">
                    <div class="card-panel grey darken-4 hoverable">
                        <center><h5 class="grey-text text-lighten-1">CRIAÇÃO DE USUÁRIO</h5></center>
                        <center><a href="cadastroUsuario.jsp"><i class="large material-icons red-text text-darken-4">person_add</i></a></center>
                        <span class="grey-text text-lighten-1">Aqui você pode criar usuários com tipos áreas do sistema diferentes, como por exemplo administrador
                            e um usuário cliente.
                        </span>
                    </div>
                </div>
                
                <div class="col s4">
                    <div class="card-panel grey darken-4 hoverable">
                        <center><h5 class="grey-text text-lighten-1">CRIAÇÃO DE COMPONENTE</h5></center>
                        <center><a href="iniciarCadastroComponente"><i class="large material-icons red-text text-darken-4">layers</i></a></center>
                        <span class="grey-text text-lighten-1"> Aqui você pode criar qualquer componente para sua loja , como por exemplo processadores, memórias,
                            HD's e seus respectivos atributos.
                        </span>
                    </div>
                </div>
                
                <div class="col s4">
                    <div class="card-panel grey darken-4 hoverable">
                        <center><h5 class="grey-text text-lighten-1">CRIAÇÃO DE ATRIBUTOS</h5></center>
                        <center><a href="cadastroTipoAtributo.jsp"><i class="large material-icons red-text text-darken-4">assignment</i></a></center>
                        <span class="grey-text text-lighten-1">Aqui você pode criar quaisquer atributos que irão compor seus componentes. Com isso, você pode definir
                           quais características ele terá.
                        </span>
                    </div>
                </div>
                
                <div class="col s4">
                    <div class="card-panel grey darken-4 hoverable">
                        <center><h5 class="grey-text text-lighten-1">LOGOUT DO SISTEMA</h5></center>
                        <center><a href="ControleAcesso?acao=Sair"><i class="large material-icons red-text text-darken-4">power_settings_new</i></a></center>
                        <span class="grey-text text-lighten-1"> Aqui você fará logout do sistema e não poderá ter acesso as áreas até realizar uma 
                            nova autenticação.
                        </span>    
                    </div>
                </div>
            </div>

            
        </div>
        <!-- Início do Rodapé -->
        <footer class="page-footer grey darken-4">
            <div class="container">
                <div class="row">
                    <div class="col l6 s12 left-align">
                        <h5 class="grey-text text-lighten-1"><i class="material-icons left green-text text-darken-2">local_grocery_store</i> Escolha as peças </h5>
                        <ul>
                            <li><a class="" href="#!">Processador</a></li>
                            <li><a class="" href="#!">Placa-mãe</a></li>
                            <li><a class="" href="#!">Placa de Vídeo</a></li>
                            <li><a class="" href="#!">HD</a></li>
                            <li><a class="" href="#!">Fonte</a></li>
                            <li><a class="" href="#!">Gabinete</a></li>
                            <li><a class="" href="#!">Memória</a></li>
                        </ul>
                    </div>

                    <div class="col l4 offset-l2 s12">
                        <h5 class="white-text grey-text text-lighten-1"><i class="material-icons left red-text text-red darken-4">share</i>Siga-nos nas redes sociais</h5>
                        <ul class="social-nav model-9">
                            <li><a href="#" class="twitter"><i class="fa fa-twitter"></i></a></li>
                            <li><a href="#" class="facebook"> <i class="fa fa-facebook"></i></a></li>
                            <li><a href="#" class="google-plus"><i class="fa fa-google-plus"></i></a></li>
                            <li><a href="#" class="linkedin"><i class="fa fa-linkedin"></i></a></li>
                        </ul>
                        <br/>
                    </div>
                </div>
            </div>
            <div class="footer-copyright">
                <div class="container">
                    © 2017 Todos os direitos reservados de PC MAKER | Versão 1.0
                    <a class="grey-text text-lighten-4 right" href="#!">More Links</a>
                </div>
            </div>
        </footer>
        <%}%>
        <!-- Fim do Rodapé -->



        <!--Import jQuery before materialize.js-->
        <script type="text/javascript" src="js/jQuery.js"></script>
        <script type="text/javascript" src="js/materialize.min.js"></script>
        <script type="text/javascript" src="js/customJS.js"></script>
        <script src="https://use.fontawesome.com/93d491e836.js"></script>
    </body>
</html>
