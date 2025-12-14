package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage {

    public WebDriver _driver;

    public HomePage(WebDriver driver){
        this._driver = driver;
    }

    public boolean checkIfContactSaleButtonPresent(){
        List<WebElement> elementsList = _driver.findElements(By.xpath("//button[text()='Contact Sales']"));
        return elementsList.size() > 0;
    }
}
