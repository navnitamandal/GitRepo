package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class SwitchWindow {
    public static void main(String[] args){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://www.tutorialspoint.com/selenium/practice/links.php");
        String parentWindow = driver.getWindowHandle();
        driver.findElement(By.xpath("//a[text()='Home']")).click();
        Set<String> allWindowHandles = driver.getWindowHandles();
        String childWindow = "";
        Iterator it=allWindowHandles.iterator();
        while (it.hasNext()){
            String temp=it.next().toString();
            if(!temp.equals(parentWindow)){
                childWindow=temp;
            }
        }
        //driver.switchTo().window(childWindow);
        //driver.close();
       driver.switchTo().window(parentWindow);
       driver.close();

       //noSuchWindowException
       String text=driver.findElement(By.xpath("//li/a[@title=\"SQL Tutorial\"]")).getText();
        System.out.println(text);
    }
}
