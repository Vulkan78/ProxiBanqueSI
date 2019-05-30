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
    <title>Nouveau conseiller</title>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-sm">
            <a href="index.html"><h1>ProxiBanqueSI</h1></a>
            <form method="post" class="form">
                <div class="form-group">
                    <label for="nom">Nom</label>
                    <input type="text" class="form-control" name="nom" id="nom" value="${empty updateConseiller ? '' : updateConseiller.nom}">
                </div>
                <div class="form-group">
                    <label for="prenom">Prénom</label>
                    <input type="text" class="form-control" name="prenom" id="prenom" value="${empty updateConseiller ? '' : updateConseiller.prenom}">
                </div>
                <div class="form-group">
                    <label for="adresse">Adresse</label>
                    <input type="text" class="form-control" name="adresse" id="adresse" value="${empty updateConseiller ? '' : updateConseiller.adresse}">
                </div>
                <div class="form-group">
                    <label for="codePostal">Code postal</label>
                    <input type="text" class="form-control" name="codePostal" id="codePostal" value="${empty updateConseiller ? '' : updateConseiller.codePostal}">
                </div>
                <div class="form-group">
                    <label for="ville">Ville</label>
                    <input type="text" class="form-control" name="ville" id="ville" value="${empty updateConseiller ? '' : updateConseiller.ville}">
                </div>
                <div class="form-group">
                    <label for="telephone">Téléphone</label>
                    <input type="text" class="form-control" name="telephone" id="telephone" value="${empty updateConseiller ? '' : updateConseiller.telephone}">
                </div>
                <div class="form-group">
                    <label for="mail">Adresse e-mail</label>
                    <input type="text" class="form-control" name="mail" id="mail" value="${empty updateConseiller ? '' : updateConseiller.mail}">
                </div>
                <div class="form-group">
                    <label for="login">Login</label>
                    <input type="text" class="form-control" name="login" id="login" value="${empty updateConseiller ? '' : updateConseiller.login}">
                </div>
                <div class="form-group">
                    <label for="password">Mot de passe</label>
                    <input type="password" class="form-control" name="password" id="password" value="${empty updateConseiller ? '' : updateConseiller.password}">
                </div>
                <button type="submit" class="btn btn-primary">Valider</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>
