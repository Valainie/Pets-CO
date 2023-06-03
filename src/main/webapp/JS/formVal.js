//da prendere come spunto e modificare
function validateLogin(password, username)

{
    var p = password.value;
    var u = username.value;

    password.value = htmlEscape(password.value);
    username.value = htmlEscape(username.value);

    var pass = /^.{7,}$/;


    if (!p.match(pass))
    {
        $(".loginbtn").button({ disabled: true });
        return;
    }
    else if (u.length > 0)
    {
        $(".loginbtn").button({ disabled: false });
    }
}

function validateMLogin (password,username)
{
    var p = password.value;
    var u = username.value;

    password.value = htmlEscape(password.value);
    username.value = htmlEscape(username.value);

    var pass = /^.{7,}$/;


    if (!p.match(pass))
    {
        document.getElementById("prova").disabled = true;
        return;
    }
    else if (u.length > 0)
    {
        document.getElementById("prova").disabled = false;
    }
}

function validateRegister(registerform)
{/*DA AGGIUNGERE CF
 NOME
 COGNOME
 TEL
 FAX
 CIVICO
 VIA
 CAP
 DETTAGLI*/
    var n = registerform.elements.length;
    var mailReg = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    var pass = /^.{7,}$/;

    for (var i = 0; i < n - 1; i++)
    {
        if (registerform.elements[i].value.length == 0)
        {
            Swal.fire({
                title: '<h6>Completare tutti i campi!</h6>',
                toast: true,
                type: 'error',
                position: 'top',
                timer: 2000,
                showConfirmButton: false
            })
            return;
        }
        else
            registerform.elements[i].value = htmlEscape(registerform.elements[i].value);
    }

    if (!registerform.pass.value.match(pass))
    {
        Swal.fire({
            title: '<h6>La password deve essere di lunghezza compresa tra 7 e 20 caratteri</h6>',
            toast: true,
            type: 'error',
            position: 'top',
            timer: 2000,
            showConfirmButton: false
        })

        registerform.pass.focus();
        return;
    }
    else if (!registerform.mail.value.match(mailReg))
    {
        Swal.fire({
            title: '<h6>Inserire un indirizzo email valido</h6>',
            toast: true,
            type: 'error',
            position: 'top',
            timer: 2000,
            showConfirmButton: false
        })
        registerform.mail.value = "";
        registerform.mail.focus();
        return;
    }
    else if (registerform.pass.value != registerform.confirmPass.value)
    {
        Swal.fire({
            title: '<h6>Le password non coincidono!</h6>',
            toast: true,
            type: 'error',
            position: 'top',
            timer: 2000,
            showConfirmButton: false
        })
        registerform.pass.value = "";
        registerform.confirmPass.value = "";
        registerform.pass.focus();
        return;
    }
    else if(!registerform.check.checked)
    {
        Swal.fire({
            title: '<h6>Accetta i Termini per continuare</h6>',
            toast: true,
            type: 'error',
            position: 'top',
            timer: 2000,
            showConfirmButton: false
        })
        registerform.check.focus();
        return;
    }

    registerform.submit();
}

function validateCreditCard(form)
{
    var n = form.elements.length;
    var card = /^[0-9]{16,16}$/;

    for (var i = 0; i < n - 1; i++)
    {
        if (form.elements[i].value.length == 0)
        {
            Swal.fire({
                title: '<h6>Completare tutti i campi!</h6>',
                toast: true,
                type: 'error',
                position: 'top',
                timer: 2000,
                showConfirmButton: false
            })
            return;
        }
        else
            form.elements[i].value = htmlEscape(form.elements[i].value);
    }

    if (!form.numero.value.match(card))
    {
        Swal.fire({
            title: '<h6>Inserire un numero valido!</h6>',
            toast: true,
            type: 'error',
            position: 'top',
            timer: 2000,
            showConfirmButton: false
        })

        form.numero.focus();
        return;
    }

    if (form.cvv.value.length == 3)
    {
        form.scadenza.value = form.mesescadenza.value.toString() + "/" + form.annoscadenza.value.toString();
        form.submit();
    }
}

