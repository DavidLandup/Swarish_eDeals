<%@include file="/WEB-INF/views/template/header.jsp" %>


<!-- Page Content -->
<div class="container">

    <!-- Page Heading/Breadcrumbs -->
    <h1 class="mt-4 mb-3">Edit Product
    </h1>

    <ol class="breadcrumb">
        <li class="breadcrumb-item">
            <a href="<c:url value="/"/>">Home</a>
        </li>
        <li class="breadcrumb-item active">Edit Product</li>
    </ol>

        <form:form action="${pageContext.request.contextPath}/profile/product/addProduct" method="post"
                   commandName="product" enctype="multipart/form-data" accept-charset="UTF-8">
            <form:hidden path="ownerUsername" value="${pageContext.request.userPrincipal.name}"/>
            <form:hidden path="id" value="${product.id}"/>

        <div class="form-group">
            <label for="name">Product Name</label> <form:errors path="productName" cssStyle="color:red"/>
            <form:input path="productName" id="name" class="form-control" accept-charset="UTF-8"/>
        </div>
            <%--Category --%>
        <div class="form-group">
            <label for="category">Category</label>


            <form:select path="productCategory" name="category">
                <form:option value="Kitchen">Kitchen</form:option>
                <form:option value="Electronics">Electronics</form:option>
                <form:option value="Home">Home</form:option>
                <form:option value="Travel">Travel</form:option>
            </form:select>

        </div>
            <%--Description --%>
        <div class="form-group">
            <label for="description">Description</label>
            <form:textarea path="productDescription" id="description" class="form-control" accept-charset="UTF-8"/>
        </div>
            <%--Price --%>
        <div class="form-group">
            <label for="price">Deal price</label> <form:errors path="dealPrice" cssStyle="color:red"/>
            <form:input path="dealPrice" id="price" class="form-control"/>
        </div>
        <div class="form-group">
            <label for="price">List price</label> <form:errors path="listPrice" cssStyle="color:red"/>
            <form:input path="listPrice" id="price" class="form-control"/>
        </div>

        <div class="form-group">
            <label for="price">URL to deal</label> <form:errors path="urltoDeal" cssStyle="color:red"/>
            <form:input path="urltoDeal" id="price" class="form-control"/>
        </div>


            <%--Photo --%>
        <div class="form-group">
            <label class="control-label" for="productImage">Choose photo</label>
            <form:input id="productImage" path="productImage" type="file" class="form:input-large"/>
        </div>

        <br><br>
        <input type="submit" value="Add" class="btn btn-default">
        </form:form>
</body>
</html>
