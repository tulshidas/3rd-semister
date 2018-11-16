package extendedJpanelWithPaintTest;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JFrame;

public class panelTest {

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String t = "sak";
		
		
		
		JFrame frmTimer;
		frmTimer = new JFrame();
		//frmTimer.
		//frmTimer.setBounds(0,0,300,300);
		frmTimer.setTitle("Timer");
		frmTimer.setLayout(null);
		frmTimer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTimer.setExtendedState(JFrame.MAXIMIZED_BOTH);


		StopWatch pn = new StopWatch();
		pn.setBounds(100, 200, 200, 200);
		pn.setBackground(Color.RED);
		
	//	TimerPanel pn1 = new TimerPanel();
	//	pn1.setBounds(100, 410, 200, 200);
	//	pn1.setBackground(Color.RED);
		
		
		frmTimer.add(pn);
	//	frmTimer.add(pn1);

		frmTimer.setVisible(true);

	}

//	private static void makeFrame() {
		//frmTimer = new JFrame();
		//frmTimer.getContentPane().setFocusTraversalPolicyProvider(true);
		//frmTimer.setTitle("Timer");
	//	frmTimer.setEnabled(true);
	//	frmTimer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frmTimer.setLayout(new FlowLayout());
	//	frmTimer.setExtendedState(JFrame.MAXIMIZED_BOTH);
	}

//}
