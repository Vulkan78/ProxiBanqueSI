<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

<head>
    <title>Liste des clients</title>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-sm">
            <a href="index.html"><h1>ProxiBanqueSI</h1></a>
            <a href="client.html"><h3>Nouveau client</h3></a>
            <a href="search.html"><h3>Recherche client</h3></a>
            <table class="table">
                <thead class="thead-light">
                <tr>
                    <td>ID</td>
                    <td>Prénom</td>
                    <td>Nom</td>
                    <td>Adresse</td>
                    <td>Ville</td>
                    <td>CP</td>
                    <td>Téléphone</td>
                    <td>Mail</td>
                    <%--<td>Entreprise</td>--%>
                    <td></td>
                    <td></td>
                    <td></td>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${clientList}" var="client">
                <tr>
                    <td>${client.id}</td>
                    <td>${client.prenom}</td>
                    <td>${client.nom}</td>
                    <td>${client.adresse}</td>
                    <td>${client.ville}</td>
                    <td>${client.codePostal}</td>
                    <td>0${client.telephone}</td>
                    <td>${client.mail}</td>
                    <%--<td>${client.typePersonne}</td>--%>
                    <td><a href="update.html?id=${client.id}">
                        <img src="images/update.png" style="width:20px">
                    </a>
                    </td>
                    <td><a href="virement.html?id=${client.id}">
                        <img src="images/virement.png" style="width:20px">
                    </a>
                    </td>
                    <td><a href="delete.html?id=${client.id}">
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
