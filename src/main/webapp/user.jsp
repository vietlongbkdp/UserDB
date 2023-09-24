<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>Title</title>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
  <script src="https://cdn.jsdelivr.net/npm/toastr@2.1.4/build/toastr.min.js"></script>
  <link href="https://cdn.jsdelivr.net/npm/toastr@2.1.4/build/toastr.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
  <div class="card container px-6" style="height: 100vh">
    <h3 class="text-center">Management User</h3>
    <c:if test="${message != null}">
      <h6 class="d-none" id="message">${message}</h6>
    </c:if>
    <div>
      <a href="/user?action=create" class="btn btn-primary mb-2">Create</a>
      <a href="/user?action=restore" class="btn btn-info mb-2">Restore</a>
    </div>
    <table class="table table-striped">
      <tr>
        <td>
          Id
        </td>
        <td>
          Last Name
        </td>
        <td>
          First Name
        </td>
        <td>
          User Name
        </td>
        <td>
          Email
        </td>
        <td>
          Date of Birth
        </td>
        <td>
          Role
        </td>
        <td>
          Gender
        </td>
<%--        <td>--%>
<%--          Deleted--%>
<%--        </td>--%>
        <td>
          Action
        </td>
      </tr>
      <c:forEach var="user" items="${users}">
        <tr>
          <td>
              ${user.id}
          </td>
          <td>
              ${user.lastName}
          </td>
          <td>
              ${user.firstName}
          </td>
          <td>
              ${user.userName}
          </td>
          <td>
              ${user.email}
          </td>
          <td>
              ${user.doB}
          </td>
          <td>
              ${user.role.roleName}
          </td>
          <td>
              ${user.gender}
          </td>
<%--          <td>--%>
<%--              ${user.deleted}--%>
<%--          </td>--%>
          <td>
            <a class="btn btn-warning" href="/user?action=edit&id=${user.id}">EDIT</a>
            <a class="btn btn-danger" onclick="return confirm('Do you want remove ${user.firstName} ?')" href="/user?action=delete&id=${user.id}">DELETE</a>
          </td>
        </tr>
      </c:forEach>
    </table>
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