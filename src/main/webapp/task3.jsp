<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <title>Task3</title>
</head>
<body>
    <h1>Task3</h1>
    <form action="task3" method="GET">
        Company name:<input type="text" name="companyName"><br>
        <input type="submit" value="Search">
    </form>
    <table>
        <thead>
        <tr>
            <th>Company</th>
        </tr>
        </thead>
        <tbody>
            <c:forEach var="record" items="${task3list}">
                <tr>
                    <td>${record.compName}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
