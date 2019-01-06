package clock;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class WallClock2 extends JPanel implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	ArrayList<Integer> x = new ArrayList<>();
	ArrayList<Integer> y = new ArrayList<>() ;
	int radius = 300;
	int cornerX = 400;
	int cornerY = 100;
	private int rootX=700;
	private int rootY=400;
	private static int iter=0;
	Timer t;
	int second=0;
	int minute=0;
	int hour=2;
	boolean isMiniteIncremented;
	boolean isHourIncremented;
	
	public WallClock2() {
		setLayout(null);
		
		
		calcculatePoints();
		
		//for(int i=0;i<x.size();i++){
	//		System.out.println(" "+x.get(i).intValue()+"  "+y.get(i).intValue());
	//	}
		
		t=new Timer(1000, this);
		t.start();
		
		
	}

	private void calcculatePoints() {
		int i;
		double tempX,tempY;
		for(i=0;i<60;i++){
			tempY = (radius-50)* Math.cos((i*2*Math.PI)/60);
			tempX = (radius-50)* Math.sin((i*2*Math.PI)/60);
			System.out.println(""+tempX+"   "+tempY);
			x.add(Integer.valueOf((int)tempX+rootX));
			y.add(Integer.valueOf((int)(rootY-tempY)));
			
		}
		
		
		
	}
	
	
	private int[] calculateCordinate(int radiusPart1,int anglePosition){
		System.out.println("Called");
		int coordinate[] = new int[2];
		coordinate[0] = (radius-radiusPart1)*(int) Math.sin((anglePosition*2*Math.PI)/60);
		coordinate[1] = (radius-radiusPart1)*(int) Math.cos((anglePosition*2*Math.PI)/60);
		coordinate[0] += rootX;
		coordinate[1] = rootY - coordinate[1];
		
		return coordinate;
		
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D)g;
		float thickness = 5;
		int tempY,tempX;
		int tempY1,tempX1;

	
		g2d.setColor(Color.RED);
		BasicStroke stroke = new BasicStroke(thickness);
		g2d.setStroke(stroke);
		g2d.drawOval(400, 100, radius*2, radius*2);
		drawTimingLine(g2d);
		g2d.setFont(new Font("sherif", Font.BOLD, 30));
		g2d.drawString(""+12, cornerX+radius-10,cornerY+70);
		
		g2d.drawString(""+3, cornerX+radius*2-60,cornerY+radius+10);
		
		g2d.drawString(""+6, cornerX+radius-10,cornerY+radius*2-60);
		
		g2d.drawString(""+9, cornerX+60,cornerY+radius+10);
		
		g2d.drawLine(rootX, rootY,x.get(iter).intValue(), y.get(iter).intValue());
		
		drawStickOfminute(g2d);
		int coordinates[]= new int[2];
		coordinates = calculateCordinate(120, hour*5);
		//coordinates[1] = calculateCordinate(0, minute);
		//System.out.println("minute="+minute);
		g2d.drawLine(coordinates[0], coordinates[1],rootX,rootY);
		
	

		iter++;
		
		
	}

	private void drawStickOfminute(Graphics2D g2d) {
		int coordinates[]= new int[2];
		coordinates = calculateCordinate(80, minute);
		//coordinates[1] = calculateCordinate(0, minute);
		//System.out.println("minute="+minute);
		g2d.drawLine(coordinates[0], coordinates[1],rootX,rootY);
		}

	private void drawTimingLine(Graphics2D g2d) {
		for(int i=0;i<60;i+=5){
			int coordinates[][]= new int[2][2];
			coordinates[0] = calculateCordinate(40, i);
			coordinates[1] = calculateCordinate(0, i);
			System.out.println(i);
		/*	tempY = (radius)*(int) Math.cos((i*2*Math.PI)/60);
			tempX = (radius)* (int)Math.sin((i*2*Math.PI)/60);
			tempX+=rootX;
			tempY=rootY-tempY;
			tempY1 = (radius-40)*(int) Math.cos((i*2*Math.PI)/60);
			tempX1 = (radius-40)* (int)Math.sin((i*2*Math.PI)/60);
			tempX1+=rootX;
			tempY1=rootY-tempY1; */
			g2d.drawLine(coordinates[0][0], coordinates[0][1],coordinates[1][0],coordinates[1][1] );
		}
	}
	@Override
	public void actionPerformed(ActionEvent e){
		
		if(second ==60){
			minute++;
			second=0;
		}

		if(minute  ==60 ){
			hour++;
			minute=0;
		}  
		if(hour==12){
			hour=0;
		}
		 repaint();
		
	}
	
	
	public static void main(String[] args) {
		JFrame fr = new JFrame("clock");
		fr.getContentPane().setLayout(new BorderLayout());
		fr.setExtendedState(JFrame.MAXIMIZED_BOTH);
		fr.getContentPane().add(new WallClock2(),BorderLayout.CENTER);
		fr.setVisible(true);
		
	}
	
}
