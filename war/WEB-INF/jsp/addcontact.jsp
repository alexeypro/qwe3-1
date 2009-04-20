<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <body>        
        <form method="post" action="/addcontact">
        <label for="contact_firstname">First name:</label> <input type="text" name="contact_firstname"> <br/>
        <label for="contact_lastname">Last name:</label> <input type="text" name="contact_lastname"> <br/>
        <label for="contact_email">Email:</label> <input type="text" name="contact_email"> <br/>
        <br/>
        <input type="submit" value="add"> or <a href="/listcontacts">Cancel</a>
        </form>
    </body>
</html>
