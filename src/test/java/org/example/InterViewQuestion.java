package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.List;

public class InterViewQuestion {

    public static void main(String[] args) {
        //american Express interview question
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.goibibo.com/flights/");
        WebElement logo = driver.findElement(By.xpath("//span[@class=\"sc-1f95z5i-8 gnkTau header-sprite logo gi-logo\"]"));
        Actions action = new Actions(driver);
        action.moveToElement(logo).click().build().perform();
        WebElement fromDate = driver.findElement(By.xpath("//div/span[text()='From']/following-sibling::p"));
        fromDate.click();
        driver.findElement(By.xpath("//div[@class='sc-12foipm-25 fbAAhv']/child::input")).sendKeys("DEL");
        WebElement fromSuggestionList = driver.findElement(By.xpath("//ul[@id=\"autoSuggest-list\"]/li[1]"));
        fromSuggestionList.click();
        driver.findElement(By.xpath("//div/span[text()='To']/following-sibling::input")).sendKeys("GOA");
        driver.findElement(By.xpath("//ul[@id=\"autoSuggest-list\"]/li[1]")).click();
        driver.findElement(By.xpath("//div/span[text()='Departure']")).click();
        WebElement desiredDate = driver.findElement(By.xpath("//div[contains(@class,'today')]/following::div[5]"));
        desiredDate.click();


    }
}

