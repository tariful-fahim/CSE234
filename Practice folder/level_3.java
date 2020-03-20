import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.util.Timer;
import javax.swing.JLabel;
import java.util.TimerTask;


 
public class level_3 extends JFrame{
	JLabel display, msg;
	level_3(){
		this.setLayout(null);
		display = new JLabel();
		msg = new JLabel("Time Left: ");
		this.add(display);
		this.add(msg);
		display.setBounds(850, 100, 100, 50);
		msg.setBounds(700, 100, 100, 50);
		Timer t = new Timer(); 	
		t.scheduleAtFixedRate(new TimerTask(){
                    int i = 10;
                    @Override
                    public void run() {
                        
                        display.setText(""+(i--));
                        if(i < 0)
                            dispose();
                    }
                }, 0, 1000);
	}

    static int w = 20; static int h = 20;
	static int x = 21; static int y =20;
    private int[][] maze = {
	{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
	{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,1,0,0,1,1,1},
        {1,1,0,1,1,1,1,1,0,1,0,1,0,1,0,1,0,0,1,0,0,0,1,1,1,0,0,1,0,0,0,1},
        {1,0,0,0,0,0,0,0,1,0,0,1,0,0,0,0,1,0,0,0,0,0,0,0,1,1,1,1,1,1,0,1},
        {1,1,0,1,0,1,1,0,0,1,0,1,1,1,1,1,1,0,1,1,0,1,1,0,0,0,0,0,0,1,0,1},
        {1,1,0,1,1,0,1,0,1,0,0,0,0,0,1,0,0,0,1,1,0,1,1,0,1,0,1,1,0,1,0,1},
        {1,0,0,0,0,0,0,0,0,0,0,1,1,0,1,0,1,1,1,1,0,1,0,0,1,0,0,0,0,1,0,1},
        {1,0,1,1,1,1,1,1,1,1,0,0,1,0,1,0,0,0,1,1,0,1,1,0,1,1,1,1,0,1,0,1},
        {1,0,1,0,0,0,0,0,0,0,0,1,0,0,1,0,1,1,0,0,0,0,1,1,1,0,0,0,0,0,0,1},
        {1,0,1,0,1,1,1,1,1,1,1,0,1,1,1,0,0,1,0,1,0,1,1,0,0,0,1,1,0,1,0,1},
        {1,0,1,0,0,0,0,0,0,0,1,0,1,0,1,0,1,1,0,1,1,0,0,0,1,0,1,0,0,1,0,1},
        {1,0,1,0,1,1,1,1,1,0,1,0,0,0,0,0,0,1,0,1,0,0,1,1,0,0,1,1,0,1,0,1},
        {1,0,0,0,1,0,0,0,0,0,0,1,0,1,0,1,1,1,0,1,1,0,0,0,0,0,1,1,0,1,0,1},
        {1,0,1,0,1,0,1,1,1,1,1,1,0,0,0,1,0,0,0,1,1,0,1,0,1,1,1,1,1,0,0,1},
        {1,0,1,0,1,0,0,0,0,0,0,0,0,1,0,1,0,1,1,0,0,0,1,0,0,0,0,0,0,1,1,1},
        {1,0,1,0,1,1,1,1,1,1,1,1,0,1,1,0,0,1,1,0,1,0,1,0,1,1,1,1,0,1,0,1},
        {1,0,1,0,0,0,0,0,0,0,0,0,0,1,0,0,1,0,0,0,1,1,1,0,0,0,0,1,0,0,0,1},
        {1,0,1,1,1,0,1,0,1,0,1,1,1,0,0,1,1,0,1,1,0,0,0,1,1,1,0,1,0,1,1,1},
       {1,0,0,0,1,0,1,0,1,0,1,0,0,1,0,1,1,0,1,0,0,1,0,0,0,0,0,1,0,0,0,1},
        {1,1,1,0,1,0,1,0,1,0,1,0,1,1,0,1,0,0,1,0,1,0,1,1,1,1,0,1,0,1,0,1},
        {1,0,1,1,1,0,1,0,1,0,1,0,1,1,0,1,0,1,1,1,1,0,1,0,0,1,0,0,0,1,0,1},
        {1,0,0,0,0,0,1,0,1,0,0,0,0,1,0,1,0,0,0,0,0,0,0,0,1,1,0,0,0,0,1,1},
        {1,1,1,0,1,0,1,0,1,0,1,1,0,1,0,1,1,1,1,1,1,1,0,1,0,1,1,1,1,0,1,1},
        {1,0,1,0,1,0,0,0,1,0,0,1,0,1,0,1,0,0,0,0,0,1,0,1,0,1,0,0,1,0,1,1},
        {1,0,1,0,1,1,1,1,1,0,1,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,1,0,1,1},
        {1,0,1,0,1,1,1,0,1,0,1,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,0,1,0,1,1},
        {1,0,0,0,0,0,1,0,1,0,1,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,1,1,1,1},
        {1,1,0,1,1,0,0,0,1,0,1,1,0,0,0,0,1,1,0,1,0,1,0,0,0,0,0,0,0,0,1,1},
        {1,1,0,1,0,1,0,1,1,0,1,0,1,1,1,1,0,1,0,1,0,1,1,1,1,1,1,1,1,0,1,1},
	{1,1,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,9,1},
	{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}
    };
    public void paint(Graphics g) {
        //super.paint(g);
        
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
	     g.fillRect(20*col, 20*row, 20, 20);
            }
        }
        if(x==20 && y==10)
           g.setColor(Color.MAGENTA);
	    else if(x==10&& y==20)
			g.setColor(Color.MAGENTA);
		else if(x==21&&y==20)
			g.setColor(Color.MAGENTA);
		else
			g.setColor(Color.RED);
		
