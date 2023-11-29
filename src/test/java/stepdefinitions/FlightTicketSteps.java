package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.FlightTicketPage;

import java.time.Duration;

public class FlightTicketSteps {

    static WebDriver driver;

    private FlightTicketPage homePage;

    @Before
    public void setUp(){
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
    }

    @After
    public void tearDown(){
      if(driver != null){
         driver.quit();
      }
    }

    @Given("I'm on the flight ticket screen on the home page")
    public void ı_m_on_the_flight_ticket_screen_on_the_home_page() {
        homePage = new FlightTicketPage(driver);
        homePage.navigateToHomePage();
    }

    @When("I select the departure route {string}")
    public void ı_select_the_departure_route(String departureCity) throws InterruptedException {
        homePage.selectDepartureRoute(departureCity);

    }
    @And("I select the return route {string}")
    public void ı_select_the_return_route(String returnDepartureCity) throws InterruptedException {
        homePage.selectReturnRoute(returnDepartureCity);
    }
    @And("I select the departure date {string}")
    public void ı_select_the_departure_date_and(String day) throws InterruptedException {
        homePage.selectDepartureDate(day);

    }
    @And("I select the return date {string}")
    public void ı_select_the_return_date(String returnDate) throws InterruptedException {
        homePage.selectReturnDate(returnDate);
    }
    @And("I mark the non-stop flight checkbox")
    public void ı_mark_the_non_stop_flight_checkbox() throws InterruptedException {
        homePage.markNonStopCheckbox();
    }
    @And("I select the number of adult passengers as {string}")
    public void ı_select_the_number_of_adult_passengers_as(String adultCount) throws InterruptedException {
        homePage.selectAdultPassengers(adultCount);

    }
    @And("I select the number of child passengers as {string}")
    public void ı_select_the_number_of_child_passengers_as(String childCount) throws InterruptedException {
        homePage.selectChildPassengers(childCount);

    }
    @And("I select the number of infant passengers as {string}")
    public void ı_select_the_number_of_infant_passengers_as(String infantCount) throws InterruptedException {
        homePage.selectInfantPassengers(infantCount);
    }
    @And("I select the cabin class as {string}")
    public void ı_select_the_cabin_class_as(String cabinType) throws InterruptedException {
        homePage.selectCabinClass(cabinType);
    }
    @And("I submit the form")
    public void ı_submit_the_form() throws InterruptedException {
        homePage.submitForm();
    }
    @Then("I should see flight list")
    public void ı_should_see_flight_list() {
        homePage.checkFlightList();
    }



}
