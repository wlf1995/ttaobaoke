package com.ibicn.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class test {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator\\Desktop\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window();
        driver.get("https://pub.alimama.com/");
        String currentUrl = driver.getCurrentUrl();
        System.out.println(currentUrl);
        //进行页面操作
        //进行登录
        login(driver);
        //进行检索
        search(driver);
    }

    /**
     * 进行登录
     */
    public static void login(WebDriver driver) throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.id("J_menu_login")).click();
        Thread.sleep(1000);

        WebElement iframe = driver.findElement(By.name("taobaoLoginIfr"));
        driver.switchTo().frame(iframe);
        //切换到帐号密码登录
        driver.findElement(By.className("login-switch")).click();
        Thread.sleep(1000);
        //输入帐号和密码
        driver.findElement(By.id("TPL_username_1")).sendKeys("18272873489");
        driver.findElement(By.id("TPL_password_1")).sendKeys("wang?1995");
        //拖动标签
        Actions action = new Actions(driver);
        WebElement tpl_username_1 = driver.findElement(By.id("nc_1_n1z"));
        action.dragAndDropBy(tpl_username_1, 600, 0).perform();
        driver.findElement(By.id("J_SubmitStatic")).click();
        //切换回来
        driver.switchTo().defaultContent();
    }

    /**
     * 进行检索
     */
    public static void search(WebDriver driver) {
        //设置搜索框的值
        driver.findElement(By.id("q")).sendKeys("测试衣服");
        //点击搜索按钮
        driver.findElement(By.className("search-btn")).click();
    }
}
