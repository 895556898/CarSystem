

import java.awt.Color;
import java.awt.event.*;  
import javax.swing.*;    
public class ButtonExample {
    public static void main(String[] args) {
        JFrame f = new JFrame("Demo");
        final JTextField tf = new JTextField();
        tf.setBounds(50, 50, 150, 20);
        JButton b = new JButton("点击");
        b.setBounds(100, 100, 65, 30);
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tf.setText("按钮事件如此简单");
                tf.setBackground(Color.cyan);
            }
        });
        f.add(b);
        f.add(tf);
        f.setSize(300, 250);
        f.setLocationRelativeTo(null);
    f.setLayout(null);  
    f.setVisible(true);   
}  
}  