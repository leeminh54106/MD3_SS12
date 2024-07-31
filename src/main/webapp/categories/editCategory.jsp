
<%--
  Created by IntelliJ IDEA.
  User: nguye
  Date: 7/26/2024
  Time: 10:59 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

</head>
<body>
<div class="container p-3">
    <h1 style="text-align: center">Cập nhật danh mục</h1>
    <form action="/category-servlet" method="post">
        <table class="table table-striped">
            <thead>
            <tr>
                <th>Id</th>
                <td><input type="text" name="categoryId" readonly value="${category.categoryId}"></td>
                <th>Tên</th>
                <td><input type="text" name="categoryName" value="${category.categoryName}"></td>
                <th>Trạng thái</th>
                <td>
                    <input type="radio" name="categoryStatus" ${category.categoryStatus ? "checked" : ""} value="true"> <span>Hiển thị</span>
                    <input type="radio" name="categoryStatus" ${!category.categoryStatus ? "checked" : ""} value="false"> <span>Ẩn</span>
                </td>
            </tr>
            <tr>
                <th colspan="2">
                    <input class="btn btn-primary" type="submit" value="edit" name="action">
                </th>

                <a class="btn btn-info" href="/category-servlet">Quay lại</a>

            </tr>
            </thead>
        </table>
    </form>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>