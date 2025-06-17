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
    public void xPath(){
        driver = new FirefoxDriver();
        driver.get("https://nhanam.vn/account/register");
        //driver.get("https://nhanam.vn/triet-hoc");
        //Tiêu chí chọn: duy nhất - id/class/name - giá trị của attribute phải có nghĩa (liên quan tới element đó)
        //Relative Xpath Format: //tagname[@attribute='value']

        //1. Đối với các element che mất/bị ẩn/không nằm trong viewport (nằm phía dưới hoặc phía trên màn hình đang chạy) / không tìm được thuộc tính trong thẻ là duy nhất => Tìm thuộc tính trong element cha của nó
        driver.findElement(By.xpath("//li[@class='li_menu']//a[@title='Về Nhã Nam']")).click();

        //2. Hàm text()
        driver.findElement(By.xpath("//p[text()='Đổi trả dễ dàng']"));

        //3. Hàm contains()
        driver.findElement(By.xpath("//p[contains(text(), 'Tích điểm')]"));
        driver.findElement(By.xpath("//a[contains(@title,'độc giả')]"));
        driver.findElement(By.xpath("//a[contains(@title,'độc giả')]"));
        driver.findElement(By.xpath("//ul[@class='list-menu']//a[contains(@href,'tuyen')]"));
        driver.findElement(By.xpath("//a[contains(.,'Nhã')]"));
        driver.findElement(By.xpath("//a[contains(string(),'Nhã')]"));

        //4. Hàm concat()
        // Ví dụ: Hello "Mai", What's happened?
        //xpath: //p[text()=concat('Hello "Mai" What',"'s happened?")]

        //5. Hàm starts-with: dùng khi thuộc tính của 1 element với mỗi lần lấy xpath nó thay đổi liên tục nhưng text ở đâu luôn cố định
        // Ví dụ: màn Login của web Lazada với trường Nhập Your phone or Email
        //xpath: //input[starts-with(@data-spm-anchor-id,'a2o4n.tm80151110')]

        //6. Hàm AND OR NOT
        driver.findElement(By.xpath("//input[@id='lastName' and @placeholder='Họ']"));
        driver.findElement(By.xpath("//input[@id='lastName' or @name='firstName']"));

        //7. Xpath Axes
        //Xpath: //button[@title='Mua ngay']/parent::*/preceding-sibling::a[@title='CON ĐƯỜNG TỈNH THỨC']
        driver.findElement(By.xpath("//button[@title='Mua ngay']/parent::*/preceding-sibling::a[@title='CON ĐƯỜNG TỈNH THỨC']")).click();
    }


}
