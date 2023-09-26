<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Create User</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/toastr@2.1.4/build/toastr.min.js"></script>
    <link href="https://cdn.jsdelivr.net/npm/toastr@2.1.4/build/toastr.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <div class="card container px-6" style="height: 100vh">
        <h3 class="text-center">Create User</h3>
        <c:if test="${message != null}">
            <h6 class="d-none" id="message">${message}</h6>
        </c:if>
        <form action=/user?action=update&id=${user.id} method="post">
            <div class="mb-3">
                <button type="submit" class="btn btn-success">SUBMIT</button>
            </div>
            <div class="mb-3">
                <label for="lastName" class="form-label">Last Name</label>
                <input type="text" class="form-control" id="lastName" placeholder="Enter your Last Name"  name="lastName" value="${user.lastName}">
            </div>
            <div class="mb-3">
                <label for="firstName" class="form-label">First Name</label>
                <input type="text" class="form-control" placeholder="Enter your First Name" id="firstName" name="firstName" value="${user.firstName}">
            </div>
            <div class="mb-3">
                <label for="userName" class="form-label">User Name</label>
                <input type="text" class="form-control" placeholder="Enter your User Name" id="userName" name="userName" value="${user.userName}">
            </div>
            <div class="mb-3">
                <label for="email" class="form-label">Email</label>
                <input type="email" class="form-control" id="email" placeholder="Enter your Email" aria-describedby="emailHelp" name="email" value="${user.email}">
            </div>
            <div class="mb-3">
                <label for="dob" class="form-label">Date of Birth</label>
                <input type="date" class="form-control" id="dob"  name="dob" value="${user.doB}">
            </div>
            <div class="mb-3" style="display: none">
                <label for="password" class="form-label">Password</label>
                <input type="text" class="form-control" id="password"  name="password">
            </div>
            <div class="mb-3">
                <label for="gender" class="form-label">Select Gender</label>
                <select class="form-select" aria-label="Default select example" id="gender" name="gender" >
                    <c:forEach var="gender" items="${genders}">
                        <option value="${gender}" >  ${gender}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="mb-3">
                <label for="role" class="form-label">Select Role</label>
                <select class="form-select" aria-label="Default select example" id="role" name="role">
                    <c:forEach var="role" items="${roles}">
                        <option value="${role.id}">${role.roleName}</option>
                    </c:forEach>
                </select>
            </div>
        </form>
    </div>

</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
<script>
    const message = document.getElementById('message');
    if (message !== null && message.innerHTML) {
        toastr.success(message.innerHTML);
    }
</script>
</body>
</html>
