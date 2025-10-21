import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CommandsTest {

    public static void main(String[] args) throws InterruptedException{

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        Thread.sleep(1000);

        driver.get("http://the-internet.herokuapp.com/dynamic_controls");


    }
}
