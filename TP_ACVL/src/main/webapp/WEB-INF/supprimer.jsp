<%@page import="modele.Ouvrage"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<html>
    <head>
	<meta charset="UTF-8"/>
	<title>Supprimer Item</title>
    </head>
    <body>
        <h2> Supprimer Item </h2>
        
        <%
            Ouvrage ouvrage = (Ouvrage) request.getAttribute("ouvrage");
        %>
        
        <form action="controleur" method="post" accept-charset="UTF-8">
            <label>Auteur :</label><input type="text" name="auteur" value="<%= ouvrage.getAuteur() %>" readonly/><br/>
            <label>Titre :</label><input type="text" name="titre" value="<%= ouvrage.getTitre() %>" readonly/> <br/>
            <!-- Annuler est un simple lien car il ne soumet pas le formulaire -->
            <a href="controleur">Annuler</a>
            <input type="submit" value="Valider" />
            <!-- Pour indiquer au contrôleur quelle action faire, on utilise un champ caché -->
            <input type="hidden" name="action" value="supprimer" />
            <input type="hidden" name="id" value="<%= ouvrage.getId() %>" />
        </form>        
    </body>
</html>
