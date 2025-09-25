package homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Instant;
import java.util.Random;

public class Topic_05_TCs_TextboxTextArea_Part3 {
    //Khai báo
    WebDriver driver;
    By myAcc = By.xpath("//div[@class='footer']//a[@title='My Account']");
    By createAcc = By.xpath("//a[@class='button']");
    String firstName, lastName, fullName, emailAdd, pass,userName,phoneNumber, comment;
    Random rand;

    @BeforeClass
    public void initialBrowser(){
        //Mở browser lên
        driver = new FirefoxDriver();
        rand = new Random();
        firstName = "mai";
        lastName = "mai";
        fullName = firstName + " " + lastName;
        emailAdd = "hoang" + rand.nextInt(999) + "@gmail.com";
        pass = "1234567m";
        userName = "maiimaii1234";
        phoneNumber = "0362646254";
        comment = "Hoàng Mai share cmt\nVery good\nYes";
    }
    @Test
    public void TC_01_TechPanda() throws InterruptedException {
        driver.get("http://live.techpanda.org/");
        driver.findElement(myAcc).click();
        driver.findElement(createAcc).click();
        driver.findElement(By.cssSelector("input#firstname")).sendKeys(firstName);
        driver.findElement(By.cssSelector("input#lastname")).sendKeys(lastName);
        driver.findElement(By.cssSelector("input#email_address")).sendKeys(emailAdd);
        driver.findElement(By.cssSelector("input#password")).sendKeys(pass);
        driver.findElement(By.cssSelector("input#confirmation")).sendKeys(pass);
        driver.findElement(By.xpath("//button[@title='Register']")).click();

        //Tuyệt đối
        Assert.assertEquals(driver.findElement(By.cssSelector("li.success-msg span")).getText(), "Thank you for registering with Main Website Store.");
        String contactInforText = driver.findElement(By.xpath("//h3[text()='Contact Information']/parent::div/following-sibling::div/p")).getText();
        //Tương đối
        Assert.assertTrue(contactInforText.contains(fullName) && contactInforText.contains(emailAdd)); //chứa full name+email
        driver.findElement(By.xpath("//h3[text()='Contact Information']/following-sibling::a")).click();
        Assert.assertEquals(driver.findElement(By.id("firstname")).getAttribute("value"),firstName);
        Assert.assertEquals(driver.findElement(By.id("lastname")).getAttribute("value"),lastName);
        Assert.assertEquals(driver.findElement(By.id("email")).getAttribute("value"),emailAdd);
        //Product Review TextArea
        driver.findElement(By.xpath("//a[text()='Mobile']")).click();
        driver.findElement(By.xpath("//h2/a[@title='Samsung Galaxy']")).click();
        driver.findElement(By.xpath("//a[text()='Add Your Review']")).click();
        driver.findElement(By.xpath("//input[@id='Quality 1_5']")).click();
        driver.findElement(By.xpath("//textarea[@id='review_field']")).sendKeys("Very good\n from Mai");
        driver.findElement(By.xpath("//input[@id='summary_field']")).sendKeys("Good Phone");
        driver.findElement(By.xpath("//button[@title='Submit Review']")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("li.success-msg span")).getText(),"Your review has been accepted for moderation.");

        //logout
        driver.findElement(By.cssSelector("div.account-cart-wrapper a")).click();
        driver.findElement(By.xpath("//li[@class=' last']")).click();
        Thread.sleep(6000);
        Assert.assertEquals(driver.getCurrentUrl(), "http://live.techpanda.org/index.php/");

    }
    @Test
    public void TC_02_OrangeHRM() throws InterruptedException {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//span[text()='PIM']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[text()='Add Employee']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys(firstName);
        driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys(lastName);
        String employeeID = driver.findElement(By.xpath("//label[text()='Employee Id']/parent::div/following-sibling::div/input")).getAttribute("value");
        driver.findElement(By.xpath("//div[@class='oxd-switch-wrapper']")).click();
        driver.findElement(By.xpath("//label[text()='Username']/parent::div/following-sibling::div/input")).sendKeys(userName);
        driver.findElement(By.xpath("//label[text()='Password']/parent::div/following-sibling::div/input")).sendKeys(pass);
        driver.findElement(By.xpath("//label[text()='Confirm Password']/parent::div/following-sibling::div/input")).sendKeys(pass);
        driver.findElement(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']")).click();
        Thread.sleep(9000);
        Assert.assertEquals(driver.findElement(By.xpath("//input[@name='firstName']")).getAttribute("value"), firstName);
        Assert.assertEquals(driver.findElement(By.xpath("//input[@name='lastName']")).getAttribute("value"), lastName);
        Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Employee Id']/parent::div/following-sibling::div/input")).getAttribute("value"), employeeID);
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[text()='Immigration']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//h6[text()='Assigned Immigration Records']/following-sibling::button")).click();
        driver.findElement(By.xpath("//label[text()='Number']/parent::div/following-sibling::div/input")).sendKeys(phoneNumber);
        driver.findElement(By.xpath("//textarea[@class='oxd-textarea oxd-textarea--active oxd-textarea--resize-vertical']")).sendKeys(comment);
        driver.findElement(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']")).click();
        Thread.sleep(7000);
        driver.findElement(By.xpath("//i[@class='oxd-icon bi-pencil-fill']")).click();
        Thread.sleep(3000);
        Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Number']/parent::div/following-sibling::div/input")).getAttribute("value"),phoneNumber);
        Assert.assertEquals( driver.findElement(By.xpath("//textarea[@class='oxd-textarea oxd-textarea--active oxd-textarea--resize-vertical']")).getAttribute("value"),comment);

        driver.findElement(By.xpath("//div[@class='oxd-topbar-header-userarea']")).click();
        driver.findElement(By.xpath("//a[text()='Logout']")).click();

        Thread.sleep(5000);
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys(userName);
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys(pass);
        driver.findElement(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//span[text()='My Info']")).click();
        Thread.sleep(3000);
        Assert.assertEquals(driver.findElement(By.xpath("//input[@name='firstName']")).getAttribute("value"), firstName);
        Assert.assertEquals(driver.findElement(By.xpath("//input[@name='lastName']")).getAttribute("value"), lastName);
        Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Employee Id']/parent::div/following-sibling::div/input")).getAttribute("value"), employeeID);
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[text()='Immigration']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//i[@class='oxd-icon bi-pencil-fill']")).click();
        Thread.sleep(3000);
        Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Number']/parent::div/following-sibling::div/input")).getAttribute("value"),phoneNumber);
        Assert.assertEquals( driver.findElement(By.xpath("//textarea[@class='oxd-textarea oxd-textarea--active oxd-textarea--resize-vertical']")).getAttribute("value"),comment);

    }

    @Test
    public void TC_03_NopCommerce() throws InterruptedException {
        driver.get("https://demo.nopcommerce.com/register");
        driver.findElement(By.cssSelector("a.ico-register")).click();

    }
    @AfterClass
    public void cleanBrowser(){
        //driver.quit();
    }

    // Tên biến/hàm: chữ cái đầu viết thường
    //Selenium: KHi thao tác với 1 element (findElement) thì trường hợp truyeenf vào 1 locator không phải là duy nhất (có nhiều hơn 1)
    // -> thì khi thao tác lên element sẽ lấy cái locator đầu tiên
}
