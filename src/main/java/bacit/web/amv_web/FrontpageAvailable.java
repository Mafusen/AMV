package bacit.web.amv_web;

import bacit.web.amv_DAO.FileDAO;
import bacit.web.amv_DAO.ToolDAO;
import bacit.web.amv_models.FileModel;
import bacit.web.amv_models.ToolFileModel;
import bacit.web.amv_models.ToolModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet (name = "FrontpageAvailable", value = "/FrontPageAvailable")
public class FrontpageAvailable extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ToolDAO tDao = new ToolDAO();

        List<ToolFileModel> toolViews = new ArrayList<>();


        try {
            toolViews = createToolFileList(tDao.getAllTools());
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        request.setAttribute("toolViews", toolViews);
        request.getRequestDispatcher("/productPage.jsp").forward(request, response);

    }

    public List<ToolFileModel> createToolFileList (List<ToolModel> tools) throws SQLException, ClassNotFoundException {

        List<ToolFileModel> toolViews = new ArrayList<>();

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

            toolViews.add(model);

        }

        return toolViews;
    }
}
