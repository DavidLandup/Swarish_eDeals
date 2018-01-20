<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Some title</title>
</head>
<body>
<h1>Welcome to eDeals.com!</h1>
<h2>Here's a list of our users: </h2>
<hr>
<br><br>
<c:forEach items="${profileList}" var="profile">
    <p><strong>Username: ${profile.username}</strong></p>
    <p>Country: ${profile.country}</p>
    <p>Profile id: ${profile.profileId}</p>
    <hr>
</c:forEach>
</body>
</html>
