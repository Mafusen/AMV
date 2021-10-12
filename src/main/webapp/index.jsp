<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<body>
<form action="AddToolServlet" method="post">
    <fieldset style="width:20%; background-color:#ccffeb">
        <h2 align="center">Legg til verktøy</h2><hr>
        <table>
            <tr>
                <td>Vektøynavn:</td>
                <td><input type="text" name="userName" required /></td>
            </tr>
            <tr>
                <td>Verktøy info:</td>
                <td><input type="password" name="userPass" required /></td>
            </tr>
            <tr>
                <td>Pris</td>
                <td><input type="text" name="userEmail" required /></td>
            </tr>
            <td><input type="reset" value="Reset"/></td>
            <td><input type="submit" value="Register"/></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>