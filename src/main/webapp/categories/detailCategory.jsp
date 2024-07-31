<%--
  Created by IntelliJ IDEA.
  User: nguye
  Date: 7/26/2024
  Time: 1:48 PM
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
    <h1 class="m-2"> Chi tiết danh mục</h1>
    <div style="display: flex; justify-content: space-between; align-items: center; margin: 20px 0;">
    </div>
    <table class="table table-striped">
        <thead>
        <tr style="text-align: center">
            <th scope="col">STT</th>
            <th scope="col">Tên danh mục</th>
            <th scope="col">Trạng thái</th>
        </tr>
        </thead>
        <tbody>
        <tr style="text-align: center">
            <td>
                ${categoryDetail.categoryId}
            </td>
            <td>
                ${categoryDetail.categoryName}
            </td>
            <td>
                ${categoryDetail.categoryStatus ? "Hiển thị" : "Ẩn"}
            </td>
        </tr>
        </tbody>
    </table>
    <a class="btn btn-info" href="/category-servlet">Quay lại</a>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>
