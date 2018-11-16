package digits;
 
import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
 
public class Seven extends Applet{
 
	private static final long serialVersionUID = 1L;

		public void paint(Graphics g){
			
                setForeground(Color.red);
               
            	for(int i = 100;i<=130;i=i+10){
                    g.fillOval(i, 30, 8, 8);

            	} 
            	
            	for(int i=40;i<=50;i=i+10){
            		g.fillOval(130,i,8,8);
            	}
            	
            	g.fillOval(130,60,8,8);
            	
               for(int i= 70;i<=80;i=i+10){
                   g.fillOval(130,i, 8, 8);
               } 
               
               g.fillOval(130,90, 8, 8);
        }
}
