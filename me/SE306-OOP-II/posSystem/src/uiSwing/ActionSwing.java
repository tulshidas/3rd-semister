package uiSwing;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

public class ActionSwing {
	
	public ActionSwing() {
		JFrame f= new JFrame("PopupMenu Example");
		
        JPopupMenu popupmenu = new JPopupMenu("Tulsi");
        
        JMenuItem cut = new JMenuItem("late");  
        JMenuItem copy = new JMenuItem("Copy");  
        JMenuItem paste = new JMenuItem("Paste"); 
        
        popupmenu.add(cut); 
        popupmenu.add(copy); 
        popupmenu.add(paste);    
        
        f.addMouseListener(
        		new MouseAdapter() {  
        			public void mouseClicked(MouseEvent e) {              
        				popupmenu.show(f , e.getX(), e.getY());  
        			}                 
        		}
        );
        
        f.add(popupmenu);   
        f.setSize(300,300);  
        f.setLayout(null);  
        f.setVisible(true);  
	}
	

}
