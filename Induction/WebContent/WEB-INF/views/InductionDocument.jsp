<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Employment Induction Documents</title>
</head>
<body>
    <h1>Employment Induction Documents</h1>
    
    <table>
        <thead>
            <tr>
                <th>Document Index</th>
                <th>Employee ID</th>
                <th>Employment Offer</th>
                <th>Document Type</th>
                <th>Document Data</th>
                <th>Processed User</th>
                <th>Verified</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${documents}" var="document">
                <tr>
                    <td>${document.documentIndex}</td>
                    <td>${document.emplid}</td>
                    <td>${document.employmentOffer}</td>
                    <td>${document.documentType}</td>
                    <td>${document.documentData}</td>
                    <td>${document.processedUser}</td>
                    <td>${document.verified}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    
    <h2>Add Document</h2>
    <form action="/documents/add" method="post" enctype="multipart/form-data">
        <label for="emplid">Employee ID:</label>
        <input type="text" id="emplid" name="emplid" required><br>
        
        <label for="employmentOffer">Employment Offer:</label>
        <input type="text" id="employmentOffer" name="employmentOffer" required><br>
        
        <label for="documentType">Document Type:</label>
        <input type="text" id="documentType" name="documentType" required><br>
        
        <label for="documentData">Document Data:</label>
        <input type="file" id="documentData" name="documentData" required><br>
        
        <label for="processedUser">Processed User:</label>
        <input type="text" id="processedUser" name="processedUser" required><br>
        
        <label for="verified">Verified:</label>
        <input type="text" id="verified" name="verified" required><br>
        
        <button type="submit">Add Document</button>
    </form>
</body>
</html>
