<%--
  Created by IntelliJ IDEA.
  User: jimmy
  Date: 25/03/2019
  Time: 15:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <title>Nouveau client</title>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-sm">
            <a href="index.html"><h1>ProxiBanqueSI</h1></a>
            <form method="post" class="form">
                    <div class="form-group">
                        <label for="nom">Nom</label>
                        <input type="text" class="form-control" name="nom" id="nom" value="${empty updateClient ? '' : updateClient.nom}">
                    </div>
                    <div class="form-group">
                        <label for="prenom">Prénom</label>
                        <input type="text" class="form-control" name="prenom" id="prenom" value="${empty updateClient ? '' : updateClient.prenom}">
                    </div>
                    <div class="form-group">
                        <label for="adresse">Adresse</label>
                        <input type="text" class="form-control" name="adresse" id="adresse" value="${empty updateClient ? '' : updateClient.adresse}">
                    </div>
                <div class="form-group">
                    <label for="codePostal">Code postal</label>
                    <input type="text" class="form-control" name="codePostal" id="codePostal" value="${empty updateClient ? '' : updateClient.codePostal}">
                </div>
                <div class="form-group">
                    <label for="ville">Ville</label>
                    <input type="text" class="form-control" name="ville" id="ville" value="${empty updateClient ? '' : updateClient.ville}">
                </div>
                <div class="form-group">
                    <label for="telephone">Téléphone</label>
                    <input type="text" class="form-control" name="telephone" id="telephone" value="${empty updateClient ? '' : updateClient.telephone}">
                </div>
                <div class="form-group">
                    <label for="mail">Adresse e-mail</label>
                    <input type="text" class="form-control" name="mail" id="mail" value="${empty updateClient ? '' : updateClient.mail}">
                </div>
<%--                <div class="form-check">
                    <input class="form-check-input" type="checkbox" id="typePersonne" name="typePersonne" value="${empty updateClient ? '' : updateClient.typePersonne}">
                    <label class="form-check-label" for="typePersonne">
                        Entreprise
                    </label>
                </div>--%>
                    <button type="submit" class="btn btn-primary">Valider</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>
