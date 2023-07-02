<!DOCTYPE html>
<html lang="en">
<head>
    <title>Admin Page</title>
    <%@include file="/includes/head.jsp"%>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/adminpage.css" type="text/css">
</head>
<body>
<%@include file="/includes/header.jsp" %>
<h1 class="Slogan">Admin Console</h1>

<div class="row" style="margin-left: 1%">
    <div id="PanelloSx" class="col-lg-2 col-md-2 col-sm-2 col-xs-12 d-none d-lg-block ">
        <%@include file="/includes/panelloSinistra.jsp" %>
    </div>
    <div class="col">
        <div class="row">
            <div class="col">
                <div class="users">
                   <input style="max-width: 75%" class="form-control" type="text" placeholder="Cerca Cliente...">
                   <button class="admin-but">Banna</button>
                </div>
            </div>
            <div class="col">
                <div class="product">
                    <input style="max-width: 75%" class="form-control" type="text" placeholder="Cerca Prodotto...">
                    <button class="admin-but">Elimina</button> <br>
                    <input style="border-radius: 50%" type="checkbox" class="form-check-input active unchecked" id="offerta">
                    <label for="offerta">Offerta</label>
                    <input style="max-width: 20%" class="form-control" type="number" id="disponibilita">
                    <label for="disponibilita">Disponibilità</label>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col1">
                <h3>Aggiungi un prodotto:</h3>
                <form action="${pageContext.request.contextPath}/..." method="post" id="addProd" name="addProduct">
                    <div class="form-group">
                        <input type="number" class="form-control" name="codice" placeholder="Codice" required>
                    </div>
                    <div class="form-group">
                        <input type="text" class="form-control" name="categoria" placeholder="Categoria" required>
                    </div>
                    <div class="form-group">
                        <input type="text" class="form-control" name="immagine" placeholder="Link Immagine" required>
                    </div>
                    <div class="form-group">
                        <input type="text" class="form-control" name="nome" placeholder="Nome Prodotto" required>
                    </div>
                    <div class="form-group">
                        <input type="text" class="form-control" name="descBreve" placeholder="Descrizione Breve" required>
                    </div>
                    <div class="form-group">
                        <input type="text" class="form-control" name="descLunga" placeholder="Descrizione Lunga" required>
                    </div>
                    <div class="form-group" style="display: flow">
                        <input style="max-width: 25%" type="number" class="form-control" name="prezzo" placeholder="prezzo" required>
                        <input style="max-width: 25%" type="number" class="form-control" name="disponibilità" placeholder="Disponibità" required>
                    </div>
                    <div id="regbutton" class="center-block form-group">
                        <button type="button" onclick="validateAddProduct(document.addProduct)" class="btn btn-success btn-lg btn-block" >Aggiungi Prodotto</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
    <div id="pannelloDx" class= "col-lg-2 col-md-2 col-sm-2 col-xs-12 d-none d-lg-block">
        <%@include file="/includes/panelloDestra.jsp" %>
    </div>
<%@include file="/includes/footer.jsp" %>
</body>
</html>
