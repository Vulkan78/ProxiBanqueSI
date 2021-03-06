<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">

<!------ Head ---------->
<head>
    <title>Liste des clients</title>
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
        <label for="srch-term">Rechercher un client :</label>
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
    </tr>
    </thead>

    <!------ Tableau infos : Données ---------->
    <tbody>
    <c:forEach items="${clientList}" var="client">
    <tr>
        <td>${client.id}</td>
        <td>${client.nom}</td>
        <td>${client.prenom}</td>
        <td>${client.adresse}</td>
        <td>${client.codePostal}</td>
        <td>${client.ville}</td>
        <td>${client.telephone}</td>
        <td>${client.mail}</td>

        <td><a class="glyphicon glyphicon-pencil" href="update.html?id=${client.id}"></td>
        <td><a class="glyphicon glyphicon-align-justify" href="comptes.html"></td>
        <td><a class="glyphicon glyphicon-sort" href="virement.html"></td>
        <td><a class="glyphicon glyphicon-trash" href="delete.html?id=${client.id}"></td>

    </tr>
    <tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
