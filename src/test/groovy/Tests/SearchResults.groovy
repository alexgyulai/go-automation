package Tests

import Pages.HomePage
import Pages.SearchResultsPage
import org.testng.annotations.BeforeMethod
import org.testng.annotations.Test
import ru.yandex.qatools.allure.annotations.Title


public class SearchResults extends BaseTest {

    HomePage homePage
    SearchResultsPage searchResults


    @BeforeMethod
    public void setUp() {
        homePage = new HomePage()
        searchResults = new SearchResultsPage()
        homePage.open()
    }


    @Title("Search results are sorted by Price in Trains channel ")
    @Test
    public void searchTrip() {
        homePage
                .selectRoundTrip()
                .enterDepartureLocation("Berlin, Deutschland")
                .enterArrivalLocation("Prag, Tschechien")
                .addAdultsQuantity()
                .disableAccommodationSearch()
                .performSearch()
        searchResults
                .selectChannel("TRAINS")
                .verifyResultsSortedByPrice()
    }

}
