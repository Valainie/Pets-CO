function addToCart(idform)
{
    var c = idform;
    var form = document.getElementById(idform);
    var q = form.quantita.value;
    if (q<1 || q >99)
    {
        Swal.fire({
            title: '<h6>Inserire una quantità compresa tra 1 e 99 prodotti</h6>',
            toast: true,
            type: 'error',
            position: 'top',
            timer: 2000,
            showConfirmButton: false
        })

        return;
    }

    $.get('cartservlet', {"quantita": q, "codice": c},
        function(){
            $('#cartitems').load(' #cartitems');
            $('.carticon').load(' .carticon');
            $('.cartorder').load(' .cartorder');

            Swal.fire({
                title: '<h6>Prodotto inserito nel carrello!</h6>',
                type: 'success',
                position: 'top-end',
                timer: 2000,
                showConfirmButton: false
            });
        },
        failAlert());

}

function reloadCart(quantita, codice)
{

    if (quantita<1 || quantita >99)
    {
        Swal.fire({
            title: '<h6>Inserire una quantità compresa tra 1 e 99 prodotti</h6>',
            toast: true,
            type: 'error',
            position: 'top',
            timer: 2000,
            showConfirmButton: false
        })

        return;
    }

    $.get('cartupdate', {"quantita": quantita, "productId": codice},
        function(){
            $('#cartitems').load(' #cartitems');
            $('.carticon').load(' .carticon');
            $('.cartreload').load(' .cartreload');
            $('.cartorder').load(' .cartorder');


        });
}


function failAlert()
{
    Swal.fire({
        title: '<h6>Errore!</h6>',
        toast: true,
        type: 'error',
        position: 'top',
        timer: 2000,
        showConfirmButton: false
    })

    return;
}