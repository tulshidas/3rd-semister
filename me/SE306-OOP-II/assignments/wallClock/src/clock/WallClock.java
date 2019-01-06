package clock;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.Timer;

public class WallClock extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ArrayList<Integer> x = new ArrayList<>();
	ArrayList<Integer> y = new ArrayList<>() ;
	int radius = 600;
	int centerX = 400;
	int centerY = 100;
	private int rootX=centerX+radius/2;
	private int rootY=centerY+radius/2;
	private int tempX=centerX+radius/2;
	private int tempY=centerY+65;
	private static int var=0;
	
	public WallClock() {
		setLayout(null);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		calcculatePoints();
		
		for(int i =0; i<x.size();i++){
			System.out.printf("%d, %d \n",x.get(i).intValue(),y.get(i).intValue());
		}
		
		Timer t=new Timer(1000, this);
		t.start();
		
		
		setVisible(true);
		
	}

	private void calcculatePoints() {
		for(int i=centerX+radius/2;i<=centerX+radius;i++){
			x.add(Integer.valueOf(i));
			x.add(Integer.valueOf(i));
			y.add(Integer.valueOf((int)(Math.sqrt(radius*radius - (i-centerX)*(i-centerX)) +centerY)));
			y.add(Integer.valueOf((int)(-(int)Math.sqrt(radius*radius - (i-centerX)*(i-centerX)) +centerY))); 

		}
		
	}
	
	public static void main(String[] args) {
		new WallClock();
		
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D)g;
		float thickness = 5;
	/*	g.drawOval(centerX, centerY, radius, radius);
		g.drawOval(centerX+2, centerY+2, radius-4, radius-4);
		g.drawOval(centerX+4, centerY+4, radius-8, radius-8);
		g.drawOval(centerX+6, centerY+6, radius-12, radius-12); */
		g.setColor(Color.RED);
	//	g.fillOval(centerX+radius/2,centerY+radius/2, 20, 20);
		BasicStroke stroke = new BasicStroke(thickness);
		g2d.setStroke(stroke);
		g2d.drawOval(400, 100, radius, radius);
		
		
		g.drawLine(centerX+radius/2, centerY, centerX+radius/2, centerY+30);
		g.drawLine(centerX+radius/2, centerY+radius, centerX+radius/2, centerY+radius-30);
		g.drawLine(centerX, centerY+radius/2, centerX+30,centerY+radius/2);
		g.drawLine(centerX+radius, centerY+radius/2, centerX+radius-30,centerY+radius/2);
		g.setFont(new Font("sherif", Font.BOLD, 30));
		g.drawString(""+12, centerX+radius/2-10,centerY+60);
		
		g.drawString(""+3, centerX+radius-60,centerY+radius/2+10);
		
		g.drawString(""+6, centerX+radius/2-10,centerY+radius-60);
		
		g.drawString(""+9, centerX+60,centerY+radius/2+10);
		
		g.drawLine(rootX, rootY,tempX, tempY);
		
		
		/*for(int i=0;i<x.size();i++){
			g.fillOval(x.get(i).intValue(), y.get(i).intValue(), 8,8);
		}
		g.fillOval(centerX, centerY, 8, 8); */
		
	}
	@Override
	public void actionPerformed(ActionEvent e){
		
		tempX=x.get(var);
		tempY=y.get(var++);
		repaint();
	}
	
}