        g.fillOval(w, h, 20, 20); //Fills an oval bounded by the specified rectangle with the current color.
    }
	
  
    @Override
    protected void processKeyEvent(KeyEvent ke) {
		int i = 0;
        if (ke.getID() != KeyEvent.KEY_PRESSED) {
            return;
        }
        if (ke.getKeyCode() == KeyEvent.VK_DOWN) {
			if(maze[(h+20)/20][w/20]!=1)
			{ 
                if(maze[(h+20)/20][w/20]==9)
				    i =1;		
			h = h+20 ;
			if(h >600)
				h =600;
			x = 10; y = 20;
                          
			}
            
		
        }
        else if (ke.getKeyCode() == KeyEvent.VK_RIGHT) {
		   if(maze[(h)/20][(w+20)/20]!=1)
		   {
                       if(maze[(h)/20][(w+20)/20]==9)
						        i = 1;
                                
			 w = w+20 ;
		     if(w>600)
			   w= 600;
		     x = 20; y= 10;
		   }
           
        }
		else if(ke.getKeyCode() == KeyEvent.VK_LEFT){
			if(maze[(h)/20][(w-20)/20]!=1)
			{
                            if(maze[(h)/20][(w-20)/20]==9)
								i = 1;
			 w = w-20;
			 if(w <20)
				w = 20;
			}
			x = 20; y = 10;
			
		}
		else if(ke.getKeyCode() == KeyEvent.VK_UP){
			if(maze[(h-20)/20][(w)/20]!=1)
			{
                             if(maze[(h-20)/20][w/20]==9)
								 i = 1;
                                
			h = h-20;
			if(h <20)
				h = 20;
			}
			
			x = 10; y=20;
			
		}
        repaint(); 
		if(i == 1)
		{
			x = 20; y = 20;
			repaint();
			ImageIcon icon = new ImageIcon("con.png");
            JOptionPane.showMessageDialog(null, "",
                "Congratulations", JOptionPane.INFORMATION_MESSAGE, icon);
				
		    //JOptionPane.showMessageDialog(null, "you win!");
			Newframe f = new Newframe();
			f.setVisible(true);
			//f.setBounds(200, 200, 800, 800);
			dispose();
		}
			
    }


    public static void main(String[] args) {
        level_3 frame = new level_3();
        frame.setVisible(true);
        frame.setBounds(200, 200, 800, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.setTitle("Escape Maze - Level 2");
        
        frame.setLocationRelativeTo(null);
        
    }
}
