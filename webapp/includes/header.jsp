


<c:set var="loginFail" value='${param["loginFail"]}' />
<c:set var="registered" value='${requestScope["registered"]}' />
<c:set var="accessDone" value='${sessionScope["accessDone"]}' />
<c:set var="loginSuccess" value='${param["loginSuccess"]}' />
<c:set var="currentUser" value='${sessionScope["currentSessionUser"]}' />
<c:set var="logoutDone" value='${param["logoutDone"]}' />
<c:set var="isAdmin" value='${sessionScope["isAdmin"]}' />
<c:set var="orderDone" value='${param["orderDone"]}' />
<c:set var="editDone" value='${param["editDone"]}' />



<c:if test="${loginFail}">
  <div class="popup alert alert-warning alert-dismissible fade-in" role="alert">
    <a class="close" data-dismiss="alert" aria-label="close">&times;</a>
    <strong>Attenzione,</strong> dati di login errati, riprova!
  </div>
</c:if>

<c:if test="${logoutDone}">
  <div class="popup alert alert-success alert-dismissible fade-in" role="success">
    <a class="close" data-dismiss="alert" aria-label="close">&times;</a>
    Logout effettuato correttamente, alla prossima!
  </div>
</c:if>

<c:if test="${loginSuccess}">
  <c:if test="${isAdmin == null}">
    <div class="popup alert alert-success alert-dismissible fade-in" role="success">
      <a class="close" data-dismiss="alert" aria-label="close">&times;</a>
      Sei loggato come <c:out value="${currentUser.username}"/>
    </div>
  </c:if>
</c:if>

<c:if test="${registered}">
  <div class="popup alert alert-success alert-dismissible fade-in" role="alert">
    <a class="close" data-dismiss="alert" aria-label="close">&times;</a>
    <strong>Complimenti!</strong> Sei registrato a Gameporium, effettua l'accesso usando il tasto Login.
  </div>
</c:if>

<c:if test="${isAdmin}">
  <div class="alert alert-warning alert-dismissible" role="alert">
    <a class="close" data-dismiss="alert" aria-label="close">&times;</a>
    <strong>Attenzione!</strong> Sei loggato come amministratore (${currentUser.username}).
  </div>
</c:if>

<c:if test="${orderDone}">
  <div class="popup alert alert-success alert-dismissible fade-in" role="success">
    <a class="close" data-dismiss="alert" aria-label="close">&times;</a>
    Ordine effettuato correttamente! È possibile consultare lo stato dell'ordine in "I miei ordini"
  </div>
</c:if>

<c:if test="${editDone}">
  <div class="popup alert alert-success alert-dismissible fade-in" role="success">
    <a class="close" data-dismiss="alert" aria-label="close">&times;</a>
    Hai cambiato correttamente i tuoi dati!
  </div>
</c:if>

<script type="text/javascript">
  window.setTimeout(function() {
    $(".popup").fadeTo(150, 0).slideUp(150, function(){
      $(this).remove();
    });
  }, 4000);
</script>

