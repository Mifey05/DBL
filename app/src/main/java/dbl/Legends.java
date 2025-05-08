package dbl;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Legends extends Source{
    private Point initialClick;
    private ComponentResizer resizer;
    public Legends(){
        setTitle("Dragon Ball Legends");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setSize(1366, 768);
        setResizable(true);
        setUndecorated(true);
        JPanel borderahh = new JPanel(new BorderLayout());
        borderahh.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.DARK_GRAY));
        borderahh.setOpaque(true);
        borderahh.setBackground(Color.BLACK);
        Navbar navbar = new Navbar(this);
        enableDrag(navbar);

        getContentPane().setBackground(Color.BLACK);
        
        borderahh.add(navbar, BorderLayout.PAGE_START);

        CharCard leCards = new CharCard();
        JScrollPane scroll = new JScrollPane(leCards, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.getVerticalScrollBar().setUnitIncrement(16);

        scroll.getViewport().addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                leCards.updateLayout(scroll.getViewport().getWidth());
            }
        });

        Sidebar sidebar = new Sidebar(leCards);
        JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, sidebar, scroll);
        split.setDividerLocation(265);
        split.setDividerSize(0);
        borderahh.add(split, BorderLayout.CENTER);
        setContentPane(borderahh);
        resizer = new ComponentResizer(borderahh, this);
        setBackground(Color.BLACK);
    }

    private void enableDrag(JComponent dragArea) {
        dragArea.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                initialClick = e.getPoint();
            }
        });

        dragArea.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(dragArea);
                if (frame != null && initialClick != null) {
                    int thisX = frame.getLocation().x;
                    int thisY = frame.getLocation().y;

                    int xMoved = e.getX() - initialClick.x;
                    int yMoved = e.getY() - initialClick.y;

                    frame.setLocation(thisX + xMoved, thisY + yMoved);
                }
            }
        });
    }

    public static void main(String[] args) {
        new Legends().setVisible(true);

    }
}
