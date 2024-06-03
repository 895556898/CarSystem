package org.example.testspringboot.front.Window;

import jakarta.annotation.Resource;
import org.example.testspringboot.dao.Car;
import org.example.testspringboot.dao.CarRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Component
public class ImportCarWindow extends JFrame {
    static JFrame window = new JFrame("导入车辆信息");

    @Resource
    private CarRepository carRepository;

    @Resource
    private ApplicationContext context;

    public ImportCarWindow(ApplicationContext context) {
        this.context = context;
        window.setBounds(100, 100, 450, 200);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        window.add(panel);
        importWindow(panel);
    }

    private void importWindow(JPanel panel) {
        panel.setLayout(null);

        JLabel userLabel = new JLabel("点击按钮导入车辆信息到数据库");
        userLabel.setBounds(10, 15, 400, 25);
        userLabel.setFont(new Font("宋体", Font.BOLD , 25));
        panel.add(userLabel);

        JButton importButton = new JButton("导入");
        importButton.setBounds(60, 80, 90, 35);
        importButton.setFont(new Font("楷体", Font.BOLD, 23));
        panel.add(importButton);

        JButton quitButton = new JButton("返回");
        quitButton.setBounds(200, 80, 90, 35);
        quitButton.setFont(new Font("楷体", Font.BOLD, 23));
        panel.add(quitButton);

        importButton.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("选择要导入的文件");
            int userSelection = fileChooser.showOpenDialog(this);

            if (userSelection == JFileChooser.APPROVE_OPTION) {
                File fileToLoad = fileChooser.getSelectedFile();
                importCarsFromFile(fileToLoad);
            }
        });

        quitButton.addActionListener(e -> {
            closeImportCarWindow();
            CarWindow carWindow = context.getBean(CarWindow.class);
            carWindow.showCarWindow();
        });
    }

    private void importCarsFromFile(File file) {
        List<String> failedEntries = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(file.getAbsolutePath()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                try {
                    Car car = parseCarFromText(line);
                    if (!carRepository.existsById(car.getId())) {
                        carRepository.save(car);
                    } else {
                        failedEntries.add(line);
                    }
                } catch (Exception e) {
                    failedEntries.add(line);
                }
            }
            if (!failedEntries.isEmpty()) {
                File logFile = new File(file.getParent(), "Import failed.txt");
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(logFile))) {
                    for (String failedEntry : failedEntries) {
                        writer.write("导入失败：" + failedEntry + System.lineSeparator());
                    }
                }
            }
            JOptionPane.showMessageDialog(this, "导入完成，失败的条目已记录在: " + new File(file.getParent(), "Import failed.txt").getPath(), "导入结束", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "导入过程中出错: " + ex.getMessage(), "错误", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }

    private Car parseCarFromText(String text) throws ParseException {
        String[] parts = text.split(";");
        long id = Long.parseLong(parts[0].split("：")[1]);
        String number = parts[1].split("：")[1];
        String company = parts[2].split("：")[1];
        Date buyTime = new Date(new SimpleDateFormat("yyyy-MM-dd").parse(parts[3].split("：")[1]).getTime());
        String type = parts[4].split("：")[1];
        BigDecimal totalKm = new BigDecimal(parts[5].split("：")[1]);
        BigDecimal costOil = new BigDecimal(parts[6].split("：")[1]);
        int basicMaintenanceCost = Integer.parseInt(parts[7].split("：")[1]);
        BigDecimal roadToll = new BigDecimal(parts[8].split("：")[1]);

        return new Car(id, number, company, buyTime, type, totalKm, costOil, basicMaintenanceCost, roadToll);
    }

    public void showImportCarWindow() {
        window.setVisible(true);
    }

    public void closeImportCarWindow() {
        window.setVisible(false);
    }
}
