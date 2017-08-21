$("#botao-login").click(function(){
   var login = $(".nome").text();
   var senha = $(".senha").text();
   
   var dados = {
       login: login,
       senha: senha
   };
   
   $.post("http://localhost:8084/ControleAcesso",dados,function(data){
       
   })
           .fail(function(){
               $("#erro").toggle();
               setTimeout(function(){
                   $("#erro").toggle();
               },2000);
           });
       
   });


