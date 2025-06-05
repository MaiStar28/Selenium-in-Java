package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Topic_03_XPathCss {
    WebDriver driver;
    //Xpath tuyệt đối - đi từ node đầu tiên tới node cuối cùng - Không bỏ qua node nào trung gian
    //Ưu điểm: chạy rất nhanh
    //Nhược điểm: quá dài - Khi đổi UI là fail
    //Đi từng node một - dùng 1 /
    //Xpath tương đối - đi tới node cuối cùng
    //Ưu điểm: ngắn ngọn - ít fail
    //Đi qua node - dùng 2 //

    //Relative Xpath Format: //tagname[@attribute='value']
    @Test
    public void xPathCss(){
        //Tiêu chí chọn: duy nhất - id/class/name - giá trị của attribute phải có nghĩa (liên quan tới element đó)
        driver.findElement(By.xpath(""));
    }


}
