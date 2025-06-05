package homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_08_XpathCSS_Part2 {
    WebDriver driver;
    //Demo Selenium 4 Relative Locator + Locator Priority
    @Test
    public void TC_01_RelativeLocator() throws InterruptedException {
        driver = new FirefoxDriver();
        driver.get("https://nhanam.vn/lien-he");
        //<textarea placeholder="" name="contact[body]" id="comment" class="form-control content-area form-control-lg" rows="5" required=""></textarea>
        WebElement noiDung = driver.findElement(By.cssSelector("textarea#comment"));
        //By noiDung = By.cssSelector("textarea#comment");

        //<input placeholder="" type="text" class="form-control  form-control-lg" required="" value="Hoàng Ngọc" name="contact[Name]">
        WebElement hoTen = driver.findElement(By.cssSelector("input[name='contact[Name]']"));
        //By hoTen = By.cssSelector("input[name='contact[Name]']");

        WebElement email= driver.findElement(RelativeLocator.with(By.tagName("input")).below(hoTen).toLeftOf(noiDung));
        WebElement guiLienHe = driver.findElement(By.className("button-default"));

        noiDung.sendKeys("Tôi muốn được liên hệ qua zalo");
        hoTen.sendKeys("Hoàng Mai");
        email.sendKeys("mai@gmail.com");
        guiLienHe.click();
        Thread.sleep(3000);
    }
}
