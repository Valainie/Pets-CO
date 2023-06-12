function renderFields()
{
    addressRender();
    prodottiRender();
}

function addressRender()
{
    var addrField = document.getElementById("address");

    if (addrField === undefined || addrField == null)
        return;

    var addrField = document.getElementById("address");
    var JsonAddr = addrField.innerHTML;
    var indirizzo = JSON.parse(JsonAddr);

    addrField.innerHTML = indirizzo.via.toString() + ", " + indirizzo.civ.toString() + ", " + indirizzo.citta;

    document.getElementById("address").id = "dummy";

    addressRender();
}

function prodottiRender()
{
    var prodField = document.getElementById("prodStatus");

    if (prodField === undefined || prodField == null)
        return;

    var JsonProd = prodField.innerHTML;
    var stato = JSON.parse(JsonProd);

//	console.log(stato);
    //e' un array di oggetti con campi nomeProdotto prezzoProdotto quantita


    var finalString = " ";
    for (let i=0; i<stato.length; i+=1) {
        finalString = finalString.concat("<b>", stato[i].nomeProdotto,"</b>", " - ", stato[i].prezzoProdotto.toString(), " - ", stato[i].quantita.toString(), " <br> ");
    }

    prodField.innerHTML = finalString;

    document.getElementById("prodStatus").id = "dummy";

    prodottiRender();
}