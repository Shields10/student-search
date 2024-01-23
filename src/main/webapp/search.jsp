<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<!DOCTYPE html>
<html>
<head>
    <title>Student Search</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            margin: 20px;
        }

        h1 {
            color: #333;
        }

        form {
            margin-bottom: 20px;
        }

        label {
            display: block;
            margin-bottom: 5px;
        }

        input[type="text"] {
            padding: 5px;
            width: 200px;
        }

        button {
            padding: 8px;
            background-color: #4CAF50;
            color: white;
            border: none;
            cursor: pointer;
        }

        table {
            border-collapse: collapse;
            width: 100%;
            margin-top: 20px;
        }

        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
        }

        th {
            background-color: #4CAF50;
            color: white;
        }

        tr:nth-child(even) {
            background-color: #f2f2f2;
        }

        p {
            margin-top: 20px;
        }
    </style>
</head>
<body>
    <h1>Student Search</h1>
    <form action="StudentSearchServlet" method="get">
        <label for="searchQuery">Search:</label>
        <input type="text" id="searchQuery" name="searchQuery" required>
        <button type="submit">Search</button>
    </form>

    <c:if test="${not empty searchResults}">
        <h2>Search Results:</h2>
        <table border="1">
            <tr>
                <th>Name</th>
                <th>Student ID</th>
                <th>Phone Number</th>
                <th>Current Class</th>
                <th>Action</th>
            </tr>
            <c:forEach var="student" items="${searchResults}">
                <tr>
                    <td>${student.name}</td>
                    <td>${student.studentId}</td>
                    <td>${student.phoneNumber}</td>
                    <td>${student.currentClass}</td>
                    <td>
                        <form action="ViewResultServlet" method="post">
                            <input type="hidden" name="studentId" value="${student.studentId}">
                            <button type="submit">View Result</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </c:if>

    <c:if test="${not empty result}">
        <h2>Result:</h2>
        <p>${result}</p>
    </c:if>
</body>
</html>
