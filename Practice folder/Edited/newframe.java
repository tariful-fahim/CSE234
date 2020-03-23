import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


class Newframe extends JFrame{
    private Container c;
    //private JLabel lbl;
    private JButton bt;
    Newframe(){
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        this.setBounds(0, 0, 850, 665);
        this.setLocationRelativeTo(null);
        this.setTitle("~~~CRAZY MAZE GAME~~~");
        
        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.BLACK);
        
        
        
        bt = new JButton("Play Again");
        bt.setBounds(300, 200, 200, 200);
        c.add(bt);
        bt.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                level_3 frame = new level_3();
                frame.setVisible(true);
		        frame.setBounds(0, 0, 850, 665);
				frame.setLocationRelativeTo(null);
		        frame.setTitle("Escape Maze - Level 3");
                
            }
        });
        
        
        
    }
    public static void main(String[] args) {
        Newframe fr = new Newframe();
        fr.setVisible(true);
        
    }
}