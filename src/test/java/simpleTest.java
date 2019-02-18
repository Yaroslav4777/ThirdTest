import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;


public class simpleTest {

    private static WebDriver driver;

    @BeforeClass

    public static void setup(){
        System.setProperty("webdriver.chrome.driver", "/home/yaroslav/Work/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        driver.get("https://www.delivery-club.ru/");
    }

    @Test

    public void SearchSpace() {
        WebElement searchSpace = driver.findElement(By.xpath("//*[@id='user-addr__input']"));
        searchSpace.clear();
        searchSpace.sendKeys("Страна чудес, шахматный город, клетка е5");//enter a incorrect address
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        WebElement enterButton = driver.findElement(By.xpath("//*[@id='user-addr__form']/label[2]/a"));
        enterButton.click();
        WebElement product = driver.findElement(By.xpath("//*[@id='user-addr__form']/label[1]/span[2]/span[3]"));
        String productName = product.getText();
        Assert.assertEquals("Пожалуйста, уточните ваш адрес", productName);

    }

    @AfterClass

    public static void tearDown(){
        driver.quit();
    }
}
