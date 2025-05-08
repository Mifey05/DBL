package dbl;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class Source extends JFrame{
    public String shouldRun(){
        return "it should run, yeah";
    }
}
class Navbar extends JPanel{
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
        return item;
    }
}


class Sidebar extends JPanel{
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
        return item;
        }
}
class CharCard extends JPanel{
    private String currentTag = "Ultra";
    private int columns = 4;
    public CharCard(){
        setBackground(Color.GRAY);
        setLayout(new GridLayout(0, columns, 5, 5));
        updateCards(currentTag);
    }
    private JPanel card(String text, int ref){
        JPanel card = new JPanel();
        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
        card.setPreferredSize(new Dimension(240, 320));
        JLabel img = new JLabel(new ImageIcon(tagImg(currentTag)+ref+".png"));   
        JLabel name = new JLabel(text);
        img.setAlignmentX(Component.CENTER_ALIGNMENT);
        name.setAlignmentX(Component.CENTER_ALIGNMENT);
        card.add(img);
        card.add(name);
        card.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        return card;
    }
    public void updateCards(String tag){
        currentTag = tag;
        refreshCards();
    }
    private void refreshCards(){
        removeAll();
        String[] names = tagList(currentTag);
        for (int i = 0; i < names.length; i++) {
            add(card(names[i], i));
        }
        revalidate();
        repaint();
    }
    private String[] tagList(String tag){
        return switch(tag){
            case "Ultra" -> new String[] {"Super Janemba - DBL64-01U", "Golden Frieza - DBL69-03U", "Super Saiyan God SS Vegito - DBL61-01U", "Legendary Super Saiyan Broly - DBL51-03U", "Super Vegito - DBL49-01U", "Ultra Instinct -Sign- Goku - DBL66-04U", "Beast Gohan - DBL78-05U", "Buu: Kid - DBL58-03U", "Super Saiyan 4 Gogeta - DBL73-01U", "Majin Vegeta - DBL76-04U", "Hit - DBL55-03U", "Turles - DBL75-06U", "Super Saiyan God SS Kaioken Goku - DBL45-01U", "Super Saiyan Rosé Goku Black - DBL57-01U", "Super Saiyan God SS Gogeta - DBL54-05U", "Super Gogeta - DBL42-01U", "Super Saiyan 2 Gohan (Youth) - DBL68-03U", "Perfect Cell - DBL81-01U", "Vegeta - DBL-EVT-24U", "Super Saiyan Goku - DBL-EVT-17U", "Omega Shenron - DBL-EVT-38U"};
            case "Legends Limited" -> new String[] {"Super Saiyan 3 Gotenks - DBL76-02S", "Ultimate Gohan - DBL72-02S", "Android #17 - DBL55-01S", "Beast Gohan - DBL52-01S", "Perfect Form Cell - DBL61-03S", "Goku - DBL75-01S", "Super Vegeta - DBL68-01S", "Super Saiyan God Goku - DBL72-01S", "Super #17 - DBL67-05S", "Omega Shenron - DBL73-02S", "Ultra Instinct Goku - DBL47-01S", "Fusion Zamasu - DBL79-04S", "Super Saiyan God SS Gogeta - DBL30-01S", "Super Baby 2 - DBL69-01S", "Super Saiyan Trunks (Teen) - DBL50-01S", "Super Saiyan Trunks (Adult) - DBL41-02S", "Super Saiyan 4 Goku - DBL81-04S", "Super Saiyan 3 Vegeta - DBL81-02S", "Super Saiyan 3 Goku - DBL48-01S", "Perfect Cell - DBL40-02S", "Super Saiyan Broly: Full Power - DBL30-03S", "Super Saiyan 4 Gogeta - DBL35-01S", "Bardock - DBL43-01S", "Buu: Kid - DBL32-02S", "Half-Corrupted Fusion Zamasu - DBL35-08S", "Super Saiyan 4 Goku - DBL34-01S", "Vegeta - DBL39-01S", "Super Saiyan God SS Vegeta - DBL18-05S", "1st Form Frieza - DBL22-05S"};
            case "Zenkai" -> new String[] {"God of Destruction Toppo - DBL38-03S", "Kaioken Goku - DBL43-04S", "Super Saiyan Broly - DBL32-05S", "Launch - DBL31-05S", "Fusion Zamasu - DBL24-08S", "Super Full Power Saiyan 4 Goku - DBL24-03S", "Omega Shenron - DBL24-09S", "Jiren - DBL29-06S", "Android #21: Good - DBL31-02S", "Trunks: Mai (Assist) - DBL33-01S", "Super Saiyan God SS Vegeta - DBL25-05S", "Super Saiyan 3 Goku - DBL37-03S", "Wasteland Bandit Yamcha - DBL31-03S", "Super Saiyan 2 Kefla - DBL23-05S", "Broly: Cheelai (Assist) - DBL22-09S", "Goku - DBL16-01S", "Super Saiyan Trunks (Teen) - DBL23-01S", "Super Gogeta - DBL20-01S", "Bardock - DBL19-01S", "Great Saiyaman 1 & 2 (Assist) - DBL27-05S", "Final Form Cooler - DBL08-10S", "Majin Vegeta - DBL06-12S", "Chi-Chi - DBL09-06S"};
            case "Sparking" -> new String[] {"Tamagami Number Three - DBL78-04S", "Majin Kuu - DBL81-03S", "Majin Duu - DBL81-05S", "Goku (Mini) - DBL77-01S", "Glorio - DBL77-02S", "Goku (Mini) - DBL76-01S", "Cacao - DBL75-04S", "Daiz - DBL75-02S", "Amond - DBL75-03S", "Rasin: Lakasei (Assist) - DBL75-05S", "Majin Buu: Pure Evil - DBL72-04S", "Pui Pui - DBL-EVT-64S", "East Supreme Kai Shin - DBL71-03S", "Tien - DBL49-02S", "Majin Buu (Good): Hercule (Assist) - DBL76-03S", "God of Destruction Beerus - DBL72-03S", "Mecha Frieza - DBL50-02S", "Bulla: Vegeta (Assist) - DBL67-04S", "Gohan - DBL60-01S", "Gotenks - DBL65-03S", "Trunks (Parasitism) Baby - DBL69-02S", "Videl - DBL74-02S", "Kyawei - DBL59-05S", "Pan - DBL52-02S", "Bergamo - DBL28-01S", "Zamasu: Goku Black (Assist) - DBL41-04S", "Kakarot Goku - DBL-EVT-14S"};
            case "Extreme" -> new String[] {"Android #18 - DBL55-02E", "Majuub - DBL53-02E", "Jiren - DBL38-02E", "Omega Shenron - DBL53-04E", "Super Saiyan Gohan (Teen) - DBL74-01E", "Super Saiyan God SS Vegeta - DBL54-02E", "Thouser - DBL51-02E", "Trunks - DBL67-03E", "Metal Cooler - DBL64-03E", "Bardock - DBL66-02E", "Super Saiyan 2 Gohan (Youth) - DBL40-01E", "Super Saiyan God SS Goku - DBL54-01E", "Cell Jr. - DBL61-04E", "God of Destruction Champa - DBL59-02E", "Final Form Frieza - DBL41-05E"};
            case "Hero" -> new String[] {"Videl - DBL24-07H", "Mercenary Tao - DBL24-12H", "Nail - DBL16-04H", "Thouser - DBL08-12H", "Turles - DBL06-08H", "Krillin - DBL06-04H", "Super Saiyan Goku - DBL06-02H", "2nd Form Cell - DBL04-03H", "World Champion Hercule - DBL24-11H", "Nappa - DBL01-20H", "1st Form Cell - DBL03-09H", "Goku - DBL03-02H", "Raditz - DBL01-22H", "Recoome - DBL01-27H", "Vegeta - DBL01-18H"};
            default -> new String[] {};
        };
    }
    private String tagImg(String tag){
        return switch(tag){
            case "Ultra" -> "app\\src\\main\\resources\\ult\\";
            case "Legends Limited" -> "app\\src\\main\\resources\\lf\\";
            case "Zenkai" -> "app\\src\\main\\resources\\zen\\";
            case "Sparking" -> "app\\src\\main\\resources\\sp\\";
            case "Extreme" -> "app\\src\\main\\resources\\ex\\";
            case "Hero" -> "app\\src\\main\\resources\\he\\";
            default -> "";
        };
    }
    public void updateLayout(int width) {
        // Calculate how many columns we can fit (each card is ~250px wide with margins)
        int newColumns = Math.max(1, width / 250);
        
        if (newColumns != columns) {
            columns = newColumns;
            removeAll();
            setLayout(new GridLayout(0, columns, 5, 5));
            refreshCards();
        }
    }
}

