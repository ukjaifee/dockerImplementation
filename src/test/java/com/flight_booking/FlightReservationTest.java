package com.flight_booking;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import selenium_docker.EnterBillingAddress;
import selenium_docker.FlightDetailsPage;
import selenium_docker.FlightPage;
import selenium_docker.RegistrationConfirmationPage;
import selenium_docker.RegistrationPage;
import utility.Driver;

public class FlightReservationTest extends Driver{

	
	private String expectedPrice;
	private String noOfPassengers;

	@BeforeTest
	@Parameters({"noOfPassengers","expectedPrice"})
	public void initalize( String noOfPassengers, String expectedPrice) {

		/*WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		*/
		 
		this.noOfPassengers = noOfPassengers;
		this.expectedPrice = expectedPrice;

	}
	
	//@Test
	public void googleTest(){
		driver.get("https://www.google.com/");
		System.out.println(driver.getTitle());
		driver.quit();
	}

	@Test
	public void registrationTest() {
		try{ System.out.println("The executing my test");
		RegistrationPage registrationPage = new RegistrationPage(driver);
		navigateToUrl("https://vins-udemy.s3.amazonaws.com/docker/docker-book-flight.html");
		registrationPage.enterContactDetails("Umesh", "Kumar");
		registrationPage.enterUserInfo("jaifee", "123", "123");
		registrationPage.clickSubmitButtn();
		 System.out.println("The Test is started");}
		
		catch(Exception e){
			System.out.println(e.getMessage());
			
		}

	}
   
	@Test(dependsOnMethods="registrationTest")
	public void registrationConfirmationTest() {
		RegistrationConfirmationPage registrationConfirmationPage = new RegistrationConfirmationPage(driver);
		registrationConfirmationPage.clickFilghtlnk();

	}
	@Test(dependsOnMethods="registrationConfirmationTest")
	public void flightDetailsTest() {
		FlightDetailsPage FlightDetailsPage = new FlightDetailsPage(driver);
		FlightDetailsPage.tripType();
		FlightDetailsPage.passgenerDetails(noOfPassengers);
		FlightDetailsPage.confirmFlight();
		FlightDetailsPage.reservFlight();

	}
	@Test(dependsOnMethods="flightDetailsTest")
	public void flightConfirmationTest() {
		EnterBillingAddress enterBillingAddress=new EnterBillingAddress(driver);
		enterBillingAddress.enterBillingAddress("Gaur");
		enterBillingAddress.continueBtn();
		FlightPage flightPage = new FlightPage(driver);
		String actualPrice = flightPage.getTotalprice();
		System.out.println("The actual price is: " + actualPrice +"&& " + "The excepted price is: " + expectedPrice);
		Assert.assertEquals(actualPrice, expectedPrice);
		driver.quit();
	}

	
	
}
