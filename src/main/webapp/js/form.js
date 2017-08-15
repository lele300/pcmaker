    
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


function excluirUsuario(){
    
}


