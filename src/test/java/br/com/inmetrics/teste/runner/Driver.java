package br.com.inmetrics.teste.runner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Driver {

    protected static WebDriver driver;

    protected WebDriver getDriver(){
        System.setProperty ("webdriver.chrome.driver", "src\\test\\resources\\driver\\chromedriver.exe");
        if (driver == null){
            driver = new ChromeDriver();
        }
        return driver;
    }

}