<!-- navbar -->
<nav class="navbar navbar-dark navbar-expand-lg"
     style="margin-top: 0px">

  <button class="navbar-toggler" type="button" data-toggle="collapse"
          data-target="#collapsibleNavbar">
    <span class="navbar-toggler-icon"></span>
  </button>


  <a class="ui-icon-image" href="${pageContext.request.contextPath}/homePage.jsp"><img
          src="${pageContext.request.contextPath}/Immagini/Logo.png" class="rounded mx-auto d-block"
          alt="Responsive image"
          style="margin-bottom: 0; max-width: 200px; max-height: 50%"></a>

  <div class="collapse navbar-collapse" id="collapsibleNavbar">
    <ul class="navbar-nav">
      <!-- 				ricerca mobile -->
      <li class = "msearch nav-item d-block d-lg-none mx-auto">
        <form action="productselection.jsp" method="post"
              class="form-inline md-form form-sm active-cyan active-cyan-2 mt-2">
          <button class="btn btn-mdb-color btn-rounded btn-sm my-0 ml-sm-2" type="submit">
            <i class="fas fa-search" aria-hidden="true"></i>
          </button>
          <input class="searchbox form-control" type="text" name="searchtxt"
                 aria-label="Search" placeholder="Cerca un prodotto">
        </form>

      </li>
      <!-- 				ricerca mobile -->

    <%--  <li class="nav-item dropdown"><a
              class="nav-link dropdown-toggle text-center" href="#"
              id="navbarDropdown" role="button" data-toggle="dropdown"
              aria-haspopup="true" aria-expanded="false"> Giochi </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
          <form action="product">
            <a class="dropdown-item" href="/Gameporium/productselection.jsp?categoria=gioco&attribute=descrizioneCategoria&value=tavolo">Giochi da tavolo</a>
            <a class="dropdown-item" href="/Gameporium/productselection.jsp?categoria=gioco&attribute=descrizioneCategoria&value=ruolo">Giochi di ruolo</a>
            <a class="dropdown-item" href="/Gameporium/productselection.jsp?categoria=gioco&attribute=descrizioneCategoria&value=carte">Giochi di carte</a>
            <div class="dropdown-divider"></div>
            <a class="dropdown-item" href="/Gameporium/productselection.jsp?categoria=gioco">Mostra tutti</a>
          </form>
        </div></li>

      <li class="nav-item dropdown"><a
              class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
              role="button" data-toggle="dropdown" aria-haspopup="true"
              aria-expanded="false"> Accessori </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
          <a class="dropdown-item" href="/Gameporium/productselection.jsp?categoria=accessorio&attribute=descrizioneCategoria&value=tavolo">Accessori per GdT</a> <a
                class="dropdown-item" href="/Gameporium/productselection.jsp?categoria=accessorio&attribute=descrizioneCategoria&value=ruolo">Accessori per GdR</a> <a
                class="dropdown-item" href="/Gameporium/productselection.jsp?categoria=accessorio&attribute=descrizioneCategoria&value=carte">Accessori per GdC</a>
          <div class="dropdown-divider"></div>
          <a class="dropdown-item" href="/Gameporium/productselection.jsp?categoria=accessorio">Mostra tutti</a>
        </div></li>
