<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Hello Facebook</title>
</head>
<body>
<h3>Hello, ${facebookProfile.name}!</h3>

<h4>Here is your feed:</h4>

<c:forEach items="${feed}" var="post">
<div>
    <b> ${post.from.name} from</b> wrote:
    <p>${post.message} message text</p>
        ${post.picture}
    <img src="<c:url value="${post.picture}"/>">
    <hr/>
</div>
</c:forEach>
</body>
</html>