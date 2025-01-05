/* Name: Steven Wang
 * Email: swang177@u.rochester.edu
 * Date last modified: 11/12/2023
 * Homework5: GUILab
 * Lab Section: CSC-171-13
 */

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSlider;
import java.awt.Graphics;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.lang.Math;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.util.Random;


public class GUILab {	

	static boolean mode1;
	static boolean mode2;
	static boolean mode3;
	static Timer timer;
	static JFrame frame;
	static int xAdd;
	static int yAdd;
	static int x;
	static int y;
	static int r = 50;
	static Random rand;
	static int delay;
	static int[] circles;

	public static void main(String[] args) {
		xAdd = 1;
		yAdd = 1;
		delay = 10;

		frame = new JFrame("Main Frame");
		Ctrl ctrl = new Ctrl();
		Draw draw = new Draw();
		rand = new Random();

		frame.add(draw, BorderLayout.CENTER);
		frame.add(ctrl, BorderLayout.NORTH);
		frame.setSize(640, 480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

	}

	static class Ctrl extends JPanel {
		public Ctrl() {
			setLayout(new FlowLayout(FlowLayout.CENTER) );
			JButton bounce = new JButton("1");
			JButton circle = new JButton("2");
			JButton screen = new JButton("3");

			JSlider millisec = new JSlider(JSlider.HORIZONTAL, 0, 100, 10);

			millisec.addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent e) {
					JSlider source = (JSlider)e.getSource();

					delay = source.getValue();
				}
			});

			bounce.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (bounce.isEnabled()) {
						mode1 = true;
						mode2 = false;
						mode3 = false;

						x = rand.nextInt(frame.getWidth()-r);
						y = rand.nextInt(frame.getHeight()-2*r);
					}
				}
			});

			circle.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (circle.isEnabled()) {
						mode2 = true;
						mode1 = false;
						mode3 = false;
					}
				}
			});

			screen.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (screen.isEnabled()) {
						mode3 = true;
						mode1 = false;
						mode2 = false;
					}
				}
			});

			add(bounce);
			add(circle);
			add(screen);
			add(millisec);
		}

	}//control panel

	static class Draw extends JPanel {
		int rad = 100;
		double theta = 0;

		public Draw() {
			setBackground(Color.BLACK);
			timer = new Timer(delay, task);
			timer.start();
		}

		ActionListener task = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				repaint();
				timer.stop();
				if (mode3) {
					timer = new Timer(200, task);
				} else {
					timer = new Timer(delay, task);
				}
				timer.start();
			}
		};


		public void paintComponent(Graphics g) {
			super.paintComponent(g);

			if (mode1) {
				if (isCollideY()) {
					yAdd = -1*yAdd;
				}
				if (isCollideX()) {
					xAdd = -1*xAdd;
				}
				g.setColor(Color.WHITE);
				g.fillOval(x, y, r/2, r/2);
				g.drawOval(x, y, r/2, r/2);
				x+=xAdd;
				y+=yAdd;
			}

			if (mode2) {

				g.setColor(Color.WHITE);
				g.fillOval((int)(rad*Math.cos(theta)+frame.getWidth()/2)-r/2, (int)(rad*Math.sin(theta)+frame.getHeight()/2)-r, r/2, r/2);
				g.drawOval((int)(rad*Math.cos(theta)+frame.getWidth()/2)-r/2, (int)(rad*Math.sin(theta)+frame.getHeight()/2)-r, r/2, r/2);
				theta += 0.05;
				if (theta >= 2*Math.PI) {
					theta = 0;
				}
			}

			if (mode3) {
				circles = new int[delay];
				for (int i=0; i<circles.length; i++) {
					float red = rand.nextFloat();
					float green = rand.nextFloat();
					float blue = rand.nextFloat();

					Color randColor = new Color(red, green, blue);

					g.setColor(randColor);
					g.fillOval(x, y, r/2, r/2);
					g.drawOval(x, y, r/2, r/2);

					x = rand.nextInt(frame.getWidth()-r);
					y = rand.nextInt(frame.getHeight()-2*r);
					r = rand.nextInt(200);
				}
			}
		}

		public boolean isCollideY() {
			if (y+r >= frame.getHeight()-45 || y < 0) {
				return true;
			}
			return false;
		}

		public boolean isCollideX() {
			if (x + r/2 >= frame.getWidth() || x < 0) {
				return true;
			}
			return false;
		}
	}

}
