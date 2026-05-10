import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class SimpleForm {

    public SimpleForm() {

        JFrame frame = new JFrame("Add Customer");
        frame.setSize(300,200);
        frame.setLayout(new GridLayout(5,2));

        JTextField name = new JTextField();
        JTextField email = new JTextField();
        JTextField phone = new JTextField();
        JTextField address = new JTextField();

        JButton btn = new JButton("Add");

        frame.add(new JLabel("Name"));
        frame.add(name);
        frame.add(new JLabel("Email"));
        frame.add(email);
        frame.add(new JLabel("Phone"));
        frame.add(phone);
        frame.add(new JLabel("Address"));
        frame.add(address);
        frame.add(btn);

        btn.addActionListener(e -> {
            try {
                Connection con = DBConnection.getConnection();

                String q = "INSERT INTO Customers (name,email,phone,address) VALUES (?,?,?,?)";
                PreparedStatement pst = con.prepareStatement(q);

                pst.setString(1, name.getText());
                pst.setString(2, email.getText());
                pst.setString(3, phone.getText());
                pst.setString(4, address.getText());

                pst.executeUpdate();

                JOptionPane.showMessageDialog(frame, "Added!");

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        frame.setVisible(true);
    }
}
