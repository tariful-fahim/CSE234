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
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;
import javax.swing.SwingUtilities;
import javax.swing.JTextField;
import java.awt.Font;

 
public class level_3 extends JFrame{
	int x;
	
	//JTextField display, display_coin;
    JLabel msg_coin, msg ,display, display_coin;
	
    int a = 0, coin = 0;
    int w = 20; int h = 20;
	int flag = 0; 
	int pathX, pathY;
	int s, r, count = 0;
	
	Color GOLD;
	public static final Color VERY_LIGHT_RED = new Color(255,102,102);
	
	public int[][] maze = {
	    {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
	    {1,0,0,0,1,0,0,0,1,0,0,1,0,0,0,1,0,1,1,0,0,0,0,0,0,0,1,3,0,1,1,1},
        {1,0,0,1,1,1,1,1,0,1,0,1,0,1,0,0,0,0,1,0,0,0,1,1,1,0,0,1,0,0,0,1},
        {1,1,0,0,0,0,0,0,0,0,0,1,0,0,0,0,1,0,0,0,0,0,0,0,1,1,1,1,1,1,0,1},
        {1,1,0,1,0,1,1,0,0,1,0,1,1,1,1,1,1,0,1,1,0,1,1,3,0,0,0,0,0,1,0,1},
        {1,1,0,1,1,0,1,0,1,0,0,0,0,0,1,0,0,0,1,1,0,1,1,0,1,0,1,1,0,1,0,1},
        {1,0,0,0,0,0,0,0,0,0,0,1,1,0,1,0,1,1,1,1,0,1,0,0,1,0,0,0,0,1,0,1},
        {1,0,1,1,1,1,1,1,1,1,0,0,1,3,1,0,0,0,1,1,0,1,1,0,1,1,1,1,0,1,0,1},
        {1,1,1,0,0,0,0,0,0,0,0,1,0,0,1,0,1,1,0,0,0,0,1,1,1,0,0,0,0,0,0,1},
        {1,0,1,0,1,1,1,1,1,1,1,0,1,1,1,0,0,1,0,1,0,1,1,0,0,0,1,1,0,1,0,1},
        {1,0,1,0,0,0,0,0,0,0,1,0,1,0,1,0,1,1,0,1,1,0,0,0,1,0,1,0,0,1,0,1},
        {1,0,1,3,1,1,1,1,1,0,1,0,0,0,0,0,0,1,0,1,0,0,1,1,0,0,1,1,0,1,0,1},
        {1,0,0,0,1,0,0,0,0,0,0,1,0,1,0,1,1,1,0,1,1,0,0,0,0,0,1,1,3,1,0,1},
        {1,0,1,0,1,0,1,1,1,1,1,1,0,0,0,1,0,0,0,1,1,0,1,0,1,1,1,1,1,0,0,1},
        {1,0,1,0,1,0,0,0,0,0,0,0,0,1,0,1,0,1,1,0,0,0,1,0,0,0,0,0,0,1,1,1},
        {1,0,1,0,1,1,1,1,1,1,1,1,0,1,1,0,0,1,1,0,1,0,1,0,1,1,1,1,0,1,0,1},
        {1,1,1,0,0,0,0,0,0,0,0,0,0,1,0,0,1,0,0,0,1,1,1,0,0,3,0,1,0,0,0,1},
        {1,0,1,1,1,0,1,0,1,0,1,1,1,0,0,1,1,0,1,1,0,0,0,1,1,1,0,1,0,1,1,1},
        {1,0,0,0,1,0,1,0,1,0,1,0,0,1,0,1,1,0,1,0,0,1,0,0,0,0,0,1,0,0,0,1},
        {1,1,1,0,0,0,1,0,1,0,1,0,1,1,0,1,0,0,1,0,1,0,1,1,1,1,0,1,0,1,0,1},
        {1,0,1,1,1,0,1,0,1,0,1,0,1,1,0,1,0,1,1,1,1,0,1,0,0,1,0,0,0,1,0,1},
        {1,0,0,0,0,0,1,0,1,0,0,0,0,1,0,1,0,0,0,0,0,0,0,0,1,1,0,0,0,0,1,1},
        {1,1,1,0,1,0,1,0,1,0,1,1,0,1,3,1,1,1,1,1,1,1,0,1,0,1,1,1,1,0,1,1},
        {1,0,1,0,1,0,0,0,1,0,0,1,1,1,0,1,0,0,0,0,0,1,0,1,0,1,0,0,1,0,1,1},
        {1,0,1,0,1,1,1,1,1,0,1,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,1,0,1,1},
        {1,0,1,0,1,1,1,0,1,0,1,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,0,1,0,1,1},
        {1,0,0,0,0,0,1,0,1,0,1,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,3,1,1,1,1,1},
        {1,1,0,1,1,0,0,0,1,0,1,1,0,0,0,0,1,1,0,1,0,1,0,0,0,0,0,0,0,0,1,1},
        {1,1,0,1,0,1,0,1,1,0,1,0,1,1,1,1,0,1,0,1,0,1,1,1,1,1,1,1,1,0,1,1},
	    {1,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
	    {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}
    };
	
	void abc(int x, int y)
	  { 
		  for(int i=2; i<28; i= i+x)
		  {
			  for(int j=2; j<28; j= j+y)
			  {
				  maze[i][j] = 0;  
			  }
		  }
		  maze[1][1] = 0;
	  }
	  
	  
	    private int pathIndex;
	    private static List<Integer> path = new ArrayList<Integer>();

	//Constructor
	level_3(){
		coin = 0;
		int n, m, p, q, e, f;
		Random rn = new Random();
		p = rn.nextInt(5)+2;
		q = rn.nextInt(5)+2;
		m = rn.nextInt(3)+p;
		n = rn.nextInt(2)+q;
		
		abc(m,n);
		
		while(count<=10)
		{
			e = rn.nextInt(22)+5;
			f = rn.nextInt(22)+5;
			while(maze[e][f]==1)
			{
				e = rn.nextInt(22)+5;
			    f = rn.nextInt(22)+5;
			}
			maze[e][f] = 7;
			count ++;
		}
		
		while(true)
		{
		    s = rn.nextInt(15) +13;
		    r = rn.nextInt(15) +13;
		    if(maze[s][r]==0)
		    {
			    maze[s][r]=9;
		        break;
		    }
			
		}
		
		DepthFirst.searchPath(maze, 10, 8, path);
        pathIndex = path.size() - 2;
		
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.setLayout(null);
		
		Timer t = new Timer();
		
		display_coin = new JLabel();
		display = new JLabel();

		msg_coin = new JLabel("coin: ");
		msg = new JLabel("Time Left: ");
		
		this.add(msg_coin);
		this.add(msg);
		this.add(display);
		this.add(display_coin);
		
		display.setBounds(800, 100, 100, 50);
		msg.setBounds(700, 100, 100, 50);
		msg_coin.setBounds(700, 200, 100, 50);
		display_coin.setBounds(800, 200, 100, 50);
		timeShow(t);
		time(t);
		
		this.addWindowListener(new WindowAdapter(){
            	@Override
            	public void windowClosing(WindowEvent e) {
                	Exit(t);
            	}
        	});
	}
	
	// Exit the running game by giving a warning message
	void Exit(Timer t){
		 x = JOptionPane.showConfirmDialog(null, "Do you want to quit game?", "Cancel", JOptionPane.YES_NO_OPTION);
            if(x == JOptionPane.YES_OPTION){
		    dispose();
		    t.cancel();
		    Newframe f = new Newframe();
		    f.setVisible(true);
			f.setLocationRelativeTo(null);
		    f.setBounds(200, 200, 600, 300);
                    
            }
	}
	
	
	void timeShow(Timer t)
	{
		t.scheduleAtFixedRate(new TimerTask(){
                    int k = 1000;
                    @Override
                    public void run() { 
                        display.setText(""+(k--));
				

                        if(a==1)
						{
							w =20 ; h = 20;
							a = 0;
							t.cancel();
						}
							
                        else if(k < 0)
						{
						    dispose();
							t.cancel();
							w = 20; h = 20;
							JOptionPane.showMessageDialog(null, "Time over, you loose!");
							Newframe f = new Newframe();
			                f.setVisible(true);
                            f.setLocationRelativeTo(null);											
							
						} 						
                    }
                }, 0, 600);
	}
	
	// Timer
	void time(Timer t){
		 	
		t.scheduleAtFixedRate(new TimerTask(){
                    int i = 100000000;
                    @Override
                    public void run() {
		
                       if(pathIndex < 0 || flag == 1) {
						   JOptionPane.showMessageDialog(null,"you loose");
			               Newframe f = new Newframe();
			               f.setVisible(true);
						   f.setLocationRelativeTo(null);
			               t.cancel();
			               dispose();
                           }
						   pathIndex -= 2;
						   
                        repaint(); 			  
                    }
                }, 0, 1000);
	}
 
	
	// Abstract method graphics to draw the rectangle on JFrame.
    public void paint(Graphics g) {
		
        //super.paint(g);
        
        g.translate(05, 35);  //Translates the origin of the graphics context to the point (x, y) in the current coordinate system.
        
        for(int row = 0; row < maze.length; row++){
            for(int col = 0; col < maze[row].length; col++){
                Color color;
                switch(maze[row][col]){
                    case 1 : color = Color.BLACK; break;
                    case 9 : color = Color.GREEN; break;
		            case 7 : color = Color.yellow; break;
					case 8 : color = Color.yellow; break;
                    default : color = Color.WHITE; break;
              }
			  if(maze[row][col]==7 || maze[row][col]==8)
			  {
				g.setColor(color);
	          	g.fillOval(20*col, 20*row, 20, 20);	  
			  }
			  else
			  {
				g.setColor(color);
	          	g.fillRect(20*col, 20*row, 20, 20);	   
			  }
			    				 
		      g.setColor(Color.MAGENTA);
              g.fillOval(w, h, 20, 20); 
			 
			}  
			 
			  pathX = path.get(pathIndex);
              pathY = path.get(pathIndex + 1);
			  g.setColor(Color.RED);
              g.fillOval(pathX * 20, pathY * 20, 20, 20);
			  
			  if(w==(pathX*20)&&h==(pathY*20))
			  {
				  flag = 1;
			  }
        }
		
	}
	
    // Key Event to move the object of user 
    @Override
    protected void processKeyEvent(KeyEvent ke) {
	int j = 0;
	display_coin.setText(""+(coin));
        if (ke.getID() != KeyEvent.KEY_PRESSED) {
            return;
        }
	    
        if (ke.getKeyCode() == KeyEvent.VK_DOWN) {
	    if(maze[(h+20)/20][w/20]!=1)
	    { 
            if(maze[(h+20)/20][w/20]==9)
	             j =1;
	        else if(maze[(h+20)/20][w/20]==7 || maze[(h)/20][(w+20)/20]==8)
		        coin++;	
            maze[(h)/20][w/20] = 0;			 
	        h = h+20 ;
		    if(h >600)
		        h =600;  
			//maze[(h)/20][w/20] = 5;	
	    }	
        }
	    
        else if (ke.getKeyCode() == KeyEvent.VK_RIGHT) {
	      if(maze[(h)/20][(w+20)/20]!=1)
	      {
                if(maze[(h)/20][(w+20)/20]==9)
		            j = 1;
		else if(maze[(h)/20][(w+20)/20]==7 || maze[(h)/20][(w+20)/20]==8)
			coin++;
               maze[(h)/20][(w)/20] =0;                
		    w = w+20 ;
	        if(w>600)
		      w= 600;
		 //maze[(h)/20][(w)/20] =5;
		 
	      }
           
        }
	else if(ke.getKeyCode() == KeyEvent.VK_LEFT){
		if(maze[(h)/20][(w-20)/20]!=1)
		{
            if(maze[(h)/20][(w-20)/20]==9)
        	    j = 1;
	    else if(maze[(h)/20][(w-20)/20]==7 || maze[(h)/20][(w+20)/20]==8)
			coin++;

			maze[(h)/20][(w)/20] =0;
		    w = w-20;
		    if(w <20)
		        w = 20;
			 //maze[(h)/20][(w)/20] =5;
			 
		}
			
	}
	else if(ke.getKeyCode() == KeyEvent.VK_UP){
		if(maze[(h-20)/20][(w)/20]!=1)
		{
           if(maze[(h-20)/20][w/20]==9)
			j = 1;
	  else if(maze[(h-20)/20][w/20]==7 || maze[(h)/20][(w+20)/20]==8)
			coin++;

            maze[(h)/20][(w)/20] = 0;                    
		    h = h-20;
		    if(h <20)
			 h = 20;
		  // maze[(h)/20][(w)/20] = 5;
		  
		}
	}
		
		repaint(); 
	    
		
        
		
		if(j == 1 && a==0)
		{
			//repaint();
			a = 1;
			coin = 0;
			ImageIcon icon = new ImageIcon("con.png");
            JOptionPane.showMessageDialog(null, "","Congratulations", JOptionPane.INFORMATION_MESSAGE, icon);
			Newframe f = new Newframe();
			f.setVisible(true);
			f.setLocationRelativeTo(null);
			//f.setBounds(200, 200, 800, 800);
			dispose();
		}
			
    }              

    // Main method
    public static void main(String[] args) {
        level_3 frame = new level_3();
		//level_3 ob = new level_3(1);
        frame.setVisible(true);
        frame.setBounds(0, 0, 850, 665);
	    frame.setTitle("Escape Maze - Level 3");
        frame.setLocationRelativeTo(null);    
    }
}	 
