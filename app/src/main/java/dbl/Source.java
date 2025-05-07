package dbl;

import java.awt.*;
import javax.swing.*;

public class Source extends JFrame{
    public String shouldRun(){
        return "it should run, yeah";
    }
}
class Navbar extends JPanel{
    public Navbar(){
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
        JButton closeBtn = navItem("X", Color.RED);
        closeBtn.addActionListener(e -> System.exit(0));
        navBuNel.add(closeBtn);
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
        return item;
    }
}


class Sidebar extends JPanel{
    public Sidebar(){
        String[] items = {"Ultra", "Legends Limited", "Zenkai", "Sparking", "Extreme", "Hero"};
        setBackground(Color.DARK_GRAY);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        for (String item : items){
            add(Box.createVerticalStrut(10));
            add(sidebarItem(item));
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
        return item;
        }
}
class CharCard extends JPanel{
    public CharCard(){
        setBackground(Color.GRAY);
        String[] names = {"Super Janemba - DBL64-01U", "Golden Frieza - DBL69-03U", "Super Saiyan God SS Vegito - DBL61-01U", "Legendary Super Saiyan Broly - DBL51-03U", "Super Vegito - DBL49-01U", "Ultra Instinct -Sign- Goku - DBL66-04U", "Beast Gohan - DBL78-05U", "Buu: Kid - DBL58-03U", "Super Saiyan 4 Gogeta - DBL73-01U", "Majin Vegeta - DBL76-04U", "Hit - DBL55-03U", "Turles - DBL75-06U", "Super Saiyan God SS Kaioken Goku - DBL45-01U", "Super Saiyan Rosé Goku Black - DBL57-01U", "Super Saiyan God SS Gogeta - DBL54-05U", "Super Gogeta - DBL42-01U", "Super Saiyan 2 Gohan (Youth) - DBL68-03U", "Perfect Cell - DBL81-01U", "Vegeta - DBL-EVT-24U", "Super Saiyan Goku - DBL-EVT-17U", "Omega Shenron - DBL-EVT-38U"};
        setLayout(new GridLayout(0, 4, 5, 5));
        for (int i = 1; i < names.length+1; i++) {
            add(card(names[i-1], i));
        }
    }
    private JPanel card(String text, int ref){
        JPanel card = new JPanel();
        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
        JLabel img = new JLabel(new ImageIcon("app\\src\\main\\resources\\"+ref+".png"));   
        JLabel name = new JLabel(text);
        img.setAlignmentX(Component.CENTER_ALIGNMENT);
        name.setAlignmentX(Component.CENTER_ALIGNMENT);
        card.add(img);
        card.add(name);
        setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        return card;
    }
}
