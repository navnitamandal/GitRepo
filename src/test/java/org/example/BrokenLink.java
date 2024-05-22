package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class BrokenLink {
    public static void main(String[] args) throws IOException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://www.amazon.in/");
        List<WebElement> allLinks = driver.findElements(By.tagName("a"));
        System.out.println("total links are "+allLinks.size());
        List<String> allURLs=new ArrayList<>();
        for(WebElement url:allLinks){
            allURLs.add(url.getAttribute("href"));
            System.out.println(url.getAttribute("href"));
        }
        for(String link:allURLs){
            if(link!=null && !link.isEmpty()) {
                isBrokenLink(link);
            }
            else {
                System.out.println("this is null");
            }
        }



    }
    public static void isBrokenLink(String link) throws IOException {
        URL url=new URL(link);
        HttpURLConnection httpsURL=(HttpURLConnection)url.openConnection();
        httpsURL.setConnectTimeout(5000);
        httpsURL.connect();
        int code = httpsURL.getResponseCode();
        if(code>=400){
            System.out.println(link+" is broken");
        }
        else {
            System.out.println(link+" is not broken");
        }

    }
}
