package seleniumjava;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;


public class FirstTest {
    public ChromeDriver chromeDriver;


    @BeforeEach
    void setUp() {
        WebDriverManager.chromedriver().setup();
        chromeDriver = new ChromeDriver();

    }

    @Test
    public void firstTest() {
        chromeDriver.get("google.com");
    }


    @AfterEach
    void tearDown() {
        chromeDriver.quit();
    }
}
