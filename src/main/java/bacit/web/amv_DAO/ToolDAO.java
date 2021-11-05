package bacit.web.amv_DAO;

import bacit.web.amv_models.BookingModel;
import bacit.web.amv_models.ToolModel;
import bacit.web.amv_utilities.DBUtils;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ToolDAO {

    PrintWriter out;

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

    public List<ToolModel> getTools(){

        List<ToolModel> tools = new ArrayList<>();

        try {
            Connection db = DBUtils.getINSTANCE().getConnection(out);

            String query = "select * from TOOL";
            PreparedStatement statement = db.prepareStatement(query);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                ToolModel model = new ToolModel();
                model.setToolID(rs.getInt("TOOL_ID"));
                model.setToolName(rs.getString("Tool_Name"));
                model.setPrice(rs.getInt("Tool_Info"));
                model.setPrice(rs.getInt("Price"));
                model.setActive(rs.getBoolean("Picture"));
                model.setToolID(rs.getInt("IsActive"));
                tools.add(model);
            }

        }
        catch(SQLException | ClassNotFoundException exception){
            exception.printStackTrace();
        }

        return tools;

    }



}
