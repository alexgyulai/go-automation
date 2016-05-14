package Components

import org.openqa.selenium.WebDriver

/**
 * Created by alexander.gyulai on 13/05/16.
 */
public class WebDriverHandler {

    private static InheritableThreadLocal<WebDriver> webDriver = new InheritableThreadLocal<WebDriver>();
    private static BrowserFactory factory;

    public static void setDriver(String browserName) {
        factory = new BrowserFactory();
        webDriver.set(factory.getBrowser(browserName));
    }

    public static WebDriver getDriver() {
        return webDriver.get();
    }

}
