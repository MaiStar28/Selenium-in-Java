package webdriver;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.security.Key;

public class Topic_03_Part3_WebElement {
    //Khai báo
    WebDriver driver;
    WebElement element;
    @BeforeClass
    public void initialBrowser(){
        //Mở browser lên
        driver = new FirefoxDriver();
        //Mở app lên chuyển tới màn hình Login
        driver.get("https://nhanam.vn/account/register");
    }
    @Test
    public void TC_01_(){
        //dùng 1 lần
        driver.findElement(By.xpath(""));
        //dùng nhiều lần
        element = driver.findElement(By.xpath(""));
        //Click vào element dạng button/checkbox/radio/link/image/icon/...
        element.click();
        //Nhập liệu các element dạng: texxtbox/texarea/dropdown (edit)
        element.clear(); //xóa dữ liệu trước khi nhập
        element.sendKeys("mai xinh gái");
        element.sendKeys(Keys.ENTER);
        //Kiểm tra 1 element có hiển thị hay không
        element.isDisplayed();
        //Kiểm tra 1 element đã được chọn hay chưa
        element.isSelected();
        //Kiểm tra 1 element có enable/disable hay không (read only)
        element.isEnabled();
        //Lấy css: font/size/color/postion/location
        element.getCssValue("background");
        //Áp dụng cho element chứa text
        element.getText();
        //Lấy text nằm trong 1 thuộc tính
        element.getAttribute("Placeholder");
        //Lấy chiều rộng chiều cao của element
        //với browser:
        Dimension dimensionBrower = driver.manage().window().getSize();
        //Với element:
        Dimension dimensionElement = element.getSize();
        //Vị trí của element so với viewport (view của web mà nhìn thấy được)
        Point pointElement = element.getLocation();
        //Tổng hợp hàm getSize+getLocation
        Rectangle rectangle = element.getRect();
        //1.size:
        rectangle.getHeight();
        rectangle.getWidth();
        rectangle.getDimension();
        //2.Location:
        rectangle.getX();
        rectangle.getY();
        rectangle.getPoint();
        //
        

    }
    @AfterClass
    public void cleanBrowser(){
        driver.quit();
    }

    // Tên biến/hàm: chữ cái đầu viết thường
    //Selenium: KHi thao tác với 1 element (findElement) thì trường hợp truyeenf vào 1 locator không phải là duy nhất (có nhiều hơn 1)
    // -> thì khi thao tác lên element sẽ lấy cái locator đầu tiên
}
