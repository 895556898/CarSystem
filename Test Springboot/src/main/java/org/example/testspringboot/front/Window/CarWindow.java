package org.example.testspringboot.front.Window;

import jakarta.annotation.Resource;
import org.example.testspringboot.dao.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@Component
public class CarWindow {

	static JFrame window = new JFrame("车辆管理系统");

	@Resource
	private ApplicationContext context;
    @Autowired
    private CarRepository carRepository;

	private void placeLogins(JPanel panel) {

		//设置界面布局
		panel.setLayout(null);

		//设置标题字体对象
		Font font1 = new Font("黑体",Font.BOLD,70);

		//设置标题
		JLabel title = new JLabel("车辆管理系统");

		//设置标题位置
		title.setBounds(100,40,660,90);

		//设置标题格式
		title.setFont(font1);

		//添加标题
		panel.add(title);

		//设置按钮字体对象
		Font font2 = new Font("黑体",Font.BOLD,20);

		// 创建功能按钮

			//第一行
			JButton loginButton1 = new JButton("添加车辆信息");
			loginButton1.setFont(font2);
			loginButton1.setBounds(80, 180, 200, 60);
			panel.add(loginButton1);

			JButton loginButton2 = new JButton("查询车辆信息");
			loginButton2.setFont(font2);
			loginButton2.setBounds(360, 180, 200, 60);
			panel.add(loginButton2);


			//第二行
			JButton loginButton3 = new JButton("显示库中车辆信息");
			loginButton3.setFont(font2);
			loginButton3.setBounds(80, 300, 200, 60);
			panel.add(loginButton3);

			JButton loginButton4 = new JButton("编辑库中车辆信息");
			loginButton4.setFont(font2);
			loginButton4.setBounds(360, 300, 200, 60);
			panel.add(loginButton4);


			//第三行
			JButton loginButton5 = new JButton("删除车辆信息");
			loginButton5.setFont(font2);
			loginButton5.setBounds(80, 420, 200, 60);
			panel.add(loginButton5);

			JButton loginButton6 = new JButton("车辆统计信息");
			loginButton6.setFont(font2);
			loginButton6.setBounds(360, 420, 200, 60);
			panel.add(loginButton6);

			//第四行
			JButton loginButton7 = new JButton("车辆信息导出");
			loginButton7.setFont(font2);
			loginButton7.setBounds(80, 540, 200, 60);
			panel.add(loginButton7);

			JButton loginButton8 = new JButton("车辆信息导入");
			loginButton8.setFont(font2);
			loginButton8.setBounds(360, 540, 200, 60);
			panel.add(loginButton8);

		//创建事件监听器
		ActionListener listener1 = e -> {
            //设置点击事件
            closeCarWindow();

            AddCarWindow addCarWindow = context.getBean(AddCarWindow.class);
            addCarWindow.showAddCarWindow();
        };
		ActionListener listener2 = e -> {
            //设置点击事件
            closeCarWindow();

            SelectCarWindow selectCarWindow = context.getBean(SelectCarWindow.class);
            selectCarWindow.showSelectCarWindow();
        };
		ActionListener listener3 = e -> {
            //设置点击事件
            closeCarWindow();

            DisplayCarWindow displayCarWindow = context.getBean(DisplayCarWindow.class);
            displayCarWindow.showDisplayCarWindow();
        };
		ActionListener listener4 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//设置点击事件
				closeCarWindow();

				ChangeCarWindow changeCarWindow = context.getBean(ChangeCarWindow.class);
				changeCarWindow.showChangeCarWindow();
			}
		};
		ActionListener listener5 = e -> {
            closeCarWindow();

            DeleteCarWindow deleteCarWindow = context.getBean(DeleteCarWindow.class);
            deleteCarWindow.showDeleteCarWindow();
        };
		ActionListener listener6 = e -> {
			closeCarWindow();

            CountCarWindow countCarWindow;
            countCarWindow = context.getBean(CountCarWindow.class);
            countCarWindow.showCountCarWindow();
        };
		ActionListener listener7 = e -> {
            closeCarWindow();

            ExportCarWindow exportCarWindow = context.getBean(ExportCarWindow.class);
			exportCarWindow.showExportCarWindow();
        };
		ActionListener listener8 = e -> {
            closeCarWindow();
			ImportCarWindow importCarWindow = context.getBean(ImportCarWindow.class);
			importCarWindow.showImportCarWindow();
        };

		loginButton1.addActionListener(listener1);
		loginButton2.addActionListener(listener2);
		loginButton3.addActionListener(listener3);
		loginButton4.addActionListener(listener4);
		loginButton5.addActionListener(listener5);
		loginButton6.addActionListener(listener6);
		loginButton7.addActionListener(listener7);
		loginButton8.addActionListener(listener8);
	}

	public CarWindow(ApplicationContext context) {

		this.context = context;
		//创建一个车辆管理系统窗口

		//设置窗口在屏幕上的位置和大小
		window.setBounds(1,1,660,780);

		//设置窗口居中
		window.setLocationRelativeTo(null);

		//退出程序
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//创建面板
		JPanel panel = new JPanel();

		//添加面板
		window.add(panel);

		//调用自定义面板设置
		placeLogins(panel);

	}

	public void showCarWindow() {
		window.setVisible(true);
	}

	public void closeCarWindow(){
		window.setVisible(false);
	}
}