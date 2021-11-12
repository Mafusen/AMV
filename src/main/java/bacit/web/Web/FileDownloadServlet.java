package bacit.web.Web;

import javax.servlet.ServletOutputStream;
import bacit.web.DAOs.FileDAO;
import bacit.web.Models.FileModel;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

@WebServlet(name = "fileDownloadServlet", value = "/fileDownloadServlet")
public class FileDownloadServlet extends HttpServlet {

    Logger logger = Logger.getLogger(String.valueOf(FileUploadServlet.class));

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String stringId = getQueryStringParameter(request,"FILE_ID");
        int id = Integer.parseInt(stringId);
        try{
            FileModel fileModel =  getFile(id);
            writeFileResult(response,fileModel);
        }
        catch(Exception ex)
        {
            logger.severe(ex.getMessage());
        }
    }

    protected FileModel getFile(int id) throws Exception
    {
        return new FileDAO().getFile(id);
    }

    protected String getQueryStringParameter(HttpServletRequest request, String parameter)
    {
        return request.getParameter("FILE_ID");
    }

    protected void writeFileResult(HttpServletResponse response, FileModel model) throws IOException
    {
        response.setContentType(model.getContentType());
        response.setHeader("Content-Disposition", "attachment; filename="+model.getName());
        ServletOutputStream outStream = response.getOutputStream();
        outStream.write(model.getContents());
    }
}
