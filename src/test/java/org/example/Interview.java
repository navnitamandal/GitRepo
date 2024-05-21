package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class Interview {

    public static void main(String[] args){

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://www.tenforce.com/");
        WebElement linkToClick = driver.findElement(By.xpath("//div[@class=\"ccc\"]/child::a"));
        linkToClick.click();
        WebElement previousArticleImage = driver.findElement(By.xpath("//div[@class=\"grid\"]/child::a"));
        Actions a=new Actions(driver);
        a.moveToElement(previousArticleImage).click();
        previousArticleImage.click();

    }
}
