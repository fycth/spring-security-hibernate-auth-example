<%--
 Created with IntelliJ IDEA.
 User: Andrey Sergienko <andrey.sergienko@gmail.com>
 Date: 9/19/12
 Time: 11:46 AM
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <link rel="stylesheet" href="/resources/css/main.css" />
    <script src="/resources/js/jquery.formalize.js"></script>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title></title>
</head>
<body>

<div id="wrapper-login">

    <h1>Register New Person</h1>

    <form:form modelAttribute="personAttribute" method="POST" action="/register_new">
        <table class="horiz">
            <tr>
                <td><form:label path="login">Login:</form:label></td>
                <td><form:input path="login"/></td>
            </tr>

            <tr>
                <td><form:label path="passwd">Passwd:</form:label></td>
                <td><form:input path="passwd"/></td>
            </tr>

            <tr>
                <td><form:label path="role">Mode:</form:label></td>
                <td>
                    <form:select path="role">
                        <form:options items="${roles}" />;
                    </form:select>
                </td>
            </tr>

        </table>

        <input type="submit" value="Save" />
    </form:form>

</div>

</body>
</html>
