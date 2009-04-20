<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.qwe3.jdoexample.model.Contact" %>
<%
Contact c = new Contact("", "", "");
if (request.getAttribute("contact") != null)
    c = (Contact) request.getAttribute("contact");
%>

<html>
    <body>        
        <form method="post" action="/updatecontact?id=<%= c.getId() %>">
        <label for="contact_firstname">First name:</label> <input type="text" name="contact_firstname" value="<%= c.getFirstName() %>"> <br/>
        <label for="contact_lastname">Last name:</label> <input type="text" name="contact_lastname" value="<%= c.getLastName() %>"> <br/>
        <label for="contact_email">Email:</label> <input type="text" name="contact_email" value="<%= c.getEmail() %>"> <br/>
        <br/>
        <input type="submit" value="update"> or <a href="/listcontacts">Cancel</a>
        </form>
    </body>
</html>
