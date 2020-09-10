package selenium_docker;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationConfirmationPage {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	
	@FindBy(partialLinkText="sign-in")
	private WebElement singIn;
	
	@FindBy(partialLinkText="Flights")
	private WebElement flights;
	
	
	public RegistrationConfirmationPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 20);
		PageFactory.initElements(driver, this);

	}
	
	public void clickFilghtlnk(){
		wait.until(ExpectedConditions.visibilityOf(singIn));
		flights.click();
		
		
	}
	

}
