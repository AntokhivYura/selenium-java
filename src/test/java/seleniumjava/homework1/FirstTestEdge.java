package seleniumjava.homework1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class FirstTestEdge {
    public EdgeDriver driver;


    @BeforeEach
    void setUp() {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
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
