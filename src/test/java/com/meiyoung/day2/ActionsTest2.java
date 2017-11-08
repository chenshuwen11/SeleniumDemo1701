package com.meiyoung.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;


public class ActionsTest2 {
    WebDriver driver;
    @BeforeMethod
    public void openChrome() {
        System.setProperty("webdriver.chrome.driver", "E:\\IdeaProjects\\SeleniumDemo1701\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }
    /**
     * 打开百度页面
     * 在百度一下按钮上右键
     */
    @Test
     public void rightClickTest(){
        driver.get("http://www.baidu.com");
        WebElement buttonBaidu =driver.findElement(By.id("su"));
        //实例化Actinons
            Actions actions =new Actions(driver);
        //在百度按钮右键
            actions.contextClick(buttonBaidu).perform();
        }
    /**
     * 打开百度页面
     * 双击百度按钮一下
     */
    @Test
      public void doubleClickTest(){
        driver.get("http://www.baidu.com");
        WebElement baidubutton=driver.findElement(By.id("su"));
        Actions actions =new Actions(driver);
        actions.doubleClick(baidubutton).perform();
    }
    @Test
      public void move() throws InterruptedException {
          driver.get("file:///F:/selenium_html/selenium_html/demo1.html");
          WebElement element =driver.findElement(By.xpath("//*[@id=\"action\"]/input"));
          Actions actions=new Actions(driver);
          //移动鼠标至目标值
          actions.moveToElement(element).perform();
          Thread.sleep(3000);
          //获取文本定位
          String hello = driver.findElement(By.xpath(".//*[text()='Hello World!']")).getText();
          Assert.assertEquals(hello,"Hello World!");
    }
     @Test
      public void testDrop() throws InterruptedException {
          driver.get("file:///F:/selenium_html/selenium_html/dragAndDrop.html");
          WebElement element =driver.findElement(By.id("drag"));
          Actions actions =new Actions(driver);
          //拖动到x，y
          actions.dragAndDropBy(element,100,500).perform();
           Thread.sleep(2000);
     }
     @Test
      public  void dropTest() throws InterruptedException {
          driver.get("file:///F:/selenium_html/selenium_html/dragAndDrop.html");
          WebElement element1=driver.findElement(By.id("drag"));
          WebElement element2=driver.findElement(By.xpath("/html/body/h1"));
          Actions actions =new Actions(driver);
          actions.clickAndHold(element1)
                  .moveToElement(element2)
                  .release(element1)
                  .perform();
          Thread.sleep(2000);

     }
     @Test
     public void moreTest() throws InterruptedException {
          driver.get("file:///F:/selenium_html/selenium_html/index.html");
          WebElement element=driver.findElement(By.id("selectWithMultipleEqualsMultiple"));
         List<WebElement> list=driver.findElements(By.xpath(".//*[@id='selectWithMultipleEqualsMultiple']/option"));
          Thread.sleep(3000);
          Actions actions=new Actions(driver);
          actions.keyDown(Keys.CONTROL )
                  //.click(list.get(0))
                  .click(list.get(2))
                  .keyUp(Keys.CONTROL)
                  .perform();
         Thread.sleep(3000);
     }
     @Test
     public void saveHtml() throws AWTException, InterruptedException {
          driver.get("http://www.baidu.com");
         Robot robot =new Robot();
         robot.keyPress(KeyEvent.VK_CONTROL);
         robot. keyPress(KeyEvent.VK_S);
         Thread.sleep(2000);
         robot.keyPress(KeyEvent.VK_ENTER);

     }
     @Test
     public void  uploadTest() throws InterruptedException {
          driver.get("file:///F:/selenium_html/selenium_html/index.html");
          driver.findElement(By.id("load"))
                  .sendKeys("F:\\test.jpg");
         Thread.sleep(3000);
     }
        @AfterMethod
        public void closed() throws InterruptedException {
          Thread.sleep(3000);
            driver.quit();
        }


}
