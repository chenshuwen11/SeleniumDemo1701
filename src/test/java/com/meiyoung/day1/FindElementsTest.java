package com.meiyoung.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class FindElementsTest {
    WebDriver driver;
    @BeforeTest
    public void openChrome() {
        //设置chromedriver路径
        System.setProperty("webdriver.chrome.driver", "E:\\IdeaProjects\\SeleniumDemo1701\\drivers\\chromedriver.exe");
        //打开Chrome浏览器
        driver = new ChromeDriver();
    }
    /**
     * 打开百度页面
     * 通过ID定位搜索文本
     */
    @Test
    public void byIDTest(){
        driver.get("https://www.baidu.com");
        WebElement keyField=driver.findElement(By.id("kw"));

    }
    /**
     * 打开百度页面
     * 通过name定位搜索文本
     */
    @Test
    public void byNameTest(){
        driver.get("https://www.baidu.com");
        WebElement keyField=driver.findElement(By.name("wd"));

    }
    /**
     * 打开百度页面
     * 通过classname定位搜索文本
     */
    @Test
    public void byClassTest(){
        driver.get("https://www.baidu.com");
        WebElement keyField=driver.findElement(By.className("s_ipt"));
    }
    /**
     * 打开百度页面
     * 通过linkText/partialLinkText定位搜索文本
     */
    @Test
    public void bypartialLinkText(){
        driver.get("https://www.baidu.com");
        WebElement keyField=driver.findElement(By.partialLinkText("视"));
    }
    /**
     * 打开百度页面
     * 通过TagName定位搜索文本
     */
    @Test
    public void byTagName(){
        driver.get("https://www.baidu.com");
        List<WebElement >  list=driver.findElements(By.tagName("input"));
        System.out.println(list.size());
    }
    /**
     * 打开百度页面
     * 通过xpath定位百度按钮
     */
    @Test
    public void byxpathText() {
        driver.get("https://www.baidu.com");
        WebElement e1 = driver.findElement(By.xpath(".//*[@id='su']"));
    }
    /**
     * 打开百度页面
     * 通过CSS定位百度图片
     */
    @Test
    public void byCSSText() {
        driver.get("https://www.baidu.com");
        WebElement e1 = driver.findElement(By.cssSelector("#kw"));
    }
    /**
     * 打开百度页面
     * 通过xpath定位
     * 获取首页已获取list中的第一个新闻（0）/获取当前页面所有元素
     */
    @Test
    public void byXpath02(){
        driver.get("https://www.baidu.com");
        List<WebElement >  list=driver.findElements(By.xpath("//*[@id=\"u1\"]/a"));
        for (int i = 0; i < list.size(); i++) {
            String text = list.get(i).getText();
            System.out.println(text);
        }

    }
    @AfterMethod
    public void closedBrowser(){
        driver.close();
    }
}
