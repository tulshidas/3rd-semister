package fb;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Fb {
	public  Fb() {
		JFrame frame = new JFrame();
		frame.setSize(600, 600);
		frame.setLayout(new GridLayout(10, 1));
		JPanel p1 = new JPanel();
		p1.setBackground(Color.BLUE);
		JLabel l1= new JLabel("facebook", SwingConstants.CENTER);
	    l1.setFont(new Font("sherif", Font.BOLD, 40));
		p1.add(l1);
		frame.add(p1);
		
		JPanel p2 = new JPanel();
		p2.setLayout(new FlowLayout(FlowLayout.RIGHT));
		JLabel l2= new JLabel("Creat a new account          ");
		l2.setFont(new Font("sherif",Font.PLAIN,40));
		p2.add(l2);
		frame.add(p2);
		

		JPanel p3 = new JPanel();
		p3.setLayout(new FlowLayout(FlowLayout.RIGHT));
		JLabel l3= new JLabel("It's free and always will be.       ");
		l3.setFont(new Font("sherif",Font.PLAIN,20));
		p3.add(l3);
		frame.add(p3); 
		
		
		frame.setVisible(true);
		
	}
	
}
