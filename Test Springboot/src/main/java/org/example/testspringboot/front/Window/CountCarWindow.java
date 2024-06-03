package org.example.testspringboot.front.Window;

import jakarta.annotation.Resource;
import org.example.testspringboot.dao.CarRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

//查询车辆信息
@Component
public class CountCarWindow extends JFrame{
    static JFrame window = new JFrame("车辆管理系统");

    @Resource
    private CarRepository carRepository;

    @Resource
    private ApplicationContext context;

    private void countWindow(JPanel panel) {

        //设置界面布局
        panel.setLayout(null);

        //设置标题字体对象
        Font font1 = new Font("黑体", Font.BOLD, 50);

        //设置标题
        JLabel title = new JLabel("车辆统计信息");

        //设置标题位置
        title.setBounds(20, 15, 500, 80);

        //设置标题格式
        title.setFont(font1);

        //添加标题
        panel.add(title);

        //显示按钮
        JButton searchButton = new JButton("显示");
        searchButton.setBounds(110, 180, 150, 50);
        searchButton.setFont(new Font("楷体", Font.BOLD, 25));
        panel.add(searchButton);

        ActionListener listener1 = e -> {
            long carSum = carRepository.count();
            long smallCarSum = carRepository.findAllByType("小轿车").size();
            long truckSum = carRepository.findAllByType("卡车").size();
            long busSum = carRepository.findAllByType("大巴车").size();
            CountResultWindow countResultWindow = new CountResultWindow(carSum,smallCarSum,truckSum,busSum);
            closeCountCarWindow();
            countResultWindow.showCountResultWindow();

        };
        searchButton.addActionListener(listener1);

        //返回按钮
        JButton backButton = new JButton("返回");
        backButton.setBounds(380, 180, 150, 50);
        backButton.setFont(new Font("楷体", Font.BOLD, 25));
        panel.add(backButton);

        ActionListener listener2 = e -> {
            //设置点击事件
            closeCountCarWindow();
            CarWindow carWindow = context.getBean(CarWindow.class);
            carWindow.showCarWindow();
        };
        backButton.addActionListener(listener2);
    }

    public CountCarWindow(ApplicationContext context) {

        this.context = context;

        //设置窗口在屏幕上的位置和大小
        window.setBounds(1,1,660,300);

        //设置窗口居中
        window.setLocationRelativeTo(null);

        //退出程序
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //创建面板
        JPanel panel = new JPanel();

        //添加面板
        window.add(panel);

        //调用自定义面板设置
        countWindow(panel);
    }

    public void showCountCarWindow(){
        window.setVisible(true);
    }

    public void closeCountCarWindow(){
        window.setVisible(false);
    }
}