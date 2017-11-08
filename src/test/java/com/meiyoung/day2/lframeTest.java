package com.meiyoung.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class lframeTest {
    WebDriver driver;
    @BeforeTest
    public void openChrome(){
        System.setProperty("webdriver.chrome.driver","E:\\IdeaProjects\\SeleniumDemo1701\\drivers\\chromedriver.exe");
        driver=new ChromeDriver();
    }

    /**
     *  打开测试页面
     *  打开百度链接
     *
     */
    @Test
    public void iframe() throws InterruptedException {
        driver.get("file:///F:/selenium_html/selenium_html/index.html");
        //通过ID或者name的形式转交控制权
       // driver.switchTo().frame("aa");
        //通过webElement方式
        WebElement iframe=driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(iframe);
        driver.findElement(By.linkText("baidu")).click();
        Thread.sleep(3000);
        //driver控制权转交回原页面
        driver.switchTo().defaultContent();
        driver.findElement(By.linkText("登陆界面")).click();
    }

   @AfterMethod
   public void close(){
    driver.close();
}
}