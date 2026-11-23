import java.awt.*;
import java.awt.event.*;

public class DrawPad extends Frame {
    int count = 0;
    public DrawPad() {
        setTitle("Draw Pad - Original Code"); setSize(500, 400);
        addMouseListener(new MouseAdapter() {
            public void mouseclicked(MouseEvent e) {
                count++; Graphics g = getGraphics(); g.fillOval(e.getX(), e.getY(), 6, 6);
            }
        });
        addWindowListener(new WindowAdapter() { public void windowClosing(WindowEvent e) { dispose(); } });
        setVisible(true);
    }
    public static void main(String[] args) { new DrawPad(); }
}
