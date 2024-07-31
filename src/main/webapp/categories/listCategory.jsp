<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <title>Trang chủ</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<div class="container p-3">
    <h1 class="m-2"> Danh sách danh mục</h1>
    <div style="display: flex; justify-content: space-between; align-items: center; margin: 20px 0;">
        <a href="/category-servlet?action=add" class="btn btn-primary">Thêm mới danh mục</a>
        <form action="/category-servlet" method="post">
            <b>Tên danh mục: </b>
            <input type="text" name="search"/>
            <input type="submit" name="action" value="search"/>
        </form>
    </div>
    <table class="table table-striped">
        <thead>
        <tr style="text-align: center">
            <th scope="col">STT</th>
            <th scope="col">Tên danh mục</th>
            <th scope="col">Trạng thái</th>
            <th scope="col" colspan="1">Hành động</th>
        </tr>
        </thead>
        <tbody>
        <jsp:useBean id="categories" scope="request" type="java.util.List"/>
        <c:forEach items="${categories}" var = "c" >
            <tr style="text-align: center">
                <td scope="row">${c.categoryId}</td>
                <td>${c.categoryName}</td>
                <td>${c.categoryStatus ? "Hiển thị" : "Ẩn"}</td>
                <td>
                    <a href="/category-servlet?action=detail&id=${c.categoryId}" class="btn btn-info ">Chi tiết</a>
                </td>
                <td>
                    <a href="/category-servlet?action=edit&id=${c.categoryId}" class="btn btn-warning ">Sửa</a>
                </td>
                <td>
                    <a href="/category-servlet?action=delete&id=${c.categoryId}" class="btn btn-danger" onclick="return confirm('Bạn có chắc chắn muốn xóa không')">Xóa</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>