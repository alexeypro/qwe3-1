<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.qwe3.jdoexample.model.Contact" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%
List<Contact> contacts = new ArrayList<Contact>(1); 
if (request.getAttribute("contacts") != null) 
    contacts = (ArrayList<Contact>) request.getAttribute("contacts");
%>
<html>
    <body>
        <a href="/addcontact">Add contact</a> <br/><br/>
        <% if (contacts.isEmpty()) { %>
            No records found
        <% } else { %>
        <table>
        <thead>
        <th>&nbsp;</th>
        <th>id</th>
        <th>first name</th>
        <th>last name</th>
        <th>email</th>
        </thead>
        <% for (Contact c : contacts) { %>
        <tr>
        <td>
            <form style="display:inline;" method="post" action="/delcontact?id=<%= c.getId() %>">
            <input type="submit" value="delete">
            </form>
            <a href="/updatecontact?id=<%= c.getId() %>">update</a>
        </td>
        <td><%= c.getId() %></td>
        <td><%= c.getFirstName() %></td>
        <td><%= c.getLastName() %></td>
        <td><%= c.getEmail() %></td>
        </tr>
        <% } %>
        </table>
        <% } %>
    </body>
</html>
