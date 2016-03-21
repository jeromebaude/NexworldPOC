<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Confirmation d'enregistrement</title>
</head>
<body>
    ${success}
    <br/>
    <br/>
    Retour à la <a href="<c:url value='/list' />">liste des sites</a>
     
</body>
 
</html>