<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Customer Relationship Management</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons+Outlined"
              rel="stylesheet">
    <style>
        a {
            text-decoration:none;
            color:#555;
        }
    </style>
  </head>
  <body>
    <div class="container">
        <h2 class="text-center mt-3 mb-5">CRM - Customer Relationship Management</h2>
        <button type="button" class="btn btn-outline-success my-3" onclick="window.location.href='showForm'">Add Customer</button>
    <table class="table table-striped table-hover">
      <thead>
        <tr>
          <th scope="col">#</th>
          <th scope="col">First Name</th>
          <th scope="col">Last Name</th>
          <th scope="col">Email</th>
        </tr>
      </thead>
      <tbody>
        <c:forEach var="tempCustomer" varStatus="i" items="${customers}">
            <c:url var="updateLink" value="/customer/showFormForUpdate">
                <c:param name="customerId" value="${tempCustomer.id}" />
            </c:url>
            <c:url var="deleteLink" value="/customer/delete">
                <c:param name="customerId" value="${tempCustomer.id}" />
            </c:url>
            <tr>
              <th scope="row">${i.count}</th>
              <td>${tempCustomer.firstName}</td>
              <td>${tempCustomer.lastName}</td>
              <td>${tempCustomer.email}</td>
              <td><a href="${updateLink}"><span class="material-icons-outlined">edit</span></a></td>
              <td><a href="${deleteLink}" onclick="if(!(confirm('Are you sure you want to delete it'))) return false;"><span class="material-icons-outlined">delete</span></a></td>
            </tr>
        </c:forEach>
       </tbody>
    </table>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
  </body>
</html>