/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Swing;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TimerTask;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.util.Timer;
import javax.swing.JTextField;
import java.awt.Font;

/**
 *
 * @author fahim
 */
public class timer extends JFrame{
     //private Container c;
    JButton startTimer;
    JLabel msg, display;
    JTextField tf;
    Timer t;
     Font f;
    timer(){
        startTimer = new JButton("Start the Timer");
        display = new JLabel();
        msg = new JLabel("Enter the countdown time");
        tf = new JTextField();
         f = new Font("Arial",color.BOLD, 14)
        setLayout(null);
        add(startTimer);
        add(display);
        add(msg);
        add(tf);
        msg.setBounds(100, 100, 200, 30);
        startTimer.setBounds(400, 100, 150, 30);
        display.setBounds(200, 400, 50, 50);
        tf.setBounds(300, 100, 50, 50);
        display.setFont(f);
        startTimer.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                
                t = new Timer();
                t.scheduleAtFixedRate(new TimerTask(){
                    int i = Integer.parseInt(tf.getText());
                    @Override
                    public void run() {
                        
                        display.setText(""+(i--));
                        if(i < 0)
                            t.cancel();
                    }
                }, 0, 1000);
            }
        });
        
        
    }
    
    public static void main(String[] args) {
        timer frame = new timer();
        frame.setVisible(true);
        frame.setTitle("Timer");
        frame.setLocationRelativeTo(null);
        frame.setSize(800, 800);
    }
}
