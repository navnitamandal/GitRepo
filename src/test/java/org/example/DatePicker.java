package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class DatePicker {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://www.tutorialspoint.com/selenium/practice/date-picker.php");
        driver.findElement(By.id("datetimepicker1")).click();
        int date = 30;
        String month = "MAY";
        WebElement calenderBody = driver.findElement(By.className("flatpickr-calendar"));
        String desiredMonth = String.format("%s %d, 2024", month, date);
        System.out.println(desiredMonth);
        calenderBody.findElement(By.xpath("//span[text()=23][1]")).click();
        WebElement date2 = driver.findElement(By.id("datetimepicker2"));
        Actions a = new Actions(driver);
        a.moveToElement(date2).click().build().perform();
    }
}