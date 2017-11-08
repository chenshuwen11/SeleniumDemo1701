package com.meiyoung.day3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import javax.management.DescriptorAccess;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Set;

import static java.lang.Thread.*;

public class GridTest {
    @Test
    public void testchrome() throws MalformedURLException,InterruptedException {
       // System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");
        //创建一个desiredcapabilities类型
       DesiredCapabilities dc= DesiredCapabilities.chrome();
        //实例化一个driver
      WebDriver driver = new RemoteWebDriver(new URL("http://192.168.0.37:4444/wd/hub"),dc);
        //WebDriver driver = new ChromeDriver() ;
        driver.get("http://www.baidu.com");
        Thread.sleep(10000);
        driver.quit();
    }
//数据驱动部分,让程序代码在不同的浏览器跑
    @DataProvider(name="data4")
    public Object[][]test1(){
       return new Object[][]{
               {"firefox"},
               {"chrome"}};
}

    @Test(dataProvider = "data4")//调用上面的方法
    //使用if判断在那个浏览器跑
    public void testGrid2(String browser) throws InterruptedException,MalformedURLException {
   DesiredCapabilities dc=null;
   if (browser.contentEquals("firefox")) {
       dc = DesiredCapabilities.firefox();
   }else if (browser.equals("chrome"));{
       dc=DesiredCapabilities.chrome();
  // }else{
            System.out.println("error");
        }
        WebDriver driver = new RemoteWebDriver(new URL("http://192.168.0.37:4444/wd/hub"),dc);
        driver.get("http://www.baidu.com");
        Thread.sleep(10000);
        driver.quit();
    }
}
