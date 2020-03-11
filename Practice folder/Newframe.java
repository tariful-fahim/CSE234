
package Swing;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class Newframe extends JFrame{
    private Container c;
    private JLabel lbl;
    private JButton bt;
    Newframe(){
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        this.setBounds(50, 20, 450, 500);
        
        this.setTitle("NEW frame");
        
        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.red);
        
        lbl = new JLabel("Hello Everyone to the new Frame");
        lbl.setBounds(20, 20, 300, 50);
        c.add(lbl);
        
        bt = new JButton("Play Maze Game");
        bt.setBounds(30, 30, 200, 200);
        c.add(bt);
        bt.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                graphics frame = new graphics();
                frame.setVisible(true);
                
            }
        });
        
        
        
    }
    public static void main(String[] args) {
        Newframe fr = new Newframe();
        fr.setVisible(true);
        
    }
}
