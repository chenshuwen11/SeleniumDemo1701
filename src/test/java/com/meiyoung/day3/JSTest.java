package com.meiyoung.day3;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JSTest {
    WebDriver driver;
    @BeforeMethod
    public void openChrome() {
        System.setProperty("webdriver.chrome.driver", "E:\\IdeaProjects\\SeleniumDemo1701\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }
    @AfterMethod
    public void closed() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
    @Test
    public void exJS() throws InterruptedException {
        driver.get("http://www.baidu.com");
        //执行js
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("document.getElementById(\"kw\").setAttribute(\"value\",\"webdriver\");");
        Thread.sleep(5000);
    }
}
