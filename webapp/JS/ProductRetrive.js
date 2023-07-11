$(document).ready(function() {
    let c = 0;
    while (c != -1){
        c++;
        $.ajax({
            url: '${pageContext.request.contextPath}/JsonRevtrieveForHomeServlet.java?codice=' + c,
            type: 'GET',
            dataType: 'json',
            success: function (products) {
                let productContainer = $('#product_container');
                let html = generateProduct(products);
                productContainer.append(html);
            },
            error: c = -1
        })
    }
})

function generateProduct(product) {
    let html =
        '<li class="products">' +
        '<img src="' + product.Immagine + '" alt="">' +
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