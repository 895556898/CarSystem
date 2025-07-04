package org.example.testspringboot.front.Window;

import jakarta.annotation.Resource;
import org.example.testspringboot.dao.Car;
import org.example.testspringboot.dao.CarRepository;
import org.example.testspringboot.front.Window.way.PlaceholderTextField;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

@Component
public class AddCarWindow extends JFrame{
    static JFrame window = new JFrame("车辆管理系统");

    @Resource
    private CarRepository carRepository;

    @Resource
    private ApplicationContext context;

    private void addWindow(JPanel panel) {

        //设置界面布局
        panel.setLayout(null);

        //设置标题字体对象
        Font font1 = new Font("黑体", Font.BOLD, 50);

        //设置标题
        JLabel title = new JLabel("添加车辆信息");

        //设置标题位置
        title.setBounds(20, 20, 500, 80);

        //设置标题格式
        title.setFont(font1);

        //添加标题
        panel.add(title);

        //创建提示字体
        Font font2 = new Font("宋体", Font.BOLD , 25);

        //创建按钮提示字体
        Font font3 = new Font("楷体", Font.BOLD, 27);

        //创建文本框字体
        Font font4 = new Font("楷体", Font.PLAIN, 20);

        //车辆编号标签
        JLabel carIdLabel = new JLabel("车辆编号：");
        carIdLabel.setBounds(100, 120, 180, 30);
        carIdLabel.setFont(font2);
        panel.add(carIdLabel);

        //车辆编号文本框
        JTextField carIdField = new JTextField(12);
        carIdField.setBounds(300, 120, 250, 30);
        carIdField.setFont(font4);
        panel.add(carIdField);

        //车牌号标签
        JLabel carNumberLabel = new JLabel("车牌号：");
        carNumberLabel.setBounds(100, 170, 150, 30);
        carNumberLabel.setFont(font2);
        panel.add(carNumberLabel);

        //车牌号文本框
        JTextField carNumberField = new JTextField(12);
        carNumberField.setBounds(300, 170, 250, 30);
        carNumberField.setFont(font4);
        panel.add(carNumberField);

        //制造公司标签
        JLabel carCompanyLabel = new JLabel("制造公司：");
        carCompanyLabel.setBounds(100, 220, 150, 30);
        carCompanyLabel.setFont(font2);
        panel.add(carCompanyLabel);

        //制造公司文本框
        JTextField carCompanyField = new JTextField(12);
        carCompanyField.setBounds(300, 220, 250, 30);
        carCompanyField.setFont(font4);
        panel.add(carCompanyField);

        //购买时间标签
        JLabel carBuyTimeLabel = new JLabel("购买时间：");
        carBuyTimeLabel.setBounds(100, 270, 180, 30);
        carBuyTimeLabel.setFont(font2);
        panel.add(carBuyTimeLabel);

        //购买时间文本框!!!!!!!!!!!!!!!!!!!!!!!!
        PlaceholderTextField carBuyTimeField = new PlaceholderTextField(12);
        carBuyTimeField.setBounds(300, 270, 250, 30);
        carBuyTimeField.setFont(font4);
        carBuyTimeField.setPlaceholder("yyyy-MM-dd");
        panel.add(carBuyTimeField);

        //车辆类型标签
        JLabel carTypeLabel = new JLabel("车辆类型：");
        carTypeLabel.setBounds(100, 320, 150, 30);
        carTypeLabel.setFont(font2);
        panel.add(carTypeLabel);

        //车辆类型列表框
        String [] cartypelist = {
                "小轿车","卡车","大巴车"
        };
        JComboBox<String> cartypeComboBox = new JComboBox<>(cartypelist);
        cartypeComboBox.setBounds(300, 320, 250, 30);
        cartypeComboBox.setFont(font4);
        panel.add(cartypeComboBox);

        //车辆总公里标签
        JLabel carTotal_km_Label = new JLabel("总公里：");
        carTotal_km_Label.setBounds(100, 370, 180, 30);
        carTotal_km_Label.setFont(font2);
        panel.add(carTotal_km_Label);

        //车辆总公里文本框
        JTextField carTotal_km_Field = new JTextField(12);
        carTotal_km_Field.setBounds(300, 370, 250, 30);
        carTotal_km_Field.setFont(font4);
        panel.add(carTotal_km_Field);

        //每公里耗油量标签
        JLabel carCostOilLabel = new JLabel("耗油量/公里：");
        carCostOilLabel.setBounds(100, 420, 180, 30);
        carCostOilLabel.setFont(font2);
        panel.add(carCostOilLabel);

        //每公里耗油量文本框
        JTextField carCostOilField = new JTextField(12);
        carCostOilField.setBounds(300, 420, 250, 30);
        carCostOilField.setFont(font4);
        panel.add(carCostOilField);

        //基本维护费用标签
        JLabel basicMaintenanceCostLabel = new JLabel("基本维护费：");
        basicMaintenanceCostLabel.setBounds(100, 470, 180, 30);
        basicMaintenanceCostLabel.setFont(font2);
        panel.add(basicMaintenanceCostLabel);

        //基本维护费用文本框
        JTextField basicMaintenanceCostField = new JTextField(12);
        basicMaintenanceCostField.setBounds(300, 470, 250, 30);
        basicMaintenanceCostField.setFont(font4);
        basicMaintenanceCostField.setEditable(false); // 设置为不可编辑
        panel.add(basicMaintenanceCostField);

        //养路费标签
        JLabel carRoadTollLabel = new JLabel("养路费：");
        carRoadTollLabel.setBounds(100, 520, 180, 30);
        carRoadTollLabel.setFont(font2);
        panel.add(carRoadTollLabel);

        //养路费文本框
        JTextField carRoadTollField = new JTextField(12);
        carRoadTollField.setBounds(300, 520, 250, 30);
        carRoadTollField.setFont(font4);
        panel.add(carRoadTollField);

        //用户选择好车辆类型后自动填充车辆基本维护费用
        cartypeComboBox.addActionListener(e -> {
            String carType = (String) cartypeComboBox.getSelectedItem();
            if("小轿车".equals(carType)){
                basicMaintenanceCostField.setText("1000");
            }
            else if("卡车".equals(carType)){
                basicMaintenanceCostField.setText("1500");
            }
            else if ("大巴车".equals(carType)) {
                basicMaintenanceCostField.setText("2000");
            }
        });

        //录入按钮
        JButton enterButton = new JButton("录入");          //定义按钮对象
        enterButton.setBounds(180, 600, 90, 40);
        enterButton.setFont(font3);
        panel.add(enterButton);

        //点击录入按钮进行事件
        ActionListener listener1 = e -> {
            //设置点击事件
            long id = Integer.parseInt(carIdField.getText());
            ArrayList<Car> carArrayList = new ArrayList<>(carRepository.findAllById(id));
            if(carArrayList.isEmpty()){
                try{
                    String Number = carNumberField.getText();

                    String Company = carCompanyField.getText();

                    //格式化输入文本为时间yyyy-MM-dd
                    SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
                    java.util.Date TestTime =  date.parse(carBuyTimeField.getText());
                    java.sql.Date BuyTime = new java.sql.Date(TestTime.getTime());

                    String Type = (String) cartypeComboBox.getSelectedItem();

                    BigDecimal Total_Km = new BigDecimal(carTotal_km_Field.getText());

                    BigDecimal CostOil = new BigDecimal(carCostOilField.getText());

                    int basicMaintenanceCost = Integer.parseInt(basicMaintenanceCostField.getText());

                    BigDecimal RoadToll = new BigDecimal(carRoadTollField.getText());

                    Car car = new Car(id,Number,Company,BuyTime,Type,Total_Km,CostOil,basicMaintenanceCost,RoadToll);

                    carRepository.save(car);

                    System.out.println("车辆信息已添加，车辆编号为：" + id);

                } catch (ParseException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(window, "日期格式错误，请输入yyyy-MM-dd格式的日期。", "错误", JOptionPane.ERROR_MESSAGE);
                } catch (NumberFormatException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(window, "请输入正确的数字格式。", "错误", JOptionPane.ERROR_MESSAGE);
                }
                /* 为什么需要 try-catch：
                用户输入不可控：用户输入的数据可能不符合预期的格式。为了保证程序的稳定性和健壮性，捕获异常是必要的。
                防止程序崩溃：如果不处理这些异常，当用户输入无效数据时，程序会崩溃，导致用户体验不佳。
                提供友好的反馈：通过捕获异常，可以向用户提供友好的错误提示，帮助他们纠正输入错误。*/
            }else {
                //报错信息
                JOptionPane.showMessageDialog(window, "数据添加重复！", "错误", JOptionPane.ERROR_MESSAGE);
            }

        };
        enterButton.addActionListener(listener1);

        //返回按钮
        JButton closeButton = new JButton("返回");
        closeButton.setBounds(380, 600, 90, 40);
        closeButton.setFont(font3);
        panel.add(closeButton);

        ActionListener listener2 = e -> {

            closeAddCarWindow();
            CarWindow carWindow = context.getBean(CarWindow.class);
            carWindow.showCarWindow();
        };
        closeButton.addActionListener(listener2);
    }

    public AddCarWindow(ApplicationContext context) {

        this.context = context;

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
        addWindow(panel);
    }

    public void showAddCarWindow() {
        window.setVisible(true);
    }

    public void closeAddCarWindow() {
        window.setVisible(false);
    }
}