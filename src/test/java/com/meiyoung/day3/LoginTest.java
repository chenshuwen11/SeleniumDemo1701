package com.meiyoung.day3;

import com.po.page.EmailPageTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {
    WebDriver driver;
    @BeforeMethod
    public void openChrome() {
        System.setProperty("webdriver.chrome.driver", "E:\\IdeaProjects\\SeleniumDemo1701\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://mail.163.com/");
    }
    @AfterMethod
    public void closed() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
    //登陆成功case
    @Test
    public void loginTest() throws InterruptedException {
        LoginTest.loginPo(driver,"meyoungtester","meyoung123");
        //显示等待
        WebDriverWait wait=new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("退出")));
        String logout=driver.findElement(By.linkText("退出")).getText();
        Assert.assertEquals(logout,"退出");
    }
    /**
     *
     * 登陆错误case
     */
    @Test
    public void loginError() throws InterruptedException {
       LoginTest.loginPo(driver,"meyoungtester","meyoung1231111");
        //显示等待
        WebDriverWait wait=new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"nerror\"]/div[2]")));
        String error=driver.findElement(By.xpath("//*[@id=\"nerror\"]/div[2]")).getText();
        Assert.assertEquals(error,"帐号或密码错误");
    }
  //封装公共部分
    public static void loginPo(WebDriver driver,String email,String pwd) throws InterruptedException {
        Thread.sleep(2000);
        driver.switchTo().frame("x-URS-iframe");
        driver.findElement(EmailPageTest.emailInput).sendKeys(email);
        driver.findElement(EmailPageTest.pwdInput).sendKeys(pwd);
        driver.findElement(EmailPageTest.loginButton).click();
    }
}
