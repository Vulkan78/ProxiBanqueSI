<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">

<!------ Head ---------->
<head>
    <title>Liste des conseillers</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>

<!------ Body ---------->
<body>

<!------ Bar de menu ---------->
<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <!------ Logo ---------->
            <img src="https://www.proxi-bnk.com/content/PA_esf-ca-app-content/content/pws/rbwm/static/images/layout/logo-fb.gif" alt="Responsive image" style="width:60%">
        </div>
        <ul class="nav navbar-nav">
            <li><a href="index.html"><span class="glyphicon glyphicon-home"></a></li>

            <li> <a href="client.html">Nouveau client</a></li>
            <li><a href="conseiller.html">Nouveau conseiller</a></li>
        </ul>
        <!------ Déconnexion ---------->
        <ul class="nav navbar-nav navbar-right">
            <li><a href="login.html"><span class="glyphicon glyphicon-off"></span> Se déconnecter</a></li>
        </ul>
    </div>
</nav>

<!------ Barre de recherche ---------->

<div class="container">

    <div class="col-sm-5">
        <label for="srch-term">Rechercher un conseiller :</label>
    </div>

    <div class="col-sm-9">
        <div class="input-group-btn">
            <form class="navbar-form" role="search">
                <div class="input-group add-on">

                    <input class="form-control" placeholder="Rechercher" name="srch-term" id="srch-term" type="text">

                    <button class="btn btn-default" type="submit"><i class="glyphicon glyphicon-search"></i></button>
                </div>
        </div>
        </form>


    </div>
</div>



<!------ Tableau infos : Titres ---------->
<table class="table table-striped">
    <thead>
    <tr>
        <th scope="col">#</th>
        <th scope="col">Nom</th>
        <th scope="col">Prénom</th>
        <th scope="col">Adresse</th>
        <th scope="col">CP</th>
        <th scope="col">Ville</th>
        <th scope="col">Téléphone</th>
        <th scope="col">Mail</th>
        <th scope="col">Login</th>
    </tr>
    </thead>

    <!------ Tableau infos : Données ---------->
    <tbody>
    <c:forEach items="${conseillerList}" var="conseiller">
    <tr>
        <td>${conseiller.id}</td>
        <td>${conseiller.nom}</td>
        <td>${conseiller.prenom}</td>
        <td>${conseiller.adresse}</td>
        <td>${conseiller.codePostal}</td>
        <td>${conseiller.ville}</td>
        <td>${conseiller.telephone}</td>
        <td>${conseiller.mail}</td>
        <td>${conseiller.login}</td>

        <td><a class="glyphicon glyphicon-pencil" href="updateConseiller.html?id=${conseiller.id}"></td>
        <td><a class="glyphicon glyphicon-align-justify" href="comptes.html"></td>
        <td><a class="glyphicon glyphicon-sort" href="virement.html"> </td>
        <td><a class="glyphicon glyphicon-trash" href="deleteConseiller.html?id=${conseiller.id}"></td>

    </tr>
    <tr>

        </c:forEach>
    </tbody>
</table>
</body>
</html>
