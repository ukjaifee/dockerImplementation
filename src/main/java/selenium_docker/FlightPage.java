package selenium_docker;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlightPage {

	private WebDriver driver;
	private WebDriverWait wait;

	@FindBy(css = "#confirm-table font")
	private List<WebElement> totalPric;

	@FindBy(linkText = "SIGN-OFF")
	private WebElement singOff;

	@FindBy(id = "reserveFlights")
	private WebElement flightReservation;

	public FlightPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 20);
		PageFactory.initElements(driver, this);

	}

	public String getTotalprice() {
		this.wait.until(ExpectedConditions.visibilityOf(singOff));
		String totatlPrice = totalPric.get(2).getText();

		return totatlPrice;

	}

}
