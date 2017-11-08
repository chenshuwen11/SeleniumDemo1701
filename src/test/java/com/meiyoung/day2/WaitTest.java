package com.meiyoung.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class WaitTest {
    WebDriver driver;
    @BeforeTest
    public void openChrome() {
        System.setProperty("webdriver.chrome.driver", "E:\\IdeaProjects\\SeleniumDemo1701\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        //全局等待
       // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    /**
     * 打开测试页面
     * 点击wait按钮
     * 获取文本值并判断是否为“wait for display”
     */
    @Test
    public void waitTest(){
     driver.get("file:///F:/selenium_html/selenium_html/index.html");
     driver.findElement(By.xpath("//*[@id=\"wait\"]/input")).click();

     String text=driver.findElement(By.xpath("//*[@id=\"display\"]/div")).getText();
     Assert.assertEquals(text,"wait for display" );
    }
    @Test
    public void waitTest2(){
        driver.get("file:///F:/selenium_html/selenium_html/index.html");
        driver.findElement(By.xpath("//*[@id=\"wait\"]/input")).click();
        //显示等待
        WebDriverWait wait=new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"display\"]/div")));
        String text=driver.findElement(By.xpath("//*[@id=\"display\"]/div")).getText();
        Assert.assertEquals(text,"wait for display" );
    }
    @AfterMethod
    public void closed() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }
}
