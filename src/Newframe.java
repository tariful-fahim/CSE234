import java.awt.event.ActionListener;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


class Newframe extends JFrame{
    private Container c;
    private JLabel lbl, lbl1;
    private ImageIcon img;
    private JButton bt, bt1;
    private JComboBox cb;
    private String[] level = {"1", "2", "3", "4", "5"};
    Newframe(){
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        this.setBounds(200, 200, 600, 300);
        
        this.setTitle("~~~CRAZY MAZE GAME~~~");
        
        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.BLACK);
        
        img = new ImageIcon("Amazing_Maze.png");
	lbl = new JLabel(img);
	lbl.setBounds(0,0,256,224);
	c.add(lbl);
	
	bt1 = new JButton("INSTRUCTION");
	bt1.setBounds(270, 50, 300, 20);
	bt1.setBackground(Color.yellow);
	c.add(bt1);
	
	lbl1 = new JLabel("Choose the Level");
	lbl1.setBounds(270, 90, 200, 20);
	c.add(lbl1);
	cb = new JComboBox(level);
	cb.setBounds(480, 90, 100, 20);
	c.add(cb);
        
        bt = new JButton("Play Maze Game");
        bt.setBounds(270, 20, 300, 20);
	bt.setBackground(Color.green);
        c.add(bt);
        bt.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
		String choose = cb.getSelectedItem().toString();
		if(choose == "1"){
			dispose(); 
			level_2 frame = new level_2();
			frame.setVisible(true);
			frame.setBounds(200, 200, 880, 580);
			frame.setTitle("Escape Maze - Level 1");
			
		}
		else if(choose == "2"){
                dispose();
                level_3 frame = new level_3();
                frame.setVisible(true);
		frame.setBounds(200, 200, 850, 680);
		frame.setTitle("Escape Maze - Level 2");
		}
		//frame.timer();
                
            }
        });
	
	bt1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{	
				JFrame frame = new JFrame("Instructions");
				frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				
				JLabel textLabel = new JLabel("" +"<html>" +
						"1. Player starts as the blue character.<br> " +
						"2. Player must reach the red endpoint to win.<br> " +
						"3. Get coins and skip enemy while making your way through the maze. <br>" +
						"4. coin will help to gain higher enregy level.<br>" +
						"" +
						"5.you have to complete the in a given time or  <br>" +
						"you will loose the game instant<br>" +
						"" +
						"6. Move the character by using the standard arrow keys to move. </html>");
				frame.getContentPane().add(textLabel, BorderLayout.CENTER);
        					frame.setLocationRelativeTo(null);
				frame.pack();
				frame.setVisible(true);
			}
		});
        
        
    }
    public static void main(String[] args) {
        Newframe fr = new Newframe();
        fr.setVisible(true);
        
    }
}