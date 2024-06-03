package org.example.testspringboot.front.Window;

import org.example.testspringboot.dao.Car;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class SearchResultWindow {

    static JFrame window = new JFrame("查询结果");

    public SearchResultWindow(ArrayList<Car> carArrayList) {
        window.setBounds(1,1,1400,800);

        //设置窗口居中
        window.setLocationRelativeTo(null);

        //退出程序
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();

        window.add(panel);

        placeResult(panel,carArrayList);
    }

    private void placeResult(JPanel panel,ArrayList<Car> carArrayList) {
        panel.setLayout(null);

        //设置标题字体对象
        Font font1 = new Font("黑体",Font.BOLD,70);

        //设置标题
        JLabel title = new JLabel("查询结果");

        //设置标题位置
        title.setBounds(30,20,400,70);

        //设置标题格式
        title.setFont(font1);

        //添加标题
        panel.add(title);

        //结果显示区
        JTable table = getjTable(carArrayList);

        // 设置表头字体
        table.getTableHeader().setFont(new Font("楷体", Font.BOLD, 20));

        // 设置表格字体
        table.setFont(new Font("楷体", Font.PLAIN, 18));

        // 设置行高
        table.setRowHeight(30);

        // 居中显示单元格内容
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

        // 创建滚动面板，包含表格
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(30, 100, 1300, 600);
        panel.add(scrollPane);
    }

    private static JTable getjTable(ArrayList<Car> carArrayList) {
        String[] columnNames = {"编号", "车牌号", "制造公司", "购买时间", "车辆型号", "总公里", "耗油量/公里", "基本维护费用", "养路费", "总费用"};

        // 创建表格模型
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        // 填充数据
        for (Car car : carArrayList) {
            Object[] row = new Object[]{
                    car.getId(),
                    car.getNumber(),
                    car.getCompany(),
                    car.getBuyTime(),
                    car.getType(),
                    car.getTotalKm(),
                    car.getCostOil(),
                    car.getBasicMaintenanceCost(),
                    car.getRoadToll(),
                    car.getAllCost()
            };
            model.addRow(row);
        }
        return new JTable(model);
    }

    public void showSearchResultWindow(){
        window.setVisible(true);
    }

    public void closeSearchResultWindow(){
        window.setVisible(false);
    }
}