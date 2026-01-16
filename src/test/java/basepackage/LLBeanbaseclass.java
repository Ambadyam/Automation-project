package basepackage;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

public class LLBeanbaseclass {

    public ChromeDriver driver;

    @BeforeTest
    public void setup() {
        driver = new ChromeDriver();
        driver.get("https://global.llbean.com/");
        driver.manage().window().maximize();
    }
}
