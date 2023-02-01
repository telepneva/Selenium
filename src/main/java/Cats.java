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

import static org.junit.Assert.assertEquals;



public class Cats {
    ChromeDriver driver;

    @Before
public void setUp(){
    System.setProperty("webdriver.chrome.driver","/C:/Users/anyut/chromedriver.exe");
    driver = new ChromeDriver();
    String BASE_URL = "http://suninjuly.github.io/cats.html";
    driver.get(BASE_URL);
}
@Test
public void checkHeaderText(){
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    WebElement header = wait.until(ExpectedConditions.presenceOfElementLocated(By.className("jumbotron-heading")));
    String expectedHeaderText = "Cat memes";
    assertEquals("Element does not contains text:" + expectedHeaderText , expectedHeaderText, header.getText());
}
@Test
public void checkCatsCardsQuantity(){
    List<WebElement> catsCards = driver.findElements(By.className("col-sm-4"));
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    wait.until(ExpectedConditions.visibilityOf(catsCards.get(0)));
    assertEquals("Quantity of cat cards is not 6!", 6, catsCards.size());
}

@Test
public void checkNameOfSecondCat() {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(500));
    WebElement NameOfSecondCat = driver.findElement(By.cssSelector("[class='col-sm-4']:nth-child(2) .card-body [class='card-text second']"));
    wait.until(ExpectedConditions.visibilityOf(NameOfSecondCat));
    String expectedNameOfSecondCat = "Serious cat";
    assertEquals("Element contains text:" + expectedNameOfSecondCat, expectedNameOfSecondCat, NameOfSecondCat.getText());
}


    @Test
    public void check9minsSecondCat() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement MinsSecondCat = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//small[@class='text-muted'])[2]")));
        String expectedMinsSecondCat = "9 mins";
        assertEquals("Element contains text:" + expectedMinsSecondCat, expectedMinsSecondCat, MinsSecondCat.getText());
    }

   // @Test
    //public void catsHatImage() {
    //    List<WebElement> catsImage = driver.findElements(By.cssSelector("(//small[@class='text-muted'])[2]"));
    //    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(9));
    //    String expectedTime = "9 mins";
    //    wait.until(ExpectedConditions.visibilityOf(catsImage.get(0)));
    //    assertEquals("Quantity of cat cards is not 6!", 6, catsImage.size());
   // }

   // @Test
    //public void buttonEditOfSixthCat() {
    //    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    //    WebElement buttonEditOfSixthCat = driver.findElement(By.cssSelector("[class='col-sm-4']:nth-child(6) [class='btn btn-sm btn-outline-secondary']:nth-child(2)"));
    //    wait.until(ExpectedConditions.visibilityOf(buttonEditOfSixthCat));
    //    String expectedNameOfSecondCat = "Edit";
    //    assertEquals("Element contains text:" + expectedNameOfSecondCat, expectedNameOfSecondCat, buttonEditOfSixthCat.getText());
    //}



@After
public void TearDown() {
        driver.quit();
    }
}