class ComponentResizer extends MouseAdapter {
    private static final int BORDER = 5;
    private final Component target;
    private final JFrame frame;
    private Point startPos;
    private Rectangle startBounds;
    private int direction;
    private boolean isResizing = false;
    private Cursor defaultCursor;

    // Constants for directions with proper visibility
    protected static final int NORTH = 1;
    protected static final int SOUTH = 2;
    protected static final int WEST = 4;
    protected static final int EAST = 8;

    public ComponentResizer(Component target, JFrame frame) {
        this.target = target;
        this.frame = frame;
        this.defaultCursor = target.getCursor();
        target.addMouseListener(this);
        target.addMouseMotionListener(this);
    }

    protected int getResizeDirection(Point p) {  // Changed to protected
        int width = target.getWidth();
        int height = target.getHeight();
        
        int direction = 0;
        if (p.x <= BORDER) direction |= WEST;
        if (p.x >= width - BORDER) direction |= EAST;
        if (p.y <= BORDER) direction |= NORTH;
        if (p.y >= height - BORDER) direction |= SOUTH;
        
        return direction;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        startPos = e.getLocationOnScreen();
        startBounds = frame.getBounds();
        direction = getResizeDirection(e.getPoint());
        isResizing = direction != 0;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        isResizing = false;
        resetCursor();
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (!isResizing) {
            resetCursor();
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if (!isResizing) return;
        
        Point current = e.getLocationOnScreen();
        int dx = current.x - startPos.x;
        int dy = current.y - startPos.y;
        
        int x = startBounds.x;
        int y = startBounds.y;
        int width = startBounds.width;
        int height = startBounds.height;

        if ((direction & WEST) == WEST) {
            x += dx;
            width -= dx;
        }
        if ((direction & EAST) == EAST) {
            width += dx;
        }
        if ((direction & NORTH) == NORTH) {
            y += dy;
            height -= dy;
        }
        if ((direction & SOUTH) == SOUTH) {
            height += dy;
        }

        // Ensure minimum size
        Dimension minSize = frame.getMinimumSize();
        if (width < minSize.width) {
            if (x != startBounds.x) x = startBounds.x + startBounds.width - minSize.width;
            width = minSize.width;
        }
        if (height < minSize.height) {
            if (y != startBounds.y) y = startBounds.y + startBounds.height - minSize.height;
            height = minSize.height;
        }
        frame.setBounds(x, y, width, height);
        frame.validate();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        if (isResizing) return;
        
        int dir = getResizeDirection(e.getPoint());
        
        if (dir == 0) {
            resetCursor();
            return;
        }
        
        switch (dir) {
            case NORTH:
            case SOUTH:
                target.setCursor(Cursor.getPredefinedCursor(Cursor.S_RESIZE_CURSOR));
                break;
            case EAST:
            case WEST:
                target.setCursor(Cursor.getPredefinedCursor(Cursor.E_RESIZE_CURSOR));
                break;
            case NORTH | EAST:
                target.setCursor(Cursor.getPredefinedCursor(Cursor.NE_RESIZE_CURSOR));
                break;
            case NORTH | WEST:
                target.setCursor(Cursor.getPredefinedCursor(Cursor.NW_RESIZE_CURSOR));
                break;
            case SOUTH | EAST:
                target.setCursor(Cursor.getPredefinedCursor(Cursor.SE_RESIZE_CURSOR));
                break;
            case SOUTH | WEST:
                target.setCursor(Cursor.getPredefinedCursor(Cursor.SW_RESIZE_CURSOR));
                break;
        }
    }

    private void resetCursor() {
        target.setCursor(defaultCursor);
    }
}