<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <title>Task4</title>
</head>
<body>
    <h1>Task4</h1>
    <form action="task4" method="GET">
        Company name:<input type="text" name="companyName"><br>
        <input type="submit" value="Search">
    </form>
    <table>
        <thead>
        <tr>
            <th>Company</th>
            <th>Order ID</th>
        </tr>
        </thead>
        <tbody>
            <c:forEach var="record" items="${task4list}">
                <tr>
                    <td>${record.companyName}</td>
                    <td>${record.orderId}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
