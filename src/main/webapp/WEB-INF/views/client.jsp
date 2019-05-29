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
    <title>Form</title>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-sm">
            <h1>Formulaire</h1>
            <a href="index.html"><h3>Accueil</h3></a>
            <a href="search.html"><h3>Recherche</h3></a>
            <form method="post" class="form">
                <div class="form-row">
                    <div class="col">
                        <input type="text" placeholder="nom" name="nom" class="form-control" value="${empty updateClient ? '' : updateClient.nom}">
                    </div>
                    <div class="col">
                        <input type ="text" placeholder ="prenom" name="prenom" class="form-control" value="${empty updateClient ? '' : updateClient.nom}">
                    </div>
                    <div class="col">
                        <input type="submit" class="btn btn-primary">
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
