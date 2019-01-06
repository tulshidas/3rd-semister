package uiSwing;

import java.awt.Color;

import javax.swing.JColorChooser;
import javax.swing.JOptionPane;

public class ColorSwing {
	public ColorSwing() {
		
		Color initialcolor=Color.GREEN;  
		Color color=JColorChooser.showDialog(null, "Pick One", initialcolor); 
		JOptionPane.showMessageDialog(null, color.toString());
	}

}
