package com.meiyoung.day1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ClosedBrowserTest {
    @Test
    public void ClosedChrome() throws InterruptedException {
        //设置Chromedriver路径
        System.setProperty("webdriver.chrome.driver","E:\\IdeaProjects\\SeleniumDemo1701\\drivers\\chromedriver.exe");
        //实例化Chromedriver
        WebDriver driver = new ChromeDriver();
        //等待5s
        Thread.sleep(5000);
        //关闭当前窗口
        driver.close();
    }
    @Test
    public void Closedquit() throws InterruptedException {
        //设置Chromedriver路径
        System.setProperty("webdriver.chrome.driver", "E:\\IdeaProjects\\SeleniumDemo1701\\drivers\\chromedriver.exe");
        //实例化Chromedriver
        WebDriver driver = new ChromeDriver();
        //等待5s
        Thread.sleep(15000);
        //关闭浏览器
        driver.quit();
    }
}
