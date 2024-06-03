package org.example.testspringboot;

import org.example.testspringboot.front.Window.CarWindow;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class CarSwingWindow {

    public static void main(String[] args) {

        //Spring Boot 应用是使用SpringApplicationBuilder创建的。 我们关闭无头模式，该模式适用于服务器应用。
        var ctx = new SpringApplicationBuilder(CarSwingWindow.class)
                .headless(false).run(args);

        CarWindow carWindow = new CarWindow(ctx);
        carWindow.showCarWindow();


    }

}
