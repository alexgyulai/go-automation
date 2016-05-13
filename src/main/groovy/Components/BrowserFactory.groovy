package Components

import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.firefox.FirefoxDriver

/**
 * Created by alexander.gyulai on 13/05/16.
 */
public class BrowserFactory {


    private static void setSystemPathForDrivers() {
        String path = "./src/main/resources/drivers/";
        String osName = System.getProperty("os.name")

        if (osName.toLowerCase().contains("mac")) {
            System.setProperty("webdriver.chrome.driver", path + "mac/chromedriver")
            print("this is MAC")

        } else if (osName.toLowerCase().contains("linux")) {
            System.setProperty("webdriver.chrome.driver", path + "linux/chromedriver")
            print("this is Linux")

        } else if (osName.toLowerCase().contains("windows")) {
            System.setProperty("webdriver.chrome.driver", path + "win/chromedriver.exe")
            print("this is Linux")

        } else {
            print("OS is not defined")
        }
    }

    public BrowserFactory() {}

    public static WebDriver getBrowser(String browserName) {

        if(browserName.equalsIgnoreCase("chrome")){
            setSystemPathForDrivers()
            return new ChromeDriver()

        } else if(browserName.equalsIgnoreCase("firefox")) {
            return new FirefoxDriver()

        } else {
            setSystemPathForDrivers()
            return new ChromeDriver()
        }
    }

}
