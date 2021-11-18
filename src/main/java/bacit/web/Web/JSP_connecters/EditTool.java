package bacit.web.Web.JSP_connecters;

import bacit.web.DAOs.FileDAO;
import bacit.web.DAOs.ToolDAO;
import bacit.web.Models.FileModel;
import bacit.web.Models.ToolModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "admin/redigerVerktoy", value = "/admin/redigerVerktoy")
public class EditTool extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String IDString = request.getParameter("toolID");
        int toolID = Integer.parseInt(IDString);

        ToolDAO tDao = new ToolDAO();
        ToolModel tool = new ToolModel();
        try {
            tool = tDao.getTool(toolID);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        FileDAO fDao = new FileDAO();
        FileModel file = new FileModel();
        try {
            file = fDao.getFileForTool(toolID);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        request.setAttribute("tool", tool);
        request.setAttribute("file", file);
        request.getRequestDispatcher("/editTool.jsp").forward(request, response);
    }
}
