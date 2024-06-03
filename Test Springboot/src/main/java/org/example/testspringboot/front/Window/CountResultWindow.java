package org.example.testspringboot.front.Window;

import javax.swing.*;
import java.awt.*;

public class CountResultWindow {

    static JFrame window = new JFrame("查询结果");

    public CountResultWindow(long carSum, long smallCarSum, long truckSum, long busSum) {
        window.setBounds(1,1,660,410);

        //设置窗口居中
        window.setLocationRelativeTo(null);

        //退出程序
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();

        window.add(panel);

        placeResult(panel,carSum,smallCarSum,truckSum,busSum);
    }

    private void placeResult(JPanel panel,long carSum, long smallCarSum, long truckSum, long busSum) {
        panel.setLayout(null);

        //设置标题字体对象
        Font font1 = new Font("黑体",Font.BOLD,70);

        //设置标题
        JLabel title = new JLabel("统计结果");

        //设置标题位置
        title.setBounds(30,20,400,70);

        //设置标题格式
        title.setFont(font1);

        //添加标题
        panel.add(title);

        //创建提示字体
        Font font2 = new Font("宋体", Font.BOLD , 25);

        //创建文本框字体
        Font font3 = new Font("楷体", Font.PLAIN, 25);

        //库中车辆总数标签
        JLabel carSumLabel = new JLabel("库中车辆总数：");
        carSumLabel.setBounds(100, 120, 180, 30);
        carSumLabel.setFont(font2);
        panel.add(carSumLabel);

        //库中车辆总数文本框
        JTextField carSumField = new JTextField(12);
        carSumField.setBounds(300, 120, 250, 30);
        carSumField.setFont(font3);
        carSumField.setText(String.valueOf(carSum));
        carSumField.setEditable(false); // 设置为不可编辑
        panel.add(carSumField);

        //小轿车车辆总数
        JLabel smallCarSumLabel = new JLabel("小轿车总数：");
        smallCarSumLabel.setBounds(100, 170, 180, 30);
        smallCarSumLabel.setFont(font2);
        panel.add(smallCarSumLabel);

        JTextField smallCarSumField = new JTextField(12);
        smallCarSumField.setBounds(300, 170, 250, 30);
        smallCarSumField.setFont(font3);
        smallCarSumField.setText(String.valueOf(smallCarSum));
        smallCarSumField.setEditable(false);
        panel.add(smallCarSumField);

        //卡车车辆总数
        JLabel truckCarSumLabel = new JLabel("卡车总数：");
        truckCarSumLabel.setBounds(100, 220, 180, 30);
        truckCarSumLabel.setFont(font2);
        panel.add(truckCarSumLabel);

        JTextField truckCarSumField = new JTextField(12);
        truckCarSumField.setBounds(300, 220, 250, 30);
        truckCarSumField.setFont(font3);
        truckCarSumField.setText(String.valueOf(truckSum));
        truckCarSumField.setEditable(false);
        panel.add(truckCarSumField);

        //大巴车车辆总数
        JLabel busCarSumLabel = new JLabel("大巴车总数：");
        busCarSumLabel.setBounds(100, 270, 180, 30);
        busCarSumLabel.setFont(font2);
        panel.add(busCarSumLabel);

        JTextField busCarSumField = new JTextField(12);
        busCarSumField.setBounds(300, 270, 250, 30);
        busCarSumField.setFont(font3);
        busCarSumField.setText(String.valueOf(busSum));
        busCarSumField.setEditable(false);
        panel.add(busCarSumField);
    }

    public void showCountResultWindow(){
        window.setVisible(true);
    }
}