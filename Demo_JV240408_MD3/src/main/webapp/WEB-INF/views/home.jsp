<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: nguye
  Date: 8/6/2024
  Time: 9:54 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <title>danh sach account</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
    <div class="container">
        <a class="btn btn-primary" href="<%=request.getContextPath()%>/add">Thêm mới</a>
        <table class="table table-striped table-inverse table-responsive">
            <thead class="thead-inverse">
            <tr>
                <th>Stt</th>
                <th>Họ và tên</th>
                <th>Email</th>
                <th>Mật khẩu</th>
                <th>Giới tính</th>
                <th>TRạng thái</th>
                <th colspan="2">Hành động</th>

            </tr>
            </thead>
            <tbody>
            <c:forEach items="${accounts}" var="a" varStatus="loop">
                <tr>
                    <td scope="row">${loop.count}</td>
                    <td>${a.fullName}</td>
                    <td>${a.email}</td>
                    <td >${a.password}</td>
                    <td>${a.gender ? "Nam" : "Nữ"}</td>
                    <td>${a.status ? "Hoạt động" : "Không hoạt động"}</td>
                    <td>
                        <a class="btn btn-warning" href="<%=request.getContextPath()%>/edit/${a.id}">Sửa</a>
                        <a class="btn btn-danger" href="<%=request.getContextPath()%>/delete/${a.id}">Xóa</a>
                        <a class="btn btn-primary" href="<%=request.getContextPath()%>/detail/${a.id}">Chi tiết</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
</body>
</html>