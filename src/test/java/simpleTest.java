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
        searchSpace.sendKeys("Кемерово, улица Сибиряков-Гвардейцев, 16");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        WebElement enterButton = driver.findElement(By.xpath("//*[@id='user-addr__form']/label[2]/a"));
        enterButton.click();
        WebElement product = driver.findElement(By.xpath("//*[@id='vendor-list-app']/div/div[2]/div[6]/ul/li[1]/section/div[2]/section[1]/a/span"));
        String productName = product.getText();
        Assert.assertEquals("Гигант-суши", productName);

    }
}
