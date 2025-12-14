import PageObjects.HomePage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestCI {

    ChromeDriver driver;

    @BeforeClass
    public void initDriver() {
        ChromeOptions options = new ChromeOptions();

        // Essential for running in CI/CD (GitHub Actions)
        options.addArguments("--headless");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.orangehrm.com/");
    }

    @Test(priority = 1)
    public void startTest(){
        HomePage homePage = new HomePage(driver);
        boolean check = homePage.checkIfContactSaleButtonPresent();
        Assert.assertTrue(check,"The button doesn't exist");
    }

    @AfterClass
    public void close(){
        driver.close();
    }
}
