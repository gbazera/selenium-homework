import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CommandsTest {

    public static void main(String[] args){

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("http://the-internet.herokuapp.com/dynamic_controls");

        WebElement inputExampleForm = driver.findElement(By.id("input-example"));
        WebElement input = inputExampleForm.findElement(By.tagName("input"));
        WebElement enableBtn = inputExampleForm.findElement(By.tagName("button"));

        enableBtn.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        By messageLocator = By.id("message");
        wait.until(ExpectedConditions.visibilityOfElementLocated(messageLocator));

        WebElement message = inputExampleForm.findElement(messageLocator);

        wait.until(ExpectedConditions.elementToBeClickable(input));

        if(input.isEnabled() && message.getText().equals("It's enabled!")){
            System.out.println("Input field enabled and text visible");
        }else{
            System.out.println("Input field not enabled or text not visible");
        }

        String buttonText = enableBtn.getText();

        if(buttonText.equals("Disable")){
            System.out.println("Button text changed successfully");
        }else {
            System.out.println("Button text did NOT change");
        }

        input.sendKeys("Bootcamp");
        System.out.println("Entered 'Bootcamp' into the input field");

        input.clear();
        System.out.println("Cleared the input field");

        driver.get("http://the-internet.herokuapp.com/drag_and_drop");

        WebElement columnA = driver.findElement(By.id("column-a"));
        WebElement columnB = driver.findElement(By.id("column-b"));

        int yCoordColumnA = columnA.getLocation().getY();
        int yCoordColumnB = columnB.getLocation().getY();

        if(yCoordColumnA == yCoordColumnB){
            System.out.println("Columns A and B aligned successfully");
        }else{
            System.out.println("Columns A and B are NOT aligned");
        }

        driver.quit();
    }
}
