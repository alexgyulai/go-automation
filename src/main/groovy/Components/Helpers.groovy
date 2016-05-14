package Components

import org.openqa.selenium.By
import org.openqa.selenium.Keys
import org.openqa.selenium.interactions.Actions
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait

import static Components.WebDriverHandler.*


public class Helpers {

    WebDriverWait wait = new WebDriverWait(driver, 10);

    static def readProperty(String key) {
        Properties properties = new Properties()
        File propertiesFile = new File("src/main/resources/environment.properties")
        propertiesFile.withInputStream {
            properties.load(it)
        }
        return properties."$key"
    }

    def clickElement(String locator) {
        driver.findElement(By.cssSelector(locator)).click()
        return this
    }

    def fillInFieldWith(String field, String text) {
        driver.findElement(By.cssSelector(field)).sendKeys(text)
        return this
    }

    def clearField(String field) {
        driver.findElement(By.cssSelector(field)).clear()
        return this
    }

    def waitUntillElementVisible(String element) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(element)))
        return this
    }

    def sendKey(String key) {
        Actions action = new Actions(driver)
        if (key.toLowerCase().equals("escape")) {
            action.sendKeys(Keys.ESCAPE).perform()
        } else {
            print("key is not recognized")
        }
        return this
    }


}
