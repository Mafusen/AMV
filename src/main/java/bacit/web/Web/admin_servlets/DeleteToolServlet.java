package bacit.web.Web.admin_servlets;

import bacit.web.DAOs.FileDAO;
import bacit.web.DAOs.ToolDAO;
import bacit.web.Models.FileModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet (name = "admin/slett", value = "/admin/slett")
public class DeleteToolServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String IDString = request.getParameter("toolID");
        int toolID = Integer.parseInt(IDString);

        ToolDAO tDao = new ToolDAO();
        try {
            tDao.deleteTool(toolID);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        FileDAO fDao = new FileDAO();
        FileModel file = new FileModel();

        try {
            file = fDao.getFileForTool(toolID);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            fDao.deleteFile(file.getFileID());
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        response.sendRedirect(request.getContextPath() + "/admin/Tools");

    }
}
