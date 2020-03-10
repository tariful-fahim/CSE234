import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class View extends JFrame {

    /**
     * Conventions:
     * 
     * maze[row][col]
     * 
     * Values: 0 = not-visited node
     *         1 = wall (blocked)
     *         2 = visited node
     *         9 = target node
     *
     * borders must be filled with "1" to void ArrayIndexOutOfBounds exception.
     */
    private int [][] maze = 
        { {1,1,1,1,1,1,1,1,1,1,1,1,1},
          {1,0,1,0,1,0,1,0,0,1,0,9,1},
          {1,0,1,0,0,0,1,0,1,1,1,0,1},
          {1,0,1,0,1,1,1,0,0,0,0,0,1},
          {1,0,1,0,0,0,0,0,1,1,1,0,1},
          {1,0,1,0,1,1,1,0,1,0,0,0,1},
          {1,0,1,0,1,0,0,1,1,1,1,0,1},
          {1,0,1,0,1,1,1,0,1,0,1,0,1},
          {1,0,0,0,0,0,0,0,0,1,0,0,1},
          {1,1,1,1,1,1,1,1,1,1,1,1,1}
        };
    
    public View() {
        setTitle("Simple Maze Solver");
        setSize(800, 550);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
	
	
    int w = 50, h= 50;
	
	
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        
        g.translate(40, 40);  //Translates the origin of the graphics context to the point (x, y) in the current coordinate system.
        
        // draw the maze
        for (int row = 0; row < maze.length; row++) {
            for (int col = 0; col < maze[0].length; col++) {
                Color color;
                switch (maze[row][col]) {
                    case 1 : color = Color.BLACK; break;
                    case 9 : color = Color.yellow; break;
                    default : color = Color.WHITE;
                }
                g.setColor(color); //Sets this graphics context's current color to the specified color.
                g.fillRect(50 * col, 50 * row, 50, 50);  //Fills the specified rectangle.
                //g.setColor(Color.BLACK);
                //g.drawRect(50 * col, 50 * row, 50, 50); //Draws the outline of the specified rectangle.
            }
        }
        
        g.setColor(Color.RED);
        g.fillOval(w, h, 50, 50);  //Fills an oval bounded by the specified rectangle with the current color.
    }
	
  
    @Override
    protected void processKeyEvent(KeyEvent ke) {
        if (ke.getID() != KeyEvent.KEY_PRESSED) {
            return;
        }
        if (ke.getKeyCode() == KeyEvent.VK_DOWN) {
            h = h+50 ;//g.fillOval(w, h+50, 50, 50);
			if(h >400)
				h =400;
		
        }
        else if (ke.getKeyCode() == KeyEvent.VK_RIGHT) {
           w = w+50 ;// g.fillOval(w+50, h, 50, 50);
		   if(w>550)
			   w= 550;
        }
		else if(ke.getKeyCode() == KeyEvent.VK_LEFT){
			w = w-50;
			if(w <50)
				w = 50;
		}
		else if(ke.getKeyCode() == KeyEvent.VK_UP){
			h = h-50;
			if(h <50)
				h = 50;
		}
        repaint(); 
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                View view = new View();
                view.setVisible(true);
            }
        });
    }
    
}