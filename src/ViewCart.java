import javax.swing.*;
import java.awt.*;

public class ViewCart {

    public ViewCart() {

        JFrame frame = new JFrame("Cart");
        frame.setSize(300,300);

        // 👇 layout set (IMPORTANT)
        frame.setLayout(new BorderLayout());

        JTextArea area = new JTextArea();

        double total = 0;

        // 👇 items + total calculate
        for(String item : Cart.items) {
            area.append(item + "\n");

            // price extract karna
            String price = item.split("Rs.")[1];
            total += Double.parseDouble(price);
        }

        // 👇 total show
        area.append("\nTotal: Rs." + total);

        // 👇 scroll area center me
        frame.add(new JScrollPane(area), BorderLayout.CENTER);

        // 👇 place order button
        JButton orderBtn = new JButton("Place Order");

        orderBtn.addActionListener(e -> {
            JOptionPane.showMessageDialog(frame, "Order Placed!");
            Cart.items.clear(); // cart empty
            frame.dispose();    // window close
        });

        // 👇 button neeche
        frame.add(orderBtn, BorderLayout.SOUTH);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}