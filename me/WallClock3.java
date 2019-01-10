package clock;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class WallClock3 extends JPanel implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	ArrayList<Integer> peakOfSecondSticX = new ArrayList<>();
	ArrayList<Integer> peakOfSecondSticY = new ArrayList<>();
	ArrayList<Integer> peakOfMinuteSticX = new ArrayList<>();
	ArrayList<Integer> peakOfMinuteSticY = new ArrayList<>();
	ArrayList<Integer> peakOfHourSticX = new ArrayList<>();
	ArrayList<Integer> peakOfHourSticY = new ArrayList<>();

	int radius = 300;
	int cornerX = 400;
	int cornerY = 100;
	private int rootX=700;
	private int rootY=400;
	Timer t;
	int second=0;
	int minute=0;
	int hour=2;
	boolean isMiniteIncremented;
	boolean isHourIncremented;
	
	public WallClock3() {
		setLayout(null);
		
		takePeakOfSecondStics();
		takePeakOfMinuteStics();
		takePeakOfHourStics();
		initialiseTime();
		
		t=new Timer(1000, this);
		t.start();
		
		
	}

	private void initialiseTime() {
		ZoneId zone = ZoneId.of( "Asia/Dhaka" );
		ZonedDateTime zonedDateAndTime = ZonedDateTime.now(zone);
		hour = zonedDateAndTime.getHour();
		
		if(hour>12 || hour ==0){
			hour = Math.abs(hour - 12) ;
		}
		minute = zonedDateAndTime.getMinute();
		second = zonedDateAndTime.getSecond();
	}

	private void takePeakOfHourStics() {
		ArrayList< ArrayList<Integer>> allCoordinates = new ArrayList<>();
		allCoordinates = calcculatePoints(130);
		peakOfHourSticX = allCoordinates.get(0);
		peakOfHourSticY = allCoordinates.get(1);
	}

	private void takePeakOfMinuteStics() {
		ArrayList< ArrayList<Integer>> allCoordinates = new ArrayList<>();
		allCoordinates = calcculatePoints(90);
		peakOfMinuteSticX = allCoordinates.get(0);
		peakOfMinuteSticY = allCoordinates.get(1);
	}

	private void takePeakOfSecondStics() {
		ArrayList< ArrayList<Integer>> all = new ArrayList<>();
		all = calcculatePoints(50);
		peakOfSecondSticX = all.get(0);
		peakOfSecondSticY = all.get(1);
	}

	private ArrayList<ArrayList<Integer>> calcculatePoints(int toMinimisedFromRadius) {
		int i;
		double angle;
		ArrayList<Integer> x = new ArrayList<>() ;
		ArrayList<Integer> y = new ArrayList<>() ;
		ArrayList< ArrayList<Integer>> all = new ArrayList<>();
		
		
		double tempX,tempY;
		for(i=0;i<60;i++){
			angle = (Math.PI/2)- ((2*Math.PI)/60)*i;
			tempX = (radius-toMinimisedFromRadius)* Math.cos(angle);
			tempY = (radius-toMinimisedFromRadius)* Math.sin(angle);
			System.out.println(""+tempX+"   "+tempY);
			x.add(Integer.valueOf((int)tempX+rootX));
			y.add(Integer.valueOf((int)(rootY-tempY)));
			
		}
		all.add(x);
		all.add(y);
		
		return all;
	}
	

	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D)g;
		float thickness = 5;
		g2d.setColor(Color.RED);
		BasicStroke stroke = new BasicStroke(thickness);
		g2d.setStroke(stroke);
		g2d.drawOval(400, 100, radius*2, radius*2);
//		drawTimingLine(g2d);
		g2d.setFont(new Font("sherif", Font.BOLD, 30));
		g2d.drawString(""+12, cornerX+radius-10,cornerY+70);
		
		g2d.drawString(""+3, cornerX+radius*2-60,cornerY+radius+10);
		
		g2d.drawString(""+6, cornerX+radius-10,cornerY+radius*2-60);
		
		g2d.drawString(""+9, cornerX+60,cornerY+radius+10);
		
		g2d.drawLine(rootX, rootY,peakOfSecondSticX.get(second).intValue(), peakOfSecondSticY.get(second).intValue());
		g2d.drawLine(rootX, rootY,peakOfMinuteSticX.get(minute).intValue(), peakOfMinuteSticY.get(minute).intValue());
		g2d.drawLine(rootX, rootY,peakOfHourSticX.get(hour).intValue(), peakOfHourSticY.get(hour).intValue());

		//I have added a comment here
	}
/*
	private void drawTimingLine(Graphics2D g2d) {
		for(int i=0;i<60;i+=5){
			int coordinates[][]= new int[2][2];
	//		coordinates[0] = calculateCordinate(40, i);
		//	coordinates[1] = calculateCordinate(0, i);
			System.out.println(i);
			tempY = (radius)*(int) Math.cos((i*2*Math.PI)/60);
			tempX = (radius)* (int)Math.sin((i*2*Math.PI)/60);
			tempX+=rootX;
			tempY=rootY-tempY;
			tempY1 = (radius-40)*(int) Math.cos((i*2*Math.PI)/60);
			tempX1 = (radius-40)* (int)Math.sin((i*2*Math.PI)/60);
			tempX1+=rootX;
			tempY1=rootY-tempY1; 
			g2d.drawLine(coordinates[0][0], coordinates[0][1],coordinates[1][0],coordinates[1][1] );
		}
	} 

*/
	
	@Override
	public void actionPerformed(ActionEvent e){
		
		second++;
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
		//here is a  commit for me
		
	}
	
	
	public static void main(String[] args) {
		JFrame fr = new JFrame("clock");
		fr.getContentPane().setLayout(new BorderLayout());
		fr.setExtendedState(JFrame.MAXIMIZED_BOTH);
		fr.getContentPane().add(new WallClock3(),BorderLayout.CENTER);
		fr.setVisible(true);
		
	}
	//branch test
	
}
