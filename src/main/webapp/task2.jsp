<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <title>Task2</title>
</head>
<body>
    <h1>Task2</h1>
    <form action="task2" method="GET">
        Company name:<input type="text" name="companyName"><br>
        <input type="submit" value="Search">
    </form>
    <table>
        <thead>
        <tr>
            <th>Company</th>
            <th>Number of Products</th>
        </tr>
        </thead>
        <tbody>
            <c:forEach var="record" items="${task2list}">
                <tr>
                    <td>${record.companyName}</td>
                    <td>${record.products}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
