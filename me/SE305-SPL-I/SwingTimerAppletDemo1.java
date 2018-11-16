package lernigGraphics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.geom.Ellipse2D;

import javax.swing.JApplet;
import javax.swing.Timer;

public class SwingTimerAppletDemo1 extends JApplet {

  //private static final long serialVersionUID = 656209471758159755L;
	private static final long serialVersionUID = 1L;

  private Ellipse2D ball;
  private Timer moveBallTimer;
  private int moveX;
  private int moveY;

  @Override
  public void init() {
    ball = new Ellipse2D.Double(0, 0, 10, 10);
    moveX = 5;
    moveY = 5;

    moveBallTimer = new Timer(100, new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        moveBall();
        repaint();
        
      }
    });

    addKeyListener(new KeyAdapter() {
      @Override
      public void keyPressed(KeyEvent e) {
        if (moveBallTimer.isRunning()) {
          moveBallTimer.stop();
        } else {
          moveBallTimer.start();
        }
      }
    });
  }

  protected void moveBall() {
    int width = getWidth();
    int height = getHeight();

    Rectangle ballBounds = ball.getBounds();
    if (ballBounds.x + moveX < 0) {
      moveX = 5;
    } else if (ballBounds.x + ballBounds.width + moveX > width) {
      moveX = -5;
    }
    if (ballBounds.y + moveY < 0) {
      moveY = 5;
    } else if (ballBounds.y + ballBounds.height + moveY > height) {
      moveY = -5;
    }
    ballBounds.x += moveX;
    ballBounds.y += moveY;

    ball.setFrame(ballBounds);
  }

  @Override
  public void paint(Graphics g) {
    super.paint(g);

    Graphics2D g2d = (Graphics2D) g;
    g2d.setColor(Color.RED);
    g2d.fill(ball);
  }

  @Override
  public void start() {
    moveBallTimer.start();
  }

  @Override
  public void stop() {
    moveBallTimer.stop();
  }
}

