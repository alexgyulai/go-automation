package Pages

import Components.Helpers
import org.openqa.selenium.By
import ru.yandex.qatools.allure.annotations.Step

import static Components.WebDriverHandler.*


public class SearchResultsPage {

    Helpers helpers = new Helpers()

    private static final String TRAINS_CHANNEL = "#tab_train"
    private static final String FLIGHTS_CHANNEL = "#tab_flight"
    private static final String BUS_CHANNEL = "#tab_bus"
    private static final String TRAIN_PRICES = "#results-train .result .price-no"

    def selectChannel(String channel) {
        switch (channel) {
            case "TRAINS":
                helpers.clickElement(TRAINS_CHANNEL)
                break
            case "FLIGHTS":
                helpers.clickElement(FLIGHTS_CHANNEL)
                break
            case "BUS":
                helpers.clickElement(BUS_CHANNEL)
                break
            default:
                print("Correct channel is not specified")
                break
        }
        return this
    }

    @Step("Verify results are sorted by Price ascending")
    def verifyResultsSortedByPrice() {
        def prices = []
        driver.findElements(By.cssSelector(TRAIN_PRICES)) each {
            prices << it.getText().replaceAll("[^0-9.]", "").toBigDecimal()  //Getting prices and removing everything but numbers
        }
        def prices_sorted = prices.sort(false) //Sorting without mutating original

        assert prices.equals(prices_sorted) //Comparing sorted and original array

        return this
    }

}
