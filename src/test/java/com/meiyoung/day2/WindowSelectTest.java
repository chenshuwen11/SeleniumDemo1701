package com.meiyoung.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static java.lang.Thread.*;

public class WindowSelectTest {
    WebDriver driver;
    @BeforeTest
    public void openChrome() {
        System.setProperty("webdriver.chrome.driver", "E:\\IdeaProjects\\SeleniumDemo1701\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }
    /**
     * 打开测试界面
     * 点击Open new window
     * 点击百度
     */
    @Test
    public void testwin() throws InterruptedException {
        driver.get("file:///F:/selenium_html/selenium_html/index.html");
         driver.findElement(By.linkText("Open new window")).click();
         Thread.sleep(3000);
         //获取当前窗口的句柄值
         String handle1=driver.getWindowHandle();
         //获取第二个窗口的局值并转交控制权
         for (String handles:driver.getWindowHandles()){
             if (handles.equals(handle1)){
                 continue;
             }else {
                 driver.switchTo().window(handles);
             }
         }
         driver.findElement(By.linkText("baidu")).click();
         Thread.sleep(3000);
    }
    @AfterMethod
    public void closed()  {

        driver.close();
    }
}
