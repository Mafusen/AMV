package bacit.web.amv_DAO;

import bacit.web.amv_models.FileModel;
import bacit.web.amv_web.DBUtils;

import javax.sql.rowset.serial.SerialBlob;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class FileDAO {

    PrintWriter out = null;

    public void persistFile(FileModel file) throws Exception{
        Connection db = DBUtils.getINSTANCE().getConnection(out);
        String query3 = "insert into FILE (File_Name, File_Content, ContentType) values(?,?,?)";

        PreparedStatement statement = db.prepareStatement(query3);
        statement.setString(1, file.getName());
        statement.setBlob(2,  new SerialBlob(file.getContents()));
        statement.setString(3, file.getContentType());
        statement.executeUpdate();
        db.close();
    }

    public FileModel getFile(int id) throws  Exception
    {
        Connection db = DBUtils.getINSTANCE().getConnection(out);
        String query3 = "select File_Name, File_Content, ContentType from FILE where FILE_ID = ?";
        PreparedStatement statement = db.prepareStatement(query3);
        statement.setInt(1, id);
        ResultSet rs =  statement.executeQuery();
        FileModel model = null;
        if (rs.next()) {
            model = new FileModel(
                    rs.getString("File_Name"),
                    rs.getBytes("File_Content"),
                    rs.getString("ContentType")
            );
        }
        db.close();
        return model;

    }
}
