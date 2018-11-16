package digits;

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
 
public class Six extends Applet{
 
	private static final long serialVersionUID = 1L;

		public void paint(Graphics g){
			
                setForeground(Color.red);
               
            	for(int i = 100;i<=130;i=i+10){
                    g.fillOval(i, 30, 8, 8);

            	} 
            	
            	for(int i= 100;i<=130;i=i+10){
                	g.fillOval(i, 60, 8, 8);
                } 
            	
            	for(int i= 130;i>=100;i=i-10){
                	g.fillOval(i,90, 8, 8);
                }

                for(int i= 40;i<=50;i=i+10){
                	g.fillOval(100, i, 8, 8);
                }    
                
                for(int i= 80;i>=70;i=i-10){
                	g.fillOval(100,i, 8, 8);
                } 
                
                for(int i= 70;i<=80;i=i+10){
                	g.fillOval(130,i, 8, 8);
                } 
        }
}
