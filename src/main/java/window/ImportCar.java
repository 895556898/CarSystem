package window;

import javax.swing.*;
import java.awt.*;


public class ImportCar {
    static JFrame window = new JFrame("车辆管理系统");

    public void importcar() {
        //创建一个车辆管理系统窗口


        //设置窗口在屏幕上的位置和大小
        window.setBounds(1,1,660,780);

        //设置窗口居中
        window.setLocationRelativeTo(null);

        //设置窗口可见
        window.setVisible(true);

        //退出程序
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //创建面板
        JPanel panel = new JPanel();

        //添加面板
        window.add(panel);

        //调用自定义面板设置
        new ImportCar().placeLogins(panel);


    }

    private void placeLogins(JPanel panel) {

        //设置界面布局
        panel.setLayout(null);

        //设置标题字体对象
        Font font1 = new Font("黑体", Font.BOLD, 70);

        //设置标题
        JLabel title = new JLabel("导入车辆信息");

        //设置标题位置
        title.setBounds(100, 40, 660, 90);

        //设置标题格式
        title.setFont(font1);

        //添加标题
        panel.add(title);
    }
}
