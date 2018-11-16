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
 
 
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JApplet;
import javax.swing.Timer;
 
public class One extends JApplet{
	public static int hour,minute,second=0;
 
	private static final long serialVersionUID = 1L;
	private Timer timer ;

	public void init(){
		timer = new Timer(1000, new ActionListener() {
	      @Override
	      public void actionPerformed(ActionEvent e) {
	        second++;
	        if(second == 10)second = 0;
	        repaint();
	        
	      }
	    });
	}
	
		public void paint(Graphics g){
			
          /* this portion draw one */
			if(second==1){
				g.clearRect(0, 0, 800, 800);
				setForeground(Color.red);

        		g.fillOval(100, 50, 8, 8);
        		g.fillOval(110, 40, 8, 8);
        		for(int i= 30;i<=90;i=i+10){
            		g.fillOval(120, i, 8, 8);

        		}
        		g.fillOval(110, 90, 8, 8);
        		g.fillOval(130, 90, 8, 8);
        		
			}
			/* this method draw two */
			else if(second == 2){
				g.clearRect(0, 0, 800, 800);
				setForeground(Color.red);

				g.fillOval(100, 50, 8, 8);
        		g.fillOval(110, 40, 8, 8);
        		g.fillOval(120, 40, 8, 8);
        		g.fillOval(130, 50, 8, 8);
        		g.fillOval(130, 60, 8, 8);
        		g.fillOval(120, 70, 8, 8);
        		g.fillOval(110, 80, 8, 8);
        		g.fillOval(100, 90, 8, 8);
        		g.fillOval(100, 100, 8, 8);
        		g.fillOval(110, 100, 8, 8);
        		g.fillOval(120, 100, 8, 8);
        		g.fillOval(130, 100, 8, 8);
			}
			
			else if(second==3){
				g.clearRect(0, 0, 800, 800);
				setForeground(Color.red);

				g.fillOval(100, 50, 8, 8);
        		g.fillOval(110, 40, 8, 8);
        		g.fillOval(120, 40, 8, 8);
        		g.fillOval(130, 50, 8, 8);
        		g.fillOval(130, 60, 8, 8);
        		g.fillOval(120, 70, 8, 8);
        		g.fillOval(110, 70, 8, 8);
        		g.fillOval(130, 80, 8, 8);
        		
        		g.fillOval(100,90, 8, 8);
        		g.fillOval(110, 100, 8, 8);
        		g.fillOval(120, 100, 8, 8);
        		g.fillOval(130, 90, 8, 8);
			}
			
			else if(second==4){
				g.clearRect(0, 0, 800, 800);
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
			
			else if(second==5){
				g.clearRect(0, 0, 800, 800);
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
			
			else if(second==6){
				g.clearRect(0, 0, 800, 800);
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
			
			else if(second==7){
				g.clearRect(0, 0, 800, 800);
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
			else if(second==8){
				g.clearRect(0, 0, 800, 800);
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
                
                for(int i=40;i<=50;i=i+10){
            		g.fillOval(130,i,8,8);
            	}
                
                for(int i= 80;i>=70;i=i-10){
                	g.fillOval(100,i, 8, 8);
                } 
                
                for(int i= 70;i<=80;i=i+10){
                	g.fillOval(130,i, 8, 8);
                } 
			}
			else if(second==9){
				g.clearRect(0, 0, 800, 800);
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
                
                for(int i=40;i<=50;i=i+10){
            		g.fillOval(130,i,8,8);
                }
                
                for(int i= 70;i<=80;i=i+10){
                	g.fillOval(130,i, 8, 8);
                } 
			}
        }
		
		public void start() {
		    timer.start();
		  }

}