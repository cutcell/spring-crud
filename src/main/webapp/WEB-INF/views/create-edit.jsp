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

<section class="container">

    <form:form method="post" modelAttribute="user" class="form-horizontal">

        <legend>Edit</legend>

        <form:input path="id" type="hidden"/>

        <div class="form-group row">
            <label class="col-form-label col-sm-2">Login</label>
            <div class="col-sm-3">
                <form:input path="login" type="text" class="form-control"/>
            </div>
        </div>

        <div class="form-group row">
            <label class="col-form-label col-sm-2">Password</label>
            <div class="col-sm-3">
                <form:input path="password" type="text" class="form-control"/>
            </div>
        </div>

        <div class="form-group row">
            <label class="col-form-label col-sm-2">First name</label>
            <div class="col-sm-3">
                <form:input path="firstName" type="text" class="form-control"/>
            </div>
        </div>

        <div class="form-group row">
            <label class="col-form-label col-sm-2">Last name</label>
            <div class="col-sm-3">
                <form:input path="lastName" type="text" class="form-control"/>
            </div>
        </div>

        <div class="form-group row">
            <label class="col-form-label col-sm-2">E-Mail</label>
            <div class="col-sm-3">
                <form:input path="email" type="text" class="form-control"/>
            </div>
        </div>

        <div class="form-group row">
            <div class="col-sm-2">
                <input type="submit" id="btnSave" class="btn btn-success" value="Save">
            </div>
        </div>


    </form:form>

</section>

</body>
</html>
