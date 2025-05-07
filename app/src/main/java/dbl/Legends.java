package dbl;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Legends extends Source{
    private Point initialClick;
    public Legends(){
        setTitle("Dragon Ball Legends");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setSize(1920, 1080);
        setUndecorated(true);
        Navbar navbar = new Navbar();
        enableDrag(navbar);

        setLayout(new BorderLayout());
        add(navbar, BorderLayout.PAGE_START);

        CharCard leCards = new CharCard();
        JScrollPane scroll = new JScrollPane(leCards, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.getVerticalScrollBar().setUnitIncrement(16);

        JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, new Sidebar(), scroll);
        split.setDividerLocation(265);
        split.setDividerSize(0);
        add(split, BorderLayout.CENTER);
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
