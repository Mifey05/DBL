package dbl;
import java.awt.*;
import javax.swing.*;

public class Sidebar extends JPanel{
    public Sidebar(CharCard cardpan){
        String[] items = {"Ultra", "Legends Limited", "Zenkai", "Sparking", "Extreme", "Hero", "Soul Boost", "Arts Boost", "Equipments"};
        setBackground(Color.DARK_GRAY);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        for (String item : items){
            add(Box.createVerticalStrut(10));
            JButton itton = sidebarItem(item);
            itton.addActionListener(e -> cardpan.updateCards(item));
            add(itton);
        }
    }
    private JButton sidebarItem(String text){
        JButton item = new JButton(text);
        item.setFont(new Font("Arial", Font.BOLD, 16));
        item.setForeground(Color.WHITE);
        item.setBackground(Color.GRAY);
        item.setAlignmentX(Component.CENTER_ALIGNMENT);
        item.setMaximumSize(new Dimension(250, 45));
        item.setPreferredSize(new Dimension(250, 45));
        item.setFocusable(false);
        return item;
        }
}