import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static java.lang.Thread.sleep;
import static org.junit.Assert.*;


public class Registration {
    ChromeDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/C:/Users/anyut/chromedriver.exe");
        driver = new ChromeDriver();
        String BASE_URL = "https://suninjuly.github.io/registration1.html";
        driver.get(BASE_URL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(200));
        driver.manage().window().maximize();
    }

    @Test
    public void onlyRequiredField() {
       WebElement firstNameInputId =
               driver.findElement(By.cssSelector("[placeholder='Input your first name']"));
        firstNameInputId.sendKeys("Hanna");
        WebElement lastNameInputId =
                driver.findElement(By.cssSelector("[placeholder='Input your last name']"));
        lastNameInputId.sendKeys("Tel");
        WebElement emailInputId =
                driver.findElement(By.cssSelector("[placeholder='Input your email']"));
        emailInputId.sendKeys("anyutatel@gmail.com");
        WebElement submitButton = driver.findElement(By.cssSelector("[type='submit']"));
        submitButton.click();

        WebElement header = driver.findElement(By.tagName("h1"));
        //assertEquals("Congratulations! You have successfully registered!", header.getText());
        assertTrue(header.getText().contains("Congratulations"));

    }

    @Test
    public void allFields(){
        WebElement firstNameInputId =
                driver.findElement(By.cssSelector("[placeholder='Input your first name']"));
        firstNameInputId.sendKeys("Hanna");
        WebElement lastNameInputId =
                driver.findElement(By.cssSelector("[placeholder='Input your last name']"));
        lastNameInputId.sendKeys("Tel");

        WebElement emailInputId =
                driver.findElement(By.cssSelector("[placeholder='Input your email']"));
        emailInputId.sendKeys("anyutatel@gmail.com");

        WebElement phoneInputId =
                driver.findElement(By.cssSelector("[placeholder='Input your phone:']"));
        phoneInputId.sendKeys("25263625");

        WebElement addressInputId =
                driver.findElement(By.cssSelector("[placeholder='Input your address:']"));
        addressInputId.sendKeys("muenster,25");

        WebElement submitButton = driver.findElement(By.cssSelector("[type='submit']"));
        submitButton.click();

        WebElement header = driver.findElement(By.tagName("h1"));
        //assertEquals("Congratulations! You have successfully registered!", header.getText());
        assertTrue("User is still on the registration page",header.getText().contains("Congratulations"));
        System.out.println("Current URL:" + driver.getCurrentUrl());
    }

    @Test
    public void notAllPudlic(){
        WebElement firstNameInputId =
                driver.findElement(By.cssSelector("[placeholder='Input your first name']"));
        firstNameInputId.sendKeys("Hanna");
        WebElement lastNameInputId =
                driver.findElement(By.cssSelector("[placeholder='Input your last name']"));
        lastNameInputId.sendKeys("Tel");

        WebElement emailInputId =
                driver.findElement(By.cssSelector("[placeholder='Input your email']"));
        emailInputId.sendKeys("");

        WebElement submitButton = driver.findElement(By.cssSelector("[type='submit']"));
        submitButton.click();
        assertFalse(driver.getCurrentUrl().contains("result"));

        WebElement header = driver.findElement(By.tagName("h1"));
        //assertEquals("Congratulations! You have successfully registered!", header.getText());
        assertTrue(header.getText().contains("Registration"));
        System.out.println("Current URL:" + driver.getCurrentUrl());
        assertFalse(driver.getCurrentUrl().contains("result"));

    }
    @After
    public void TearDown() {
        driver.quit();
    }


}