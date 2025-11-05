package day27;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/* 
 Definition : Brokren link is a link which doesn't have the resource in the server
 1)Link href="https://xyz.com 
 2) https://xyz.com ----> server ---> status code 
 3) status code>=400 broken link status code<400 not a broken link 
 */

public class BrokenLinks {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("http://www.deadlinkcity.com/");

        // Capture all the links from the website
        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println("Total number of links: " + links.size());

        int noOfBrokenLinks = 0;

        for (WebElement linkElement : links) {
            String hrefAttValue = linkElement.getAttribute("href");

            if (hrefAttValue == null || hrefAttValue.isEmpty()) {
                System.out.println("href attribute value is null or empty. So, not possible to check.");
                continue;
            }

            try {
                // Convert href value from String to URL format
                @SuppressWarnings("deprecation")
				URL linkURL = new URL(hrefAttValue);

                // Open connection to the server
                HttpURLConnection conn = (HttpURLConnection) linkURL.openConnection();
                conn.connect(); //connect to server and sent request the server

                // Check response code
                if (conn.getResponseCode() >= 400) {
                    System.out.println(hrefAttValue + " -----> Broken link");
                    noOfBrokenLinks++;
                } else {
                    System.out.println(hrefAttValue + " -----> Not a broken link");
                }

            } catch (Exception e) 
            {
                
            }
        }

        System.out.println("Number of broken links: " + noOfBrokenLinks);

        driver.quit();
    }
}
