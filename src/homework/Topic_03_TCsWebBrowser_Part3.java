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
    By myAcc = By.xpath("//div[@class='footer']//a[@title='My Account']");
    By createAcc = By.xpath("//a[@class='button']");
    By emailT = By.xpath("//input[@id='mail']");
    By ageR = By.xpath("//input[@id='under_18']");
    By edu = By.id("edu");

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
    @Test
    public void TC08_Check_All_Selected_Enable_Displayed() {
        driver.get("https://login.mailchimp.com/signup/");
        WebElement emailInput = driver.findElement(By.id("email"));
        //emailInput.sendKeys("");

        WebElement usernameInput = driver.findElement(By.id("new_username"));
        if (usernameInput.isDisplayed()){
            System.out.println("Có hiển thị");
        }else {
            System.out.println("Không hiển thị");
        }

        WebElement passInput = driver.findElement(By.id("new_password"));
        passInput.sendKeys("");

    }
    @Test
    public void TC09_Check_Enabled() {

    }
    @AfterClass
    public void cleanBrowser(){
        //driver.quit();
    }
}
