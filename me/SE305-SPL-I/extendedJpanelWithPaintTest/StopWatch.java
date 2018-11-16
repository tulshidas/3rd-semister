package extendedJpanelWithPaintTest;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.Timer;

@SuppressWarnings("serial")
public class StopWatch extends JPanel {
	private Timer t;
	private int s2=0,s1=0,dS=0,m1=0,m2=0,h1=0,h2=0;
	private String digits= "০১২৩৪৫৬৭৮৯";
	int x = 100;
	
	public StopWatch(){
	 super();
	  t = new Timer(100, new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			repaint();
			dS++;
			if(dS==10){dS=0;s2++;}
			if(s2 == 10){s2=0; s1++;}
			if(s1==6){s1=0;m2++;}
			if(m2==10){m1++;m2=0;}
			if(m1==6){h2++;m1=0;}
			if(h2==10){h1++;h2=0;}
			if(h1==10){h1=0;}
			
			
		}

	});
		t.start();

	
		
	}

	@Override
	public void paint(Graphics g){
		super.paint(g);
		g.setColor(Color.BLUE);
		g.setFont(new Font("Vrinda",Font.PLAIN,300));
		
		g.drawChars(digits.toCharArray(), h1, 1, 0, 400);
		g.drawChars(digits.toCharArray(), h2, 1, 50+x, 400);
			
		g.fillOval(200+x, 370, 20, 20);
		g.fillOval(200+x, 310, 20, 20);
		
		g.drawChars(digits.toCharArray(), m1, 1, 250+x, 400);
		g.drawChars(digits.toCharArray(), m2, 1, 400+x, 400);
		
		
		g.fillOval(600+x, 370, 20, 20);
		g.fillOval(600+x, 310, 20, 20);
		
		g.drawChars(digits.toCharArray(), s1, 1, 650+x, 400);
		g.drawChars(digits.toCharArray(), s2, 1, 800+x, 400);
		g.fillOval(1000+x, 370, 20, 20);
		g.fillOval(1000+x, 310, 20, 20);

		g.drawChars(digits.toCharArray(), dS, 1, 1050+x, 400);
	//	g.drawChars(digits.toCharArray(), cS, 1, 200, 100);


		//g.fillOval(30, 10, 10, 10);
		//g.drawChars(digits.toCharArray(), i, 1, 100, 100);
		
	}
	
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("timer1");
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);		
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		StopWatch p =  new StopWatch();
		p.setBounds(0, 0, 1300, 700);
	//	p.setBackground(Color.RED);
		frame.add(p);
		frame.setVisible(true);
		
		//new TimerPanel();
	}
	

}
