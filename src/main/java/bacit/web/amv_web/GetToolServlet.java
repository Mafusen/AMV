package bacit.web.amv_web;

import bacit.web.amv_DAO.ToolDAO;
import bacit.web.amv_models.ToolModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "getToolServlet", value = "/getToolServlet")
public class GetToolServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ToolDAO dao = new ToolDAO();
        ToolModel model = new ToolModel();

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
