package homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Random;

public class Topic_05_TCs_TextboxTextArea_Part3 {
    //Khai báo
    WebDriver driver;
    By myAcc = By.xpath("//div[@class='footer']//a[@title='My Account']");
    By createAcc = By.xpath("//a[@class='button']");
    String firstName, lastName, fullName, emailAdd, pass;
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
        pass = "1234567";

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
        driver.findElement(By.xpath("//textare[@id='review_field']")).sendKeys("Very good\n from Mai");
        driver.findElement(By.xpath("//input[@id='summary_field']")).sendKeys("Good Phone");
        driver.findElement(By.xpath("//button[@title='Submit Review']")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("li.success-msg span")).getText(),"Your review has been accept for moderation.");

        //logout
        driver.findElement(By.cssSelector("div.account-cart-wrapper a")).click();
        driver.findElement(By.xpath("//li[@class=' last']")).click();
        Thread.sleep(6000);
        Assert.assertEquals(driver.getCurrentUrl(), "http://live.techpanda.org/index.php/");

    }
    @AfterClass
    public void cleanBrowser(){
        //driver.quit();
    }

    // Tên biến/hàm: chữ cái đầu viết thường
    //Selenium: KHi thao tác với 1 element (findElement) thì trường hợp truyeenf vào 1 locator không phải là duy nhất (có nhiều hơn 1)
    // -> thì khi thao tác lên element sẽ lấy cái locator đầu tiên
}
