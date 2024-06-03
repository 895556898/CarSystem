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
public class ChangeCarWindow extends JFrame{
    static JFrame window = new JFrame("车辆管理系统");

    @Resource
    private CarRepository carRepository;

    @Resource
    private ApplicationContext context;

    private void changeWindow(JPanel panel) {

        //设置界面布局
        panel.setLayout(null);

        //设置标题字体对象
        Font font1 = new Font("黑体", Font.BOLD, 50);

        //设置标题
        JLabel title = new JLabel("编辑车辆信息");

        //设置标题位置
        title.setBounds(20, 15, 500, 80);

        //设置标题格式
        title.setFont(font1);

        //添加标题
        panel.add(title);

        //创建文本框字体
        Font font4 = new Font("楷体", Font.PLAIN, 20);

        //车辆编号标签
        JLabel deleteCarLabel = new JLabel("要编辑的车辆编号：");
        deleteCarLabel.setBounds(25, 110, 250, 35);
        deleteCarLabel.setFont(new Font("宋体", Font.BOLD, 25));
        panel.add(deleteCarLabel);

        //车辆编号文本框
        JTextField searchField = new JTextField(12);
        searchField.setBounds(290, 110, 300, 35);
        searchField.setFont(font4);
        panel.add(searchField);

        //编辑按钮
        JButton changeButton = new JButton("编辑");
        changeButton.setBounds(110, 180, 150, 50);
        changeButton.setFont(new Font("楷体", Font.BOLD, 25));
        panel.add(changeButton);

        ActionListener listener1 = e -> {
            String into = searchField.getText();
            if (into == null || into.trim().isEmpty()) {
                JOptionPane.showMessageDialog(window, "请输入车辆编号！", "错误", JOptionPane.ERROR_MESSAGE);
            }else {
                try{
                    long carId = Integer.parseInt(into);
                    ArrayList<Car> carArrayList = new ArrayList<>(carRepository.findAllById(carId));
                    if(!carArrayList.isEmpty()){
                        closeChangeCarWindow();
                        EditCarWindow editWindow;
                        editWindow = context.getBean(EditCarWindow.class);
                        editWindow.setCarId(carId);
                        editWindow.showEditCarWindow();
                    }else {
                        JOptionPane.showMessageDialog(window, "该编号不存在！", "错误", JOptionPane.ERROR_MESSAGE);
                    }
                }catch (NumberFormatException e1) {
                    JOptionPane.showMessageDialog(window, "请输入有效的车辆编号！", "错误", JOptionPane.ERROR_MESSAGE);
                }
            }
        };
        changeButton.addActionListener(listener1);

        //返回按钮
        JButton backButton = new JButton("返回");
        backButton.setBounds(380, 180, 150, 50);
        backButton.setFont(new Font("楷体", Font.BOLD, 25));
        panel.add(backButton);

        ActionListener listener2 = e -> {
            //设置点击事件
            closeChangeCarWindow();
            CarWindow carWindow = context.getBean(CarWindow.class);
            carWindow.showCarWindow();
        };
        backButton.addActionListener(listener2);

    }

    public ChangeCarWindow(ApplicationContext context) {

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
        changeWindow(panel);

    }

    public void closeChangeCarWindow(){
        window.setVisible(false);
    }

    public void showChangeCarWindow(){
        window.setVisible(true);
    }
}