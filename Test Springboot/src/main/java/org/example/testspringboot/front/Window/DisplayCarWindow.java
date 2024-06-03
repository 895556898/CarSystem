package org.example.testspringboot.front.Window;

import jakarta.annotation.Resource;
import org.example.testspringboot.dao.Car;
import org.example.testspringboot.dao.CarRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

//查询车辆信息
@Component
public class DisplayCarWindow extends JFrame{
    static JFrame window = new JFrame("车辆管理系统");

    @Resource
    private CarRepository carRepository;

    @Resource
    private ApplicationContext context;

    private void displayWindow(JPanel panel) {

        //设置界面布局
        panel.setLayout(null);

        //设置标题字体对象
        Font font1 = new Font("黑体", Font.BOLD, 60);

        //设置标题
        JLabel title = new JLabel("查询车辆信息");

        //设置标题位置
        title.setBounds(20, 15, 500, 80);

        //设置标题格式
        title.setFont(font1);

        //添加标题
        panel.add(title);

        //查询按钮
        JButton searchButton = new JButton("查询");
        searchButton.setBounds(110, 135, 150, 90);
        searchButton.setFont(new Font("楷体", Font.BOLD, 50));
        panel.add(searchButton);

        ActionListener listener1 = e -> {
            ArrayList<Car> carArrayList = new ArrayList<>(carRepository.findAll());
            //结果展示UI界面
            SearchResultWindow searchResultWindow = new SearchResultWindow(carArrayList);
            searchResultWindow.showSearchResultWindow();
            showDisplayCarWindow();
        };
        searchButton.addActionListener(listener1);

        //返回按钮
        JButton backButton = new JButton("返回");
        backButton.setBounds(380, 135, 150, 90);
        backButton.setFont(new Font("楷体", Font.BOLD, 50));
        panel.add(backButton);

        ActionListener listener2 = e -> {
            //设置点击事件
            ArrayList<Car> carArrayList = new ArrayList<>(carRepository.findAll());
            SearchResultWindow searchResultWindow = new SearchResultWindow(carArrayList);
            searchResultWindow.closeSearchResultWindow();
            closeDisplayCarWindow();
            CarWindow carWindow = context.getBean(CarWindow.class);
            carWindow.showCarWindow();
        };
        backButton.addActionListener(listener2);
    }

    public DisplayCarWindow(ApplicationContext context) {

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
        displayWindow(panel);

    }

    public void showDisplayCarWindow(){
        window.setVisible(true);
    }

    public void closeDisplayCarWindow(){
        window.setVisible(false);
    }
}