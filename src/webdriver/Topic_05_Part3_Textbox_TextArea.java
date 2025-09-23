package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_05_Part3_Textbox_TextArea {
    //Khai báo
    WebDriver driver;
    String eduText = "Autumation Test\nMai\n2002";
    @BeforeClass
    public void initialBrowser(){
        //Mở browser lên
        driver = new FirefoxDriver();
        //Mở app lên chuyển tới màn hình Login
        driver.get("https://automationfc.github.io/basic-form/index.html");
    }
    @Test
    public void TC_01_TextArea(){
        driver.findElement(By.id("edu")).sendKeys(eduText);
        driver.findElement(By.id("edu")).sendKeys("Autumation Test\nMai\n2002");

    }
    @AfterClass
    public void cleanBrowser(){
        //driver.quit();
    }

    // Tên biến/hàm: chữ cái đầu viết thường
    //Selenium: KHi thao tác với 1 element (findElement) thì trường hợp truyeenf vào 1 locator không phải là duy nhất (có nhiều hơn 1)
    // -> thì khi thao tác lên element sẽ lấy cái locator đầu tiên
}
