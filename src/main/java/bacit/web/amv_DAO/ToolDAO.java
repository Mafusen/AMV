package bacit.web.amv_DAO;

import bacit.web.amv_models.BookingModel;
import bacit.web.amv_models.ToolModel;
import bacit.web.amv_utilities.DBUtils;

import javax.sql.rowset.serial.SerialBlob;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ToolDAO {

    PrintWriter out;

    public List<ToolModel> getAllTools() throws SQLException {

        List<ToolModel> tools = new ArrayList<>();

        try {
            Connection db = DBUtils.getINSTANCE().getConnection(out);
            String query = "select * from TOOL";
            PreparedStatement statement = db.prepareStatement(query);
            ResultSet rs = statement.executeQuery();

        while (rs.next()){
            ToolModel model = new ToolModel();
            model.setToolID(rs.getInt("TOOL_ID"));
            model.setToolName(rs.getString("Tool_Name"));
            model.setToolInfo(rs.getString("Tool_Info"));
            model.setPrice(rs.getInt("Price"));
            model.setActive(rs.getBoolean("IsActive"));
            tools.add(model);
        }

        } catch(SQLException | ClassNotFoundException exception){
            exception.printStackTrace();
        }

         return tools;
    }

    public ToolModel getTool(int toolID) throws SQLException {

        Connection db = null;

        try {
            db = DBUtils.getINSTANCE().getConnection(out);
        }
        catch(SQLException | ClassNotFoundException exception){
            exception.printStackTrace();
        }

            String query = "select * from TOOL where TOOL_ID = ?";
            PreparedStatement statement = db.prepareStatement(query);
            statement.setInt(1, toolID);
            ResultSet rs = statement.executeQuery();
            ToolModel model = new ToolModel();

            while (rs.next()) {
                model = new ToolModel(rs.getInt("TOOL_ID"), rs.getString("Tool_Name"),
                        rs.getString("Tool_Info"), rs.getInt("Price"), rs.getBoolean("IsActive"));
            }
            return model;

    }

    public void newTool(ToolModel tool) throws SQLException, ClassNotFoundException {
        Connection db = DBUtils.getINSTANCE().getConnection(out);
        String query = "insert into TOOL (Tool_Name, Tool_Info, Price, IsActive) values(?,?,?,?)";

        PreparedStatement statement = db.prepareStatement(query);
        statement.setString(1, tool.getToolName());
        statement.setString(2, tool.getToolInfo());
        statement.setInt(3, tool.getPrice());
        statement.setBoolean(4, tool.isActive());
        statement.executeUpdate();
        db.close();
    }

    public ToolModel getLastTool() throws SQLException, ClassNotFoundException {

        ToolModel tool = new ToolModel();

        try {

            Connection db = DBUtils.getINSTANCE().getConnection(out);
            String query = "select * from TOOL ORDER BY TOOL_ID DESC LIMIT 1";
            PreparedStatement statement = db.prepareStatement(query);
            ResultSet rs = statement.executeQuery();

            while(rs.next()) {
                tool.setToolID(rs.getInt("TOOL_ID"));
                tool.setToolName(rs.getString("Tool_Name"));
                tool.setToolInfo(rs.getString("Tool_Info"));
                tool.setPrice(rs.getInt("Price"));
                tool.setActive(rs.getBoolean("IsActive"));
            }
        }
        catch(SQLException | ClassNotFoundException exception){
            exception.printStackTrace();
        }

        return tool;
    }



}
