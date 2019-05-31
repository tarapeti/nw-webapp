<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <title>Task1</title>
</head>
<body>
    <h1>Task1.</h1>
    <form action="task1" method="GET">
        Company name:<input type="text" name="companyName"><br>
        <input type="submit" value="Search">
    </form>
    <table>
        <thead>
        <tr>
            <th>Product</th>
            <th>Company</th>
        </tr>
        </thead>
        <tbody>
            <c:forEach var="record" items="${task1list}">
                <tr>
                    <td>${record.product}</td>
                    <td>${record.company}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
