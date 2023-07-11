$(document).ready(function() {

        $.ajax({
            url: '/Pets_Co/JsonRevtrieveForHomeServlet',
            type: 'GET',
            dataType: 'json',
            success: function (products) {
                PopulateHome(products)
            },
        });
});

function PopulateHome(products){
    let productContainer = $('#product_container');
    let n = 0;
    $.each(products, function(){
        let html = generateProduct(products[n]);
        productContainer.append(html);
        n++;
    });
}

function generateProduct(product) {
    let html =
        '<li class="products">' +
        '<img src="' + product.immagine + '" alt="">' +
        '<div class="content">' +
        '<div class="title">' + product.nome + '</div>' +
        '<div class="prezzo">Prezzo:<span>'+ product.prezzo +'&euro;</span></div>' +
        '<div class="descrizioneBreve">'+ product.descrizioneBreve + '</div>' +
        '<button class="AddToCart">AddToCart</button>' +
        '<a href="${pageContext.request.contextPath}/ProductJSP/prodotto.jsp?codice=' + product.codice + '" class="dettagli">Dettagli</a>' +
        '</div>' +
        '</li>';

    return html;
}