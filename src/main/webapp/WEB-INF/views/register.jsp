<%@include file="/WEB-INF/views/template/header.jsp" %>


<!-- Page Content -->
<div class="container">

    <!-- Page Heading/Breadcrumbs -->
    <h1 class="mt-4 mb-3">Register
    </h1>

    <ol class="breadcrumb">
        <li class="breadcrumb-item">
            <a href="<c:url value="/"/>">Home</a>
        </li>
        <li class="breadcrumb-item active">Register</li>
    </ol>

    <!-- /.row -->

    <form:form action="${pageContext.request.contextPath}/register" method="post" commandName="profile"
               style="width:30%">

    <div class="row">
        <div class="col-lg-8 mb-4">
            <h3>Info:</h3>
            <form name="sentMessage" id="contactForm" novalidate>
                <div class="control-group form-group">
                    <div class="controls">
                        <label>Name:</label>
                        <form:input path="name" id="name" class="form-control"
                                    required-validation-required-message="Please enter your name..."/>
                        <p class="help-block"></p>
                    </div>
                </div>

                <div class="control-group form-group">
                    <div class="controls">
                        <label>Surname:</label>
                        <form:input path="surname" id="surname" class="form-control"
                                    required-validation-required-message="Please enter your surname..."/>
                        <p class="help-block"></p>
                    </div>
                </div>

                <div class="control-group form-group">
                    <div class="controls">
                        <label>Email:</label>
                        <form:input path="email" id="email" class="form-control"
                                    required-validation-required-message="Please enter your email..."/>
                    </div>
                </div>
                <div class="control-group form-group">
                    <div class="controls">
                        <label>Username:</label>
                        <form:input path="username" id="username" class="form-control"
                                    required-validation-required-message="Please enter your username..."/>
                    </div>
                </div>

                <div class="control-group form-group">
                    <div class="controls">
                        <label>Password:</label>
                        <form:password path="password" id="password" class="form-control"
                                       required-validation-required-message="Please enter your password..."/>
                    </div>
                </div>

                <div class="control-group form-group">
                    <div class="controls">
                        <label>Country:</label>
                        <form:input path="country" id="country" class="form-control"
                                    required-validation-required-message="Please enter your country..."/>
                    </div>
                </div>


                <!-- /.row -->


                <input type="submit" value="Register!" class="btn btn-default">
                <a href="<c:url value="/"/>" class="btn btn-default">Cancel</a>
        </div>
        </form:form>
    </div>
</div>
    </body>
    </html>
