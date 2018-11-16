package point;

/*
        Draw Oval & Circle in Applet Window Example
        This java example shows how to draw ovals & circles in an applet window using
        drawOval method of Graphics class. It also shows how to draw a filled
        ovals and circles using fillOval method of Graphics class.
*/
 
/*
<applet code="DrawOvalsExample" width=500 height=500>
</applet>
*/
 
 
import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
 
public class PointDrawing extends Applet{
 
        /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		public void paint(Graphics g){
			
                //set color to red
                setForeground(Color.red);
               
                /*
                 * to draw a oval in an applet window use,
                 * void drawOval(int x1,int y1, int width, int height)
                 * method.
                 *
                 * This method draws a oval of specified width and
                 * height at (x1,y1)
                 */
               
                //this will draw a oval of width 50 & height 100 at (10,10)
               // g.drawOval(10,10,50,100);
               
               
                /*
                 * To draw a filled oval use
                 * fillOval(int x1,int y1, int width, int height)
                 * method of Graphics class.
                 */
               
                //draw filled oval
        		//g.fillRect(50,50,4,4);
        		//g.draw3DRect(2, 2, 100, 100, false);
        		g.drawLine(10, 10, 2000, 2000);
        		g.drawLine(10, 12, 2000, 2002);
        		g.drawLine(10, 11, 2000, 2001);
        		g.drawLine(10, 0, 10, 2000);
        		g.drawLine(10, 10, 2000, 2000);
        		g.drawLine(500, 10,10, 2000);




                



        }
}