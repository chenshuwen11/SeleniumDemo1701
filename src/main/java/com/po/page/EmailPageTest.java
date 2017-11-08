package com.po.page;

import org.openqa.selenium.By;

public class EmailPageTest {
    //定义了email文本框的定位方式
    public static By emailInput=By.name("email");
    //定义了pwd文本框的定位方式
    public  static  By pwdInput=By.name("password");
    //定义了登陆按钮的定位方式
    public  static  By loginButton=By.id("dologin");
    //定位去注册
    public  static  By registerButton=By.id("changepage");

}
