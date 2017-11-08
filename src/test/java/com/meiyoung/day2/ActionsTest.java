package com.meiyoung.day2;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.mustache.Value;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ActionsTest {
    WebDriver driver;
    @BeforeTest
    public void openChrome(){
        System.setProperty("webdriver.chrome.driver","E:\\IdeaProjects\\SeleniumDemo1701\\drivers\\chromedriver.exe");
        driver=new ChromeDriver();
    }
    /**
     *点击百度首页的新闻链接
     * 那么我打开新闻页面
     */
    @Test
    public void clickTest(){
        driver.get("https://www.baidu.com");
       WebElement newslink= driver.findElement(By.name("tj_trnews"));
       //点击百度首页新闻
       newslink.click();
       //获取当前页面的URL
       String url=driver.getCurrentUrl() ;
       //校验实际值是否等于预期值
        Assert.assertEquals(url,"http://news.baidu.com/");
    }

    /**
     * 打开百度首页
     * 输入关键字selenium
     * 点击百度搜搜按钮
     * 校验titled是不是selenium_百度搜索
     */
    @Test
    public void sendkesTest() throws InterruptedException {
        driver.get("https://www.baidu.com");
        //定位文本框并输入值
        WebElement keys=driver.findElement(By.id("kw"));
        keys.sendKeys("selenium");
        //定位百度按钮并点击
        WebElement baidubutton=driver.findElement(By.id("su"));
        baidubutton.click();
        Thread.sleep(3000);
        //获取title
        String title=driver.getTitle();
        //校验
        Assert.assertEquals(title,"selenium_百度搜索" );
    }
    @Test
    public void clearTest() throws InterruptedException {
        driver.get("https://www.baidu.com");
        //定位文本框并输入值
        WebElement keys = driver.findElement(By.id("kw"));
        keys.sendKeys("selenium");
        Thread.sleep(3000);
        //清空
        keys.clear();
        Thread.sleep(3000);
    }
    /**
     * 打开百度首页
     * 获取新闻
     * 然后校验
     */
    @Test
    public void getTextTest() throws InterruptedException {
        driver.get("https://www.baidu.com");
        //
        String text1 = driver.findElement(By.name("tj_trnews")).getText();
        Assert.assertEquals(text1,"新闻");
    }

    /**
     * 打开百度首页
     * 获取文本框的tagname
     * 校验是否为input
     */
    @Test
    public void getTagNameText(){
        driver.get("http://www.baidu.com");
        String tagname=driver.findElement(By.id("kw")).getTagName();
        Assert.assertEquals(tagname,"input");
    }
    /**
     * 打开百度页面
     * 判断按钮显示的文本值为：百度一下
     */
    @Test
    public void getATest(){
        driver.get("http://www.baidu.com");
        String attribute= driver.findElement(By.id("su")).getAttribute("value");
        Assert.assertEquals(attribute,"百度一下");
    }
    /**
     * 打开小邮局首页
     * 获取账户和密码输入框的默认显示文本分别为：用户名和密码
     */
    @Test
    public void getLPTest(){
        driver.get("http://post.uulian.com");
       String attribute1= driver.findElement(By.id("username")).getAttribute("placeholder");
       String attdriver2=driver.findElement(By.id("password")).getAttribute("placeholder");
       Assert.assertEquals(attribute1,"用户名");
       Assert.assertEquals(attdriver2,"密码");
    }
    /**
     * 打开百度
     * 判断是否显示百度一下按钮
     */
    @Test
    public void isDisplayedText(){
        driver.get("http://www.baidu.com");
        Boolean b=driver.findElement(By.id("su")).isDisplayed();
        Assert.assertTrue(b);

    }

    /**
     * 打开优优小邮局
     * 输入账号密码点击登入
     * 定位已到站第一条快递单号是否被选中
     */
    @Test
    public  void  postTest() throws InterruptedException {
        driver.get("http://post.uulian.com");
        Thread.sleep(3000);
        driver.findElement(By.id("username")).sendKeys("test123");
        driver.findElement(By.id("password")).sendKeys("123456abc");
        driver.findElement(By.id("submit")).click();
        Thread.sleep(3000);
        WebElement a=driver.findElement(By.xpath("//*[@id=\"sample_1\"]/tbody/tr[1]/td[1]/div/ins"));
        //点击
        a.click();
        Thread.sleep(2000);
        Boolean b=a.isSelected();
        Assert.assertTrue(b);
    }

    /**
     * 截图百度首页
     */
    @Test
    public void shotTest(){
         driver.get("https://www.baidu.com");
        File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file, new File("E:\\test.png"));
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @AfterMethod
    public void closed(){
        driver.close();
    }
}
