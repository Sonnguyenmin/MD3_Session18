<%--
  Created by IntelliJ IDEA.
  User: nguye
  Date: 8/6/2024
  Time: 10:59 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <title>Sửa Account</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<div class="container">
        <div class="form-group">
            <label for="fullName">Họ và tên</label>
            <input type="text" class="form-control" value="${account.fullName}" name="fullName" id="fullName" placeholder="fullName">
        </div>
        <div class="form-group">
            <label for="email">email</label>
            <input type="text" class="form-control" name="email" value="${account.email}" id="email" placeholder="email">
        </div>
        <div class="form-group">
            <label for="password">Mật khẩu</label>
            <input type="text" class="form-control" name="password" value="${account.password}" id="password" placeholder="password">
        </div>
        <div class="form-group">
            <label>Giới tính</label>
            <input type="text" class="form-control" name="password" value="${account.gender ? "Nam" : "Nữ"}" id="gender">

        </div>
        <div class="form-group">
            <label>Trạng thái</label>
            <input type="text" class="form-control" name="password" value="${account.status ? "Hoạt động" : "Không hoạt động"}" id="status">
        </div>
        <a href="/" class="btn btn btn-secondary">Trở lại</a>
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
