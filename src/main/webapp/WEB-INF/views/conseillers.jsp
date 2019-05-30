<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

<head>
    <title>Liste des conseillers</title>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-sm">
            <a href="index.html"><h1>ProxiBanqueSI</h1></a>
            <a href="conseiller.html"><h3>Nouveau conseiller</h3></a>
            <a href="client.html"><h3>Nouveau client</h3></a>
            <a href="search.html"><h3>Recherche client</h3></a>
            <table class="table">
                <thead class="thead-dark">
                <tr>
                    <td>ID</td>
                    <td>Prénom</td>
                    <td>Nom</td>
                    <td>Adresse</td>
                    <td>Ville</td>
                    <td>CP</td>
                    <td>Téléphone</td>
                    <td>Mail</td>
                    <td>Login</td>
                    <td></td>
                    <td></td>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${conseillerList}" var="conseiller">
                <tr>
                    <td>${conseiller.id}</td>
                    <td>${conseiller.prenom}</td>
                    <td>${conseiller.nom}</td>
                    <td>${conseiller.adresse}</td>
                    <td>${conseiller.ville}</td>
                    <td>${conseiller.codePostal}</td>
                    <td>0${conseiller.telephone}</td>
                    <td>${conseiller.mail}</td>
                    <td>${conseiller.login}</td>
                    <td><a href="updateConseiller.html?id=${conseiller.id}">
                        <img src="images/update.png" style="width:20px">
                    </a>
                    </td>
                    <td><a href="deleteConseiller.html?id=${conseiller.id}">
                        <img src="images/delete.png" style="width:20px">
                    </a>
                    </td>
                </tr>
                </tbody>
                </c:forEach>
            </table>
        </div>
    </div>
</div>
</body>
</html>
