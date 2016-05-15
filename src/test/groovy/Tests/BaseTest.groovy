package Tests

import Components.BrowserFactory
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import org.openqa.selenium.Dimension
import org.testng.annotations.AfterClass
import org.testng.annotations.BeforeClass
import org.testng.annotations.Optional
import org.testng.annotations.Parameters

import java.util.concurrent.TimeUnit

import static Components.WebDriverHandler.*


public abstract class BaseTest {

    private static Logger log = LogManager.getLogger(BrowserFactory)


    @Parameters("browser")
    @BeforeClass(alwaysRun = true)
    public static void setUpBrowser(@Optional("chrome") String browser) {
        System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.Jdk14Logger")
        setDriver(browser)
        log.info("Starting browser {}", browser)
        getDriver().manage().window().setSize(new Dimension(1600, 1200))
        getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS)
    }

    @AfterClass(alwaysRun = true)
    public static void tearDown() {
        log.info("Closing Browser")
        getDriver().quit()
    }
}
