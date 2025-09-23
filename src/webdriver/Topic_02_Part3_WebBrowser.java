package webdriver;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class Topic_02_Part3_WebBrowser {
    //Khai báo
    WebDriver driver;
    @BeforeClass
    public void initialBrowser(){
        //run with browser (local)
        driver = new FirefoxDriver();
        driver = new ChromeDriver();
        driver = new EdgeDriver();
        driver = new SafariDriver();
        driver = new InternetExplorerDriver();
        //remote (grid/docker/cloud testing)
        //network (LAN/WAN/IP/Port)
        ChromeOptions chromeOptions = new ChromeOptions();
        //driver = new RemoteWebDriver(new URL(""), chromeOptions);
        //Mở app lên chuyển tới màn hình Login
        driver.get("https://nhanam.vn/account/register");
    }
    @Test
    public void TC_01_(){
        //Lấy ra title của page hiện tại
        //1. Lưu dữ liệu lại rồi kiểm tra sau
        String homePageTitle = driver.getTitle();
        Assert.assertEquals(homePageTitle, "Login");
        Assert.assertTrue(homePageTitle.contains("Lo"));
        //2. Kiểm tra trực tiếp
        Assert.assertEquals(driver.getTitle(), "Login");

        //Dùng để chờ cho việc tìm element
        WebDriver.Timeouts timeouts = driver.manage().timeouts();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        timeouts.implicitlyWait(Duration.ofMinutes(1));
        //Thu nhỏ về taskbar để chạy. Ngoài ra còn phóng to, full màn hình: max, full
        WebDriver.Window window =  driver.manage().window();
        driver.manage().window().minimize();
        driver.manage().window().maximize();
        driver.manage().window().fullscreen();
        //Test reponsive với từng kích thước khác nhau. Test GUI
        driver.manage().window().setSize(new Dimension(1366, 756));
        driver.manage().window().getSize();

        driver.manage().window().setPosition(new Point(0,0));
        driver.manage().window().getPosition();
        //Lấy hết tất cả cookie
        driver.manage().getCookies();
        //Lấy name  cookie của Kho dữ liệu
        driver.manage().getCookieNamed("GR_LGURI");
        //Xóa hết cookie
        driver.manage().deleteAllCookies();
        //Xóa cookie theo thứ tự
        Set<Cookie> cookieSet = driver.manage().getCookies();
        for (Cookie cookie : cookieSet ){
            driver.manage().deleteCookie(cookie);
        }
        //Xóa cookie theo tên
        driver.manage().deleteCookieNamed("GR_LGURI");
    }
    @AfterClass
    public void cleanBrowser(){
        driver.quit();
    }

    // Tên biến/hàm: chữ cái đầu viết thường
    //Selenium: KHi thao tác với 1 element (findElement) thì trường hợp truyeenf vào 1 locator không phải là duy nhất (có nhiều hơn 1)
    // -> thì khi thao tác lên element sẽ lấy cái locator đầu tiên
}
