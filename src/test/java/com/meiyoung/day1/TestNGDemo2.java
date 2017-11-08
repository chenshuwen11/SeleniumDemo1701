package com.meiyoung.day1;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGDemo2 {
    //校验 a == a

    /**
     *加入我用A账号B密码登陆
     * 那么我登陆成功
     *
     * 我打开XX页面，点击XXX删除，那么我删除成功
     */
    @Test
    public void  assertEqualTest(){
        String a ="asdf";
        String b ="asdf";
        Assert.assertEquals(a,b,"a不等于b" );
    }
    @Test
    /**
     * 校验a和b是否相等
     */
    public  void  asserNotEqualTest(){
        int a=1;
        int b=2;
        Assert.assertNotEquals(a,b);

    }
    @Test
    public  void assertNull(){
        String a="aa";
        Assert.assertNull(a);
    }
    @Test
    public  void assertNotNull(){
        String a="aa";
        Assert.assertNotNull(a);
    }
    @Test
    public  void a (){
        Boolean a=true;
        Assert.assertTrue(a);
    }
}
