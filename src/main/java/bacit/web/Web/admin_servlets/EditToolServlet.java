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
import java.sql.SQLException;

@WebServlet (name = "admin/endreVerktoy", value = "/admin/endreVerktoy")
@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5 * 5)
public class EditToolServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String IDString = request.getParameter("toolID");
        int toolID = Integer.parseInt(IDString);

        String toolName = request.getParameter("name");
        String toolInfo = request.getParameter("info");
        String priceString = request.getParameter("price");
        Part filePart = null;
        if(request.getPart("file")!=null) {
            filePart = request.getPart("file");
        }

        int price = Integer.parseInt(priceString);

        ToolDAO tDao = new ToolDAO();
        ToolModel tool = new ToolModel();
        try {
            tool = tDao.getTool(toolID);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        tool.setToolName(toolName);
        tool.setToolInfo(toolInfo);
        tool.setPrice(price);

        tDao.editTool(tool);

        FileDAO fDao = new FileDAO();
        FileModel oldFile = new FileModel();
        try {
            oldFile = fDao.getFileForTool(toolID);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        assert filePart != null;
        if(filePart.getSize() != 0) {
            String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
            InputStream fileContent = filePart.getInputStream();
            byte[] fileBytes = fileContent.readAllBytes();

            if (oldFile.getContents() != fileBytes) {
                try {
                    fDao.deleteFile(oldFile.getFileID());
                } catch (SQLException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
                FileModel newFile = new FileModel();
                newFile.setName(fileName);
                newFile.setContents(fileBytes);
                newFile.setContentType(filePart.getContentType());
                newFile.setToolID(toolID);
                try {
                    fDao.persistFile(newFile);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        response.sendRedirect(request.getContextPath() + "/admin/Tools");

    }
}
