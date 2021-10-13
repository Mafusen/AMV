package bacit.web.bacit_web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "AddToolServlet", value = "/AddToolServlet")
public class AddToolServlet extends HttpServlet {

        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
                response.setContentType("html/text");
                PrintWriter out = response.getWriter();

                out.println("<html>");
                out.println("<head>");
                out.println("<title>Registrer nytt verktøy</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h2>Registrer nytt verktøy</h2>");
                out.println("<form method='post'>");
                out.println("  <label for='toolName'>Verktøynavn:</label>");
                out.println("  <input type='text' name='toolName'/>");

                out.println("  <label for='toolInfo'>Verktøyinfo:</label>");
                out.println("  <input type='text' name='toolInfo'/>");

                out.println("  <label for='toolInfo'>Verktøypris:</label>");
                out.println("  <input type='number' name='toolPrice'/>");

                out.println("  <label for='toolPicture'>Bilde:</label>");
                out.println("  <input type='file' name='toolPicture'/>");

                out.println("   <input type='reset' value='Tilbakestill felter'/>");
                out.println("   <input type='submit' value='Registrer'/>");
                out.println("</form>");
                out.println("</body>");
                out.println("</html>");
        }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String toolname = request.getParameter("toolName");
        String toolinfo = request.getParameter("toolName");
        int toolprice = Integer.parseInt(request.getParameter("toolPrice"));

        ToolModel model = null;
        try {
            model = createTool(toolname, toolinfo, toolprice, out);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        out.println("   Verktøy registrert: ");
        out.println("   Verktøynavn: " + toolname);
        out.println("   Verktøyinfo: " + toolinfo);
        out.println("   Pris: " + toolprice);


    }


    private ToolModel createTool(String Tool_Name, String Tool_Info, int Price, PrintWriter out) throws SQLException{

        Connection db = null;
        try {
            db = DBUtils.getINSTANCE().getConnection(out);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String query = "insert into TOOL (Tool_Name, Tool_Info, Price) values (?, ?, ?)";
        PreparedStatement statement = db.prepareStatement(query);
        statement.setString(1, Tool_Name);
        statement.setString(2, Tool_Info);
        statement.setInt(3, Price);

        ResultSet rs = statement.executeQuery();
        ToolModel model = null;
        while (rs.next()) {
            model =
                    new ToolModel(rs.getString("Tool_Name"), rs.getString("Tool_Info"),
                            rs.getInt("Price"));
        }
        return model;


    }
}

