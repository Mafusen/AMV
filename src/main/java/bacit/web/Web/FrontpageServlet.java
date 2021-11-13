package bacit.web.Web;

import bacit.web.DAOs.ToolDAO;
import bacit.web.Models.FileModel;
import bacit.web.Models.ToolModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;

@WebServlet (name = "frontpageServlet", value = "/frontpageServlet")
public class FrontpageServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        LinkedHashMap<ToolModel, FileModel> products = getProducts();

        request.setAttribute("products", products);
        request.getRequestDispatcher("frontpage.jsp").forward(request, response);

    }

    public LinkedHashMap<ToolModel, FileModel> getProducts () {

        ToolDAO tDao = new ToolDAO();

        return tDao.getProducts();
    }


}
