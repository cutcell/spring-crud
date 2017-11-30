<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Edit user</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css"
          integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb"
          crossorigin="anonymous">
</head>
<body>

<section class="container-fluid">

    <form:form method="post" modelAttribute="editUser" class="form-horizontal">

        <fieldset>

            <legend>Edit user</legend>

            <div class="form-group row">
                <label class="col-form-label col-sm-1" for="idFormInput">ID</label>
                <div class="col-sm-2">
                    <form:input path="id" id="idFormInput" type="text" class="form-control" readonly="true"/>
                </div>
            </div>

            <div class="form-group row">
                <label class="col-form-label col-sm-1" for="loginFormInput">Login</label>
                <div class="col-sm-2">
                    <form:input path="login" id="loginFormInput" type="text" class="form-control"/>
                </div>
            </div>

            <div class="form-group row">
                <label class="col-form-label col-sm-1" for="passwordFormInput">Password</label>
                <div class="col-sm-2">
                    <form:input path="password" id="passwordFormInput" type="text" class="form-control"/>
                </div>
            </div>

            <div class="form-group row">
                <label class="col-form-label col-sm-1" for="roleFormInput">Role</label>
                <div class="col-sm-2">
                    <form:input path="role" id="roleFormInput" type="text" class="form-control"/>
                </div>
            </div>

            <div class="form-group row">
                <label class="col-form-label col-sm-1" for="firstNameFormInput">First name</label>
                <div class="col-sm-2">
                    <form:input path="firstName" id="firstNameFormInput" type="text" class="form-control"/>
                </div>
            </div>

            <div class="form-group row">
                <label class="col-form-label col-sm-1" for="lastNameFormInput">Last name</label>
                <div class="col-sm-2">
                    <form:input path="lastName" id="lastNameFormInput" type="text" class="form-control"/>
                </div>
            </div>

            <div class="form-group row">
                <label class="col-form-label col-sm-1" for="emailFormInput">E-Mail</label>
                <div class="col-sm-2">
                    <form:input path="email" id="emailFormInput" type="text" class="form-control"/>
                </div>
            </div>

            <div class="form-group row">
                <div class="col-sm-2">
                    <input type="submit" id="btnSave" class="btn btn-success" value="Save">
                </div>
            </div>

        </fieldset>

    </form:form>

</section>

<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js"
        integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh"
        crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js"
        integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ"
        crossorigin="anonymous"></script>
</body>
</html>
