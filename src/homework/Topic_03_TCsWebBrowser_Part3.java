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

public class Topic_03_TCsWebBrowser_Part3 {
    WebDriver driver;
    @BeforeClass
    public void initialBrowser(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @Test
    public void TC01_Verify_Url() {
        driver.get("http://live.techpanda.org/");
        driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
        String loginUrl = driver.getCurrentUrl();
        //Assert.assertEquals(loginUrl, "http://live.techpanda.org/index.php/customer/account/login/");
        Assert.assertTrue(loginUrl.equals("http://live.techpanda.org/index.php/customer/account/login/"));
        Assert.assertFalse(loginUrl.equals("http://live.techpanda.org"));

        driver.findElement(By.xpath("//a[@class='button']")).click();
        String registerUrl = driver.getCurrentUrl();
        //Assert.assertEquals(registerUrl, "http://live.techpanda.org/index.php/customer/account/create/");
        Assert.assertTrue(registerUrl.equals("http://live.techpanda.org/index.php/customer/account/create/"));
        Assert.assertFalse(registerUrl.equals("http://live.techpanda.org"));
    }
    @Test
    public void TC02_Verify_Title() {
        driver.get("http://live.techpanda.org/");
        driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
        String loginTitle = driver.getTitle();
        Assert.assertEquals(loginTitle,"Customer Login");

        driver.findElement(By.xpath("//a[@class='button']")).click();
        String registerTitle = driver.getTitle();
        Assert.assertEquals(registerTitle,"Create New Customer Account");
    }
    @Test
    public void TC03_Navigate_Function() {
        driver.get("http://live.techpanda.org/");
        driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
        driver.findElement(By.xpath("//a[@class='button']")).click();
        String registerUrl = driver.getCurrentUrl();
        Assert.assertEquals(registerUrl, "http://live.techpanda.org/index.php/customer/account/create/");
        driver.navigate().back();
        String loginUrl = driver.getCurrentUrl();
        Assert.assertEquals(loginUrl, "http://live.techpanda.org/index.php/customer/account/login/");
        driver.navigate().forward();
        String registerTitle = driver.getTitle();
        Assert.assertEquals(registerTitle,"Create New Customer Account");
    }
    @Test
    public void TC04_GetPage_SourceCode() {
        driver.get("http://live.techpanda.org/");
        driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
        String loginPageSource = driver.getPageSource();
        Assert.assertTrue(loginPageSource.contains("Login or Create an Account"));
        driver.findElement(By.xpath("//a[@class='button']")).click();
        String registerPageSource = driver.getPageSource();
        Assert.assertTrue(registerPageSource.contains("Create an Account"));
    }
    @Test
    public void TC05_Check_Displayed() {
        driver.get("https://automationfc.github.io/basic-form/index.html");
        WebElement emailTextbox = driver.findElement(By.xpath("//input[@id='mail']"));
        if(emailTextbox.isDisplayed()){
            System.out.println("Email is displayed");
            emailTextbox.sendKeys("Automation Testing");
        }else {
            System.out.println("Email is not displayed");
        };

        WebElement ageCheckbox = driver.findElement(By.xpath("//input[@id='under_18']"));
        if(ageCheckbox.isDisplayed()){
            System.out.println("Age (Under 18) is displayed");
            emailTextbox.click();
        }else {
            System.out.println("Age (Under 18) is not displayed");
        };

        WebElement educationTextArea = driver.findElement(By.id("edu"));
        if(educationTextArea.isDisplayed()){
            System.out.println("Education is displayed");
            educationTextArea.sendKeys("Automation Testing");
        }else {
            System.out.println("Education is not displayed");
        };

        WebElement nameText = driver.findElement(By.xpath("//h5[text()='Name: User5']"));
        if(nameText.isDisplayed()){
            System.out.println("Name: User5 is displayed");
        }else {
            System.out.println("Name: User5 is not displayed");
        };

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
        //driver.quit();
    }
}
