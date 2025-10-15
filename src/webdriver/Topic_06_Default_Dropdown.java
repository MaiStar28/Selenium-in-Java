package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_06_Default_Dropdown {
    //Khai báo
    WebDriver driver;
    Select selectD;
    @BeforeClass
    public void initialBrowser(){
        //Mở browser lên
        driver = new FirefoxDriver();

        // Explicit Wait
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(15));
        //Implicit Wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //Fluent Wait
        //dùng đc cho all TC trong class này sẽ khai báo ở day. CÒn muốn dùng riền cho từng TC thì khai báo ở từng TC
        fluentWait = new FluentWait<WebDriver>(driver);
    }
    @Test
    public void TC_01_FB_SignUp(){
        driver.get("https://www.facebook.com/reg/");
        //Cách 1
        //dropdown xuất hiện
        selectD = new Select(driver.findElement(By.cssSelector("select#day")));
        //chọn 1  item
        selectD.selectByVisibleText("10");
        //Cách 2
        new Select(driver.findElement(By.cssSelector("select#day"))).selectByVisibleText("20");

        //chọn xong verify đã chọn thành công hay chưa
        Assert.assertEquals(selectD.getFirstSelectedOption().getText(), "10");

        //verify xem dropdown single hay multi
        Assert.assertFalse(selectD.isMultiple());
        //verify tổng số item trong dropdown
        Assert.assertEquals(selectD.getOptions().size(),31);


    }
    WebDriverWait explicitWait;
    FluentWait<WebDriver> fluentWait;
    @Test
    public void TC_02_Time(){
        //Các cách có thể chờ (time)
        //wait if for list break
        //1. wait: Có 3 cách: ImplicitWait/WebDriveWait/FluentWait
        //ImplicitWait: dùng Implicit cho việc tìm kiếm element - áp dụng cho 2 hàm: findElement/findElements
        //WebDriveWait: dùng Explicit Wait cho element với 1 điều kiện rõ ràng: Hiển thị/K hiển thị/Presence:xuất hiện trong html(không care hiển thị or kh)/Clickable/Selected/...
        //FluentWait: nó có thể sửa lại thời gian polling lại được (ví dụ 1m check 1 lần)
        explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("")));
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("")));
        // if - switch case: If kh check trùng điêều kiện - case thì có thể
        // while - do while:  while kiểm tra điều kiện trc còn đo while ktra điều kiện sau

    }
    @AfterClass
    public void cleanBrowser(){
        driver.quit();
    }

    // Tên biến/hàm: chữ cái đầu viết thường
    //Selenium: KHi thao tác với 1 element (findElement) thì trường hợp truyeenf vào 1 locator không phải là duy nhất (có nhiều hơn 1)
    // -> thì khi thao tác lên element sẽ lấy cái locator đầu tiên
}
