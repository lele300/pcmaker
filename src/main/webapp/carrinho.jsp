<%-- 
    Document   : telaCadastro
    Created on : 27/02/2017, 15:01:26
    Author     : Leonardo
--%>

<%@page import="java.util.List"%>
<%@page import="Modelo.Componente"%>
<%@page import="Modelo.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>  
        <!--Import Google Icon Font-->
        <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <!--Import materialize.css-->
        <link type="text/css" rel="stylesheet" href="css/materialize.css"  media="screen,projection"/>
        <link type="text/css" rel="stylesheet" href="css/custom.css"  media="screen,projection"/>        
        <!--Let browser know website is optimized for mobile-->
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    </head>

    <body>
        
            <% Usuario usuario = (Usuario) session.getAttribute("usuarioAutenticado");

                if (usuario != null) {


            %>
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
        
              <!-- Dropdown de funcionalidades de usuários -->
        
        <ul id="dropdown2" class="dropdown-content">
            <li><a class="grey darken-4 grey-text text-lighten-1 hoverable" href="#!"><i class="material-icons left red-text text-darken-4">shopping_cart</i>Meus pedidos</a></li>
            <li class="divider"></li>
            <li><a class="grey darken-4 grey-text text-lighten-1" href="consultarPorId?id=<%=usuario.getIdUsuario()%>"><i class="material-icons left red-text text-darken-4">perm_identity</i>Meu perfil</a></li>
            <li class="divider"></li>
        </ul>
        
        <!-- Fim da lista de funcionalidades -->
        <!-- Inicío Barra de Navegação -->
        <div class="navbar-fixed">

            <nav> 
                <div class="nav-wrapper grey darken-4">
                    <a href="#" class="brand-logo">Logo</a>
                    <ul id="nav-mobile" class="right hide-on-med-and-down grey darken-4">
                        <li><a href="" class="dropdown-button hoverable grey-text text-lighten-1" data-activates="dropdown2"><i class="material-icons left red-text text-darken-4">group</i><%=usuario.getLogin()%><i class="material-icons right red-text text-darken-4">arrow_drop_down</i></a></li>
                        <li><a class="dropdown-button hoverable grey-text text-lighten-1" href="#!" data-activates="dropdown1">Componentes<i class="material-icons left red-text text-darken-4">layers</i><i class="material-icons right red-text text-darken-4">arrow_drop_down</i></a></li>
                        <li><a href="home.jsp" class="hoverable grey-text text-lighten-1"><i class="material-icons left red-text text-darken-4">home</i>Home</a></li>
                    </ul>
                </div>
            </nav>
        </div>    <br>
        <!-- Fim da Barra de Navegação -->

        <!-- Início do Modal(Login) -->
        <div id="modal1" class="modal">

            <div class="modal-content grey darken-3 center-align">
                <h4 class="grey-text text-lighten-3">Faça o Login em PC MAKER</h4>
            </div>
            <div class="modal-content grey lighten-4">

                <form class="col s12" action="ControleAcesso" method="POST">
                    <div class="row">

                        <div class="input-field col s12">
                            <i class="material-icons prefix grey-text text-darken-4">account_circle</i>
                            <input id="icon_prefix" type="text" class="validate" name="login" required>
                            <label for="login" class="grey-text text-darken-4">Login</label>
                        </div>

                    </div>

                    <div class="row">         
                        <div class="input-field col s12">
                            <i class="material-icons prefix grey-text text-darken-4">lock_open</i>
                            <input id="icon_telephone" type="password" class="validate" name="senha" required>
                            <label for="senha" class="grey-text text-darken-4">Senha</label>   
                        </div>                  
                    </div>

                    <div class="row left-align">
                        <div class="col s6 left-align">
                            <input type="submit" class="btn waves-effect light-green lighten-1" name="acao" value="Entrar">                           
                        </div> 

                        <div class="col s6 right-align">
                            <input type="submit" class="btn waves-effect indigo lighten-1" name="acao" value="Com Facebook">
                        </div>
                    </div>     
                </form>

                <li class="divider grey darken-2"></li>

                <div class="modal-footer grey lighten-4">
                    <div class="row">

                    </div>
                    <div class="row">
                        <div class="col s7 left-align">
                            <h6> <a href="#" class="indigo-text text-darken-3"> Esqueceu sua senha ? </a> </h6>
                        </div>

                        <div class="col s5 right-align">
                            <h6><a href="cadastroUsuario.jsp" class="indigo-text text-darken-3"> Cadastre-se aqui !</a></h6>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Fim do Modal -->


        <!-- Carrinho de Compras -->

        <div class="container">
            
            <center><h2>Escolha os componentes do seu PC</h2></center>

            <div class="row">

                <% List<Componente> listaComponente = (List<Componente>) request.getAttribute("listaComponentes");

                    for (Componente comp : listaComponente) {%>

                <div class="col s4">
                    <div class="card-panel grey darken-4 hoverable">
                        <center><h5 class="grey-text text-lighten-1"><%=comp.getTipoComponente().getNomeComponente()%></h5></center>
                        <center><a href=""><i class="large material-icons red-text text-darken-4">layers</i></a></center>
                        <select name="componentes" class="grey lighten-3" required>
                            <option value="" disabled selected>Escolha o Componente</option>
                            <option value="<%=comp.getModelo()%>"><%=comp.getModelo()%></option>
                        </select>
                        <span class="grey-text text-lighten-1">
                            <center><a class="btn waves-effect waves-green grey lighten-3 grey-text text-darken-3">Veja as informações<i class="medium material-icons left red-text text-darken-5">add</i></a></center>
                        </span> 
                        
                        <span class="grey-text text-darken-4">
                            <center>________________________________________</center>
                        </span> 

                        <span class="grey-text text-lighten-1">
                            <center><a id="add-carrinho" href="inserirComponenteNoCarrinho?id=<%=comp.getId()%>" class="btn waves-effect waves-green grey lighten-3 grey-text text-darken-3">Colocar no carrinho<i class="medium material-icons left green-text text-darken-1">add_shopping_cart</i></a></center>
                        </span> 
                        
                    </div>
                        
                </div>

                <%}%>

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
                        <ul class="social-nav model-9 center-align">
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
                    <a class="grey-text text-lighten-1 right" href="#!">Fale Conosco</a>
                </div>
            </div>
        </footer>
        <!-- Fim do Rodapé -->

        <%}%>


        <!--Import jQuery before materialize.js-->
        <script type="text/javascript" src="js/jQuery.js"></script>
        <script type="text/javascript" src="js/materialize.min.js"></script>
        <script type="text/javascript" src="js/customJS.js"></script>
        <script src="https://use.fontawesome.com/93d491e836.js"></script>

    </body>
</html>


