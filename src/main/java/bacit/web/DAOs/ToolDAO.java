package bacit.web.DAOs;

import bacit.web.Models.FileModel;
import bacit.web.Models.ToolModel;
import bacit.web.Utilities.DBUtils;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class ToolDAO {

    PrintWriter out;

    public LinkedHashMap<ToolModel, FileModel> getProducts(String search){

        LinkedHashMap<ToolModel, FileModel> products = new LinkedHashMap<>();

        try{
            Connection db = DBUtils.getINSTANCE().getConnection(out);

            String query = "SELECT TOOL.TOOL_ID, TOOL.Tool_Name, TOOL.Tool_Info, TOOL.Price, TOOL.IsActive, FILE.FILE_ID, " +
                    "FILE.File_Name, FILE.File_Content, FILE.ContentType FROM FILE inner JOIN TOOL " +
                    "ON FILE.TOOL_ID=TOOL.TOOL_ID where isActive = 1 order by Tool_Name;";
            PreparedStatement statement = db.prepareStatement(query);
            ResultSet rs = statement.executeQuery();

            while(rs.next()){

                ToolModel tool = new ToolModel();
                tool.setToolID(rs.getInt("TOOL_ID"));
                tool.setToolName(rs.getString("Tool_Name"));
                tool.setToolInfo(rs.getString("Tool_Info"));
                tool.setPrice(rs.getInt("Price"));
                tool.setActive(rs.getBoolean("isActive"));

                FileModel file = new FileModel();
                file.setFileID(rs.getInt("FILE_ID"));
                if(tool.getToolName().toLowerCase().contains(search.toLowerCase()) || search.equals("empty")) {
                    products.put(tool, file);
                }

            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return products;

    }


    public LinkedHashMap<ToolModel, FileModel> getProduct(int toolID){

        LinkedHashMap<ToolModel, FileModel> product = new LinkedHashMap<>();

        try{
            Connection db = DBUtils.getINSTANCE().getConnection(out);

            String query = "SELECT TOOL.Tool_Name, TOOL.Tool_Info, TOOL.Price, TOOL.IsActive, FILE.FILE_ID, " +
                    "FILE.File_Name, FILE.File_Content, FILE.ContentType FROM TOOL inner JOIN FILE ON TOOL.TOOL_ID = ? " +
                    "and FILE.TOOL_ID = ? ";
            PreparedStatement statement = db.prepareStatement(query);
            statement.setInt(1, toolID);
            statement.setInt(2, toolID);
            ResultSet rs = statement.executeQuery();

            while(rs.next()){

                ToolModel tool = new ToolModel();
                tool.setToolID(rs.getInt("TOOL_ID"));
                tool.setToolName(rs.getString("Tool_Name"));
                tool.setToolInfo(rs.getString("Tool_Info"));
                tool.setPrice(rs.getInt("Price"));
                tool.setActive(rs.getBoolean("isActive"));

                FileModel file = new FileModel();
                file.setFileID(rs.getInt("FILE_ID"));

                product.put(tool, file);
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return product;

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

    public void editTool(ToolModel tool){

        try{

            // Get connection to database
            Connection db = DBUtils.getINSTANCE().getConnection(out);

            // Write  update query
            String query = "update TOOL set Tool_Name = ?, Tool_Info = ?, Price = ? where TOOL_ID = ?";

            // Set parameters with PreparedStatement
            PreparedStatement statement = db.prepareStatement(query);
            statement.setString(1, tool.getToolName());
            statement.setString(2, tool.getToolInfo());
            statement.setInt(3, tool.getPrice());
            statement.setInt(4, tool.getToolID());

            // Execute the statement
            statement.executeQuery();

        }catch (SQLException | ClassNotFoundException exception){
            exception.printStackTrace();
        }

    }

    public void deleteTool(int toolID) throws SQLException, ClassNotFoundException {

        Connection db = DBUtils.getINSTANCE().getConnection(out);

        String query = "update TOOL set IsActive = 0 where TOOL_ID = ?;";
        PreparedStatement statement = db.prepareStatement(query);
        statement.setInt(1, toolID);
        statement.executeQuery();

    }

}
