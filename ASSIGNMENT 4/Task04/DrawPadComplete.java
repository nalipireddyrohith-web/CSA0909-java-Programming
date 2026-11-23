import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class DrawPadComplete extends Frame {
    private final List<Point> points = new ArrayList<>();
    private int count = 0;
    public DrawPadComplete() {
        setTitle("Draw Pad - Complete"); setSize(500, 400);
        addMouseListener(new MouseAdapter() {
            @Override public void mouseClicked(MouseEvent e) {
                points.add(new Point(e.getX(), e.getY())); count++; repaint();
            }
        });
        addWindowListener(new WindowAdapter() { public void windowClosing(WindowEvent e) { dispose(); } });
        setVisible(true);
    }
    public void paint(Graphics g) {
        super.paint(g);
        for (Point p : points) g.fillOval(p.x, p.y, 6, 6);
        g.drawString("Clicks: " + count, 20, 50);
    }
    public static void main(String[] args) { new DrawPadComplete(); }
}
