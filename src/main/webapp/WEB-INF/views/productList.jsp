<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<style>
    table {
        border-collapse: collapse;
        width: 100%;
    }

    th, td {
        text-align: left;
        padding: 8px;
        overflow-wrap: break-word;
    }

    tr:nth-child(even){background-color: #f2f2f2}
</style>
<div class="page-header">
    <h1>All products</h1>
    <p class="lead"> These are all current products available! </p>
</div>
<div>
    <input type="text" name="search" placeholder="Search..." style="float: right">
</div>
<br><br>

<table class="table table-striped table-hover">
    <thead>
    <tr class="bg-success">
        <th>Photo</th>
        <th>Name</th>
        <th>Category</th>
        <th>Price</th>
        <th>Description</th>
        <th></th>
    </tr>
    </thead>
    <c:forEach items="${products}" var="product">

        <tr>
            <td><a href="<spring:url value="/product/viewProduct/${product.id}"/>">

                <img src="<c:url value="/resources/images/products/${product.id}.png"/>" alt="image"
                     style="width:10%">
            </a>
            </td>
            <td>${product.productName}</td>
            <td>${product.productCategory}</td>
            <td>${product.dealPrice} din</td>
            <td>${product.productDescription}</td>
            <td><a href="<spring:url value="/product/viewProduct/${product.id}"/>"><span
                    class="glyphicon glyphicon-info-sign"></span></a></td>

        </tr>
    </c:forEach>

</table>


<h4>Pages: </h4>
<c:forEach begin="1" end="${totalpages}" varStatus="counter">
    <dd style="float:left">
        <a href="<c:url value="?page=${counter.count}"/> ">
            <button class="btn btn-default">${counter.count}</button>
        </a>
    </dd>
</c:forEach>


<br><br>

</body>
</html>
