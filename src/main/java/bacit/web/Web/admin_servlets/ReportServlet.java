package bacit.web.Web;

import bacit.web.DAOs.BookingDAO;
import bacit.web.DAOs.ReportDAO;
import bacit.web.DAOs.UserDAO;
import bacit.web.Models.BookingModel;
import bacit.web.Models.ReportModel;
import bacit.web.Models.ToolModel;
import bacit.web.Models.UserModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;


@WebServlet(name = "/admin/getReport", value = "/admin/getReport")
public class ReportServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getRemoteUser();
        String fDate = request.getParameter("fDate");
        String eDate = request.getParameter("eDate");
        ReportDAO rDao = new ReportDAO();

        List<ReportModel> report = makeReport(fDate, eDate);

        request.setAttribute("report", report);
        request.getRequestDispatcher("/adminReports.jsp").forward(request, response);
    }

    public List<ReportModel> makeReport(String fDate, String eDate) {

        ReportDAO rDao = new ReportDAO();

        return rDao.reportData(fDate, eDate);
    }
}


/*
package bacit.web.Web.admin_servlets;

import bacit.web.DAOs.BookingDAO;
import bacit.web.DAOs.ReportDAO;
import bacit.web.DAOs.UserDAO;
import bacit.web.Models.BookingModel;
import bacit.web.Models.ReportModel;
import bacit.web.Models.ToolModel;
import bacit.web.Models.UserModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
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
*/

