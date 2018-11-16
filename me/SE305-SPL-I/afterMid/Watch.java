package afterMid;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import javax.swing.JApplet;
import javax.swing.Timer;
 
@SuppressWarnings("serial")
public class Watch extends JApplet{
	
	private static int hour;
	private static int minute;
	private static int second;
	private ArrayList<ArrayList<Integer>>digits = new ArrayList<ArrayList<Integer>>();
 
	private int firstDigit;
	private int secondDigit;
	private int thirdDigit;
	private int fourthDigit;
	private int fifthDigit;
	private int sixthDigit;
	private boolean isChangedFormat = true;
	private Timer timer;
	private String format;
	private boolean toChangeDigit[]={true,true,true,true,true};
	private ZoneId  zone ;
    private	ZonedDateTime zonedDateAndTime;
	
    
    public void init(){
		
		for(int i=0;i<10;i++){
			digits.add(FileManager.readFromFile(i));

		}
				
		initializeTimeAndDate();
		
		setSize(1550,652);
		timer= new Timer(1000, new ActionListener() {
	      @Override
	      public void actionPerformed(ActionEvent e) {    
	        repaint();
	        sixthDigit++;
	        
	        if(sixthDigit==10){
	        	sixthDigit=0;
	        	fifthDigit++; 
	        	toChangeDigit[4]=true;
	        }
	        if(fifthDigit==6){
	        	fifthDigit = 0;
	        	fourthDigit++; 
	        	toChangeDigit[3]=true;
	        }
	        if(fourthDigit==10){
	        	fourthDigit=0;
	        	thirdDigit++;
	        	toChangeDigit[2]=true;
	        }
	        if(thirdDigit==6){
	        	thirdDigit=0;
	        	secondDigit++;
	        	toChangeDigit[1]=true;
	        }
	        if(secondDigit==10){
	        	secondDigit=0;
	        	firstDigit++;
	        	toChangeDigit[0]=true;
	        }
	        if(firstDigit == 1 && secondDigit == 3){
	        	firstDigit=0;
	        	toChangeDigit[0]=true;
	        	secondDigit=1;
	        	toChangeDigit[1]=true;
	        }
	        
	        if((firstDigit==1) && (secondDigit ==2) && (thirdDigit+fourthDigit+fifthDigit+sixthDigit == 0)){
	        	isChangedFormat = true;
	        	if(format=="AM")format = "বিকাল";
	        	else format = "সকাল";
	        }	             
	      }
	    });
	}
	
		private void initializeTimeAndDate() {
			
			zone = ZoneId.of( "Asia/Dhaka" );
			zonedDateAndTime = ZonedDateTime.now(zone);
			hour = zonedDateAndTime.getHour();
			if(hour >=12)format = "বিকাল";
			else format = "সকাল" ;
			
			if(hour>12 || hour ==0){
				hour = Math.abs(hour - 12) ;
			}
			minute = zonedDateAndTime.getMinute();
			second = zonedDateAndTime.getSecond();
			
			firstDigit = (int)(hour / 10);
			secondDigit=hour % 10 ;
			thirdDigit = minute / 10;
			fourthDigit = minute % 10;
			fifthDigit = second / 10;
			sixthDigit = second % 10;
	}

		public void paint(Graphics g){
				
			g.setColor(Color.BLUE);
			if(isChangedFormat==true) drawFormat(g);
			
			drawColons(g);
			drawSixthDigit(g);  
			if(firstDigit!=0 && toChangeDigit[0] ==true ) drawFirstDigit(g);
			if(toChangeDigit[1]==true) drawSecondDigit(g);
			if(toChangeDigit[2]==true) drawThirdDigit(g);
			if(toChangeDigit[3]==true) drawFourthDigit(g);
			if(toChangeDigit[4]==true) drawFifthDigit(g);
		}

		private void drawFormat(Graphics g) {
			g.clearRect(1190, 580, 80, 80);
			g.setFont(new Font("Vrinda", Font.BOLD, 70));
			g.drawString(format, 1200, 600);
			isChangedFormat = false;
		}

		private void drawSixthDigit(Graphics g) {
			g.clearRect(150+163+163+163+163+163+20+10, 200, 163, 300);
			for(int i =0;i<digits.get(sixthDigit).size();i=i+2){
				g.fillOval(digits.get(sixthDigit).get(i)+163+163+163+163+163+20+10, digits.get(sixthDigit).get(i+1), 12, 12);
			
			}
		}

		private void drawFifthDigit(Graphics g) {

				g.clearRect(150+163+163+163+163+20+10, 200, 163, 300);
				for(int i =0;i<digits.get(fifthDigit).size();i=i+2){
					g.fillOval(digits.get(fifthDigit).get(i)+163+163+163+163+20+10, digits.get(fifthDigit).get(i+1), 12, 12);
			
				}
				toChangeDigit[4]=false;
		}

		private void drawFourthDigit(Graphics g) {
			
				g.clearRect(150+163+163+163+10, 200, 163, 300);
				for(int i =0;i<digits.get(fourthDigit).size();i=i+2){
					g.fillOval(digits.get(fourthDigit).get(i)+163+163+163+10, digits.get(fourthDigit).get(i+1), 12, 12);
				}
				toChangeDigit[3]=false;
		}

		private void drawThirdDigit(Graphics g) {
			
				g.clearRect(151+163+10+163, 200, 163, 300);
				for(int i =0;i<digits.get(thirdDigit).size();i=i+2){
					g.fillOval(digits.get(thirdDigit).get(i)+163+10+163, digits.get(thirdDigit).get(i+1), 12, 12);
			
				}
				toChangeDigit[2]=false;
		}

		private void drawSecondDigit(Graphics g) {
			
				g.clearRect(151+163-40, 200, 162, 300);
				for(int i =0;i<digits.get(secondDigit).size();i=i+2){
					g.fillOval(digits.get(secondDigit).get(i)+163-40, digits.get(secondDigit).get(i+1), 12, 12);
			
				}
				toChangeDigit[1]=false;
		}

		private void drawFirstDigit(Graphics g) {
			
				g.clearRect(151-40, 200, 163, 300);
				for(int i=0;i<digits.get(firstDigit).size();i=i+2){
					g.fillOval(digits.get(firstDigit).get(i)-40, digits.get(firstDigit).get(i+1), 12, 12);
				}
				toChangeDigit[0]=false;
		}
		

		private void drawColons(Graphics g) {
			g.fillRect(476-20, 280, 10, 10);
			g.fillRect(476-20, 350, 10, 10);

			g.fillRect(812, 280, 10, 10);
			g.fillRect(812, 350, 10, 10);
		}	
		

		
	public void start() {
		  timer.start();
	}

}