function limitField (field, max)
{
    var numOnly = /^[0-9]{0,30}$/;

    if (!field.value.match(numOnly))
    {
        field.value = field.value.slice(0,field.value.length);
    }

    if (field.value.length > max) {
        field.value = field.value.slice(0,max);
    }
}

function acquisto()
{
    var form=document.getElementById("ordinafrm");
    var n = form.elements.length;

    for (var i = 0; i < n - 1; i++)
    {
        if (form.elements[i].value.length == 0)
        {
            Swal.fire({
                title: '<h6>Completare tutti i campi!</h6>',
                toast: true,
                type: 'error',
                position: 'top',
                timer: 2000,
                showConfirmButton: false
            })
            return;
        }
        else
            form.elements[i].value = htmlEscape(form.elements[i].value);
    }

    var indirizzo={via:form.indirizzo.value, civ:form.ncivico.value, cap:form.cap.value, citta: form.citta.value};
    var jsonAddress=JSON.stringify(indirizzo);
    var campoIndirizzo = document.getElementById("jsonaddress");
    campoIndirizzo.value = jsonAddress;

    var metodo = document.getElementById("metodoselect");
    metodo.value=document.getElementById("pselect").value;

    form.submit();

}

function htmlEscape(toEscape)

{

    toEscape.replace(/>/g, "&gt;");

    toEscape.replace(/</g, "&lt;");

    toEscape.replace(/>/g, "&amp;");

    toEscape.replace(/"/g, "&quot;");



    return toEscape;

}

function validateAddProduct(addproductform){
    var cod=addproductform.codiceProdotto.value;
    console.log(cod)
    var cat=addproductform.Tipo.value;
    console.log(cat)
    var q=addproductform.DescrizioneBrene.value;
    console.log(q)
    var i=addproductform.IVA.value;
    console.log(i)
    var p=addproductform.prezzo.value;
    console.log(p)
    var n=addproductform.elements.length;
    console.log(n)


    if(isNaN(cod))
    {
        Swal.fire({
            title: '<h6>il Codice deve essere un numero!</h6>',
            toast: true,
            type: 'error',
            position: 'top',
            timer: 2000,
            showConfirmButton: false
        })
        return;
    }
    if(cat!="gioco" && cat!="accessorio")
    {
        Swal.fire({
            title: '<h6>Scegliere una categoria!</h6>',
            toast: true,
            type: 'error',
            position: 'top',
            timer: 2000,
            showConfirmButton: false
        })
        return;
    }


    if(cat=="gioco"){
        var e=addproductform.eta.value;
        var sc=addproductform.sceltag.value;
        if(sc==" - "){
            Swal.fire({
                title: '<h6>Scegliere una sottocategoria!</h6>',
                toast: true,
                type: 'error',
                position: 'top',
                timer: 2000,
                showConfirmButton: false
            })
            return;
        }
        if(isNaN(e)){
            Swal.fire({
                title: '<h6>Eta\' deve essere un numero!</h6>',
                toast: true,
                type: 'error',
                position: 'top',
                timer: 2000,
                showConfirmButton: false
            })
            return;
        }
    }
    if(cat=="accessorio"){
        var sc=addproductform.sceltaa.value;
        if(sc==" - "){
            Swal.fire({
                title: '<h6>Scegliere una sottocategoria!</h6>',
                toast: true,
                type: 'error',
                position: 'top',
                timer: 2000,
                showConfirmButton: false
            })
            return;
        }
    }
    if(isNaN(p))
    {
        Swal.fire({
            title: '<h6>Prezzo deve essere un numero!</h6>',
            toast: true,
            type: 'error',
            position: 'top',
            timer: 2000,
            showConfirmButton: false
        })
        return;
    }
    if(isNaN(i))
    {
        Swal.fire({
            title: '<h6>L\'IVA deve essere un numero!</h6>',
            toast: true,
            type: 'error',
            position: 'top',
            timer: 2000,
            showConfirmButton: false
        })
        return;
    }

    if(isNaN(q))
    {
        Swal.fire({
            title: '<h6>La quantita\' deve essere un numero!</h6>',
            toast: true,
            type: 'error',
            position: 'top',
            timer: 2000,
            showConfirmButton: false
        })
        return;
    }

    for (var i = 0; i < n - 1; i++)
    {

        if(cat=="accessorio"){
            document.getElementById("eta").value="."
            document.getElementById("durata").value="."
            document.getElementById("ngiocatori").value="."
        }
        if (addproductform.elements[i].value.length == 0)
        {

            Swal.fire({
                title: '<h6>Completare tutti i campi!</h6>',
                toast: true,
                type: 'error',
                position: 'top',
                timer: 2000,
                showConfirmButton: false
            })
            return;
        }
    }
    if(cat=="accessorio"){
        document.getElementById("eta").value=""
        document.getElementById("durata").value=""
        document.getElementById("ngiocatori").value=""
    }
    addproductform.submit();
}

function validateModProduct(modproductform){
    var cod=modproductform.codiceProdotto.value;
    console.log(cod)
    var cat=modproductform.nomeCategoria.value;
    console.log(cat)
    var q=modproductform.disponibilita.value;
    console.log(q)
    var i=modproductform.IVA.value;
    console.log(i)
    var p=modproductform.prezzo.value;
    console.log(p)
    var n=modproductform.elements.length;
    console.log(n)


    if(isNaN(cod))
    {
        Swal.fire({
            title: '<h6>il Codice deve essere un numero!</h6>',
            toast: true,
            type: 'error',
            position: 'top',
            timer: 2000,
            showConfirmButton: false
        })
        return;
    }
    if(cat!="gioco" && cat!="accessorio")
    {
        Swal.fire({
            title: '<h6>Scegliere una categoria!</h6>',
            toast: true,
            type: 'error',
            position: 'top',
            timer: 2000,
            showConfirmButton: false
        })
        return;
    }


    if(cat=="gioco"){
        var e=modproductform.eta.value;
        var sc=modproductform.descrizioneCategoriaGiochi.value;
        if(sc==" - "){
            Swal.fire({
                title: '<h6>Scegliere una sottocategoria!</h6>',
                toast: true,
                type: 'error',
                position: 'top',
                timer: 2000,
                showConfirmButton: false
            })
            return;
        }
        if(isNaN(e)){
            Swal.fire({
                title: '<h6>Eta\' deve essere un numero!</h6>',
                toast: true,
                type: 'error',
                position: 'top',
                timer: 2000,
                showConfirmButton: false
            })
            return;
        }
    }
    if(cat=="accessorio"){
        var sc=modproductform.descrizioneCategoriaAccessori.value;
        if(sc==" - "){
            Swal.fire({
                title: '<h6>Scegliere una sottocategoria!</h6>',
                toast: true,
                type: 'error',
                position: 'top',
                timer: 2000,
                showConfirmButton: false
            })
            return;
        }
    }
    if(isNaN(p))
    {
        Swal.fire({
            title: '<h6>Prezzo deve essere un numero!</h6>',
            toast: true,
            type: 'error',
            position: 'top',
            timer: 2000,
            showConfirmButton: false
        })
        return;
    }
    if(isNaN(i))
    {
        Swal.fire({
            title: '<h6>L\'IVA deve essere un numero!</h6>',
            toast: true,
            type: 'error',
            position: 'top',
            timer: 2000,
            showConfirmButton: false
        })
        return;
    }

    if(isNaN(q))
    {
        Swal.fire({
            title: '<h6>La quantita\' deve essere un numero!</h6>',
            toast: true,
            type: 'error',
            position: 'top',
            timer: 2000,
            showConfirmButton: false
        })
        return;
    }

    for (var i = 0; i < n - 1; i++)
    {
        console.log(modproductform.elements[i].name)
        if(cat=="accessorio"){
            modproductform.eta.value="."
            modproductform.durata.value="."
            modproductform.numeroGiocatori.value="."
        }
        if (modproductform.elements[i].value.length == 0)
        {
            console.log(modproductform.elements[i].name)
            Swal.fire({
                title: '<h6>Completare tutti i campi!</h6>',
                toast: true,
                type: 'error',
                position: 'top',
                timer: 2000,
                showConfirmButton: false
            })
            return;
        }
    }
    if(cat=="accessorio"){
        modproductform.eta.value="."
        modproductform.durata.value="."
        modproductform.numeroGiocatori.value="."
    }
    modproductform.submit();
}
