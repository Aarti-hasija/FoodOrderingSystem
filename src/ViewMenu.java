import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class ViewMenu {

    public ViewMenu(String restaurantName) {

        JFrame frame = new JFrame("Menu");
        frame.setSize(300,300);
        frame.setLayout(new BorderLayout());

        DefaultListModel<String> model = new DefaultListModel<>();
        JList<String> list = new JList<>(model);

        try {
            Connection con = DBConnection.getConnection();

            String q = "SELECT * FROM Menu_Items"; // 👈 simple query
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(q);

            while(rs.next()) {
                String item = rs.getString("name") + " - Rs." + rs.getDouble("price");
                System.out.println(item); // 👈 debug
                model.addElement(item);
            }

        } catch(Exception e) {
            e.printStackTrace();
        }

        frame.add(new JScrollPane(list), BorderLayout.CENTER);

        JButton addBtn = new JButton("Add to Cart");

        addBtn.addActionListener(e -> {
            String selected = list.getSelectedValue();

            if(selected != null) {
                Cart.items.add(selected);
                JOptionPane.showMessageDialog(frame, "Added!");
            }
        });

        frame.add(addBtn, BorderLayout.SOUTH);

        frame.setVisible(true);
    }
}