package org.example.testspringboot.front.Window;

import jakarta.annotation.Resource;
import org.example.testspringboot.dao.Car;
import org.example.testspringboot.dao.CarRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@Component
public class ExportCarWindow extends JFrame {
    static JFrame window = new JFrame("导出车辆信息");

    @Resource
    private CarRepository carRepository;

    @Resource
    private ApplicationContext context;

    public ExportCarWindow(ApplicationContext context) {
        this.context = context;
        window.setBounds(100, 100, 450, 200);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        window.add(panel);
        exportWindow(panel);
    }

    private void exportWindow(JPanel panel) {
        panel.setLayout(null);

        JLabel userLabel = new JLabel("点击按钮导出车辆信息到文本文件");
        userLabel.setBounds(10, 15, 400, 25);
        userLabel.setFont(new Font("宋体", Font.BOLD , 25));
        panel.add(userLabel);

        JButton exportButton = new JButton("导出");
        exportButton.setBounds(60, 80, 90, 35);
        exportButton.setFont(new Font("楷体", Font.BOLD, 23));
        panel.add(exportButton);

        JButton quitButton = new JButton("返回");
        quitButton.setBounds(200, 80, 90, 35);
        quitButton.setFont(new Font("楷体", Font.BOLD, 23));
        panel.add(quitButton);

        exportButton.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("指定导出文件保存路径");
            fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

            int userSelection = fileChooser.showSaveDialog(this);

            if (userSelection == JFileChooser.APPROVE_OPTION) {
                File fileToSave = fileChooser.getSelectedFile();
                saveCarsToFile(new File(fileToSave.getAbsolutePath() + "/cars_export.txt"));
            }
        });

        quitButton.addActionListener(e -> {
           closeExportCarWindow();

            CarWindow carWindow = context.getBean(CarWindow.class);
            carWindow.showCarWindow();
        });
    }

    private void saveCarsToFile(File file) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            List<Car> cars = carRepository.findAll();
            for (Car car : cars) {
                writer.write(car.toString() + System.lineSeparator());
            }
            JOptionPane.showMessageDialog(this, "数据已经成功导出到: " + file.getPath(), "导出成功", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "导出过程中出错: " + ex.getMessage(), "错误", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }

    public void showExportCarWindow() {
        window.setVisible(true);
    }

    public void closeExportCarWindow() {
        window.setVisible(false);
    }
}