--%>

      <c:if test="${accessDone}">
        <c:if test="${isAdmin == true}">
          <li class="nav-item dropdown d-lg-none"><a
                  class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
                  role="button" data-toggle="dropdown" aria-haspopup="true"
                  aria-expanded="false"> Area amministratore </a>
            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
              <a class="dropdown-item" style="text-align: left; " href="AdminJSP/adminpage.jsp">Area amministratore</a>
              <div class="dropdown-divider"></div>
              <div style="text-align: center"><button class="btn btn-primary" type="submit">Logout</button></div>
            </div></li>

        </c:if>
        <c:if test="${isAdmin != true}">
          <li class="nav-item dropdown d-lg-none"><a
                  class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
                  role="button" data-toggle="dropdown" aria-haspopup="true"
                  aria-expanded="false"> Area utente </a>
            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
              <a class="dropdown-item" style="text-align: left; " href="userJSP/userLogged.jsp?azione=dati">Dati Utente</a>
              <a class="dropdown-item" style="text-align: left" href="userJSP/userLogged.jsp?azione=ordini">I miei Ordini</a>
              <a class="dropdown-item" style="text-align: left" href="userJSP/userLogged.jsp?azione=pagamento">Metodi di Pagamento</a>
              <div class="dropdown-divider"></div>

              <form action="${pageContext.request.contextPath}/LogoutServlet" method="get">
                <div style="text-align: center"><button class="btn btn-primary" type="submit">Logout</button></div>
              </form>
            </div></li>
          <a class="dropdown-item d-lg-none" style="text-align: center" href="CartJSP/cart.jsp">
            Carrello <i class="fas fa-shopping-cart" aria-hidden="true"></i>
          </a>
        </c:if>
      </c:if>

      <c:if test="${accessDone != true}">
        <li class="nav-item d-block d-lg-none"
            style="border-top: 1px solid #000000"><a class="nav-link"
                                                     href="mobileLogin.jsp" id="navbarDropdown" role="button">Accedi</a>
        </li>
        <li class="nav-item d-block d-lg-none"><a class="nav-link"
                                                  href="userJSP/register.jsp" id="navbarDropdown" role="button">Registrati</a>
        </li>
      </c:if>

    </ul>
  </div>


  <div class="navbar-collapse collapse w-100 order-3 dual-collapse2 d-none d-lg-block"
       id="collapsibleNavbarRight">

    <!-- 			ricerca desktop -->
    <ul class="navbar-nav ml-auto d-none d-lg-block">
      <li class="nav-item mr-auto" style="margin-bottom: 5px;">
        <form action="productselection.jsp" method="post"
              class="form-inline md-form form-sm active-cyan active-cyan-2 mt-2">
          <button class="btn btn-mdb-color btn-rounded btn-sm my-0 ml-sm-2" type="submit">
            <i class="fas fa-search" aria-hidden="true"></i>
          </button>
          <input class="searchbox form-control" type="text" name="searchtxt"
                 aria-label="Search" placeholder="Cerca un prodotto">
        </form>
      </li>
    </ul>
    <!-- 			ricerca desktop -->

    <!-- 			carrello -->
    <c:set var="cartcard" value='${sessionScope["cartcardinality"]}' />
    <ul class="navbar-nav">
      <li class="nav-item mr-auto carticon d-xs-block">
        <a href="CartJSP/cart.jsp" style="color: #E07D00;">
          <i class="fas fa-shopping-cart" aria-hidden="true"></i>
          <c:out value="${cartcard}"/>
        </a>
      </li>
    </ul>
    <!-- 			carrello -->


    <!-- 			login popup -->
    <c:if test="${accessDone == null}">
      <button type="button" id="dropdownMenu1" data-toggle="dropdown"
              class="btn btn-outline-secondary dropdown-toggle" onclick="validateLogin(document.loginform.pw, document.loginform.un)">
        Accedi o registrati <span class="caret"></span>
      </button>
      <ul class="dropdown-menu dropdown-menu-right mt-2">

        <li class="px-3 py-2">
          <form action="${pageContext.request.contextPath}/LoginServlet" method="post" class="form" role="form" name="loginform">


            <div class="form-group" >
              <input id="emailInput" placeholder="Username" oninput="validateLogin(document.loginform.pw, document.loginform.un)"
                     class="form-control form-control-sm" type="text" name="un"
                     required autocomplete="off" value="${cookie.saveUser.value}">
            </div>


            <div class="form-group">
              <input id="passwordInput" placeholder="Password" oninput="validateLogin(document.loginform.pw, document.loginform.un)" required
                     class="form-control form-control-sm" type="password" name="pw" autocomplete="off" value="${cookie.savePass.value}">
            </div>

            <div class="form-group">
              <button type="submit" class="loginbtn btn btn-primary btn-block" disabled>Login</button>
            </div>

            <div class="form-check text-right">
              <input type="checkbox" class="form-check-input active unchecked" id="exampleCheck1" name="remember">
              <label class="form-check-label" for="exampleCheck1">Ricordami</label>
            </div>

            <div class="form-group text-right">
              <small><a href="userJSP/register.jsp">Registrati</a></small>
            </div>

          </form>
        </li>
      </ul>
    </c:if>
    <!-- 			login popup -->

    <c:if test="${accessDone}">

      <c:if test="${isAdmin == null}">
        <div class="navbar-nav nav-item dropdown">

          <button type="button" id="dropdownMenu1" data-toggle="dropdown"
                  class="btn btn-outline-secondary dropdown-toggle">
            Benvenuto, <c:out value="${currentUser.username}"/> <span class="caret"></span>
          </button>

          <form action="${pageContext.request.contextPath}/LogoutServlet" method="get" class="dropdown-menu" aria-labelledby="navbarDropdown">
            <a class="dropdown-item" style="text-align: left; " href="userJSP/userLogged.jsp?azione=dati">Dati Utente</a>
            <a class="dropdown-item" style="text-align: left" href="userJSP/userLogged.jsp?azione=ordini">I miei Ordini</a>
            <a class="dropdown-item" style="text-align: left" href="userJSP/userLogged.jsp?azione=pagamento">Metodi di Pagamento</a>
            <div class="dropdown-divider"></div>
            <div style="text-align: center"><button class="btn btn-primary" type="submit">Logout</button></div>
          </form>
        </div>
      </c:if>

      <c:if test="${isAdmin == true}">
        <div class="navbar-nav nav-item dropdown">

          <button type="button" id="dropdownMenu1" data-toggle="dropdown"
                  class="btn btn-outline-secondary dropdown-toggle">
            Benvenuto, amministratore! <span class="caret"></span>
          </button>

          <form action="LogoutServlet" method="get" class="dropdown-menu" aria-labelledby="navbarDropdown">
            <a class="dropdown-item" style="text-align: left; " href="AdminJSP/adminpage.jsp">Area Amministratore</a>
            <div class="dropdown-divider"></div>
            <div style="text-align: center"><button class="btn btn-primary" type="submit">Logout</button></div>
          </form>
        </div>
      </c:if>

    </c:if>

  </div>

</nav>
<!-- end navbar -->

</body>