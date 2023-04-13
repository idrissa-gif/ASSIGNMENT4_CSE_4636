<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> <!-- Add this import statement -->

<!DOCTYPE html>
<html>
<head>
    <title>Student List</title>
    <!-- Add Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        /* Add custom CSS for highlighting rows on hover */
        .table tbody tr:hover {
            background-color: #f8f9fa;
            cursor: pointer;
        }
    </style>
</head>
<body>
<div class="container mt-5">
    <h1>Welcome to Student List</h1>
    <p>This is a list of students in the system.</p>
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
    <table class="table mt-3">
        <thead class="thead-dark">
        <tr>
            <th scope="col">ID</th>
            <th scope="col">Name</th>
            <th scope="col">Semester</th>
            <th scope="col">CGPA</th>
        </tr>
        </thead>
        <tbody>
        <%-- Loop through the list of students and display each student as a row in the table --%>
        <c:forEach var="student" items="${studentList}">
            <tr>
                <td>${student.studentId}</td>
                <td>${student.name}</td>
                <td>${student.semester}</td>
                <td>${student.cgpa}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
