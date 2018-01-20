<%@include file="/WEB-INF/views/template/header.jsp" %>


<!-- Page Content -->
<div class="container">

    <!-- Page Heading/Breadcrumbs -->
    <h1 class="mt-4 mb-3">Login
    </h1>

    <ol class="breadcrumb">
        <li class="breadcrumb-item">
            <a href="<c:url value="/"/>">Home</a>
        </li>
        <li class="breadcrumb-item active">Login</li>
    </ol>


            <h2>Log in using your credentials!</h2>

            <c:if test="${not empty msg}">
                <div class="msg">
                        ${msg}
                </div>
            </c:if>


            <form name="loginForm" action="<c:url value="/j_spring_security_check"/>" method="post" style="width:30% ">

                <c:if test="${not empty error}">
                    <div class="error" style="color:red">${error}</div>
                </c:if>

                <div class="form-group">
                    <label for="username">Username: </label>
                    <input type="text" id="username" name="username" class="form-control"/>

                </div>

                <div class="form-group">
                    <label for="password">Password: </label>
                    <input type="password" id="password" name="password" class="form-control"/>
                </div>

                <input type="submit" value="Login" class="btn btn-default"/>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

            </form>
        </div>

</body>
</html>

