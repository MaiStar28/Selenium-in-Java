package homework;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_03_TCsWebBrowser_Part3 {
    WebDriver driver;
    By myAcc = By.xpath("//div[@class='footer']//a[@title='My Account']");
    By createAcc = By.xpath("//a[@class='button']");
    By emailT = By.xpath("//input[@id='mail']");
    By ageR = By.xpath("//input[@id='under_18']");
    By edu = By.id("edu");
    By emailLogin = By.xpath("//input[@id='email']");
    By passLogin = By.xpath("//input[@id='pass']");
    By loginB = By.xpath("//button[@id='send2']");

    By oneLowercaseF = By.xpath("//li[@class='lowercase-char not-completed']");
    By oneUppercaseF = By.xpath("//li[@class='uppercase-char not-completed']");
    By oneNumberF = By.xpath("//li[@class='number-char not-completed']");
    By oneSpecialF = By.xpath("//li[@class='special-char not-completed']");
    By eightCharactersF = By.xpath("//li[@class='8-char not-completed']");
    By mustNotContainUsernameF = By.xpath("//li[@class='username-check not-completed']");

    By oneLowercaseT = By.xpath("//li[@class='lowercase-char completed']");
    By oneUppercaseT = By.xpath("//li[@class='uppercase-char completed']");
    By oneNumberT = By.xpath("//li[@class='number-char completed']");
    By oneSpecialT = By.xpath("//li[@class='special-char completed']");
    By eightCharactersT = By.xpath("//li[@class='8-char completed']");
    By mustNotContainUsernameT = By.xpath("//li[@class='username-check completed']");

    @BeforeClass
    public void initialBrowser(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @Test
    public void TC01_Verify_Url() {
        driver.get("http://live.techpanda.org/");
        driver.findElement(myAcc).click();
        String loginUrl = driver.getCurrentUrl();
        //Assert.assertEquals(loginUrl, "http://live.techpanda.org/index.php/customer/account/login/");
        Assert.assertTrue(loginUrl.equals("http://live.techpanda.org/index.php/customer/account/login/"));
        Assert.assertFalse(loginUrl.equals("http://live.techpanda.org"));

        driver.findElement(createAcc).click();
        String registerUrl = driver.getCurrentUrl();
        //Assert.assertEquals(registerUrl, "http://live.techpanda.org/index.php/customer/account/create/");
        Assert.assertTrue(registerUrl.equals("http://live.techpanda.org/index.php/customer/account/create/"));
        Assert.assertFalse(registerUrl.equals("http://live.techpanda.org"));
    }
    @Test
    public void TC02_Verify_Title() {
        driver.get("http://live.techpanda.org/");
        driver.findElement(myAcc).click();
        String loginTitle = driver.getTitle();
        Assert.assertEquals(loginTitle,"Customer Login");

        driver.findElement(createAcc).click();
        String registerTitle = driver.getTitle();
        Assert.assertEquals(registerTitle,"Create New Customer Account");
    }
    @Test
    public void TC03_Navigate_Function() {
        driver.get("http://live.techpanda.org/");
        driver.findElement(myAcc).click();
        driver.findElement(createAcc).click();
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
        driver.findElement(myAcc).click();
        String loginPageSource = driver.getPageSource();
        Assert.assertTrue(loginPageSource.contains("Login or Create an Account"));
        driver.findElement(createAcc).click();
        String registerPageSource = driver.getPageSource();
        Assert.assertTrue(registerPageSource.contains("Create an Account"));
    }
    @Test
    public void TC05_Check_Displayed() {
        driver.get("https://automationfc.github.io/basic-form/index.html");
        WebElement emailTextbox = driver.findElement(emailT);
        if(emailTextbox.isDisplayed()){
            System.out.println("Email is displayed");
            emailTextbox.sendKeys("Automation Testing");
        }else {
            System.out.println("Email is not displayed");
        }

        WebElement ageCheckbox = driver.findElement(ageR);
        if(ageCheckbox.isDisplayed()){
            System.out.println("Age (Under 18) is displayed");
            emailTextbox.click();
        }else {
            System.out.println("Age (Under 18) is not displayed");
        }

        WebElement educationTextArea = driver.findElement(edu);
        if(educationTextArea.isDisplayed()){
            System.out.println("Education is displayed");
            educationTextArea.sendKeys("Automation Testing");
        }else {
            System.out.println("Education is not displayed");
        }

        WebElement nameText = driver.findElement(By.xpath("//h5[text()='Name: User5']"));
        if(nameText.isDisplayed()){
            System.out.println("Name: User5 is displayed");
        }else {
            System.out.println("Name: User5 is not displayed");
        }

    }
    @Test
    public void TC06_Check_Enabled() {
        driver.get("https://automationfc.github.io/basic-form/index.html");
        WebElement emailTextbox = driver.findElement(emailT);
        if(emailTextbox.isEnabled()){
            System.out.println("Email is enabled");
        }else {
            System.out.println("Email is disabled");
        }

        WebElement ageCheckbox = driver.findElement(ageR);
        if(ageCheckbox.isEnabled()){
            System.out.println("Age (Under 18) is enabled");
        }else {
            System.out.println("Age (Under 18) is disabled");
        }

        WebElement educationTextArea = driver.findElement(edu);
        if(educationTextArea.isEnabled()){
            System.out.println("Education is enabled");
        }else {
            System.out.println("Education is disabled");
        }

        WebElement jobRole1 = driver.findElement(By.xpath("//select[@id='job1']"));
        if(jobRole1.isEnabled()){
            System.out.println("Job Role 01 is enabled");
        }else {
            System.out.println("Job Role 01 is disabled");
        }

        WebElement jobRole2 = driver.findElement(By.xpath("//select[@id='job2']"));
        if(jobRole2.isEnabled()){
            System.out.println("Job Role 02 is enabled");
        }else {
            System.out.println("Job Role 02 is disabled");
        }

        WebElement interestDev = driver.findElement(By.xpath("//input[@id='development']"));
        if(interestDev.isEnabled()){
            System.out.println("Interests (Development) is enabled");
        }else {
            System.out.println("Interests (Development) is disabled");
        }

        WebElement slider1 = driver.findElement(By.xpath("//input[@id='slider-1']"));
        if(slider1.isEnabled()){
            System.out.println("Slider 01 is enabled");
        }else {
            System.out.println("Slider 01 is disabled");
        }

        WebElement passDisabled = driver.findElement(By.xpath("//input[@id='disable_password']"));
        if(passDisabled.isEnabled()){
            System.out.println("Password is enabled");
        }else {
            System.out.println("Password is disabled");
        }

        WebElement ageDisabled = driver.findElement(By.xpath("//input[@id='radio-disabled']"));
        if(ageDisabled.isEnabled()){
            System.out.println("Age is enabled");
        }else {
            System.out.println("Age is disabled");
        }

        WebElement biographyDisabled = driver.findElement(By.xpath("//textarea[@id='bio']"));
        if(biographyDisabled.isEnabled()){
            System.out.println("Biography is enabled");
        }else {
            System.out.println("Biography is disabled");
        }

        WebElement jobRole3 = driver.findElement(By.xpath("//select[@id='job3']"));
        if(jobRole3.isEnabled()){
            System.out.println("Job Role 03 is enabled");
        }else {
            System.out.println("Job Role 03 is disabled");
        }

        WebElement interestDisabled = driver.findElement(By.xpath("//input[@id='check-disbaled']"));
        if(interestDisabled.isEnabled()){
            System.out.println("Interests (Disabled) is enabled");
        }else {
            System.out.println("Interests (Disabled) is disabled");
        }

        WebElement slider2 = driver.findElement(By.xpath("//input[@id='slider-2']"));
        if(slider2.isEnabled()){
            System.out.println("Slider 02 is enabled");
        }else {
            System.out.println("Slider 02 is disabled");
        }
    }
    @Test
    public void TC07_Check_Selected() {
        driver.get("https://automationfc.github.io/basic-form/index.html");
        WebElement ageCheckbox = driver.findElement(ageR);
        ageCheckbox.click();
        if(ageCheckbox.isSelected()){
            System.out.println("Age (Under 18) is selected");
        }else {
            System.out.println("Age (Under 18) is de-selected");
        }
        WebElement languageC = driver.findElement(By.xpath("//input[@id='java']"));
        languageC.click();
        if(languageC.isSelected()){
            System.out.println("Languages is selected");
        }else {
            System.out.println("Languages is de-selected");
        }

        languageC.click();
        if(ageCheckbox.isSelected() && languageC.isSelected() ){
            System.out.println("Age (Under 18) is selected");
            System.out.println("Languages is selected");
        }else {
            System.out.println("Age (Under 18) is de-selected");
            System.out.println("Languages is de-selected");
        }
    }
    //Register function at MailChimp
    @Test
    public void TC08_Check_All_Selected_Enable_Displayed() throws InterruptedException {
        driver.get("https://login.mailchimp.com/signup/");
        WebElement emailInput = driver.findElement(By.id("email"));
        WebElement newPass = driver.findElement(By.id("new_password"));

        emailInput.sendKeys("mai@gmail.com");
        emailInput.sendKeys(Keys.TAB); //click nut TAB de tu dong nhap username

        // Nhập số
        newPass.sendKeys("123");
        newPass.sendKeys(Keys.TAB);

        Assert.assertTrue(driver.findElement(oneLowercaseF).isDisplayed());
        Assert.assertTrue(driver.findElement(oneUppercaseF).isDisplayed());
        Assert.assertTrue(driver.findElement(oneNumberT).isDisplayed());
        Assert.assertTrue(driver.findElement(oneSpecialF).isDisplayed());
        Assert.assertTrue(driver.findElement(eightCharactersF).isDisplayed());
        Assert.assertTrue(driver.findElement(mustNotContainUsernameT).isDisplayed());
        Thread.sleep(3000);

        // Nhập chữ thường
        newPass.clear();
        newPass.sendKeys("abcd");
        newPass.sendKeys(Keys.TAB);

        Assert.assertTrue(driver.findElement(oneLowercaseT).isDisplayed());
        Assert.assertTrue(driver.findElement(oneUppercaseF).isDisplayed());
        Assert.assertTrue(driver.findElement(oneNumberF).isDisplayed());
        Assert.assertTrue(driver.findElement(oneSpecialF).isDisplayed());
        Assert.assertTrue(driver.findElement(eightCharactersF).isDisplayed());
        Assert.assertTrue(driver.findElement(mustNotContainUsernameT).isDisplayed());
        Thread.sleep(3000);

        // Nhập chữ hoa
        newPass.clear();
        newPass.sendKeys("ABCD");
        newPass.sendKeys(Keys.TAB);

        Assert.assertTrue(driver.findElement(oneLowercaseF).isDisplayed());
        Assert.assertTrue(driver.findElement(oneUppercaseT).isDisplayed());
        Assert.assertTrue(driver.findElement(oneNumberF).isDisplayed());
        Assert.assertTrue(driver.findElement(oneSpecialF).isDisplayed());
        Assert.assertTrue(driver.findElement(eightCharactersF).isDisplayed());
        Assert.assertTrue(driver.findElement(mustNotContainUsernameT).isDisplayed());
        Thread.sleep(3000);

        // Nhập kí tự đặc biệt
        newPass.clear();
        newPass.sendKeys("@#$");
        newPass.sendKeys(Keys.TAB);

        Assert.assertTrue(driver.findElement(oneLowercaseF).isDisplayed());
        Assert.assertTrue(driver.findElement(oneUppercaseF).isDisplayed());
        Assert.assertTrue(driver.findElement(oneNumberF).isDisplayed());
        Assert.assertTrue(driver.findElement(oneSpecialT).isDisplayed());
        Assert.assertTrue(driver.findElement(eightCharactersF).isDisplayed());
        Assert.assertTrue(driver.findElement(mustNotContainUsernameT).isDisplayed());
        Thread.sleep(3000);

        // Nhập full
        newPass.clear();
        newPass.sendKeys("Abc123@123");
        newPass.sendKeys(Keys.TAB);

        Assert.assertFalse(driver.findElement(oneLowercaseT).isDisplayed());
        Assert.assertFalse(driver.findElement(oneUppercaseT).isDisplayed());
        Assert.assertFalse(driver.findElement(oneNumberT).isDisplayed());
        Assert.assertFalse(driver.findElement(oneSpecialT).isDisplayed());
        Assert.assertFalse(driver.findElement(eightCharactersT).isDisplayed());
        Assert.assertFalse(driver.findElement(mustNotContainUsernameT).isDisplayed());
        Thread.sleep(3000);
    }
    @Test
    public void TC09_Login_Empty() {
        driver.get("https://live.techpanda.org/");
        driver.findElement(myAcc).click();
        driver.findElement(loginB).click();
        Assert.assertEquals(driver.findElement(By.id("advice-required-entry-email")).getText(), "This is a required field.");
        Assert.assertEquals(driver.findElement(By.id("advice-required-entry-pass")).getText(), "This is a required field.");
    }
    @Test
    public void TC10_Login_Invalid_Email() {
        driver.get("https://live.techpanda.org/");
        driver.findElement(myAcc).click();
        driver.findElement(emailLogin).sendKeys("123@123.123");
        driver.findElement(passLogin).sendKeys("123456");
        driver.findElement(loginB).click();
        Assert.assertEquals(driver.findElement(By.id("advice-validate-email-email")).getText(), "Please enter a valid email address. For example johndoe@domain.com.");
    }
    @Test
    public void TC11_Login_Invalid_Pass() {
        driver.get("https://live.techpanda.org/");
        driver.findElement(myAcc).click();
        driver.findElement(emailLogin).sendKeys("maihts@elcom.com.vn");
        driver.findElement(passLogin).sendKeys("123");
        driver.findElement(loginB).click();
        Assert.assertEquals(driver.findElement(By.id("advice-validate-password-pass")).getText(), "Please enter 6 or more characters without leading or trailing spaces.");
    }
    @Test
    public void TC12_Login_Incorrect_Email_Pass() {
        driver.get("https://live.techpanda.org/");
        driver.findElement(myAcc).click();
        driver.findElement(emailLogin).sendKeys("maihts@elcom.com.vn");
        driver.findElement(passLogin).sendKeys("123456");
        driver.findElement(loginB).click();
        // Chờ alert xuất hiện
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.alertIsPresent());
        // Chuyển sang alert - OK
        Alert alert = driver.switchTo().alert();
        alert.accept();
        Assert.assertEquals(driver.findElement(By.xpath("//li/span")).getText(), "Invalid login or password.");
    }
    @AfterClass
    public void cleanBrowser(){
        //driver.quit();
    }
}
