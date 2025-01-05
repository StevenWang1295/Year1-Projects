/* Name: Steven Wang
 * Email: swang177@u.rochester.edu
 * Date last modified: 11/04/2023
 * Homework4: Connect The Dots
 * Lab Section: CSC-171-13
 */

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.event.MouseMotionListener;
import java.lang.Math;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;



public class ConnectTheDots {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Connect the Dots");

		DotCanvas canvas = new DotCanvas();
		frame.add(canvas);	
		frame.setSize(640, 480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}


class DotCanvas extends JPanel implements MouseListener, MouseMotionListener, KeyListener {

	private MouseEvent[] circles;
	int d = 20;
	private int numClicks;
	boolean mouseDragged = false;
	boolean replace = false;
	Color c = Color.BLACK;
	
	
	public DotCanvas() {
		setBackground(Color.GRAY);
		addMouseListener(this);
		addMouseMotionListener(this);
		addKeyListener(this);
		setFocusable(true);

		circles = new MouseEvent[100];
		
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (MouseEvent e : circles) {
			if (e != null) {
				g.setColor(c);
				g.drawOval(e.getX()-d/2, e.getY()-d/2, d, d);
				g.fillOval(e.getX()-d/2, e.getY()-d/2, d, d);

			}
		}
		g.setColor(Color.BLACK);
		System.out.println(circles[4]);
		if (mouseDragged && numClicks > 0) {
			for (int i=0; i<numClicks; i++) {
				if (circles[i+1] != null) {
					g.drawLine(circles[i].getX(), circles[i].getY(), circles[i+1].getX(), circles[i+1].getY());
				}
			}
		} else if (numClicks > 1) {
			for (int i=1; i<numClicks; i++) {
				g.drawLine(circles[i].getX(), circles[i].getY(), circles[i-1].getX(), circles[i-1].getY());
			}	
		}
	}

	public void mouseClicked(MouseEvent e) {
		System.out.println("Click detected at (" + e.getX() + "," + e.getY() + ")");
		circles[(numClicks-1)] = e;
		if (numClicks == 100) {
			numClicks = 0;
		}
		repaint();
	}

	public void mouseDragged(MouseEvent e) {
		mouseDragged = true;
		if (numClicks == 0) {
			circles[numClicks] = e;
			repaint();
		}
		else {
			for (int i = 0; i < numClicks; i++) {
				double dist = Math.sqrt( Math.pow( ( e.getX()-circles[i].getX() ), 2) + Math.pow( ( e.getY()-circles[i].getY() ), 2) );
				if (dist < d/2) {
					replace = true;
					circles[i] = e;
					repaint();
					break;
				} 
				else {
					circles[numClicks] = e;
					repaint();
				}

			}
		}
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

	public void mousePressed(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
		mouseDragged = false;
		if (!replace) {
			numClicks++;
		}
		replace = false;
	}

	public void mouseMoved(MouseEvent e) {
	}

	public void keyTyped(KeyEvent e) {
		if (e.getKeyChar() == 'r' ) {		
			c = Color.RED;
		} else if (e.getKeyChar() == 'o') {
			c = Color.ORANGE;
		} else if (e.getKeyChar() == 'y') {
			c = Color.YELLOW;
		} else if (e.getKeyChar() == 'g') {
			c = Color.GREEN;
		} else if (e.getKeyChar() == 'b') {
			c = Color.BLUE;
		} else if (e.getKeyChar() == 'p') {
			c = Color.MAGENTA;
		} else if (e.getKeyChar() == 'l') {
			c = Color.BLACK;
		}
		repaint();
	}

	public void keyPressed(KeyEvent e) {
	}

	public void keyReleased(KeyEvent e) {
	}

}
