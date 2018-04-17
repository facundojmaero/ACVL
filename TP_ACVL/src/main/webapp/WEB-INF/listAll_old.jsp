<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
	<meta charset="UTF-8"/>
	<title>Références bibliographiques</title>
    </head>
    <body>
        <h2> Liste des références </h2>

        <p>
            <a href="ajouter.html">Ajouter une référence bibliographique</a>
        </p>

        <table>
            <tr>
                <th>Auteur</th>
                <th>Titre</th>
                <th><!-- Modifier --></th>
                <th><!-- Supprimer --></th>
            </tr>
            <c:forEach items="${ouvrages}" var="ouvrage">
                <tr>
                    <td>${ouvrage.auteur}</td><td>${ouvrage.titre}</td>
                    <td><a href="controleur?action=getOuvrage&view=modifier&id=${ouvrage.id}">modifier</a></td>
                    <td><a href="controleur?action=getOuvrage&view=supprimer&id=${ouvrage.id}">supprimer</a></td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
