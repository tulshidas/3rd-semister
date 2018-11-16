package digits;
 
import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
 
public class Five extends Applet{
 
	private static final long serialVersionUID = 1L;

		public void paint(Graphics g){
			
                setForeground(Color.red);
               
            	for(int i = 110;i<=130;i=i+10){
                    g.fillOval(i, 30, 8, 8);

            	}

                for(int i= 30;i<=50;i=i+10){
                	g.fillOval(100, i, 8, 8);
                }
        		
                for(int i= 100;i<=130;i=i+10){
                	g.fillOval(i, 60, 8, 8);
                }
                
                for(int i= 70;i<=90;i=i+10){
                	g.fillOval(130,i, 8, 8);
                }
                
                for(int i= 120;i>=100;i=i-10){
                	g.fillOval(i,90, 8, 8);
                }
                
        }
}
