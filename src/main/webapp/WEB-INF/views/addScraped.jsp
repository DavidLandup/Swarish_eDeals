<%@include file="/WEB-INF/views/template/header.jsp" %>


<!-- Page Content -->
<div class="container">

    <!-- Page Heading/Breadcrumbs -->
    <h1 class="mt-4 mb-3">Add Product
    </h1>

    <ol class="breadcrumb">
        <li class="breadcrumb-item">
            <a href="<c:url value="/"/>">Home</a>
        </li>
        <li class="breadcrumb-item active">Add Product</li>
    </ol>

    <!-- /.row -->
        <form:form action="${pageContext.request.contextPath}/profile/product/addScraped" method="post"
               commandName="product" enctype="multipart/form-data" accept-charset="UTF-8">
        <form:hidden path="ownerUsername" value="${pageContext.request.userPrincipal.name}"/>

    <div class="form-group">
        <label for="name">Product URL</label>
        <input type="text" name="productURL" id="name" class="form-control" accept-charset="UTF-8"/>
    </div>


    <br><br>
    <input type="submit" value="Add" class="btn btn-default">
    </form:form>
    </body>
    </html>
