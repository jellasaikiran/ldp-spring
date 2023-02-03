<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Customer Relationship Management</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons+Outlined"
          rel="stylesheet">
  </head>
  <body>
    <div class="container">
        <h2 class="text-center mt-3 mb-5">CRM - Customer Relationship Management</h2>
        <form:form action="saveCustomer" modelAttribute="customer" method="POST">
            <div class="input-group mb-3">
              <span class="input-group-text">
                <span class="material-icons-outlined">
                    badge
                </span>
              </span>
              <div class="form-floating">
                  <form:input path="firstName" type="text" class="form-control" id="floatingInputGroup1" placeholder="First name"/>
                  <label for="floatingInputGroup1">First name</label>
                </div>
                <div class="form-floating">
                    <form:input path="lastName" type="text" class="form-control" id="floatingInputGroup1" placeholder="Last name"/>
                    <label for="floatingInputGroup1">Last name</label>
                  </div>
            </div>
            <div class="input-group mb-3">
              <span class="input-group-text" id="basic-addon1">
                <span class="material-icons-outlined">
                    email
                </span>
              </span>
              <div class="form-floating">
                  <form:input path="email" type="text" class="form-control" id="floatingInputGroup1" placeholder="Email address"/>
                  <label for="floatingInputGroup1">Email address</label>
                </div>
            </div>
            <div class="d-flex justify-content-center">
            <button type="submit" class="btn btn-outline-success my-3 d-flex align-items-center">
                <span class="material-icons-outlined me-2">save</span>Save
            </button>
            </div>
        </form:form>

    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
  </body>
</html>