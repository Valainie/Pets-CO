function myFunct(){
    //ci vuole un altro if che faccia partire la funzione solo quando il form è quello giusto altrimenti cercherà sempre il button
    if(document.getElementById("modproductform"))
    {
        var cod=document.getElementById("codProdotto").value;
        if(!isNaN(cod)){
            document.getElementById("cercaCRUD").click();
        }
    }
}
function myFunctEvento(){
    //ci vuole un altro if che faccia partire la funzione solo quando il form è quello giusto altrimenti cercherà sempre il button
    if(document.getElementById("modeventform"))
    {
        var cod=document.getElementById("codEvento").value;
        if(!isNaN(cod)){
            document.getElementById("cercaCRUD").click();
        }
    }
}
/*questa funzione abilita tutti i campi del form quando l'admin vuole modificare i dati di un prodotto*/



/*questa funzione mostra e/o nasconde gli attributi delle categorie del prodotto*/
function gameoraccessory(category){
    if(category=='cibo'){
        document.getElementById("subCatGioco").style.display="block";
        document.getElementById("subCatAccessorio").style.display="none";
    }
    else if(category=='accessorio'){
        document.getElementById("subCatGioco").style.display="none";
        document.getElementById("subCatAccessorio").style.display="block";
    }
    else if(category==''){
        document.getElementById("subCatGioco").style.display="none";
        document.getElementById("subCatAccessorio").style.display="none";
    }
}



/*questa funzione permette all'admin di arrivare alla pagina di modifica/elimina clienti con i dati dell'evento già inseriti*/
$(document).ready(function() {

    $("#modclienteform").submit(function(event) {
        event.preventDefault()
        var formContents = $('#modclienteform').serializeArray();
        var codC = formContents.find(x => x.name == "user").value

        $("#modclienteform input").each(function(){
            var inputn=$(this);
            console.log(inputn.attr('name'));
        });

        $.getJSON('jsonretrievalcliente', {user: codC},
            function(response) {
                var formProduct=$("#modclienteformhidden").serializeArray().map(x => x.name);
                console.log(response)
                for (var key in response){
                    console.log(key)
                    if (response.hasOwnProperty(key)){
                        console.log(key)
                        document.getElementById(key).value=response[key];
                    }
                }
            })
            .fail(function(error) {
                console.error(error)
            });
    });
});


function ajaxOrder()
{
    $("#modorderform").submit(function(event)
    {
        var u =document.getElementById("username").value
        $.get('adminorder', {"username": u},
            function(){
                $("#ordertable").load(' #ordertable');
            },
            failAlert());
    });
}