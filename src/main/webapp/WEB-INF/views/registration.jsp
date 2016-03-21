<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<html>
 
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Enregistrement d'un nouveau site</title>
 
<style>
 
    .error {
        color: #ff0000;
    }
</style>
 
</head>
 
<body>
 
    <h2>Enregistrement d'un nouveau site</h2>
  
    <form:form method="POST" modelAttribute="site">
        <form:input type="hidden" path="id" id="id"/>
        <table>
            <tr>
                <td><label for="nom">Nom: </label> </td>
                <td><form:input path="nom" id="nom"/></td>
                <td><form:errors path="nom" cssClass="error"/></td>
            </tr>
         
            <tr>
                <td><label for="dateOuverture">Date d'ouverture : </label> </td>
                <td><form:input path="dateOuverture" id="dateOuverture"/></td>
                <td><form:errors path="dateOuverture" cssClass="error"/></td>
            </tr>
     
            <tr>
                <td><label for="nombreSalaries">Nombre d'employés : </label> </td>
                <td><form:input path="nombreSalaries" id="nombreSalaries"/></td>
                <td><form:errors path="nombreSalaries" cssClass="error"/></td>
            </tr>
     
            <tr>
                <td colspan="3">
                    <c:choose>
                        <c:when test="${edit}">
                            <input type="submit" value="Mettre à jour"/>
                        </c:when>
                        <c:otherwise>
                            <input type="submit" value="Enregistrer"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
        </table>
    </form:form>
    <br/>
    <br/>
    Retour à la <a href="<c:url value='/list' />">liste des sites</a>
</body>
</html>