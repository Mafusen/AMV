package bacit.web.Web.admin_servlets;

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

@WebServlet (name = "admin/Tools", value = "/admin/Tools")
public class GetToolsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String search = request.getParameter("search");
        if (search == null){
            search = "empty";
        }

        LinkedHashMap<ToolModel, FileModel> products = getProducts(search);

        request.setAttribute("products", products);
        request.getRequestDispatcher("/adminTools.jsp").forward(request, response);

    }

    public LinkedHashMap<ToolModel, FileModel> getProducts (String search){

        ToolDAO tDao = new ToolDAO();

        return tDao.getProducts(search);
    }

}













