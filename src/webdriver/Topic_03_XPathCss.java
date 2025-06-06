package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_03_XPathCss {
    WebDriver driver;
    public void initialBrowser(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @Test
    public void xPathCss(){
        driver = new FirefoxDriver();
        driver.get("https://nhanam.vn/account/register");
        //Tiêu chí chọn: duy nhất - id/class/name - giá trị của attribute phải có nghĩa (liên quan tới element đó)
        //Relative Xpath Format: //tagname[@attribute='value']

        //Đối với các element che mất/bị ẩn/không nằm trong viewport (nằm phía dưới hoặc phía trên màn hình đang chạy) / không tìm được thuộc tính trong thẻ là duy nhất
        // Tìm thuộc tính trong element cha của nó
        //<a class="a-img" href="/gioi-thieu" title="Về Nhã Nam"> Về Nhã Nam</a>
        //<a href="/gioi-thieu" title="Về Nhã Nam">Về Nhã Nam</a>
        driver.findElement(By.xpath("//li[@class='li_menu']//a[@title='Về Nhã Nam']")).click();
    }


}
