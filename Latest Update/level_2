import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Timer;
import javax.swing.JLabel;
import java.util.TimerTask;
import java.util.Random;

 
public class level_2 extends JFrame{
	JLabel display;
	static int a = 0;	
    
    int w = 50; int h = 50;
	int x = 51; int y =50;
	int m, n;
    public int[][] maze = {
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
    
	
      void abc(int x, int y)
	  {
		  for(int i=1; i<9; i= i+x)
		  {
			  for(int j=1; j<11; j= j+y)
			  {
				  maze[i][j] = 0;
			  }
		  }
	  }
	//constructor
	level_2(){
		int n, m;
		Random rn = new Random();
		m = rn.nextInt(3)+1;
		n = rn.nextInt(4)+1;
		abc(m, n);
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.setLayout(null);
		Timer t = new Timer();
		display = new JLabel();
		JLabel msg = new JLabel("Time Left: ");
		this.add(display);
		this.add(msg);
		display.setBounds(800, 100, 100, 50);
		msg.setBounds(700, 100, 100, 50);
		time(t);
		this.addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent e) {
                Exit(t);
            }
            
        	});
	}
	
	//Exit the running game giving a warning message
	void Exit(Timer t){
		int x = JOptionPane.showConfirmDialog(null, "Do you want to quit game?", "Cancel", JOptionPane.YES_NO_OPTION);
                if(x == JOptionPane.YES_OPTION){
		    dispose();
		    t.cancel();
		    Newframe f = new Newframe();
		    f.setVisible(true);
		    f.setBounds(200, 200, 600, 300);
                    
                }
	}
	
	//Timer 
	void time(Timer t){
		 	
		t.scheduleAtFixedRate(new TimerTask(){
                    int i = 20;
                    @Override
                    public void run() {
                        
                        display.setText(""+(i--));
						if(a==1)
						{
							w =20 ; h = 20;
							a = 0;
							t.cancel();
						}
							
                                                else if(i < 0)
						{
						        dispose();
							t.cancel();
							w = 20; h = 20;
							JOptionPane.showMessageDialog(null, "you loose!");
							Newframe f = new Newframe();
			                                f.setVisible(true);	
							
						}
                            
                    }
                }, 0, 1200);
	}
	
	//Abstract method graphics to draw the rectangle
    public void paint(Graphics g) {
        //super.paint(g);
        
        g.translate(40, 40);  //Translates the origin of the graphics context to the point (x, y) in the current coordinate system.
        
        // draw the maze
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
	
  	//key event to move the user object.
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
	    	//when user can reach the final destination
		if(i == 1 && a==0)
		{
			a = 1;
			x = 50; y = 50;
			repaint();
			ImageIcon icon = new ImageIcon("con.png");
            JOptionPane.showMessageDialog(null, "", 
            "Congratulations", JOptionPane.INFORMATION_MESSAGE, icon);
			Newframe f = new Newframe();
			f.setVisible(true);
			f.setBounds(200, 200, 600, 300);
			dispose();
		}
			
    }
	//Main method
    public static void main(String[] args) {
		int n, m;
		Random rn = new Random();
		m = rn.nextInt(4);
		n = rn.nextInt(4);
		
        level_2 frame = new level_2();
		frame.abc(m, n);
        frame.setVisible(true);
        frame.setBounds(200, 200, 800, 800);
        frame.setTitle("Graphics Design");  
        frame.setLocationRelativeTo(null);      
    }
}