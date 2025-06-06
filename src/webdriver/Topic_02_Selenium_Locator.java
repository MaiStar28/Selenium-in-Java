package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class Topic_02_Selenium_Locator {
    //Khai báo
    WebDriver driver;
    @BeforeClass
    public void initialBrowser(){
        //Mở browser lên
        driver = new FirefoxDriver();
        //Mở app lên chuyển tới màn hình Login
        driver.get("https://nhanam.vn/account/register");
    }
    @Test
    public void TC_01_ID() throws InterruptedException {
        //HTML Source Code
        //Thẻ -  Thuộc tính - Giá trị thuộc tính
        //Tagname - Attribute - Value

        //XPath: //tagname[@attribute='value']
        //Css:   tagname[attribute='value']
        //Tương tác lên Email Address textbox
        //8 loại locator để tìm Email Address này

        /*
        Tìm 1 element
        driver.findElement(By.id(""));

        //1 - Thao tác lên luôn (dùng 1 lần thì kh cần khai báo biến)
        driver.findElement(By.id("")).click();

        //2 - Lưu dữ liệu lại (dùng nhiều lần nên khai báo biến)
        WebElement emailTextbox = driver.findElement(By.id(""));
        //cho những lần sau, chỉ cần gọi lại biến emailTextbox
        emailTextbox.clear();
        emailTextbox.sendKeys();
        emailTextbox.isDisplayed();

        //Tìm nhiều element giống nhau
        driver.findElements(By.cssSelector(""));
        */
        driver.findElement(By.id("lastName")).sendKeys("Hoang");
        Thread.sleep(3000);
    }
    @Test
    public void TC_02_Class() {
        // Giá trị trong class mà không có khoảng trắng (lấy toàn bộ)
        // Giá trị trong class mà có khoảng trắng (lấy phần nào là duy nhất)
        driver.findElement(By.className("btn-login"));
    }
    @Test
    public void TC_03_Name() {
        driver.findElement(By.name("firstName"));
    }
    @Test
    public void TC_04_LinkText() {
        //Chỉ làm việc với element là link và có text
        //Thẻ a và có thuộc tính href
        driver.findElement(By.linkText("info@nhanam.vn"));
    }
    @Test
    public void TC_05_Partial_Link_Text() {
        //Chỉ làm việc với element là link
        //Có thể lấy hết toàn bộ text hoặc 1 phần (hay dùng): ví dụ tìm link là Tuyển dụng
        driver.findElement(By.partialLinkText("Tuyển"));
        driver.findElement(By.partialLinkText("dụng"));
        //Chú ý: khi dùng Partial_Link_Text: sẽ bị trùng case nhiều (vì lỡ đâu nó kh là duy nhất)
    }
    @Test
    public void TC_06_Tagname() {
        //Tên thẻ (HTML)
        // Tìm tất cả các element giống nhau (thẻ của componemt giống nhau)
        //Tất cả các textbox/ checkbox/ radio/ link/ button/ ...
        driver.findElements(By.tagName("button"));
        driver.findElements(By.tagName("input"));
    }
    @Test
    public void TC_07_Css() {
        driver.findElements(By.cssSelector("input#id"));
        driver.findElements(By.cssSelector("#id"));
        driver.findElements(By.cssSelector("input[id='tên id']"));
        driver.findElements(By.cssSelector("button.tên class"));
        driver.findElements(By.cssSelector("button[class='tên class']"));
        driver.findElements(By.cssSelector("select[name='tên name']"));
        driver.findElements(By.cssSelector("a[href*='tên link trỏ tới: vd nếu đền 1 phần của link: login?']"));
    }
    @Test
    public void TC_08_xPath() {
        //Xpath tuyệt đối - đi từ node đầu tiên tới node cuối cùng - Không bỏ qua node nào trung gian
        //Ưu điểm: chạy rất nhanh
        //Nhược điểm: quá dài - Khi đổi UI là fail
        //Đi từng node một - dùng 1 /
        //Xpath tương đối - đi tới node cuối cùng
        //Ưu điểm: ngắn ngọn - ít fail
        //Đi qua node - dùng 2 //

        //Relative Xpath Format: //tagname[@attribute='value']

        //Tiêu chí chọn: duy nhất - id/class/name - giá trị của attribute phải có nghĩa (liên quan tới element đó)

        driver.findElements(By.xpath("//input[@id='tên id']"));

        driver.findElements(By.xpath("//button[@class='tên class']"));
        driver.findElements(By.xpath("//button[contains(@class,'tên class')]"));

        driver.findElements(By.xpath("//select[@name='tên name']"));

        driver.findElements(By.xpath("//a[text()='tên text của link']"));
        driver.findElements(By.xpath("//a[contains(text(),'tên text của link')]"));
    }

    @Test
    //dùng khi không thể định danh được element của chính nó (-> phải dựa vào vị trí element gần nó)
    //sử dụng khi test GUI (test giao diện - position khớp với Figma hay kh)
    //có thể dùng 1 trong 4 vị trí (không cần bắt buộc phải dùng cả 4)
    public void TC_09_Relative_Locator(){
        //Element By A
        //Khai báo bằng By
        By passwordTextboxBy1 = By.cssSelector("input#Password");
        //Khai báo bằng Element
        WebElement passwordTextboxBy2 = driver.findElement(By.cssSelector("input#Password"));
        //Element By B
        By rememberMeCheckboxBy = By.id("RememberMe");
        //Element By C
        By forgotPasswordLinkBy = By.id("forgotPasswword");
        //Element By D
        By loginButtonBy = By.id("loginButton");
        //Element By E
        WebElement rememberMe = driver.findElement(RelativeLocator.with(By.tagName("label"))
                .above(loginButtonBy)             //label này đang nằm trên Login
                .below(passwordTextboxBy1)        //label này đang nằm dưới Quên MK
                .toLeftOf(rememberMeCheckboxBy)   //label này ở bên trái Checkbox
                .toRightOf(forgotPasswordLinkBy)  //label này ở bên phải Quên MK
                .near(rememberMeCheckboxBy)       //label này ở gần Checkbox
                .near(forgotPasswordLinkBy)       //label này cũng ở gần Quên MK
        );
    }
    @AfterClass
    public void cleanBrowser() {
        driver.quit();
    }

    // Tên biến/hàm: chữ cái đầu viết thường
}
