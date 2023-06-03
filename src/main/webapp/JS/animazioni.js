//funzione onhover con zoom
jQuery(document).ready(function($){

    $('.prodotto').hover(
        function () {
            $(this).children().children(".card-hover").animate({height: "0"},"slow");
            $(this).children().children().children(".prod-des").removeClass("d-none")
            $(this).children().children().children(".item-titolo").addClass("d-none")
            $(this).children().children().children().children(".price").addClass("d-none")
            ///$(this).children().children().children().children().children().children(".fas").addClass("d-none")
            //$(this).children().children().children().children().children(".quantButton").addClass("d-none")

        },
        function () {
            $(this).children().children().children(".prod-des").addClass("d-none")
            $(this).children().children(".card-hover").animate({height: "70%"});
            $(this).children().children().children(".item-titolo").removeClass("d-none")
            $(this).children().children().children().children(".price").removeClass("d-none")
            //$(this).children().children().children().children().children().children(".fas").removeClass("d-none")
            //$(this).children().children().children().children().children(".quantButton").removeClass("d-none")
        }
    );
});


/*funzione slideshow*/
//rimossa perchè le immagini si accodavano, venivano caricate tutte nella prima slide*/

/*funzione onhover con dati*/
//problema di  sovrapposizione. I dati vengono accodati all'immagine invece di sovrascriverla.
//Son riusvita a farli comparire sull'immagine, ma a quel punto l'immagine si era totalmente sminchiata
//e fuoriusciva dal container


/*jQuery(document).ready(function($){
    //portfolio - show link
    $('.card-img-top').hover(
        function () {
            $(this).animate({opacity:'0'});
        },
        function () {
            $(this).animate({opacity:'1'});
        }
    );
});*/