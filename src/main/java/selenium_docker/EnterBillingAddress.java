package selenium_docker;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EnterBillingAddress {

	
	
	private WebDriver driver;
	private WebDriverWait wait;

	@FindBy(css ="#input_53_addr_line1")
	private WebElement billingAdd;

	@FindBy(name = "buyFlights")
	private WebElement submitBtn;

	
	
	@FindBy(id ="reserveFlights")
	private WebElement flightReservation;

	public EnterBillingAddress(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 20);
		PageFactory.initElements(driver, this);

	}
	
	public void enterBillingAddress(String billingAddress){
		this.wait.until(ExpectedConditions.visibilityOf(billingAdd));
		billingAdd.sendKeys(billingAddress);
		
		
	}
	
	public void continueBtn(){
		submitBtn.click();
	}
}
