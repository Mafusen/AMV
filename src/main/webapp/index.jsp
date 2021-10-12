<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!doctype html>

<style>
    form {width:100px; margin: auto}
    h2 {font-family: "Helvetica" ; padding:10px; text-align: center}
    tr {font-family: "Helvetica"}
    fieldset {border-radius: 25px; padding: 20px}
</style>

<title>AMV - Nytt Verktøy</title>

<body>
<form action="AddToolServlet" method="post">
    <fieldset style="width:20%; background-color:#cccc00">
        <h2> Legg til nytt verktøy</h2><hr>
        <table>
            <tr>
                <td>Vektøynavn:</td>
                <td><input type="text" name="toolName" required /></td>
            </tr>
            <tr>
                <td>Verktøyinfo:</td>
                <td><input type="text" name="toolInfo" required /></td>
            </tr>
            <tr>
                <td>Pris:</td>
                <td><input type="text" name="toolPrice" required /></td>
            </tr>
            <td><input type="reset" value="Tilbakestill felter"/></td>
            <td><input type="submit" value="Registrer"/></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>