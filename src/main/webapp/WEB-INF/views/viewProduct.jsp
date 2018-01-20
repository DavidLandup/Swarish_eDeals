<%@include file="/WEB-INF/views/template/header.jsp" %>


<!-- Page Content -->
<div class="container">

    <!-- Page Heading/Breadcrumbs -->
    <h1 class="mt-4 mb-3">Product details: </h1>

    <ol class="breadcrumb">
        <li class="breadcrumb-item">
            <a href="<c:url value="/"/>">Home</a>
        </li>
        <li class="breadcrumb-item active">${product.productCategory}</li>
        <li class="breadcrumb-item active">${product.productName}</li>
    </ol>

    <!-- Content Row -->
    <div class="row">
        <!-- Sidebar Column -->
        <div class="col-lg-3 mb-4">
            <div class="list-group">
                <a href="<c:url value="/"/>" class="list-group-item">Home</a>
                <a href="" class="list-group-item">About</a>
                <a href="" class="list-group-item">Services</a>
                <a href="" class="list-group-item">Contact</a>
                <a href="" class="list-group-item">1 Column Portfolio</a>
                <a href="" class="list-group-item">2 Column Portfolio</a>
                <a href="" class="list-group-item">3 Column Portfolio</a>
                <a href="" class="list-group-item">4 Column Portfolio</a>
                <a href="" class="list-group-item">Pricing Table</a>
            </div>
        </div>
        <!-- Content Column -->
        <div class="col-lg-9 mb-4">
            <h2>${product.productName}</h2>
            <img src="<c:url value="/resources/images/products/${product.id}.png"/>">
            <p>${product.productDescription}</p>

            <h4 style="color:red">Deal price: ${product.dealPrice}$</h4>
            <p style="text-decoration: line-through">List price: ${product.listPrice}$</p>

            <a href="${product.urltoDeal}" class="btn btn-success"> See deal! </a>
            <h4>Posted by: ${product.ownerUsername}</h4>
            <c:if test="${pageContext.request.userPrincipal.name == product.ownerUsername}">
                <a href="<c:url value="/profile/product/editProduct/${product.id}"/>" class="btn btn-success"> Edit post! </a>
            </c:if>
        </div>
    </div>
    <!-- /.row -->

</div>
<!-- /.container -->

<!-- Footer -->
<footer class="py-5 bg-dark">
    <div class="container">
        <p class="m-0 text-center text-white">Copyright &copy; Swarish eDeals 2017</p>
    </div>
    <!-- /.container -->
</footer>

<!-- Bootstrap core JavaScript -->
<script src="vendor/jquery/jquery.min.js"></script>
<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

</body>

</html>
