<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>

<head>

    <title>AMV - Nytt verktøy</title>

    <style>
        * {
            box-sizing: border-box;
        }

        input[type=text], select, textarea {
            width: 100%;
            padding: 12px;
            border: 1px solid #ccc;
            border-radius: 4px;
            resize: vertical;
        }

        label {
            padding: 12px 12px 12px 0;
            display: inline-block;
        }

        input[type=submit] {
            background-color: #4e6bff;
            color: white;
            padding: 12px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            float: right;
        }

        input[type=submit]:hover {
            background-color: #405ffc;
        }

        input[type=reset] {
            background-color: #4e6bff;
            color: white;
            padding: 12px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            float: right;
        }

        input[type=reset]:hover {
            background-color: #405ffc;
        }

        form {width:500px; margin: auto; display: flex;
            justify-content: center; align-content: center;}
        h2 {font-family: "Helvetica"; padding:10px; text-align: center;}
        tr {font-family: "Helvetica"}
        td {font-family: "Helvetica"}
        textarea {font-family: "Helvetica"}
        /*fieldset {border-radius: 10px; padding: 20px;}*/

        .fs {width: 450px; border-radius: 10px; background-color: #cccc00; padding: 20px}
        .center {padding: 10% 0;}

    </style>

</head>
<body>
<div class="center">
<form action="NewToolServlet" method="multipart/form-data">
    <div class="fs">
        <h2> Legg til nytt verktøy</h2>
        <hr>
        <table>
            <tr>
                <td>Vektøynavn:</td>
                <td><input type="text" name="toolName" placeholder="Navnet på verktøyet..." required> </td>
            </tr>
            <tr>
                <td>Verktøyinfo:</td>
                <td><textarea name="toolInfo"  style="height:80px" required placeholder="Info om verktøyet..."></textarea></td>
            </tr>
            <tr>
                <td>Pris:</td>
                <td><input type="text" name="toolPrice" placeholder="Prisen på verktøyet fra dag 2..." required> </td>
            </tr>
            <tr>
                <td>Bilde:</td>
                <td><input type="file" name="Picture" placeholder="Last opp bilde..." size="20" /></td>
            </tr>
            <td><input type="reset" value="Tilbakestill felter"/></td>
            <td><input type="submit" value="Registrer"/></td>
            </tr>
        </table>
    </div>
</form>
</div>
</body>
</html>