package bacit.web.Web;

import bacit.web.DAOs.FileDAO;
import bacit.web.DAOs.ToolDAO;
import bacit.web.Models.FileModel;
import bacit.web.Models.ToolFileModel;
import bacit.web.Models.ToolModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet (name = "admin/Tools", value = "/admin/Tools")
public class GetToolsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ToolDAO tDao = new ToolDAO();

        List<ToolFileModel> toolFiles = new ArrayList<>();

        try {
            toolFiles = createToolFileList(tDao.getAllTools());
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        request.setAttribute("toolFiles", toolFiles);
        request.getRequestDispatcher("/adminTools.jsp").forward(request, response);

    }

    public List<ToolFileModel> createToolFileList (List<ToolModel> tools) throws SQLException, ClassNotFoundException {

        List<ToolFileModel> toolFiles = new ArrayList<>();

        for(ToolModel tool : tools){

            int toolID = tool.getToolID();
            FileDAO fDao = new FileDAO();

            FileModel file;
            ToolFileModel model = new ToolFileModel();

            file = fDao.getFileForTool(toolID);

            model.setToolID(tool.getToolID());
            model.setToolName(tool.getToolName());
            model.setToolInfo(tool.getToolInfo());
            model.setPrice(tool.getPrice());
            model.setActive(tool.isActive());

            model.setFileID(file.getFileID());
            model.setName(file.getName());
            model.setContents(file.getContents());
            model.setContentType(file.getContentType());

            toolFiles.add(model);

        }

        return toolFiles;
    }
}













