<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<title> Customer Form </title>
<style>
.error{
    color:red;
 }
</style>
</head>
<body>
<form:form modelAttribute="customer" action="processForm">

    First Name: <form:input path="firstName" />
    <form:errors path="firstName" cssClass="error"/>

    <br><br>
    Last Name (*): <form:input path="lastName" />
    <form:errors path="lastName" cssClass="error"/>

    <br><br>
    Free Passes (*): <form:input path="freePasses" />
    <form:errors path="freePasses" cssClass="error"/>

    <br><br>
    Postal Code (*): <form:input path="postalCode" />
    <form:errors path="postalCode" cssClass="error"/>

    <br><br>
    <input type="submit" value="Submit" />
</form:form>
</body>
</html>
