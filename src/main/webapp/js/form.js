    
$(function(){
    //Atrelando evento de click ao botão e limpar todos os campos.
    $("#btn-limpar").click(limparCamposFormUsuario);
});


function limparCamposFormUsuario(){
    $("#nomeCompleto").val("");
    $("#login").val("");
    $("#senha").val("");
    $("#email").val("");
    $("#telefone").val("");
    $("#rg").val("");
    $("#cpf").val("");
    $("#cep").val("");
    $("#cidade").val("");
    $("#rua").val("");
    $("#bairro").val("");
    $("#uf").val("");
    $("#numero").val("");
    $("#complemento").val("");
   
}


function retornoUsuario(){
    $.get("http://localhost:8084/PCMAKER/consultarUsuario", novaLinhaUsuario)
            .fail(function(){
                $("#erro").toggle();
                setTimeOut(function(){
                   $("erro").toggle(); 
                },1800);
    });   
}

function novaLinhaUsuario(data){
    //Criando tbody.
    var tbody = $("<tbody>");
    
    //Criando a TR.
    var tr = $("<tr>");
    
    //Criando td's com informações de Usuário retornados pela requisição.
    var tdId = $("<td>").text(data.idUsuario);
    var tdNome = $("<td>").text(data.nomeCompleto);
    var tdLogin = $("<td>").text(data.login);
    var tdEmail = $("<td>").text(data.email);
    var tdCpf = $("<td>").text(data.cpf);
    var tdRg = $("<td>").text(data.rg);
    var tdRua = $("<td>").text(data.rua);
    var tdBairro = $("<td>").text(data.bairro);
    var tdCep = $("<td>").text(data.cep);
    var tdUf = $("<td>").text(data.uf);
    var tdNum = $("<td>").text(data.numero);
    var tdTipo = $("<td>").text(data.tipoAdm);
    var tdCidade = $("<td>").text(data.cidade);
    var tdComplemento = $("<td>").text(data.complemento);
    var tdExcluir = $("<td>").text("Excluir");
    var tdAlterar = $("<td>").text("Alterar");
    
    //Criando as tags <a> e colocando as propriedades HTML.
    var linkExcluir = $("<a>").attr("id","botao-excluir");
    var linkAlterar = $("<a>").attr("href","consultarPorId?=");
    
    //Colocando as tags <a> dentro da TD de excluir e alterar.
    tdExcluir.append(linkExcluir);
    tdAlterar.append(linkAlterar);
    
    //Colocando todas as TD's dentro da TR
    tr.append(tdId);
    tr.append(tdNome);
    tr.append(tdLogin);
    tr.append(tdEmail);
    tr.append(tdCpf);
    tr.append(tdRg);
    tr.append(tdRua);
    tr.append(tdBairro);
    tr.append(tdCep);
    tr.append(tdUf);
    tr.append(tdNum);
    tr.append(tdTipo);
    tr.append(tdCidade);
    tr.append(tdComplemento);
    tr.append(tdExcluir);
    tr.append(tdAlterar);
    
    //Colocando a tr dentro do tbody
    tbody.append(tr);
    
}



