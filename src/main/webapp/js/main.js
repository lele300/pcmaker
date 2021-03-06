$(function (){
    consultarTiposComponentesAJAX();
});


function consultarTiposComponentesAJAX() {

    $.get("http://localhost:8084/PCMAKER/consultarTipoComponenteAJAX", exibeTipoComponente)

            .fail(function(){
                var erro = $("#erro");
                erro.toggle();
                setTimeOut(function () {
                    erro.fadeOut();
                }, 1800);

            });
}

function exibeTipoComponente(data) {

    var objJSON = JSON.parse(data);

    var comboBoxComponente = $("#dropdown1");

    $.each(objJSON, function (i) {

        var li1 = $("<li>");
        var a = $("<a>")

                .addClass("grey")
                .addClass("darken-4")
                .addClass("grey-text")
                .addClass("text-lighten-5")
                .attr("href", true)
                .text(objJSON[i].nomeComponente);

        var iconeComponente = $("<i>")

                .addClass("material-icons")
                .addClass("left")
                .addClass("red-text")
                .addClass("text-darken-4")
                .text("layers");

        a.append(iconeComponente);
        li1.append(a);
        
        var li2 = $("<li>")
                .addClass("divider");
   
        comboBoxComponente.append(li1);
        comboBoxComponente.append(li2);

    });

}