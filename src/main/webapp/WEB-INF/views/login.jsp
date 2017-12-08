<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Login</title>
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

<section>

    <div class="container">
        <c:url var="loginUrl" value="/login" />
        <form:form class="form-horizontal" action="${loginUrl}" method="post">

            <c:if test="${param.error != null}">
                <div class="alert alert-danger">
                    <p>Invalid login or password</p>
                </div>
            </c:if>

            <c:if test="${param.logout != null}">
                <div class="alert alert-success">
                    <p>You have been logged out</p>
                </div>
            </c:if>

            <c:if test="${param.accessDenied != null}">
                <div class="alert alert-danger">
                    <p>Access denied: not authorized</p>
                </div>
            </c:if>

            <div class="form-group row">
                <label for="userLogin" class="col-sm-1 col-form-label">Login</label>
                <div class="col-sm-4">
                    <input type="text" class="form-control is-required" name="login" id="userLogin"
                           required>
                </div>
            </div>

            <div class="form-group row">
                <label for="userPassword" class="col-sm-1 col-form-label">Password</label>
                <div class="col-sm-4">
                    <input type="password" class="form-control" name="password" id="userPassword">
                </div>
            </div>

            <input type="hidden" name="${_csrf.parameterName}"   value="${_csrf.token}" />
            <div class="form-group row">
                <div class="col-sm-4">
                    <button class="btn btn-primary" type="submit">Login</button>
                </div>
            </div>

        </form:form>

    </div>

</section>

</body>
</html>
