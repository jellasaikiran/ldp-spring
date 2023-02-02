<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<title> Student Form </title>
<style>
.error{
    color:red;
 }
</style>
</head>
<body>
<form:form modelAttribute="student" action="processForm">

    First Name: <form:input path="firstName" />

    <br><br>
    Last Name: <form:input path="lastName" />

    <br><br>
    Country:
    <form:select path="country">
        <form:options items="${student.countryOptions}" />
        <form:option value="US" label="United States" />
    </form:select>

    <br><br>
    Favourite Language:
    Java <form:radiobutton path="favouriteLanguage" value="Java"/>
    C++ <form:radiobutton path="favouriteLanguage" value="C++"/>
    Python <form:radiobutton path="favouriteLanguage" value="Python"/>

    <br><br>
    Operating System:
    Mac <form:checkbox path="operatingOS" value="Mac"/>
    Windows <form:checkbox path="operatingOS" value="Windows"/>
    Linux <form:checkbox path="operatingOS" value="Linux"/>

    <br><br>
    <input type="submit" value="Submit" />
</form:form>
</body>
</html>
