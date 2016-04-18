<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Sites Elis</title> 
 
    <style>
        tr:first-child{
            font-weight: bold;
            background-color: #C6C9C4;
        }
    </style>
 
</head>
 
 
<body>
	<img src="resources/images/logoNexworld-300x65.png" style="float: left;"/>
    <h2>Liste des sites</h2>  
    <table>
        <tr>
            <td>Nom</td><td>Date d'ouverture</td><td>Nombre d'employés</td><td></td><td></td>
        </tr>
        <c:forEach items="${sites}" var="site">
            <tr>
            <td>${site.nom}</td>
            <td>${site.dateOuverture}</td>
            <td>${site.nombreSalaries}</td>
            <td><a href="<c:url value='/edit-${site.id}-site' />">éditer</a></td>
            <td><a href="<c:url value='/delete-${site.id}-site' />">supprimer</a></td>
            </tr>
        </c:forEach>
    </table>
    <br/>
    <a href="<c:url value='/new' />">Ajouter un site</a>
</body>
</html>