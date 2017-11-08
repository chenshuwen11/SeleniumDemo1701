package com.meiyoung.day1;

import org.testng.annotations.*;

public class TestNGDemo1 {
    @BeforeTest
    public  void  BeforeTest(){
        System.out.println("这是@BeforeTest注解");
    }
    @BeforeMethod
    public  void BeforeMethod(){
        System.out.println("这是@BeforeMethod注解");
    }
    @Test
    public void testCase1(){
        System.out.println("这是@注解1");
    }
    @Test
    public void testCase2(){
        System.out.println("这是@注解2");
    }
    @AfterMethod
    public void afterMethod() {
        System.out.println("这是@afterMethod注解");
    }
    @AfterTest
    public void afterTest(){
        System.out.println("这是@AfterTest注解");
    }
}
