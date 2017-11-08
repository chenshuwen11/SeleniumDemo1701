package com.meiyoung.day1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

public class OpenBrowserTest {
    @Test
    public  void  OpenFF(){

        WebDriver  webDriver= new FirefoxDriver();
    }
    @Test
    public void   OpenChrome(){
    System.setProperty("webdriver.chrome.driver","E:\\IdeaProjects\\SeleniumDemo1701\\drivers\\chromedriver.exe");
    WebDriver webDriver = new ChromeDriver();
    }
    @Test
    public void   OpenIE(){
        System.setProperty("webdriver.ie.driver","E:\\IdeaProjects\\SeleniumDemo1701\\drivers\\IEDriverServer.exe");
        WebDriver webDriver = new InternetExplorerDriver();
    }
}
