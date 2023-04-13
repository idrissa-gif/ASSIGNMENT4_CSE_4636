<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>View Student</title>
    <!-- Include Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-5">
    <h1 class="mb-4">View Student</h1>
    <div class="form-group">
        <label for="studentId">Student ID:</label>
        <input type="text" class="form-control" id="studentId" name="studentId" value="<%= request.getParameter("studentId") %>">
    </div>
    <div class="form-group">
        <label for="name">Name:</label>
        <input type="text" class="form-control" id="name" name="name" value="<%= request.getParameter("name") %>">
    </div>
    <div class="form-group">
        <label for="semester">Semester:</label>
        <input type="text" class="form-control" id="semester" name="semester" value="<%= request.getParameter("semester") %>">
    </div>
    <div class="form-group">
        <label for="cgpa">CGPA:</label>
        <input type="text" class="form-control" id="cgpa" name="cgpa" value="<%= request.getParameter("cgpa") %>">
    </div>
    <a href="/students" class="btn btn-primary">Back</a>
</div>
<!-- Include Bootstrap JS and jQuery -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
