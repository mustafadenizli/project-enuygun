package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class FlightTicketPage extends BasePage {

    private WebDriver driver;

    private By departureRouteLocator = By.cssSelector("label[data-testid='flight-origin-input-comp']");
    private By returnRouteLocator = By.cssSelector("label[data-testid='flight-destination-input-comp']");
    private By dataPickerLocator = By.cssSelector("label[data-testid='enuygun-homepage-flight-departureDate-input-comp']");
    private By nextButtonLocator = By.cssSelector("button[data-testid='enuygun-homepage-flight-departureDate-month-forward-button']");
    private By dateLocator = By.cssSelector("button[class='sc-dUWDJJ dzmTYP']");
    private By returnDataPickerLocator = By.cssSelector("label[data-testid='enuygun-homepage-flight-returnDate-input-comp']");
    private By MarkCheckboxLocator = By.cssSelector("div[class='Flight-module_checkboxWrapper__FlJ4S']");
    private By passengerCountLocator = By.cssSelector("div[data-testid='enuygun-homepage-flight-selectPassengerAndCabin']");
    private By adultCountLocator = By.cssSelector("button[data-testid='flight-adult-counter-plus-button']");
    private By childCountLocator = By.cssSelector("button[data-testid='flight-child-counter-plus-button']");
    private By infantCountLocator = By.cssSelector("button[data-testid='flight-infant-counter-plus-button']");
    private By cabinTypesLocator = By.cssSelector("div[class='CabinClass-module_btnWrapper__b0J0P']");
    private By submitButtonLocator = By.cssSelector("button[data-testid='enuygun-homepage-flight-submitButton']");
    private By flightListLocator = By.cssSelector("div[class='flight-list-body']");


    public FlightTicketPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }


    public void navigateToHomePage() {
        driver.get("https://enuygun.com");
    }

    public void selectDepartureRoute(String departureCity) {
        WebElement departureRoute = waitForVisibility(departureRouteLocator);
        departureRoute.click();
        WebElement departureRouteValue = waitForVisibility(departureRouteLocator);
        departureRouteValue.sendKeys(departureCity);
        departureRouteValue.sendKeys(Keys.ENTER);
    }

    public void selectReturnRoute(String returnDepartureCity){
        WebElement returnRoute = waitForVisibility(returnRouteLocator);
        returnRoute.click();
        WebElement returnRouteValue = waitForVisibility(returnRouteLocator);
        returnRouteValue.sendKeys(returnDepartureCity);
        returnRouteValue.sendKeys(Keys.ENTER);

    }

    public void selectDepartureDate(String day) {
        WebElement departureDataPicker = waitForVisibility(dataPickerLocator);
        departureDataPicker.click();

        WebElement nextButton = waitForVisibility(nextButtonLocator);
        nextButton.click();

        List<WebElement> days = driver.findElements(dateLocator);
        for (WebElement element : days) {
            if (element.getText().contains(day)) {
                element.click();
                break;
            }
        }
    }

    public void selectReturnDate(String day) {
        WebElement returnDataPicker = waitForVisibility(returnDataPickerLocator);
        returnDataPicker.click();

        List<WebElement> days = driver.findElements(dateLocator);
        for (WebElement element : days) {
            if (element.getText().contains(day)) {
                element.click();
                break;
            }
        }
    }

    public void markNonStopCheckbox() {
        WebElement MarkCheckbox = waitForVisibility(MarkCheckboxLocator);
        MarkCheckbox.click();
    }

    public void selectAdultPassengers(String adultCountValue) {
        WebElement passengerCount = waitForVisibility(passengerCountLocator);
        passengerCount.click();
        WebElement adultCount = waitForVisibility(adultCountLocator);
        for(int i = 1; i < Integer.parseInt(adultCountValue); i++){
            adultCount.click();
        }
    }

    public void selectChildPassengers(String childCountValue) {
        WebElement childCount = waitForVisibility(childCountLocator);
        for(int i = 0; i < Integer.parseInt(childCountValue); i++){
            childCount.click();
        }
    }

    public void selectInfantPassengers(String infantCountValue) {
        WebElement infantCount = waitForVisibility(infantCountLocator);
        for(int i = 0; i < Integer.parseInt(infantCountValue); i++){
            infantCount.click();
        }
    }

    public void selectCabinClass(String cabinClass) {
        List<WebElement> cabinTypes = driver.findElements(cabinTypesLocator);
        for (WebElement element : cabinTypes) {
            if (element.getText().contains(cabinClass)) {
                element.click();
                break;
            }
        }
    }

    public void submitForm() {
        WebElement submitButton = waitForVisibility(submitButtonLocator);
        submitButton.click();
    }

    public void checkFlightList(){
        WebElement flightList = waitForVisibility(flightListLocator);
        Assert.assertTrue(flightList.isDisplayed(),"uçuş listesi kontrol edilemedi.");
    }


}
