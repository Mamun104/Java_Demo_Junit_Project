import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MyJunit
{


    WebDriver driver;
    WebDriverWait wait;
    @Before

    public void setup() {

        System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver.exe");

        //FirefoxOptions ops = new FirefoxOptions();
        ChromeOptions ops  = new ChromeOptions();
        ops.addArguments("--headed");
        driver = new ChromeDriver(ops);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
    }

    @Test
    //Get website title
    public void getTitle() {
        driver.get("https://demoqa.com");
        String title = driver.getTitle();
        System.out.println(title);
        Assert.assertTrue(title.contains("ToolsQA"));
    }
    @Test
    //CHECK IF ELEMENT EXISTS
    public void checkifElementExists() {
        driver.get("https://demoqa.com");
       //Boolean status  =  driver.findElement(By.className("banner-image")).isDisplayed();
       //Assert.assertTrue(status);
        wait = new WebDriverWait(driver,Duration.ofSeconds(60));
        Boolean status = wait.until(ExpectedConditions.elementToBeClickable(By.className("banner-image"))).isDisplayed();
        Assert.assertTrue(status);

    }
    @Test
    public void fillUpForm()
    {
        driver.get("https://demoqa.com/text-box");
        driver.findElement(By.id("userName")).sendKeys("Mr. Karim");
        driver.findElement(By.id("userEmail")).sendKeys("karim@test.com");
        driver.findElement(By.id("submit")).click();
    }
    @After
    public void CloseBrowser()
    {
       driver.quit();
    }

}






