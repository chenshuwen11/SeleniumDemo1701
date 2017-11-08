package com.meiyoung.day2;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AlertTest {
    WebDriver driver;
    @BeforeTest
    public void openChrome(){
        System.setProperty("webdriver.chrome.driver","E:\\IdeaProjects\\SeleniumDemo1701\\drivers\\chromedriver.exe");
        driver=new ChromeDriver();
    }

    /**
     *打开UI自动化测试页面
     * 点击Alert按钮
     *在Alert警告框点击确定按钮
     */
    @Test
    public void AlertTest() throws InterruptedException {
        driver.get("file:///F:/selenium_html/selenium_html/index.html");
        driver.findElement(By.className("alert")).click();
        Thread.sleep(3000);
        //driver控制权转交给Alert
        Alert alert=driver.switchTo().alert();
        //获取警告框文本值
        String text=alert.getText();
        alert.accept();
        Assert.assertEquals(text,"请点击确定");
    }

    /**
     * 打开UI自动化测试页面
     * 点击confirm按钮
     *在confirm警告框点击取消按钮
     *再次点击确定按钮
     */
    @Test
    public void confirmTest() throws InterruptedException {
        driver.get("file:///F:/selenium_html/selenium_html/index.html");
        driver.findElement(By.className("confirm")).click();
        Thread. sleep(3000);
        Alert alert=driver.switchTo().alert();
        //点击取消
        alert.dismiss();
        Thread. sleep(3000);
        alert.accept();
    }

    /**
     * 打开UI自动化测试页面
     * 点击Prompt按钮
     *在Prompt弹窗中，输入“这个是Prompt"
     *点击确定按钮/取消按钮
     */
    @Test
    public void promptTest() throws InterruptedException {
        driver.get("file:///F:/selenium_html/selenium_html/index.html");
        driver.findElement(By.className("prompt")).click();
        Thread.sleep(2000);
       Alert alert = driver.switchTo().alert();
       alert.sendKeys("这个是Prompt");
       Thread.sleep(3000);
       alert.accept();
       Thread.sleep(3000);
       alert.accept();
    }
    @AfterMethod
    public void closed() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }
}
