package dbl;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class CharCard extends JPanel{
    private String currentTag = "Ultra";
    private int columns = 4;
    private JFrame parent;
    public CharCard(JFrame parent){
        this.parent = parent;
        setBackground(Color.GRAY);
        setLayout(new GridLayout(0, columns, 5, 5));
        updateCards(currentTag);
    }
    private void clickIngfo(JComponent leClick, String text, String inDesc){
        leClick.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ingfoCard(parent, text, inDesc);
            }
        });
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
        String[] desc = tagDesc(currentTag);
        for (int i = 0; i < names.length; i++) {
            JPanel newCard = card(names[i], i);
            clickIngfo(newCard, names[i], desc[i]);
            add(newCard);
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
            default -> new String[] {"kosonk", "ini", "coek", "bom", "ba", "clat"};
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
    private String[] tagDesc(String tag){
        return switch(tag){
            case "Ultra" -> new String[] {"Super Janemba - DBL64-01U\nSuper Janemba came straight out of the otherworld. It first appeared on the 1995 DBZ movie, Fusion Reborn.\n\nElement: Blue\nType: Melee\nTag: Transforming Warrior, Regeneration, Powerful Opponent, Weapon Wielder, Sagas from the Movies.", "Golden Frieza - DBL69-03U\nGolden Frieza is the next form Frieza obtained after training. He first appeared in a 2015 DBZ movie, Resurrection F.\n\nElement: Purple\nType; Melee\nTag: Frieza Force, Transforming Warrior, Lineage of Evil, Powerful Opponent, Sagas from the Movies.", "Super Saiyan God SS Vegito - DBL61-01U\nVegito is a result of a potara fusion between Goku and Vegeta. Super Saiyan Blue Vegito in particular appeared in DBS, episode 66, back in 2016.\n\nElement: Red\nType: Melee\nTag: Saiyan, Future, Potara, Fusion Warrior, God Ki, Super Saiyan God SS, 'Future' Trunks Saga (S).", "Legendary Super Saiyan Broly - DBL51-03U\nBroly is a terrifying beast with the power to get stronger with anger with limitless potential. Legendary Super Saiyan Broly in particular, appeared in a 1993 DBZ, Broly - The Legendary Super Saiyan\n\nElement: Purple\nType: Melee\nTag: Saiyan, Super Saiyan, Powerful Opponent, Sagas from the Movies.", "Super Vegito - DBL49-01U", "Ultra Instinct -Sign- Goku - DBL66-04U", "Beast Gohan - DBL78-05U", "Buu: Kid - DBL58-03U", "Super Saiyan 4 Gogeta - DBL73-01U", "Majin Vegeta - DBL76-04U", "Hit - DBL55-03U", "Turles - DBL75-06U", "Super Saiyan God SS Kaioken Goku - DBL45-01U", "Super Saiyan Rosé Goku Black - DBL57-01U", "Super Saiyan God SS Gogeta - DBL54-05U", "Super Gogeta - DBL42-01U", "Super Saiyan 2 Gohan (Youth) - DBL68-03U", "Perfect Cell - DBL81-01U", "Vegeta - DBL-EVT-24U", "Super Saiyan Goku - DBL-EVT-17U", "Omega Shenron - DBL-EVT-38U"};
            case "Legends Limited" -> new String[] {"Super Saiyan 3 Gotenks - DBL76-02S", "Ultimate Gohan - DBL72-02S", "Android #17 - DBL55-01S", "Beast Gohan - DBL52-01S", "Perfect Form Cell - DBL61-03S", "Goku - DBL75-01S", "Super Vegeta - DBL68-01S", "Super Saiyan God Goku - DBL72-01S", "Super #17 - DBL67-05S", "Omega Shenron - DBL73-02S", "Ultra Instinct Goku - DBL47-01S", "Fusion Zamasu - DBL79-04S", "Super Saiyan God SS Gogeta - DBL30-01S", "Super Baby 2 - DBL69-01S", "Super Saiyan Trunks (Teen) - DBL50-01S", "Super Saiyan Trunks (Adult) - DBL41-02S", "Super Saiyan 4 Goku - DBL81-04S", "Super Saiyan 3 Vegeta - DBL81-02S", "Super Saiyan 3 Goku - DBL48-01S", "Perfect Cell - DBL40-02S", "Super Saiyan Broly: Full Power - DBL30-03S", "Super Saiyan 4 Gogeta - DBL35-01S", "Bardock - DBL43-01S", "Buu: Kid - DBL32-02S", "Half-Corrupted Fusion Zamasu - DBL35-08S", "Super Saiyan 4 Goku - DBL34-01S", "Vegeta - DBL39-01S", "Super Saiyan God SS Vegeta - DBL18-05S", "1st Form Frieza - DBL22-05S"};
            case "Zenkai" -> new String[] {"God of Destruction Toppo - DBL38-03S", "Kaioken Goku - DBL43-04S", "Super Saiyan Broly - DBL32-05S", "Launch - DBL31-05S", "Fusion Zamasu - DBL24-08S", "Super Full Power Saiyan 4 Goku - DBL24-03S", "Omega Shenron - DBL24-09S", "Jiren - DBL29-06S", "Android #21: Good - DBL31-02S", "Trunks: Mai (Assist) - DBL33-01S", "Super Saiyan God SS Vegeta - DBL25-05S", "Super Saiyan 3 Goku - DBL37-03S", "Wasteland Bandit Yamcha - DBL31-03S", "Super Saiyan 2 Kefla - DBL23-05S", "Broly: Cheelai (Assist) - DBL22-09S", "Goku - DBL16-01S", "Super Saiyan Trunks (Teen) - DBL23-01S", "Super Gogeta - DBL20-01S", "Bardock - DBL19-01S", "Great Saiyaman 1 & 2 (Assist) - DBL27-05S", "Final Form Cooler - DBL08-10S", "Majin Vegeta - DBL06-12S", "Chi-Chi - DBL09-06S"};
            case "Sparking" -> new String[] {"Tamagami Number Three - DBL78-04S", "Majin Kuu - DBL81-03S", "Majin Duu - DBL81-05S", "Goku (Mini) - DBL77-01S", "Glorio - DBL77-02S", "Goku (Mini) - DBL76-01S", "Cacao - DBL75-04S", "Daiz - DBL75-02S", "Amond - DBL75-03S", "Rasin: Lakasei (Assist) - DBL75-05S", "Majin Buu: Pure Evil - DBL72-04S", "Pui Pui - DBL-EVT-64S", "East Supreme Kai Shin - DBL71-03S", "Tien - DBL49-02S", "Majin Buu (Good): Hercule (Assist) - DBL76-03S", "God of Destruction Beerus - DBL72-03S", "Mecha Frieza - DBL50-02S", "Bulla: Vegeta (Assist) - DBL67-04S", "Gohan - DBL60-01S", "Gotenks - DBL65-03S", "Trunks (Parasitism) Baby - DBL69-02S", "Videl - DBL74-02S", "Kyawei - DBL59-05S", "Pan - DBL52-02S", "Bergamo - DBL28-01S", "Zamasu: Goku Black (Assist) - DBL41-04S", "Kakarot Goku - DBL-EVT-14S"};
            case "Extreme" -> new String[] {"Android #18 - DBL55-02E", "Majuub - DBL53-02E", "Jiren - DBL38-02E", "Omega Shenron - DBL53-04E", "Super Saiyan Gohan (Teen) - DBL74-01E", "Super Saiyan God SS Vegeta - DBL54-02E", "Thouser - DBL51-02E", "Trunks - DBL67-03E", "Metal Cooler - DBL64-03E", "Bardock - DBL66-02E", "Super Saiyan 2 Gohan (Youth) - DBL40-01E", "Super Saiyan God SS Goku - DBL54-01E", "Cell Jr. - DBL61-04E", "God of Destruction Champa - DBL59-02E", "Final Form Frieza - DBL41-05E"};
            case "Hero" -> new String[] {"Videl - DBL24-07H", "Mercenary Tao - DBL24-12H", "Nail - DBL16-04H", "Thouser - DBL08-12H", "Turles - DBL06-08H", "Krillin - DBL06-04H", "Super Saiyan Goku - DBL06-02H", "2nd Form Cell - DBL04-03H", "World Champion Hercule - DBL24-11H", "Nappa - DBL01-20H", "1st Form Cell - DBL03-09H", "Goku - DBL03-02H", "Raditz - DBL01-22H", "Recoome - DBL01-27H", "Vegeta - DBL01-18H"};
            default -> new String[] {"kosonk", "ini", "coek", "bom", "ba", "clat"};
        };
    }

    public void updateLayout(int width) {
        int newColumns = Math.max(1, width / 250);
        
        if (newColumns != columns) {
            columns = newColumns;
            removeAll();
            setLayout(new GridLayout(0, columns, 5, 5));
            refreshCards();
        }
    }
    public JDialog ingfoCard(JFrame owner, String text, String indesc){
        JDialog ingfo = new JDialog(owner, text, true);
        ingfo.setTitle(text);
        ingfo.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ingfo.setSize(675, 380);
        ingfo.setResizable(true);
        ingfo.setLocationRelativeTo(null);

        JTextArea inDesc = new JTextArea(indesc, 10, 50);
        inDesc.setLineWrap(true);
        inDesc.setWrapStyleWord(true);
        inDesc.setFont(new Font("Arial", Font.PLAIN, 24));
        inDesc.setBackground(Color.DARK_GRAY);
        inDesc.setForeground(Color.GRAY);
        JScrollPane desc = new JScrollPane(inDesc);
        desc.setBorder(BorderFactory.createEmptyBorder());
        ingfo.add(desc);

        JButton yeet = new JButton("Click to close");
        yeet.addActionListener(e -> ingfo.dispose());
        yeet.setFocusable(false);
        yeet.setBackground(Color.GRAY);
        yeet.setFont(new Font("Arial", Font.BOLD, 30));
        yeet.setBorder(BorderFactory.createEmptyBorder());

        ingfo.add(yeet, BorderLayout.SOUTH);
        ingfo.setUndecorated(true);
        ingfo.setVisible(true);
        return ingfo;
    }
}