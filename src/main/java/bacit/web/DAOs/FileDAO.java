package bacit.web.DAOs;

import bacit.web.Models.FileModel;
import bacit.web.Utilities.DBUtils;

import javax.sql.rowset.serial.SerialBlob;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FileDAO {

    PrintWriter out;

    public void persistFile(FileModel file) throws Exception{
        Connection db = DBUtils.getINSTANCE().getConnection(out);
        String query = "insert into FILE (File_Name, File_Content, ContentType, TOOL_ID) values(?,?,?,?)";

        PreparedStatement statement = db.prepareStatement(query);
        statement.setString(1, file.getName());
        statement.setBlob(2,  new SerialBlob(file.getContents()));
        statement.setString(3, file.getContentType());
        statement.setInt(4, file.getToolID());

        statement.executeUpdate();
        db.close();

    }

    public FileModel getFile(int id) throws  Exception
    {
        Connection db = DBUtils.getINSTANCE().getConnection(out);
        String query3 = "select FILE_ID, File_Name, File_Content, ContentType, TOOL_ID from FILE where FILE_ID = ?";
        PreparedStatement statement = db.prepareStatement(query3);
        statement.setInt(1, id);
        ResultSet rs =  statement.executeQuery();
        FileModel model = null;
        if (rs.next()) {
            model = new FileModel(
                    rs.getInt("FILE_ID"),
                    rs.getString("File_Name"),
                    rs.getBytes("File_Content"),
                    rs.getString("ContentType"),
                    rs.getInt("TOOL_ID")
            );
        }
        db.close();
        return model;

    }

    public FileModel getFileForTool(int toolID) throws SQLException, ClassNotFoundException {

        FileModel model = new FileModel();
        Connection db = DBUtils.getINSTANCE().getConnection(out);
        String query = "select * from FILE where TOOL_ID = ?";
        PreparedStatement statement = db.prepareStatement(query);
        statement.setInt(1, toolID);
        ResultSet rs =  statement.executeQuery();

        while (rs.next()) {
             model.setFileID(rs.getInt("FILE_ID"));
             model.setName(rs.getString("File_Name"));
             model.setContents(rs.getBytes("File_Content"));
             model.setContentType(rs.getString("ContentType"));
             model.setToolID(rs.getInt("TOOL_ID"));
        }
        db.close();
        return model;

    }
}
