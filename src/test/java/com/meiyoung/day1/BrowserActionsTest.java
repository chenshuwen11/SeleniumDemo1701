package com.meiyoung.day1;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.URL;

public class BrowserActionsTest {
    WebDriver driver;
    @BeforeTest
    public void openChrome(){
        //设置chromedriver路径
        System.setProperty("webdriver.chrome.driver","E:\\IdeaProjects\\SeleniumDemo1701\\drivers\\chromedriver.exe");
        //打开Chrome浏览器
        driver =new ChromeDriver();
    }
    /**
     * 打开 chrome浏览器
     * 打开百度首页
     * 等待 5s
     * 关闭浏览器
     */
    @Test
    public void getTest() throws InterruptedException {
        //输入百度地址
        driver.get("https://www.baidu.com");
       //等待5s
        Thread.sleep(5000);


    }
    /**
     * 打开 chrome浏览器
     * 打开百度首页
     * 等待 3s
     *后退
     * 等待3s
     * 关闭浏览器
     */
    @Test
    public void backTest() throws InterruptedException {
        //输入百度地址
        driver.get("http://www.baidu.com");
        //等待3s
        Thread.sleep(3000);
        //后退
        driver.navigate().back();
        //等待3s
        Thread.sleep(5000);
        //关闭浏览器


    }
    /**
     * 打开 chrome浏览器
     * 打开百度首页
     * 等待 3s
     *后退
     * 等待3s
     * 前进
     * 等待3s
     * 关闭浏览器
     */
    @Test
    public void forwardTest() throws InterruptedException {
        //输入百度地址
        driver.get("http://www.baidu.com");
        //等待3s
        Thread.sleep(3000);
        //后退
        driver.navigate().back();
        //等待3s
        Thread.sleep(3000);
        //前进
        driver.navigate().forward();
        //等待3s
        Thread.sleep(3000);
        //关闭浏览器

    }
    /**
     * 打开 chrome浏览器
     * 打开google
     * 等待 3s
     *刷新
     * 等待3s
     * 关闭浏览器
     */
    @Test
    public void refreshTest() throws InterruptedException {
        //输入google地址
        driver.get("https://www.google.com.hk");
        //等待3s
        Thread.sleep(3000);
        //刷新
        driver.navigate().refresh();
        //等待3s
        Thread.sleep(3000);
        //关闭浏览器


    }
    /**
     * 打开chrome浏览器
     * 设置窗口大小   500*500
     * 等待 3s
     *最大化
     * 等待3s
     * 关闭浏览器
     */

    @Test
    public  void  windowTest() throws InterruptedException {
        //实例化Dimension类，并设置窗口大小
        Dimension dimension =new Dimension(300,300);
        driver.manage().window().setSize(dimension);
         Thread.sleep( 3000);
         //窗口最大化
         driver.manage().window().maximize();
         Thread.sleep(3000);

    }
    /**
     * 打开chrome浏览器
     * 打开百度首页
     *
     *获取当前页面的url
     * 等待 3s
     * 校验当前页面URL是不是百度地址
     * 关闭浏览器
     */
    @Test
    public  void  getURLTest() throws InterruptedException {
        driver.get("https://www.baidu.com");
        String url = driver.getCurrentUrl();
        System.out.println("获取到的URL是：" + url);
        Assert.assertEquals(url, "https://www.baidu.com/");

    }
    @AfterMethod
    public void closeBrowser(){
         driver.close();
    }
}
