<!DOCTYPE html>

<html lang="en">
<head>
    <title>Pagina Cliente Pets&Co</title>
    <%@include file="/includes/head.jsp"%>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/userLogged.css" type="text/css">
    <script>
        function showModDati(){
            (document.getElementById('modDati')).removeAttribute('hidden');
            (document.getElementById('carta-add')).setAttribute('hidden','hidden');
            (document.getElementById('address-add')).setAttribute('hidden','hidden');
        }
        function showCartaAdd(){
            (document.getElementById('modDati')).setAttribute('hidden','hidden');
            (document.getElementById('carta-add')).removeAttribute('hidden');
            (document.getElementById('address-add')).setAttribute('hidden','hidden');
        }
        function showAddressAdd(){
            (document.getElementById('modDati')).setAttribute('hidden','hidden');
            (document.getElementById('carta-add')).setAttribute('hidden','hidden');
            (document.getElementById('address-add')).removeAttribute('hidden');
        }
    </script>
</head>
<body>
<%@include file="/includes/header.jsp" %>


<div class="row" style="margin-left: 1%">
    <div id="PanelloSx" class="col-lg-2 col-md-2 col-sm-2 col-xs-12 d-none d-lg-block ">
        <%@include file="/includes/panelloSinistra.jsp" %>
    </div>
    <div class="col" style="max-width: 65%">
        <div class="row">
            <div class="col">
                <div class="anagrafica">
                    <p><b>Username</b>: Username</p>
                    <p><b>Nome</b>: Nome Cognome</p>
                    <p><b>Codice Fiscale</b>: CFahdiem0m013905</p>
                    <p><b>Telefono</b>: +39 123-4567890</p>
                    <p><b>Email</b>: indirizzo.mail@email.ml</p>

                    <ul style="list-style: none; padding: 0; text-align: center; margin-top: 20%">
                        <li style="display: inline-block; margin-right: 10px;">
                            <a href="${pageContext.request.contextPath}/userJSP/myOrders.jsp" class="client-but">Preferiti</a>
                        </li>

                        <li style="display: inline-block; margin-right: 10px;">
                            <a href="${pageContext.request.contextPath}/userJSP/preferiti.jsp" class="client-but">Ordini passati</a>
                        </li>
                    </ul>
                </div>
            </div>
            <div class="col">
                <div class="indirizzi">
                    <div class = "indirizzo">
                        <p><b>Città</b>: Città (CAP: )</p>
                        <p><b>Indirizzo</b>: Via Strada N. Civico</p>
                    </div>
                    <div class = "indirizzo">
                        <p><b>Città</b>: Città (CAP: )</p>
                        <p><b>Indirizzo</b>: Via Strada N. Civico</p>
                    </div>
                </div>
            </div>
            <div class="col">
                <div class="metodi">
                    <div class="metodo">
                        <p><b>Carta</b>: Circuito *********NNN </p>
                        <p><b>Scadenza</b>: Data-di-scadenza</p>
                    </div>
                    <div class="metodo">
                        <p><b>Carta</b>: Circuito *********NNN </p>
                        <p><b>Scadenza</b>: Data-di-scadenza</p>
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <div style="margin-top: 10%"> <!-- Qui ci stanno i bottoni per mostrare o meno i menu-->
                <button class="client-but" onclick="showModDati()">modifica dati</button>
                <span><button class="client-but" onclick="showAddressAdd()">aggiungi indirizzo</button></span>
                <span><button class="client-but" onclick="showCartaAdd()">aggiungi metodo di pagamento</button></span>
            </div>
            <div class="hiddenForm" id="modDati" hidden="hidden">
                <!-- Qui va il form di modifica dei dati! -->
                DATI
            </div>
            <div class="hiddenForm" id="address-add" hidden="hidden">
                <!-- Qui va il form di aggiungere indirizzi -->
                INDIRIZZO
            </div>
            <div class="hiddenForm" id="carta-add" hidden="hidden">
                <!-- Qui va il form di aggiungere metodi di pagamento (carte) -->
                CARTA
            </div>

        </div>

    </div>
    <div id="pannelloDx" class= "col-lg-2 col-md-2 col-sm-2 col-xs-12 d-none d-lg-block">
        <%@include file="/includes/panelloDestra.jsp" %>
    </div>
</div>
<%@include file="/includes/footer.jsp" %>
</body>
</html>