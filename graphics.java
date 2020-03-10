
package Swing;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;



 
public class graphics extends JFrame{

    int w = 20; int h = 20;
    private int[][] maze = {
        {1,1,1,1,1,1,1,1,1,1,1,1,1},
          {1,0,1,0,1,0,1,0,0,0,0,0,1},
          {1,0,1,0,0,0,1,0,1,1,1,0,1},
          {1,0,0,0,1,1,1,0,0,0,0,0,1},
          {1,0,1,0,0,0,0,0,1,1,1,0,1},
          {1,0,1,0,1,1,1,0,1,0,0,0,1},
          {1,0,1,0,1,0,9,0,1,1,1,0,1},
          {1,0,1,0,1,1,1,0,1,0,1,0,1},
          {1,0,0,0,0,0,0,0,0,0,1,0,1},
          {1,1,1,1,1,1,1,1,1,1,1,1,1}
        
    };
    public void paint(Graphics g) {
        super.paint(g);
        
        g.translate(40, 40);  //Translates the origin of the graphics context to the point (x, y) in the current coordinate system.
        
        // draw the maze
         //int p = 0; int q = 0;
        
        for(int row = 0; row < maze.length; row++){
            //q = 0;
            for(int col = 0; col < maze[row].length; col++){
                Color color;
                switch(maze[row][col]){
                    case 1 : color = Color.BLACK; break;
                    case 9 : color = Color.YELLOW; break;
                    default : color = Color.WHITE; break;
                    
                }
              g.setColor(color);
              g.fillRect(20*col, 20*row, 20, 20);
            }
        }
        
        g.setColor(Color.RED);
        g.fillOval(w, h, 20, 20); //Fills an oval bounded by the specified rectangle with the current color.
    }
	
  
    @Override
    protected void processKeyEvent(KeyEvent ke) {
        if (ke.getID() != KeyEvent.KEY_PRESSED) {
            return;
        }
        if (ke.getKeyCode() == KeyEvent.VK_DOWN) {
			if(maze[(h+20)/20][w/20]!=1)
			{
                            if(maze[(h+20)/20][w/20]==9){
                                JOptionPane.showMessageDialog(null, "you win!");
                                dispose();
                            }
                                
                                
			h = h+20 ;//g.fillOval(w, h+50, 50, 50);
			if(h >400)
				h =400;
			}
            
		
        }
        else if (ke.getKeyCode() == KeyEvent.VK_RIGHT) {
		   if(maze[(h)/20][(w+20)/20]!=1)
		   {
                       if(maze[(h)/20][(w+20)/20]==9){
                                JOptionPane.showMessageDialog(null, "you win!");
                                dispose();
                            }
			 w = w+20 ;// g.fillOval(w+50, h, 50, 50);
		     if(w>550)
			   w= 550;
		   }
           
        }
		else if(ke.getKeyCode() == KeyEvent.VK_LEFT){
			if(maze[(h)/20][(w-20)/20]!=1)
			{
                            if(maze[(h)/20][(w-20)/20]==9){
                                JOptionPane.showMessageDialog(null, "you win!");
                                dispose();
                            }
			 w = w-20;
			 if(w <20)
				w = 20;
			}
			
		}
		else if(ke.getKeyCode() == KeyEvent.VK_UP){
			if(maze[(h-20)/20][(w)/20]!=1)
			{
                             if(maze[(h-20)/20][w/20]==9){
                                JOptionPane.showMessageDialog(null, "you win!");
                                //this.dispose();
                            }
			h = h-20;
			if(h <20)
				h = 20;
			}
			
		}
        repaint(); 
    }

    public static void main(String[] args) {
        graphics frame = new graphics();
        frame.setVisible(true);
        frame.setBounds(200, 200, 500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Graphics Design");
        
        frame.setLocationRelativeTo(null);
       
        //DrawingComponent DC = new DrawingComponent();
        //frame.add(DC);
        
    }
}
