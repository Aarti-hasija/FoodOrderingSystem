import java.sql.*;

public class InsertData {
    public static void main(String[] args) {

        try {
            Connection con = DBConnection.getConnection();

            String query = "INSERT INTO Customers (name, email, phone, address) VALUES (?, ?, ?, ?)";

            PreparedStatement pst = con.prepareStatement(query);

            pst.setString(1, "John");
            pst.setString(2, "john@gmail.com");
            pst.setString(3, "03451234567");
            pst.setString(4, "Lahore");

            pst.executeUpdate();

            System.out.println("Data Inserted Successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
