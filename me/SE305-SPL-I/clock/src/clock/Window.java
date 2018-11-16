package clock;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class Window extends JFrame{
	public Window() {
		setLayout(new BorderLayout());
		ClockPanel panel=new ClockPanel();
		add(panel,BorderLayout.CENTER);
		
		setSize(400, 600);
		setVisible(true);
		setLocationRelativeTo(null);
	}
}
