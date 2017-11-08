package com.meiyoung.day2;


import org.apache.bcel.generic.Visitor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SelectText {
    WebDriver driver;

    @BeforeTest
    public void openChrome() {
        System.setProperty("webdriver.chrome.driver", "E:\\IdeaProjects\\SeleniumDemo1701\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    /**
     * 打开我们的测试界面
     * 下拉框选择viov
     * 第二次选择huawei
     * 第三次选择iphone
     */
    @Test
    public void selectTest() throws InterruptedException {
        driver.get("file:///F:/selenium_html/selenium_html/index.html");
        WebElement selectEl =driver.findElement(By.id("moreSelect"));
        //实例化select
        Select select =new Select(selectEl);
        //通过索引选择下拉框
        select.selectByIndex(2);
        Thread.sleep(3000);
        //通过value值选择下拉框
        select.selectByValue("huawei");
        Thread.sleep(3000);
        //通过文本值选择下拉框
        select.selectByVisibleText("iphone");
}
    @AfterMethod
    public void closed()  {

        driver.close();
    }
}