package com.meiyoung.day3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegisterTest {
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
    @Test
    public void registerTest() throws InterruptedException {
        //控制权转交给iframe;
        Thread.sleep(3000);
        driver.switchTo().frame("x-URS-iframe");
        //点击去注册按钮
        driver.findElement(By.id("changepage")).click();
        //获取当前页面所在的handles
        String handle1 = driver.getWindowHandle();
        // driver切换到新的页面
        for (String handles : driver.getWindowHandles()) {
            if (handles.equals(handle1)) {
                continue;
            }
            driver.switchTo().window(handles);
        }
        //时间搓及定位元素
        String time = String.valueOf(System.currentTimeMillis() / 100);
        driver.findElement(By.id("nameIpt")).sendKeys("emain" + time);
        driver.findElement(By.id("mainPwdIpt")).sendKeys("123123123");
        driver.findElement(By.id("mainCfmPwdIpt")).sendKeys("123123123");
        driver.findElement(By.id("mainMobileIpt")).sendKeys(time);
        driver.findElement(By.id("vcodeIpt")).sendKeys("123123");
        driver.findElement(By.id("mainAcodeIpt")).sendKeys("147258");
        driver.findElement(By.id("mainRegA")).click();
        //显示等待
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"m_mainAcode\"]/span")));
        String error = driver.findElement(By.xpath("//*[@id=\"m_mainAcode\"]/span")).getText();
        //校验
        Assert.assertEquals(error, "  手机验证码不正确，请重新填写");

    }
}
