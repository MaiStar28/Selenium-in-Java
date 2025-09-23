package homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_09_TCs_Xpath_Part2 {
    WebDriver driver;
    @BeforeClass
    public void initialBrowser(){
        driver = new FirefoxDriver();
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @Test
    public void Register_01_Empty_Data() {
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        Assert.assertEquals(driver.findElement(By.id("txtFirstname-error")).getText(), "Vui lòng nhập họ tên");
        Assert.assertEquals(driver.findElement(By.id("txtEmail-error")).getText(), "Vui lòng nhập email");
        Assert.assertEquals(driver.findElement(By.id("txtCEmail-error")).getText(), "Vui lòng nhập lại địa chỉ email");
        Assert.assertEquals(driver.findElement(By.id("txtPassword-error")).getText(), "Vui lòng nhập mật khẩu");
        Assert.assertEquals(driver.findElement(By.id("txtCPassword-error")).getText(), "Vui lòng nhập lại mật khẩu");
        Assert.assertEquals(driver.findElement(By.id("txtPhone-error")).getText(), "Vui lòng nhập số điện thoại.");
    }
    @Test
    public void Register_02_Invalid_Email() {
        driver.findElement(By.id("txtFirstname")).sendKeys("Hoàng Mai");
        driver.findElement(By.xpath("//input[@id='txtEmail']")).sendKeys("mai@123@123");
        driver.findElement(By.xpath("//input[@name='txtCEmail']")).sendKeys("mai@123@123");
        driver.findElement(By.id("txtPassword")).sendKeys("12345678");
        driver.findElement(By.id("txtCPassword")).sendKeys("12345678");
        driver.findElement(By.xpath("//input[@id='txtPhone']")).sendKeys("0987451365");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        Assert.assertEquals(driver.findElement(By.id("txtEmail-error")).getText(), "Vui lòng nhập email hợp lệ");
        Assert.assertEquals(driver.findElement(By.id("txtCEmail-error")).getText(), "Vui lòng nhập email hợp lệ");
    }
    @Test
    public void Register_03_Incorrect_Confirm_Email() {
        driver.findElement(By.id("txtFirstname")).sendKeys("Hoàng Mai");
        driver.findElement(By.xpath("//input[@id='txtEmail']")).sendKeys("mai@gmail.com");
        driver.findElement(By.xpath("//input[@name='txtCEmail']")).sendKeys("mai@123");
        driver.findElement(By.id("txtPassword")).sendKeys("12345678");
        driver.findElement(By.id("txtCPassword")).sendKeys("12345678");
        driver.findElement(By.xpath("//input[@id='txtPhone']")).sendKeys("0987451365");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        Assert.assertEquals(driver.findElement(By.id("txtCEmail-error")).getText(), "Email nhập lại không đúng");
    }
    @Test
    public void Register_04_Password() {
        driver.findElement(By.id("txtFirstname")).sendKeys("Hoàng Mai");
        driver.findElement(By.xpath("//input[@id='txtEmail']")).sendKeys("mai@gmail.com");
        driver.findElement(By.xpath("//input[@name='txtCEmail']")).sendKeys("mai@gmail.com");
        driver.findElement(By.id("txtPassword")).sendKeys("123");
        driver.findElement(By.id("txtCPassword")).sendKeys("123");
        driver.findElement(By.xpath("//input[@id='txtPhone']")).sendKeys("0987451365");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        Assert.assertEquals(driver.findElement(By.id("txtPassword-error")).getText(), "Mật khẩu phải có ít nhất 6 ký tự");
        Assert.assertEquals(driver.findElement(By.id("txtCPassword-error")).getText(), "Mật khẩu phải có ít nhất 6 ký tự");
    }
    @Test
    public void Register_05_Incorrect_Confirm_Password() {
        driver.findElement(By.id("txtFirstname")).sendKeys("Hoàng Mai");
        driver.findElement(By.xpath("//input[@id='txtEmail']")).sendKeys("mai@gmail.com");
        driver.findElement(By.xpath("//input[@name='txtCEmail']")).sendKeys("mai@gmail.com");
        driver.findElement(By.id("txtPassword")).sendKeys("123456");
        driver.findElement(By.id("txtCPassword")).sendKeys("123534");
        driver.findElement(By.xpath("//input[@id='txtPhone']")).sendKeys("0987451365");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        Assert.assertEquals(driver.findElement(By.id("txtCPassword-error")).getText(), "Mật khẩu bạn nhập không khớp");
    }
    @Test
    public void Register_06_Invalid_PhoneNumber() {
        //Actions
        driver.findElement(By.id("txtFirstname")).sendKeys("Hoàng Mai");
        driver.findElement(By.xpath("//input[@id='txtEmail']")).sendKeys("mai@gmail.com");
        driver.findElement(By.xpath("//input[@name='txtCEmail']")).sendKeys("mai@gmail.com");
        driver.findElement(By.id("txtPassword")).sendKeys("123456");
        driver.findElement(By.id("txtCPassword")).sendKeys("123456");
        WebElement phoneInput = driver.findElement(By.xpath("//input[@id='txtPhone']"));
        WebElement submitButton = driver.findElement(By.xpath("//button[@type='submit']"));
        //Nhập Phone < 10 kí tự
        phoneInput.sendKeys("0987451");
        submitButton.click();
        WebElement phoneError = driver.findElement(By.xpath("//label[@id='txtPhone-error']"));
        Assert.assertEquals(phoneError.getText(), "Số điện thoại phải từ 10-11 số.");
        //Nhập Phone > 10 kí tự
        phoneInput.clear();
        phoneInput.sendKeys("0987451479864476");
        submitButton.click();
        Assert.assertEquals(phoneError.getText(), "Số điện thoại phải từ 10-11 số.");
        //Nhập Phone với số bắt đầu không phải là đầu số của nhà mạng
        phoneInput.clear();
        phoneInput.sendKeys("1478596214");
        submitButton.click();
        Assert.assertEquals(phoneError.getText(), "Số điện thoại bắt đầu bằng: 09 - 03 - 012 - 016 - 018 - 019 - 088 - 03 - 05 - 07 - 08");
    }
    @AfterClass
    public void cleanBrowser(){
        driver.quit();
    }
}
