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

 
public class level_3 extends JFrame{
	int x;
	
	JLabel display, msg;
	
	static int a = 0;
	static int w = 20; static int h = 20;
	
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
	
	
	
	level_3(){
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.setLayout(null);
		Timer t = new Timer();
		display = new JLabel();
		msg = new JLabel("Time Left: ");
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
	void Exit(Timer t){
		 x = JOptionPane.showConfirmDialog(null, "Do you want to quit game?", "Cancel", JOptionPane.YES_NO_OPTION);
                if(x == JOptionPane.YES_OPTION){
		    dispose();
		    t.cancel();
		    Newframe f = new Newframe();
		    f.setVisible(true);
		    f.setBounds(200, 200, 600, 300);
                    
                }
	}
	

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
 
	
	
    public void paint(Graphics g) {
        //super.paint(g);
        
        g.translate(05, 35);  //Translates the origin of the graphics context to the point (x, y) in the current coordinate system.
        
        
        for(int row = 0; row < maze.length; row++){
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
        
        g.setColor(Color.MAGENTA);
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
	}
        repaint(); 
		
		if(i == 1 && a==0)
		{
			//repaint();
			a = 1;
			ImageIcon icon = new ImageIcon("con.png");
                        JOptionPane.showMessageDialog(null, "","Congratulations", JOptionPane.INFORMATION_MESSAGE, icon);
			Newframe f = new Newframe();
			f.setVisible(true);
			//f.setBounds(200, 200, 800, 800);
			dispose();
		}
			
    }              


    public static void main(String[] args) {
        level_3 frame = new level_3();
		//level_3 ob = new level_3(1);
        frame.setVisible(true);
        //frame.setBounds(0, 0, 850, 665);
	frame.setTitle("Escape Maze - Level 3");
        frame.setLocationRelativeTo(null);    
    }
}	 
