// package com.yiibai.swing;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SwingButton {
   private JFrame mainFrame;
   private JLabel headerLabel;
   private JLabel statusLabel;
   private JPanel controlPanel;

   public SwingButton(){
      prepareGUI();
   }
   public static void main(String[] args){
       SwingButton  swingControlDemo = new SwingButton();      
      swingControlDemo.showButtonDemo();
   }
   private void prepareGUI(){
      mainFrame = new JFrame("Java Swing JButton示例");
      mainFrame.setSize(400,400);
      mainFrame.setLayout(new GridLayout(3, 1));

      mainFrame.addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent windowEvent){
            System.exit(0);
         }        
      });    
      headerLabel = new JLabel("", JLabel.CENTER);        
      statusLabel = new JLabel("",JLabel.CENTER);    
      statusLabel.setSize(350,100);

      controlPanel = new JPanel();
      controlPanel.setLayout(new FlowLayout());

      mainFrame.add(headerLabel);
      mainFrame.add(controlPanel);
      mainFrame.add(statusLabel);
      mainFrame.setVisible(true);  
   }
   private static ImageIcon createImageIcon(String path, String description) {
      java.net.URL imgURL = SwingButton.class.getResource(path);
      if (imgURL != null) {
         return new ImageIcon(imgURL, description);
      } else {            
         System.err.println("Couldn't find file: " + path);
         return null;
      }
   }   
   private void showButtonDemo(){
      headerLabel.setText("Control in action: Button"); 

      //resources folder should be inside SWING folder.
      ImageIcon icon = createImageIcon("/resources/java_icon.jpg","Java");

      JButton okButton = new JButton("好了");        
      JButton javaButton = new JButton("提交", icon);
      JButton cancelButton = new JButton("取消", icon);
      cancelButton.setHorizontalTextPosition(SwingConstants.LEFT);   

      okButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            statusLabel.setText("'好了'按钮提交");
         }          
      });
      javaButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            statusLabel.setText("'提交'按钮提交");
         }
      });
      cancelButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            statusLabel.setText("'取消'按钮提交");
         }
      });
      controlPanel.add(okButton);
      controlPanel.add(javaButton);
      controlPanel.add(cancelButton);       

      mainFrame.setVisible(true);  
   }
}
//更多请阅读：https://www.yiibai.com/swing/swing_jbutton.html

