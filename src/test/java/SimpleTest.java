import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
import static com.thoughtworks.selenium.SeleneseTestNgHelper.assertEquals;

/**
 * Created by Tkachenko A.
 */
public class SimpleTest {

    WebDriver driver;
    String baseUrl;

    @BeforeClass
    public void loginToGies() {
        System.setProperty("webdriver.chrome.driver", "/home/user/chromeDriver/chromedriver");
        driver = new ChromeDriver();
        baseUrl = "http://demo.gies.ivt.lan";
        driver.manage().window().maximize();
        driver.get(baseUrl + "/login");
        driver.findElement(By.cssSelector("[name=username]")).clear();
        driver.findElement(By.cssSelector("[name=username]")).sendKeys("Tkachenko");
        driver.findElement(By.cssSelector("[name=password]")).sendKeys("qwerty");
        driver.findElement(By.cssSelector("[class=login-button]")).click();
    }

    @Test
    public void pageTitle() {
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        System.out.println("Page title is: " + driver.getTitle());
        assertEquals("Gloria", driver.getTitle());
    }

    @Test
    public void firstPage() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        assertEquals("Выберите объект энергосервиса", driver.findElement(By.id("tbtext-1448")));
    }

    @Test
    public void potrebleniePage() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.id("ext-element-16")).click();
    }











    @AfterClass
    public void finish() {
        driver.quit();
    }
}