package selenium_docker;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage {
	private WebDriver driver;
	private WebDriverWait wait;

	@FindBy(name = "firstName")
	private WebElement firsName;

	@FindBy(name = "lastName")
	private WebElement lastName;

	@FindBy(css = "input#email")
	private WebElement UserName;

	@FindBy(name = "password")
	private WebElement passWord;

	@FindBy(name = "confirmPassword")
	private WebElement confirmPassWord;

	@FindBy(css = "input#register-btn")
	private WebElement submitBtn;

	public RegistrationPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 30);
		PageFactory.initElements(driver, this);

	}

	public void goTo() {
		driver.get("https://vins-udemy.s3.amazonaws.com/docker/docker-book-flight.html");

	}

	public void enterContactDetails(String fName, String lName) {
	//	this.wait.until(ExpectedConditions.visibilityOf(firsName));

		firsName.sendKeys(fName);
		lastName.sendKeys(lName);

	}

	public void enterUserInfo(String uName, String password, String cnPassword) {

		UserName.sendKeys(uName);
		passWord.sendKeys(password);
		confirmPassWord.sendKeys(cnPassword);

	}

	public void clickSubmitButtn() {

		submitBtn.click();
	}

}
