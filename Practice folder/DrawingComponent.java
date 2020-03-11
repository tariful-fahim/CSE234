
package Swing;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import javax.swing.JComponent;

public class DrawingComponent extends JComponent{
    int w = 20; int h = 20;
    private int[][] maze = {
        {1,1,1,1,1,1,1,1,1,1,1,1,1},
          {1,0,1,0,1,0,1,0,0,0,0,0,1},
          {1,0,1,0,0,0,1,0,1,1,1,0,1},
          {1,0,0,0,1,1,1,0,0,0,0,0,1},
          {1,0,1,0,0,0,0,0,1,1,1,0,1},
          {1,0,1,0,1,1,1,0,1,0,0,0,1},
          {1,0,1,0,1,0,0,0,1,1,1,0,1},
          {1,0,1,0,1,1,1,0,1,0,1,0,1},
          {1,0,0,0,0,0,0,0,0,0,1,9,1},
          {1,1,1,1,1,1,1,1,1,1,1,1,1}
        
    };
    //private Rectangle rect1, rect2;
    public void paintComponent(Graphics g){
        super.paint(g);
        
        Graphics2D g2 = (Graphics2D) g; 
        g2.translate(40, 40);
        
        int p = 0; int q = 0;
        
        for(int row = 0; row < maze.length; row++){
            q = 0;
            for(int col = 0; col < maze[row].length; col++){
                if(maze[row][col] == 1){
                    g2.setColor(Color.red);
                    g2.fillRect(q, p, 20, 20);
                    
                }
               q += 20;
            }
            p += 20;
        }
        
        g2.setColor(Color.BLACK);
        g2.fillOval(20, 20, 20, 20);
        
  
}
    @Override
    protected void processKeyEvent(KeyEvent ke) {
        
        if (ke.getID() != KeyEvent.KEY_PRESSED) {
            return;
        }
        if (ke.getKeyCode() == KeyEvent.VK_DOWN) {
			if(maze[(h+20)/20][w/20]!=1)
			{
			h = h+20 ;//g.fillOval(w, h+50, 50, 50);
			if(h >400)
				h =400;
			}
            
		
        }
        else if (ke.getKeyCode() == KeyEvent.VK_RIGHT) {
		   if(maze[(h)/20][(w+20)/20]!=1)
		   {
			 w = w+20 ;// g.fillOval(w+50, h, 50, 50);
		     if(w>550)
			   w= 550;
		   }
           
        }
		else if(ke.getKeyCode() == KeyEvent.VK_LEFT){
			if(maze[(h)/20][(w-20)/20]!=1)
			{
			 w = w-20;
			 if(w <20)
				w = 20;
			}
			
		}
		else if(ke.getKeyCode() == KeyEvent.VK_UP){
			if(maze[(h-20)/20][(w)/20]!=1)
			{
			h = h-20;
			if(h <20)
				h = 20;
			}
			
		}
        repaint(); 
    }
    
}

