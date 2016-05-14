package Pages

import Components.Helpers

import static Components.WebDriverHandler.*


public class HomePage {

    Helpers helpers = new Helpers()

    private static final String HOME_PAGE = Helpers.readProperty("URL")
    private static final String ROUND_TRIP = ".analytics-round-trip-btn"
    private static final String ONE_WAY = "analytics-oneway-trip-btn"
    private static final String DEPARTURE_LOCATION = "#from_filter"
    private static final String ARRIVAL_LOCATION = "#to_filter"
    private static final String PERSON_SELECTION = "#person-counter"
    private static final String ADULTS_COUNT_FIELD = "#nbadults"
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
        helpers.clearField(DEPARTURE_LOCATION)
        helpers.fillInFieldWith(DEPARTURE_LOCATION, location)
        return this
    }

    def enterArrivalLocation(String location) {
        helpers.clearField(ARRIVAL_LOCATION)
        helpers.fillInFieldWith(ARRIVAL_LOCATION, location)
        return this
    }

    def selectAdultsQuantity(String count) {
        helpers
                .clickElement(PERSON_SELECTION)
                .clearField(ADULTS_COUNT_FIELD)
                .fillInFieldWith(ADULTS_COUNT_FIELD, count)
                .sendKey("escape")
        return this
    }

    def disableAccommodationSearch() {
        helpers.waitUntillElementVisible(ACCOMMODATION_CHECKBOX)
        helpers.clickElement(ACCOMMODATION_CHECKBOX)
        return this
    }

    def performSearch() {
        helpers.clickElement(SEARCH_BUTTON)
        return this
    }


}
