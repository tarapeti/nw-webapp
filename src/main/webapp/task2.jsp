<%@ page contentType="text/html; charset=UTF-8" %>
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
                    <td>${record.company}</td>
                    <td>${record.prodnum}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
