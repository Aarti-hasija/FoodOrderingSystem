import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class LoginForm {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Login");
        frame.setSize(300,150);
        frame.setLayout(new GridLayout(3,2));

        JTextField email = new JTextField();
        JTextField phone = new JTextField();

        JButton btn = new JButton("Login");

        frame.add(new JLabel("Email"));
        frame.add(email);
        frame.add(new JLabel("Phone"));
        frame.add(phone);
        frame.add(btn);

        btn.addActionListener(e -> {
            try {
                Connection con = DBConnection.getConnection();

                String q = "SELECT * FROM Customers WHERE email=? AND phone=?";
                PreparedStatement pst = con.prepareStatement(q);

                pst.setString(1, email.getText().trim());
                pst.setString(2, phone.getText().trim());

                ResultSet rs = pst.executeQuery();

                if(rs.next()) {
                    JOptionPane.showMessageDialog(frame, "Login Success");
                    frame.dispose();
                    new Dashboard();
                } else {
                    JOptionPane.showMessageDialog(frame, "Invalid");
                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        frame.setVisible(true);
    }
}
