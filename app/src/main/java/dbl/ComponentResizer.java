package dbl;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class ComponentResizer extends MouseAdapter {
    private static final int BORDER = 5;
    private final Component target;
    private final JFrame frame;
    private Point startPos;
    private Rectangle startBounds;
    private int direction;
    private boolean isResizing = false;
    private Cursor defaultCursor;

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

    protected int getResizeDirection(Point p) {
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