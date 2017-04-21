<%-- 
    Document   : cadastroComponente
    Created on : 10/04/2017, 08:30:36
    Author     : Leonardo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de Componente</title>
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
                        <li><a href="#modal1" class="hoverable grey-text text-lighten-1"><i class="material-icons left red-text text-darken-4">group</i>Entrar/Cadastrar</a></li>
                        <li><a class="dropdown-button hoverable grey-text text-lighten-1" href="#!" data-activates="dropdown1">Componentes<i class="material-icons left red-text text-darken-4">layers</i><i class="material-icons right red-text text-darken-4">arrow_drop_down</i></a></li>
                        <li><a href="" class="hoverable grey-text text-lighten-1"><i class="material-icons left red-text text-darken-4">account_balance</i>Home</a></li>
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

        <!-- Formulário de cadastro de Componente -->

        <div class="container">
            <div class="row">
                <form class="col s12" method="post" action="ControleComponente">
                    <div class="row">
                        
                        <div class="input-field col s6">
                            <input name="nomeComponente" id="nomeComponente" type="text" class="validate hoverable" maxlength="50" required>
                            <label for="nomeComponente" class="grey-text text-darken-4"><i class="material-icons left brown-text text-lighten-2">layers</i>Componente</label>
                        </div> 
                        
                        <div class="input-field col s6">
                            <input name="quantidade" id="quantidade" type="text" class="validate hoverable" maxlength="50" required>
                            <label for="quantidade" class="grey-text text-darken-4"><i class="material-icons left brown-text text-lighten-2">layers</i>Quantidade</label>
                        </div> 
                      
                    </div>
                    
                    <div class="row">
                        
                        <div class="input-field col s6">
                            <input name="modelo" id="modelo" type="text" class="validate hoverable" maxlength="50" required>
                            <label for="modelo" class="grey-text text-darken-4"><i class="material-icons left brown-text text-lighten-2">layers</i>Modelo</label>
                        </div>       
                        
                        <div class="input-field col s6">
                            <input name="marca" id="marca" type="text" class="validate hoverable" maxlength="50" required>
                            <label for="marca" class="grey-text text-darken-4"><i class="material-icons left brown-text text-lighten-2">layers</i>Marca</label>
                        </div> 
                        
                    </div>
                    
                    <div class="row">
                        
                        <div class="input-field col s12">
                            <textarea name="descricao" id="descricao" class="materialize-textarea hoverable"></textarea>
                            <label for="descricao" class="grey-text text-darken-4"><i class="material-icons left brown-text text-lighten-2">flag</i>Descrição</label>
                        </div>
                        
                    </div>
                    
                    <!-- Opções dos atributos -->
                    
                    <div class="row">
                        
                        <div class="col s3">
                            <input type="checkbox" name="opcaoAtributo" class="filled-in black" id="clock" checked="checked" />
                            <label for="clock">Clock</label>
                        </div>
                        
                        <div class="col s3">
                            <input type="checkbox" name="opcaoAtributo" class="filled-in" id="capacidade" checked="checked" />
                            <label for="capacidade">Capacidade (500 GB...)</label>
                        </div>
                        
                        <div class="col s3">
                            <input type="checkbox" name="opcaoAtributo" class="filled-in" id="tipoMemoria" checked="checked" />
                            <label for="tipoMemoria">Memória (DD3,DDR4...)</label>
                        </div>
                        
                        <div class="col s3">
                            <input type="checkbox" name="opcaoAtributo" class="filled-in" id="velocidadeHD" checked="checked" />
                            <label for="velocidadeHD">Vel. HD (5200 RPM...)</label>
                        </div>
                        
                    </div>
                    
                    <div class="row">
                        <div class=" col s3">
                            <input type="checkbox" name="opcaoAtributo" class="filled-in" id="portasUSB" checked="checked" />
                            <label for="portasUSB">Qtde. Portas USB</label>
                        </div>
                        
                         <div class=" col s3">
                            <input type="checkbox" name="opcaoAtributo" class="filled-in" id="quantidadeMemoria" checked="checked" />
                            <label for="quantidadeMemoria">Qtde. Memória (2 GB...)</label>
                        </div>
                        
                         <div class=" col s3">
                            <input type="checkbox" name="opcaoAtributo" class="filled-in" id="interface" checked="checked" />
                            <label for="interface">Interface (SATA...)</label>
                        </div>
                        
                         <div class=" col s3">
                            <input type="checkbox" name="opcaoAtributo" class="filled-in" id="soquete" checked="checked" />
                            <label for="soquete">Soquete</label>
                         </div>
                    </div>
                    
                    <div class="row">
                        
                        <div class="col s3">
                            <input type="checkbox" name="opcaoAtributo" class="filled-in" id="quantidadeNucleos" checked="checked" />
                            <label for="quantidadeNucleos">Qtde. de Núcleos</label> 
                        </div>
                        
                        <div class="col s3">
                            <input type="checkbox" name="opcaoAtributo" class="filled-in" id="cache" checked="checked" />
                            <label for="cache">Cache</label> 
                        </div>
                        
                        <div class="col s3">
                            <input type="checkbox" name="opcaoAtributo" class="filled-in" id="potencia" checked="checked" />
                            <label for="potencia">Potência</label> 
                        </div>
                        
                        <div class="col s3">
                            <input type="checkbox" name="opcaoAtributo" class="filled-in" id="voltagem" checked="checked" />
                            <label for="voltagem">Voltagem</label>                            
                        </div>
                    </div>
                    
                    <div class="row">
                        
                        <div class="col s3">
                            <input type="checkbox" name="opcaoAtributo" class="filled-in" id="cor" checked="checked" />
                            <label for="cor">Cor</label> 
                        </div>
                        
                        <div class="col s3">
                            <input type="checkbox" name="opcaoAtributo" class="filled-in" id="peso" checked="checked" />
                            <label for="peso">Cache</label> 
                        </div>
                        
                        <div class="col s3">
                            <input type="checkbox" name="opcaoAtributo" class="filled-in" id="materialGabinete" checked="checked" />
                            <label for="materialGabinete">Material Gabinete</label> 
                        </div>
                        
                        <div class="col s3">
                            <input type="checkbox" name="opcaoAtributo" class="filled-in" id="quantidadeThreads" checked="checked" />
                            <label for="quantidadeThreads">Qtde. de Threads</label>                            
                        </div>
                    </div>
                    
                    <input type="submit" class="btn waves-effect waves-light grey darken-4" value="Cadastrar">
                </form>
            </div>
        </div>

    <!-- Fim do formulário de cadastro de componente -->

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
<!-- Fim do Rodapé -->

<!--Import jQuery before materialize.js-->
<script type="text/javascript" src="js/jQuery.js"></script>
<script type="text/javascript" src="js/materialize.min.js"></script>
<script type="text/javascript" src="js/customJS.js"></script>
<script src="https://use.fontawesome.com/93d491e836.js"></script>
</body>
</html>
