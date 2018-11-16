package point;
 
import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
 
public class PointDrawing extends Applet{
 
	private static final long serialVersionUID = 1L;

		public void paint(Graphics g){
			
               
                setForeground(Color.red);
              
        		g.drawLine(10, 10, 2000, 2000);
        		g.drawLine(10, 12, 2000, 2002);
        		g.drawLine(10, 11, 2000, 2001);
        		g.drawLine(10, 0, 10, 2000);
        		g.drawLine(10, 10, 2000, 2000);
        		g.drawLine(500, 10,10, 2000);


        }
}