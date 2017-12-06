<%@ page pageEncoding="UTF-8" session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Users</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css"
          integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb"
          crossorigin="anonymous">
    <script src="https://use.fontawesome.com/00550c2ed3.js"></script>
</head>
<body>

<section>
    <div class="container-fluid">
        <h3>Users</h3>
    </div>
</section>

<section>
    <div class="container-fluid">

        <table class="table table-sm table-striped">
            <thead class="thead-light">
            <tr>
                <th scope="col">ID</th>
                <th scope="col">Login</th>
                <th scope="col">Role</th>
                <th scope="col">First name</th>
                <th scope="col">Last name</th>
                <th scope="col">E-Mail</th>
                <th scope="col">Actions</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${usersList}" var="user">
                <tr>
                    <td>${user.id}</td>
                    <td>${user.login}</td>
                    <td>${user.role}</td>
                    <td>${user.firstName}</td>
                    <td>${user.lastName}</td>
                    <td>${user.email}</td>
                    <td>
                        <a
                                href="<spring:url value="/adm/edit?id=${user.id}"/>"
                                class="btn btn-primary btn-sm">
                            <i class="fa fa-pencil" aria-hidden="true"></i> Edit
                        </a>

                        <a
                                href="<spring:url value="/adm/delete?id=${user.id}"/>"
                                class="btn btn-danger btn-sm">
                            <i class="fa fa-times" aria-hidden="true"></i> Delete
                        </a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</section>

<section class="container-fluid">
    <a href="<spring:url value="/adm/create"/>" class="btn btn-primary">Create user</a>
    <a href="<spring:url value="/logout"/>" class="btn btn-success">Logout</a>
</section>

</body>
</html>
