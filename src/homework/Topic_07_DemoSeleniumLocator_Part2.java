package homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
public class Topic_07_DemoSeleniumLocator_Part2 {
    WebDriver driver;
    //abc
    @BeforeClass
    public void initialBrowser(){
        driver = new FirefoxDriver();
        driver.get("https://nhanam.vn/account/register");
    }
    @Test
    public void TC_01_ID() throws InterruptedException {
        driver.findElement(By.id("lastName")).sendKeys("Hoang");
        driver.findElement(By.id("firstName")).sendKeys("Mai");
        driver.findElement(By.id("PhoneNumber")).sendKeys("0985475125");
        driver.findElement(By.id("email")).sendKeys("mai@gmail.com");
        driver.findElement(By.id("password")).sendKeys("Mai@123");
        Thread.sleep(4000);
    }
    @Test
    public void TC_02_Class() throws InterruptedException {
        driver.findElement(By.className("btn-login")).click();
        Thread.sleep(4000);
    }
    @Test
    public void TC_03_Name() throws InterruptedException {
        driver.findElement(By.name("firstName"));
        Thread.sleep(4000);
    }
    @Test
    public void TC_04_LinkText() throws InterruptedException {
        driver.findElement(By.linkText("info@nhanam.vn")).click();
        Thread.sleep(2000);
        driver.findElement(By.linkText("Về Nhã Nam")).click();
        Thread.sleep(3000);
    }
    @Test
    public void TC_05_Partial_Link_Text() {
        driver.findElement(By.partialLinkText("Tuyển")).click();
        driver.findElement(By.partialLinkText("dụng")).click();
    }
    @Test
    public void TC_06_Tagname() {
        //driver.findElements(By.tagName("button"));
        driver.findElements(By.tagName("a"));
    }
    @Test
    public void TC_07_Css() {
        driver.findElements(By.cssSelector("input[id='lastName']"));
        driver.findElements(By.cssSelector("button.btn search-button"));
        driver.findElements(By.cssSelector("button[class='btn search-button']"));
        driver.findElements(By.cssSelector("select[name='Phone']"));
        driver.findElements(By.cssSelector("a[href*='tin-sach?']"));
    }
    @Test
    public void TC_08_xPath() {
        driver.findElements(By.xpath("//input[@id='firstName']"));

        driver.findElements(By.xpath("//button[@class='btn search-button']"));
        driver.findElements(By.xpath("//button[contains(@class,'search-button')]"));

        driver.findElements(By.xpath("//select[@name='Phone']"));

        driver.findElements(By.xpath("//a[text()='Chính sách bảo mật']"));
        driver.findElements(By.xpath("//a[contains(text(),'Chính sách')]"));
    }
    @AfterClass
    public void cleanBrowser() {
        driver.quit();
    }
}
