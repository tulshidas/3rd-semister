package digits;
 
import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
 
public class Four extends Applet{
 
	private static final long serialVersionUID = 1L;

		public void paint(Graphics g){
			
                setForeground(Color.red);
               
                for(int i= 30;i<=50;i=i+10){
                	g.fillOval(100, i, 8, 8);
                }
        		
                for(int i= 100;i<=130;i=i+10){
                	g.fillOval(i, 60, 8, 8);
                }
                g.fillOval(130, 50, 8, 8);
                g.fillOval(130, 40, 8, 8);
                g.fillOval(130, 30, 8, 8);
                g.fillOval(130, 60, 8, 8);
                g.fillOval(130, 70, 8, 8);
                g.fillOval(130, 80, 8, 8);
                g.fillOval(130, 90, 8, 8);
        }
}
