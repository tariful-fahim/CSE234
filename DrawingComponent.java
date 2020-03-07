
package Swing;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.swing.JComponent;

public class DrawingComponent extends JComponent{
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
    private Rectangle rect1, rect2;
    public void paintComponent(Graphics g){
        
        Graphics2D g2 = (Graphics2D) g; 
        
        
        int h = 0; int w = 0;
        
        for(int row = 0; row < maze.length; row++){
            w = 0;
            for(int col = 0; col < maze[row].length; col++){
                if(maze[row][col] == 1){
                    g2.fillRect(w, h, 20, 20);
                }
                w += 20;
            }
            h += 20;
        }
        
        //rect1 = new Rectangle(0, 0, 20, 20);
        //g2.drawRect(0, 0, 20, 20);
        //g2.draw(rect1);
        
        //rect2 = new Rectangle(0, 21, 20, 20);
        /*g2.draw(rect2);
        g2.drawRect(0, 42, 20, 20);
        g2.drawRect(20, 0, 20, 20);
        //g2.drawRect(20, 20, 20, 20);
        g2.fillRect(20, 20, 20, 20);*/
        
    }
}
