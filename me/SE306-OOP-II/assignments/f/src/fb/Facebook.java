package fb;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Facebook extends JFrame{

	public  Facebook() {
		//super("Sign up to Facebook");
		setSize(500, 500);
		setLayout(new BorderLayout());
		
	/*	JLabel facebook = new JLabel("Facebook",SwingConstants.CENTER);
		facebook.setOpaque(true);
        facebook.setBackground(Color.BLUE);
        facebook.setFont(new Font("sherif",Font.BOLD, 40));
        facebook.setForeground(Color.WHITE);
        frame.add(facebook,BorderLayout.NORTH);
      */
		
		
        JPanel north = new JPanel();
        JLabel facebook = new JLabel("Facebook",SwingConstants.CENTER);
        facebook.setOpaque(true);
        north.setBackground(Color.BLUE);
        facebook.setFont(new Font("sherif",Font.BOLD, 40));
        facebook.setForeground(Color.WHITE);
        north.add(facebook);
        add(north,BorderLayout.NORTH);
        
        JPanel east = new JPanel();
        add(east,BorderLayout.EAST);
        
        JPanel west = new JPanel();
        add(west,BorderLayout.WEST);
        
        JPanel center = new JPanel();
        add(center,BorderLayout.CENTER);
        
        JPanel south = new JPanel();
        add(south,BorderLayout.SOUTH);
        
        center.setLayout(new GridLayout(10, 1));
        
        JLabel label = new JLabel("Creat Account");
        setFont(new Font("sherif",Font.BOLD, 25));
        center.add(label);
        
        
        
        setVisible(true);
        setLocationRelativeTo(null);
		
	}

}
