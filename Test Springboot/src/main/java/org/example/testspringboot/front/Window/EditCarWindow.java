package org.example.testspringboot.front.Window;

import jakarta.annotation.Resource;
import lombok.Setter;
import org.example.testspringboot.dao.Car;
import org.example.testspringboot.dao.CarRepository;
import org.example.testspringboot.front.Window.way.PlaceholderTextField;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Optional;

@Component
public class EditCarWindow extends JFrame {
    static JFrame window = new JFrame("车辆信息编辑");
    @Setter
    private long carId;

    @Resource
    private CarRepository carRepository;

    @Resource
    private ApplicationContext context;

    public void showEditCarWindow() {
        window.setVisible(true);
        loadCarDetails();
    }

    public void closeEditCarWindow() {
        window.setVisible(false);
    }

    private void loadCarDetails() {
        Optional<Car> carOpt = carRepository.findById(carId);
        if (carOpt.isPresent()) {
            Car car = carOpt.get();
            carIdField.setText(String.valueOf(car.getId()));
            carNumberField.setText(car.getNumber());
            carCompanyField.setText(car.getCompany());
            carBuyTimeField.setText(new SimpleDateFormat("yyyy-MM-dd").format(car.getBuyTime()));
            cartypeComboBox.setSelectedItem(car.getType());
            carTotal_km_Field.setText(car.getTotalKm().toString());
            carCostOilField.setText(car.getCostOil().toString());
            basicMaintenanceCostField.setText(String.valueOf(car.getBasicMaintenanceCost()));
            carRoadTollField.setText(car.getRoadToll().toString());
        } else {
            JOptionPane.showMessageDialog(window, "车辆信息加载失败！", "错误", JOptionPane.ERROR_MESSAGE);
        }
    }

    private JTextField carIdField;
    private JTextField carNumberField;
    private JTextField carCompanyField;
    private PlaceholderTextField carBuyTimeField;
    private JComboBox<String> cartypeComboBox;
    private JTextField carTotal_km_Field;
    private JTextField carCostOilField;
    private JTextField basicMaintenanceCostField;
    private JTextField carRoadTollField;

    private void editWindow(JPanel panel) {
        //设置界面布局
        panel.setLayout(null);

        //设置标题字体对象
        Font font1 = new Font("黑体", Font.BOLD, 50);

        //设置标题
        JLabel title = new JLabel("编辑车辆信息");

        //设置标题位置
        title.setBounds(20, 20, 500, 80);

        //设置标题格式
        title.setFont(font1);

        //添加标题
        panel.add(title);

        //创建提示字体
        Font font2 = new Font("宋体", Font.BOLD, 25);

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
        carIdField = new JTextField(12);
        carIdField.setBounds(300, 120, 250, 30);
        carIdField.setFont(font4);
        carIdField.setEditable(false); // 设置为不可编辑
        panel.add(carIdField);

        //车牌号标签
        JLabel carNumberLabel = new JLabel("车牌号：");
        carNumberLabel.setBounds(100, 170, 150, 30);
        carNumberLabel.setFont(font2);
        panel.add(carNumberLabel);

        //车牌号文本框
        carNumberField = new JTextField(12);
        carNumberField.setBounds(300, 170, 250, 30);
        carNumberField.setFont(font4);
        panel.add(carNumberField);

        //制造公司标签
        JLabel carCompanyLabel = new JLabel("制造公司：");
        carCompanyLabel.setBounds(100, 220, 150, 30);
        carCompanyLabel.setFont(font2);
        panel.add(carCompanyLabel);

        //制造公司文本框
        carCompanyField = new JTextField(12);
        carCompanyField.setBounds(300, 220, 250, 30);
        carCompanyField.setFont(font4);
        panel.add(carCompanyField);

        //购买时间标签
        JLabel carBuyTimeLabel = new JLabel("购买时间：");
        carBuyTimeLabel.setBounds(100, 270, 180, 30);
        carBuyTimeLabel.setFont(font2);
        panel.add(carBuyTimeLabel);

        //购买时间文本框
        carBuyTimeField = new PlaceholderTextField(12);
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
        cartypeComboBox = new JComboBox<>(new String[]{"小轿车", "卡车", "大巴车"});
        cartypeComboBox.setBounds(300, 320, 250, 30);
        cartypeComboBox.setFont(font4);
        panel.add(cartypeComboBox);

        //车辆总公里标签
        JLabel carTotalKmLabel = new JLabel("总公里：");
        carTotalKmLabel.setBounds(100, 370, 180, 30);
        carTotalKmLabel.setFont(font2);
        panel.add(carTotalKmLabel);

        //车辆总公里文本框
        carTotal_km_Field = new JTextField(12);
        carTotal_km_Field.setBounds(300, 370, 250, 30);
        carTotal_km_Field.setFont(font4);
        panel.add(carTotal_km_Field);

        //每公里耗油量标签
        JLabel carCostOilLabel = new JLabel("耗油量/公里：");
        carCostOilLabel.setBounds(100, 420, 180, 30);
        carCostOilLabel.setFont(font2);
        panel.add(carCostOilLabel);

        //每公里耗油量文本框
        carCostOilField = new JTextField(12);
        carCostOilField.setBounds(300, 420, 250, 30);
        carCostOilField.setFont(font4);
        panel.add(carCostOilField);

        //基本维护费用标签
        JLabel basicMaintenanceCostLabel = new JLabel("基本维护费：");
        basicMaintenanceCostLabel.setBounds(100, 470, 180, 30);
        basicMaintenanceCostLabel.setFont(font2);
        panel.add(basicMaintenanceCostLabel);

        //基本维护费用文本框
        basicMaintenanceCostField = new JTextField(12);
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
        carRoadTollField = new JTextField(12);
        carRoadTollField.setBounds(300, 520, 250, 30);
        carRoadTollField.setFont(font4);
        panel.add(carRoadTollField);

        // 更新按钮
        JButton updateButton = new JButton("更新");
        updateButton.setBounds(150, 580, 100, 50);
        updateButton.setFont(new Font("楷体", Font.BOLD, 25));
        panel.add(updateButton);

        // 返回按钮
        JButton backButton = new JButton("返回");
        backButton.setBounds(280, 580, 100, 50);
        backButton.setFont(new Font("楷体", Font.BOLD, 25));
        panel.add(backButton);

        updateButton.addActionListener(e -> updateCarDetails());

        backButton.addActionListener(e -> {
            closeEditCarWindow();
            ChangeCarWindow changeCarWindow = context.getBean(ChangeCarWindow.class);
            changeCarWindow.showChangeCarWindow();
        });

        add(panel);
    }

    private void updateCarDetails() {
        try {
            long id = Integer.parseInt(carIdField.getText());

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

            JOptionPane.showMessageDialog(window, "车辆信息更新成功！", "更新成功", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(window, "更新失败：" + ex.getMessage(), "错误", JOptionPane.ERROR_MESSAGE);
        }
    }

    public EditCarWindow(ApplicationContext context) {
        this.context = context;

        //设置窗口在屏幕上的位置和大小
        window.setBounds(1,1,660,780);

        //设置窗口居中
        window.setLocationRelativeTo(null);

        //退出程序
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //创建面板
        JPanel panel = new JPanel();

        //调用自定义面板设置
        editWindow(panel);

        window.add(panel);
    }
}