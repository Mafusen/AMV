package bacit.web.Web.admin_servlets;

import bacit.web.DAOs.FileDAO;
import bacit.web.DAOs.ToolDAO;
import bacit.web.Models.FileModel;
import bacit.web.Models.ToolModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;

@WebServlet(name = "admin/registerTool", value = "/admin/registerTool")
@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5 * 5)
public class RegisterToolServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {

            String toolName = request.getParameter("name");
            String toolInfo = request.getParameter("info");
            int price = Integer.parseInt(request.getParameter("price"));

            ToolModel tool = new ToolModel();
            tool.setToolName(toolName);
            tool.setToolInfo(toolInfo);
            tool.setPrice(price);
            tool.setActive(true);

            ToolDAO tDao = new ToolDAO();
            tDao.newTool(tool);

            ToolModel newTool = tDao.getLastTool();

            Part filePart = request.getPart("file");
            String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
            InputStream fileContent = filePart.getInputStream();
            byte[] fileBytes = fileContent.readAllBytes();

            FileModel file = new FileModel();

            file.setName(fileName);
            file.setContents(fileBytes);
            file.setContentType(filePart.getContentType());
            file.setToolID(newTool.getToolID());

            FileDAO fDao = new FileDAO();
            fDao.persistFile(file);

        } catch (Exception e) {
            e.printStackTrace();
        }

        response.sendRedirect(request.getContextPath() + "/admin/Tools");
    }

}
