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
    //Selenium: KHi thao tác với 1 element (findElement) thì trường hợp truyeenf vào 1 locator không phải là duy nhất (có nhiều hơn 1)
    // -> thì khi thao tác lên element sẽ lấy cái locator đầu tiên
}
