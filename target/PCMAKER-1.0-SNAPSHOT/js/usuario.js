
$(function(){
    consultarUsuarioAJAX();
});

function consultarUsuarioAJAX(){
    $.get("http://localhost:8084/PCMAKER/consultarUsuarioAJAX",exibeUsuarios)
            
            .fail(function(){
                console.log("Erro");
    });
}

function exibeUsuarios(data){
     
    var objJSON = JSON.parse(data);
      
    var corpoTabela = $(".tabela-usuario").find("tbody");

    $.each(objJSON.dadosUsuario,function(i){
        
       linhaUsuario = criaLinha(objJSON[i].dadosUsuario); 
       
      });
      
     corpoTabela.append(linhaUsuario);
     
}
    
    
    function criaLinha(objJSON){
        
        var tr = $("<tr>");
        var colunaIdUsuario = $("<td>").text(objJSON.idUsuario);
        var colunaNomeUsuario = $("<td>").text(objJSON.nomeCompleto);
        var colunaLogin = $("<td>").text(objJSON.login);
        var colunaEmail = $("<td>").text(objJSON.email);
        var colunaCpf = $("<td>").text(objJSON.cpf);
        var colunaRg = $("<td>").text(objJSON.rg);
//        var colunaRua = $("<td>").text(objJSON.enderecos.rua);
//        var colunaBairro = $("<td>").text(objJSON.enderecos.bairro);
//        var colunaCep = $("<td>").text(objJSON.enderecos.cep);
//        var colunaUf = $("<td>").text(objJSON.enderecos.uf);
//        var colunaTipoAdm = $("<td>").text(objJSON.tipoAdm);
//        var colunaCidade = $("<td>").text(objJSON.enderecos.cidade);
//        var colunaComplemento = $("<td>").text(objJSON.enderecos.complemento);
        var colunaDeletar = $("<td>").text("Excluir");
        var colunaAlterar = $("<td>").text("Alterar");
        
        var linkExcluir = $("<a>").attr("href","deletarUsuario?id="+objJSON.dadosUsuario.idUsuario);
        var linkAlterar = $("<a>").attr("href","alterarUsuario?id="+objJSON.dadosUsuario.idUsuario);
        
        //Colocando links de Excluir e Alterar dentro do TD
        colunaDeletar.append(linkExcluir);
        colunaAlterar.append(linkAlterar);
        
        //Colocando os TD's na TR's
        tr.append(colunaIdUsuario);
        tr.append(colunaNomeUsuario);
        tr.append(colunaLogin);
        tr.append(colunaEmail);
        tr.append(colunaCpf);
        tr.append(colunaRg);
////        tr.append(colunaRua);
////        tr.append(colunaBairro);
////        tr.append(colunaCep);
////        tr.append(colunaUf);
////        tr.append(colunaTipoAdm);
////        tr.append(colunaCidade);
////        tr.append(colunaComplemento);
        
        return tr;       
    }
   

