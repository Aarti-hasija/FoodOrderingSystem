import java.sql.*;

public class FetchData {
    public static void main(String[] args) {

        try {
            Connection con = DBConnection.getConnection();

            String query = "SELECT * FROM Customers";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                System.out.println(
                    rs.getInt("customer_id") + " " +
                    rs.getString("name") + " " +
                    rs.getString("email")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}