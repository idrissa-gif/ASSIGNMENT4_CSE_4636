<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Find Student</title>
    <!-- Include Bootstrap CSS -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<ul class="nav nav-tabs mt-3">
    <li class="nav-item">
        <a class="nav-link" href="add-student.jsp">Add Student</a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="find-student.jsp">Find Student</a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="highest-cgpa.jsp">Highest CGPA</a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="update-student.jsp">Update Student</a>
    </li>
</ul>
<div class="container mt-5">
    <h1>Find Student</h1>
    <form action="http://localhost:8080/CSE4636_ASSIGNMENT4-1.0-SNAPSHOT/api/Stateless/" method="get">
        <div class="form-group">
            <label for="studentId">Student ID:</label>
            <input type="text" id="studentId" name="studentId" class="form-control" required>
        </div>
        <button type="submit" class="btn btn-primary">Find Student</button>
    </form>
    <hr>
<%--    &lt;%&ndash; Display student details if available &ndash;%&gt;--%>
<%--    <h3>Student Details:</h3>--%>
<%--    <p>Student ID: <%= studentId %></p>--%>
<%--    <p>Name: <%= name %></p>--%>
<%--    <p>Semester: <%= semester %></p>--%>
<%--    <p>CGPA: <%= cgpa %></p>--%>
</div>
</body>
</html>
