package seleniumjava;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;


public class FirstTestСhrome {
    public ChromeDriver driver;


    @BeforeEach
    void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

    }

    @Test
    public void firstTest() {
        driver.get("http://google.com");
    }


    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
