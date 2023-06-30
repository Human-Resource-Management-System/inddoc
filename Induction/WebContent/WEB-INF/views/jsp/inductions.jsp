<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Induction List</title>
    <style>
        h1 {
            color: #333;
            margin-bottom: 30px;
            text-align: center;
        }

        table {
            width: 20%;
            border-collapse: collapse;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            background-color: #fff;
            margin: 0 auto;
        }

        th, td {
            text-align: center;
            border-bottom: 1px solid #ddd;
            padding: 10px;
        }

        th {
            background-color: #f2f2f2;
            font-weight: bold;
            color: #333;
            text-transform: uppercase;
        }

        .no-inductions {
            margin-top: 20px;
            color: #888;
            text-align: center;
        }

        .table-container {
            overflow-x: auto;
        }

        .table-container::-webkit-scrollbar {
            height: 5px;
            background-color: #f4f4f4;
        }

        .table-container::-webkit-scrollbar-thumb {
            background-color: #888;
            border-radius: 4px;
        }

        .table-container::-webkit-scrollbar-track {
            background-color: #f4f4f4;
        }

        /* Custom styles */
        .view-link {
            color: #007bff;
            text-decoration: none;
        }

        .view-link:hover {
            text-decoration: underline;
        }

        .center {
            text-align: center;
            margin-top: 10px;
        }
    </style>
</head>
<body>
    <h1>Induction List</h1>
  
    <% List<Integer> inductions = (List<Integer>) request.getAttribute("inductions"); %>
    
    <% if (inductions != null && !inductions.isEmpty()) { %>
        <table>
            <thead>
                <tr>
                    <th>Induction ID</th>
                </tr>
            </thead>
            <tbody>
                <% for (Integer induction : inductions) { %>
                    <tr>
                       <td>Induction :  <a class="view-link" href="getinductiondetails?id=<%= induction %>"><%= induction  %></a></td>
                    </tr>
                <% } %>
            </tbody>
        </table>
    <% } else { %>
        <p class="no-inductions">No inductions found.</p>
    <% } %>
</body>
</html>
