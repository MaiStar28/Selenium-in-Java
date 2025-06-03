package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_00_Template {
    //Khai báo
    WebDriver driver;
    @BeforeClass
    public void initialBrowser(){
        //Mở browser lên
        driver = new FirefoxDriver();
        //Mở app lên chuyển tới màn hình Login
        driver.get("https://nhanam.vn/account/register");
    }
    @Test
    public void TC_01_(){

    }
    @AfterClass
    public void cleanBrowser(){
        driver.quit();
    }

    // Tên biến/hàm: chữ cái đầu viết thường
}
