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
public class SelectCarWindow extends JFrame{
    static JFrame window = new JFrame("车辆管理系统");

    @Resource
    private CarRepository carRepository;

    @Resource
    private ApplicationContext context;

    private void selectWindow(JPanel panel) {

        //设置界面布局
        panel.setLayout(null);

        //设置标题字体对象
        Font font1 = new Font("黑体", Font.BOLD, 50);

        //设置标题
        JLabel title = new JLabel("查询车辆信息");

        //设置标题位置
        title.setBounds(20, 15, 500, 80);

        //设置标题格式
        title.setFont(font1);

        //添加标题
        panel.add(title);

        //创建文本框字体
        Font font4 = new Font("楷体", Font.PLAIN, 20);

        //查询方式列表框
        String [] searchtypelist = {
                "按编号查询","按车辆制造公司查询","按类别查询"
        };
        JComboBox<String> searchtypeComboBox = new JComboBox<>(searchtypelist);
        searchtypeComboBox.setBounds(20, 110, 210, 35);
        searchtypeComboBox.setFont(font4);
        panel.add(searchtypeComboBox);

        //查询内容文本框
        JTextField searchField = new JTextField(12);
        searchField.setBounds(250, 110, 350, 35);
        searchField.setFont(font4);
        panel.add(searchField);

        //查询按钮
        JButton searchButton = new JButton("查询");
        searchButton.setBounds(110, 180, 150, 50);
        searchButton.setFont(new Font("楷体", Font.BOLD, 20));
        panel.add(searchButton);

        ActionListener listener1 = e -> {
            String selectType = (String) searchtypeComboBox.getSelectedItem();
            if("按编号查询".equals(selectType)){
                long carId = Integer.parseInt(searchField.getText());
                ArrayList<Car> carArrayList = new ArrayList<>(carRepository.findAllById(carId));
                if(!carArrayList.isEmpty()){
                    closeSelectCarWindow();
                    //结果展示UI界面
                    SearchResultWindow searchResultWindow = new SearchResultWindow(carArrayList);
                    searchResultWindow.showSearchResultWindow();
                }else {
                    // 报错信息
                    JOptionPane.showMessageDialog(window, "该编号不存在！", "错误", JOptionPane.ERROR_MESSAGE);
                }

            } else if ("按车辆制造公司查询".equals(selectType)) {
                String carCompany = searchField.getText();
                ArrayList<Car> carArrayList = new ArrayList<>(carRepository.findAllByCompany(carCompany));
                if(!carArrayList.isEmpty()){
                    closeSelectCarWindow();
                    //结果展示UI界面
                    SearchResultWindow searchResultWindow = new SearchResultWindow(carArrayList);
                    searchResultWindow.showSearchResultWindow();
                }else {
                    // 报错信息
                    JOptionPane.showMessageDialog(window, "未找到该制造公司的车辆！", "错误", JOptionPane.ERROR_MESSAGE);
                }

            } else if ("按类别查询".equals(selectType)) {
                String carType = searchField.getText();
                ArrayList<Car> carArrayList = new ArrayList<>(carRepository.findAllByType(carType));
                if(!carArrayList.isEmpty()){
                    closeSelectCarWindow();
                    SearchResultWindow searchResultWindow = new SearchResultWindow(carArrayList);
                    searchResultWindow.showSearchResultWindow();
                }else {
                    // 报错信息
                    JOptionPane.showMessageDialog(window, "未找到该类别的车辆！", "错误", JOptionPane.ERROR_MESSAGE);
                }
            }
        };
        searchButton.addActionListener(listener1);

        //返回按钮
        JButton backButton = new JButton("返回");
        backButton.setBounds(380, 180, 150, 50);
        backButton.setFont(new Font("楷体", Font.BOLD, 20));
        panel.add(backButton);

        ActionListener listener2 = e -> {
            //设置点击事件
            closeSelectCarWindow();
            CarWindow carWindow = context.getBean(CarWindow.class);
            carWindow.showCarWindow();
        };
        backButton.addActionListener(listener2);
    }

    public SelectCarWindow(ApplicationContext context) {

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
        selectWindow(panel);
    }

    public void showSelectCarWindow(){
        window.setVisible(true);
    }

    public void closeSelectCarWindow(){
        window.setVisible(false);
    }
}