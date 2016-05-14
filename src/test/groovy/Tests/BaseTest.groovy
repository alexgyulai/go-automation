package Tests

import org.openqa.selenium.Dimension
import org.testng.annotations.AfterClass
import org.testng.annotations.BeforeClass
import org.testng.annotations.Optional
import org.testng.annotations.Parameters

import java.util.concurrent.TimeUnit

import static Components.WebDriverHandler.*


public abstract class BaseTest {

    @Parameters("browser")
    @BeforeClass(alwaysRun = true)
    public static void setUpBrowser(@Optional("chrome") String browser) {
        System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.Jdk14Logger")
        setDriver(browser)
        getDriver().manage().window().setSize(new Dimension(1600, 1200))
        getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS)
    }

    @AfterClass(alwaysRun = true)
    public static void tearDown() {
        getDriver().quit()
    }
}
