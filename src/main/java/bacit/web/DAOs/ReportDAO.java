package bacit.web.DAOs;

import bacit.web.Models.ReportModel;
import bacit.web.Utilities.DBUtils;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReportDAO {

    PrintWriter out;

    public List<ReportModel> reportData(String fDate, String eDate){


        Connection db;
        List<ReportModel> report = new ArrayList<>();

        try {
            db = DBUtils.getINSTANCE().getConnection(out);
            String query =
                    "SELECT BOOKING.Booking_ID, TOOL.Tool_Name, USER.Fname, USER.Lname, BOOKING.StartDate, " +
                            "BOOKING.EndDate, BOOKING.Cmnt, BOOKING.TotalPrice FROM BOOKING inner JOIN USER ON " +
                            "BOOKING.USER_ID=USER.USER_ID JOIN TOOL ON BOOKING.TOOL_ID=TOOL.TOOL_ID where StartDate = ? and EndDate = ?";

            PreparedStatement statement = db.prepareStatement(query);
            statement.setString(1, fDate);
            statement.setString(2, eDate);
            ResultSet rs = statement.executeQuery();

            while (rs.next()){
                ReportModel model = new ReportModel(
                        rs.getInt("BOOKING_ID"),
                        rs.getDate("StartDate"),
                        rs.getDate("EndDate"),
                        rs.getString("Cmnt"),
                        rs.getInt("TotalPrice"),
                        rs.getString("Tool_Name"),
                        rs.getString("Fname"),
                        rs.getString("Lname")
                );
                report.add(model);
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return report;

    }

}