package bacit.web.Web.admin_servlets;

import bacit.web.DAOs.ReportDAO;
import bacit.web.Models.ReportModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet (name = "admin/report", value = "/admin/report")
public class ReportServlet extends HttpServlet {

    PrintWriter out;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ReportDAO rDao = new ReportDAO();

        List<ReportModel> report = rDao.reportData();

        request.setAttribute("report", report);
        request.getRequestDispatcher("/adminReports.jsp").forward(request, response);

    }

}
