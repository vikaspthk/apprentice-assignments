<%@page import="javax.servlet.RequestDispatcher"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>DefaultView</title>
    </head>
    <body>
        <%
     RequestDispatcher rd = request.getRequestDispatcher("/TreeView");
     rd.forward(request, response);
%>
    </body>
</html>
