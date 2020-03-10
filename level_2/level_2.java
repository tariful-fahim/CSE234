

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;


 
public class level_2 extends JFrame{

    int w = 50; int h = 50;
	int x = 51; int y =50;
    private int[][] maze = {
		{1,1,1,1,1,1,1,1,1,1,1,1,1},
		{1,0,0,0,1,0,0,0,0,0,0,0,1},
		{1,1,1,0,1,0,1,0,1,1,0,1,1},
		{1,0,0,0,0,1,0,0,1,0,0,0,1},
		{1,1,0,1,1,0,0,1,1,0,1,0,1},
		{1,0,0,1,0,0,1,0,0,0,1,1,1},
		{1,0,1,0,1,0,1,1,1,0,0,0,1},
		{1,0,0,0,1,0,0,0,1,1,1,0,1},
		{1,0,1,0,0,0,1,1,0,0,0,0,1},
		{1,0,1,0,1,0,0,1,9,1,0,1,1},
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
                    case 9 : color = Color.GREEN; break;
                    default : color = Color.WHITE; break;
                    
                }
              g.setColor(color);
              g.fillRect(50*col, 50*row, 50, 50);
            }
        }
        if(x==50 && y==30)
           g.setColor(Color.MAGENTA);
	    else if(x==30&& y==50)
			g.setColor(Color.PINK);
		else if(x==51&&y==50)
			g.setColor(Color.BLUE);
		else
			g.setColor(Color.RED);
		
        g.fillOval(w, h, x, y); //Fills an oval bounded by the specified rectangle with the current color.
    }
	
  
    @Override
    protected void processKeyEvent(KeyEvent ke) {
		int i = 0;
        if (ke.getID() != KeyEvent.KEY_PRESSED) {
            return;
        }
        if (ke.getKeyCode() == KeyEvent.VK_DOWN) {
			if(maze[(h+50)/50][w/50]!=1)
			{ 
                if(maze[(h+50)/50][w/50]==9)
				    i =1;		
			h = h+50 ;
			if(h >450)
				h =450;
			x = 30; y = 50;
                          
			}
            
		
        }
        else if (ke.getKeyCode() == KeyEvent.VK_RIGHT) {
		   if(maze[(h)/50][(w+50)/50]!=1)
		   {
                       if(maze[(h)/50][(w+50)/50]==9)
						        i = 1;
                                
			 w = w+50 ;
		     if(w>550)
			   w= 550;
		     x = 50; y= 30;
		   }
           
        }
		else if(ke.getKeyCode() == KeyEvent.VK_LEFT){
			if(maze[(h)/50][(w-50)/50]!=1)
			{
                            if(maze[(h)/50][(w-50)/50]==9)
								i = 1;
			 w = w-50;
			 if(w <50)
				w = 50;
			}
			x = 50; y = 30;
			
		}
		else if(ke.getKeyCode() == KeyEvent.VK_UP){
			if(maze[(h-50)/50][(w)/50]!=1)
			{
                             if(maze[(h-50)/50][w/50]==9)
								 i = 1;
                                
			h = h-50;
			if(h <50)
				h = 50;
			}
			
			x = 30; y=50;
			
		}
        repaint(); 
		if(i == 1)
		{
			x = 50; y = 50;
			repaint();
			ImageIcon icon = new ImageIcon("con.png");
            JOptionPane.showMessageDialog(null, "You Win !", 
                "Congratulations", JOptionPane.INFORMATION_MESSAGE, icon);
				
		    //JOptionPane.showMessageDialog(null, "you win!");
			dispose();
		}
			
    }

    public static void main(String[] args) {
        level_2 frame = new level_2();
        frame.setVisible(true);
        frame.setBounds(200, 200, 800, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Graphics Design");
        
        frame.setLocationRelativeTo(null);
        
    }
}