
package Swing;

import java.awt.Color;
import javax.swing.JFrame;



 
public class graphics extends JFrame{

    
    public static void main(String[] args) {
        graphics frame = new graphics();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Graphics Design");
        frame.setBounds(50, 50, 500, 500);
       
        DrawingComponent DC = new DrawingComponent();
        frame.add(DC);
        
    }
}
