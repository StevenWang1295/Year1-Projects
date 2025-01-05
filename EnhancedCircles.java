/* File: Enhanced Circles
   Purpose:  A model-view-controller approach to drawing circles.
   Date: Oct 23
*/
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;

import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
public class EnhancedCircles {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Circle Creator");

        CircleCanvas canvas = new CircleCanvas();
        frame.add(canvas);
        frame.setSize(640, 480);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    
}

class CircleCanvas extends JPanel implements MouseListener {

    private MouseEvent[] clickBuffer;
    private int maxClicks = 4;
    private int numClicks = 0;

    public CircleCanvas() {
        setBackground(Color.BLACK);
        addMouseListener(this);
        clickBuffer = new MouseEvent[maxClicks];
        
        System.out.println("Finished CircleCanvas constructor..");
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (MouseEvent e : clickBuffer) {
            if (e != null) {
                g.setColor(Color.WHITE);
                int r = 50;
                g.drawOval(e.getX()-r/2, e.getY()-r/2, r, r);
            }
        }
    }


    public void mouseClicked(MouseEvent e) {
        System.out.println("Mouse clicked at " + e);
        clickBuffer[numClicks++] = e;
        if (numClicks == maxClicks) {
            numClicks = 0;
        }
        repaint();
    }
    public void mousePressed(MouseEvent e) {
        System.out.println("Mouse pressed at " + e);        
    }
    public void mouseReleased(MouseEvent e) {
        System.out.println("Mouse released at " + e);        
    }
    public void mouseEntered(MouseEvent e) {
        System.out.println("Mouse entered at " + e);
    }
    public void mouseExited(MouseEvent e) {
        System.out.println("Mouse exited at " + e);
    }
    
}
