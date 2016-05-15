package Pages

import Components.Helpers
import org.openqa.selenium.Keys
import org.openqa.selenium.interactions.Actions

import static Components.WebDriverHandler.*


public class HomePage {

    Helpers helpers = new Helpers()

    private static final String HOME_PAGE = Helpers.readProperty("URL")
    private static final String ROUND_TRIP = ".analytics-round-trip-btn"
    private static final String ONE_WAY = "analytics-oneway-trip-btn"
    private static final String DEPARTURE_LOCATION = "#from_filter"
    private static final String ARRIVAL_LOCATION = "#to_filter"
    private static final String PERSON_SELECTION = "#person-counter"
    private static final String INCREASE_ADULTS_COUNT = "#number-of-adults-spinner-next"
    private static final String SEARCH_BUTTON = "#search-form__submit-btn"
    private static final String ACCOMMODATION_CHECKBOX = ".checkboxv2"

    static def open() {
        getDriver().get(HOME_PAGE)
        return this
    }

    def selectRoundTrip() {
        helpers.clickElement(ROUND_TRIP)
        return this
    }

    def selectOneWayTrip() {
        helpers.clickElement(ONE_WAY)
        return this
    }

    def enterDepartureLocation(String location) {
        helpers
                .clearField(DEPARTURE_LOCATION)
                .fillInFieldWith(DEPARTURE_LOCATION, location)
                .sendKey("escape")
        return this
    }

    def enterArrivalLocation(String location) {
        helpers
                .clearField(ARRIVAL_LOCATION)
                .fillInFieldWith(ARRIVAL_LOCATION, location)
                .sendKey("escape")
        return this
    }

    def addAdultsQuantity() {
        helpers
                .clickElement(PERSON_SELECTION)
                .clickElement(INCREASE_ADULTS_COUNT)
                .sendKey("escape")
        return this
    }

    def disableAccommodationSearch() {
        helpers
                .waitUntillElementVisible(ACCOMMODATION_CHECKBOX)
                .clickElement(ACCOMMODATION_CHECKBOX)
        return this
    }

    def performSearch() {
        helpers.clickElement(SEARCH_BUTTON)
        return this
    }


}
