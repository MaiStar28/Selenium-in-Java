package javaSDET;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.util.*;

public class Topic_01_DataType {
    //2 nhom kieu du lieu
    //Cach khai bao:
    //Access Modifier: pham vi truy cap (private/public/protected/default)
    //1 - Access Modifier - Kieu du lieu - Ten bien - Gia tri cua bien
    public char cName = 'm';
    //2.1 - Access Modifier - Kieu du lieu - Ten bien
    public char cAdd;
    //2.2 - Ten bien - Gia tri cua bien (viet ham)
    public void clickElement(){
        cAdd = 'm';
        char dAdd = 'a';
    }

    //Nhom 1: Kieu du lieu nguyen thuy
    //char: ki tu (character)
    //Khi gan gia tri (khoi tao): biến nằm trong dấu nháy đơn (')
    char bAdd = 'i';
    //byte/ short/ int /long: so nguyen
    int age = 24;
    //float/ double: so thuc
    float numberA = 23.5f;
    double numberB = 12.4522d;
    //boolean: logic
    boolean gender = false;

    //Nhom 2: Kieu du lieu tham chieu
    // String
    String fullName = "Hoang Mai";
    // Class
    FirefoxDriver fDriver;
    // Interface
    WebDriver driver;
    JavascriptExecutor jsExecutor;
    // Array
    String[] studentName = {"Hai", "Nam", "Mai", "An"};
    Integer[] studentPhone = {01247,14566,3557};
    // List/ Set/ Queue
    List<String> studentAddress = new ArrayList<String>();
    List<String> studentCity = new LinkedList<String>();
    //Map
    Map<String, Integer> zip = new HashMap<String, Integer>();
    //Object
    Object name = "Mai";
    Object phone = 69874512;
    Object isDisplayed = true;
}
