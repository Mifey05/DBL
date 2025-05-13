package dbl;

import java.awt.*;
import javax.swing.*;

public class Navbar extends JPanel{
    private final JFrame parent;
    public Navbar(JFrame parent){
        this.parent = parent;
        JLabel title = new JLabel(" Dragon Ball Legends");
        title.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 25));
        title.setForeground(Color.WHITE);
        setLayout(new BorderLayout());
        add(title, BorderLayout.WEST);
        setMaximumSize(new Dimension(1080, 60));
        setPreferredSize(new Dimension(1080, 60));
        setBackground(Color.black);

        JPanel navBuNel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 10));
        navBuNel.setOpaque(false);
        JButton xBtn = navItem("X", Color.RED);
        xBtn.addActionListener(e -> System.exit(0));
        navBuNel.add(xBtn);
        JButton maxBtn = navItem("⬜", Color.RED);
        maxBtn.addActionListener(e -> {
            int state = parent.getExtendedState();
            if ((state & JFrame.MAXIMIZED_BOTH) == JFrame.MAXIMIZED_BOTH) {
                parent.setExtendedState(JFrame.NORMAL);
            } else {
                parent.setExtendedState(JFrame.MAXIMIZED_BOTH);
            }
        });
        navBuNel.add(maxBtn);
        navBuNel.add(navItem("Join Discord", Color.BLUE));
        navBuNel.add(navItem("Buy us a Ko-Fi", Color.RED));
        add(navBuNel, BorderLayout.EAST);
    }
    private JButton navItem(String text, Color color){
        JButton item = new JButton(text);
        item.setFont(new Font("Arial", Font.PLAIN, 16));
        item.setForeground(Color.WHITE);
        item.setBackground(color);
        item.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));
        item.setFocusable(false);
        return item;
    }
}