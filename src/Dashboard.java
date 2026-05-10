import javax.swing.*;
import java.awt.*;

public class Dashboard {

    public Dashboard() {

        JFrame frame = new JFrame("Dashboard");
        frame.setSize(300,200);
        frame.setLayout(new GridLayout(3,1));

        JButton btn1 = new JButton("View Restaurants");
        JButton btn2 = new JButton("View Cart");
        JButton btn3 = new JButton("Exit");

        frame.add(btn1);
        frame.add(btn2);
        frame.add(btn3);

        btn1.addActionListener(e -> new ViewRestaurants());
        btn2.addActionListener(e -> new ViewCart());
        btn3.addActionListener(e -> frame.dispose());

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
