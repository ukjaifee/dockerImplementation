package selenium_docker;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlightDetailsPage {

	private WebDriver driver;
	private WebDriverWait wait;

	@FindBy(css = "input[value='roundtrip']")
	private WebElement tripType;

	@FindBy(css = "select#passCount")
	private WebElement passengerCount;

	@FindBy(name = "findFlights")
	private WebElement confirmFlight;
	
	@FindBy(xpath="//input[@value='First']")
	private WebElement preference;
	
	
	
	@FindBy(id ="reserveFlights")
	private WebElement flightReservation;

	public FlightDetailsPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 20);
		PageFactory.initElements(driver, this);

	}

	public void tripType() {
		this.wait.until(ExpectedConditions.visibilityOf(tripType));
		tripType.click();
		


	}

	public void passgenerDetails(String countOfPassegners) {

		Select slectPassenger = new Select(passengerCount);
		slectPassenger.selectByValue(countOfPassegners);
		
	}

	public void confirmFlight() {
		preference.click();
		confirmFlight.click();
	}

	public void reservFlight(){
		this.wait.until(ExpectedConditions.visibilityOf(flightReservation));
		flightReservation.click();
		
	}
	
	
}
