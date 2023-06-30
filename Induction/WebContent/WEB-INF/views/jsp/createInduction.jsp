<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="models.HrmsEmploymentOffer" %>
<%@ page import="models.OfferDiffModel" %>

<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Create Induction</title>
    <style>
        body {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }

        .container {
            width: 400px;
            padding: 20px;
            background-color: #f4f4f4;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        h1 {
            text-align: center;
            margin-top: 0;
        }

        label, input, select {
            display: block;
            margin-bottom: 10px;
        }

        input[type="submit"] {
            width: 100%;
            padding: 10px;
            background-color: #4CAF50;
            color: white;
            border: none;
            cursor: pointer;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Create Induction</h1>
        
            <%
                // Create a SimpleDateFormat object with the desired date format
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

                // Get the current date
                Date currentDate = new Date();

                // Format the current date as a string
                String IndcDate = dateFormat.format(currentDate);
                
                int IndcProcessedAusrId = 123;
            %>
		<h2>Induction Date: <%= IndcDate %></h2>
		<h3>Induction Date: <%= IndcProcessedAusrId %></h3>
      
        <form action="inductionsave" method="post">
<input type="hidden" id="IndcDate" name=IndcDate value="<%= IndcDate %>">
<input type="hidden" id="IndcProcessedAusrId" name="IndcProcessedAusrId" value="<%= IndcProcessedAusrId %>">
  <label for="IndcEmofId">Employee Offers:</label>
<select id="IndcEmofId" name="IndcEmofId" multiple required size="8" style="width: 400px;">
    <% List<OfferDiffModel> offerDiffList = (List<OfferDiffModel>) request.getAttribute("diffmodel"); %>
    <% if (offerDiffList != null && !offerDiffList.isEmpty()) { %>
        <% for (OfferDiffModel offerDiff : offerDiffList) { %>
            <option value="<%= offerDiff.getOfferId() %>" data-status="<%= offerDiff.getStatus() %>" >
                <%= offerDiff.getOfferId() %> ( Status :  <%= offerDiff.getStatus()%>)
            </option>
        <% } %>
    <% } %>
</select>
            <input type="submit" value="Save">
        </form>
    </div>
   
</body>
</html>