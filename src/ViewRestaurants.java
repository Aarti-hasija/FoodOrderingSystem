import javax.swing.*;
import java.sql.*;

public class ViewRestaurants {

    public ViewRestaurants() {

        JFrame frame = new JFrame("Restaurants");
        frame.setSize(300,300);

        DefaultListModel<String> model = new DefaultListModel<>();
        JList<String> list = new JList<>(model);

        try {
            Connection con = DBConnection.getConnection();

            String q = "SELECT * FROM Restaurants";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(q);

            while(rs.next()) {
                model.addElement(
                    rs.getString("name") + " - " +
                    rs.getString("location")
                );
            }

        } catch(Exception e) {
            e.printStackTrace();
        }

        list.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                String selected = list.getSelectedValue();

                if(selected != null) {
                    String restaurantName = selected.split(" - ")[0];
                    new ViewMenu(restaurantName);
                }
            }
        });

        frame.add(new JScrollPane(list));
        frame.setVisible(true);
    }
}
