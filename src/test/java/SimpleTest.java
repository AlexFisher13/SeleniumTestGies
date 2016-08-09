import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;dj,
import static com.thoughtworks.selenium.SeleneseTestNgHelper.assertEquals;

/**
 * Created by Tkachenko A.
 */
public class SimpleTest {

    @Test
    public void loginToGies() {
        //System.setProperty("webdriver.chrome.driver", "/home/user/chromeDriver/chromedriver");
        WebDriver driver = new ChromeDriver();
        String baseUrl = "http://demo.gies.ivt.lan";
        driver.manage().window().maximize();
        driver.get(baseUrl + "/login");
        driver.findElement(By.cssSelector("[name=username]")).clear();
        driver.findElement(By.cssSelector("[name=username]")).sendKeys("Tkachenko");
        driver.findElement(By.cssSelector("[name=password]")).sendKeys("qwerty");
        driver.findElement(By.cssSelector("[class=login-button]")).click();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        System.out.println("Page title is: " + driver.getTitle());
        assertEquals("Gloria", driver.getTitle());
    }

}
