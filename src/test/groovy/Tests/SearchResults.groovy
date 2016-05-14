package Tests

import Pages.HomePage
import Pages.SearchResultsPage
import org.testng.annotations.BeforeMethod
import org.testng.annotations.Test


public class SearchResults extends BaseTest {

    HomePage homePage
    SearchResultsPage searchResults


    @BeforeMethod
    public void setUp() {
        homePage = new HomePage()
        searchResults = new SearchResultsPage()
        homePage.open()
    }



    @Test
    public void searchTrip() {
        homePage
            .selectRoundTrip()
            .enterDepartureLocation("Berlin, Deutschland")
            .enterArrivalLocation("Prag, Tschechien")
            .selectAdultsQuantity("2")
            .disableAccommodationSearch()
            .performSearch()
        searchResults
            .selectChannel("TRAINS")
            .verifyResultsSortedByPrice()
    }

}
