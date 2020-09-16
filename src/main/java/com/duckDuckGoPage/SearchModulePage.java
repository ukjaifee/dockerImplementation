package com.duckDuckGoPage;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchModulePage {
	
	
	
	private WebDriver driver;
	private WebDriverWait wait;

	@FindBy(id ="search_form_input_homepage")
	private WebElement searchbox;

	@FindBy(linkText = "Videos")
	private WebElement videoslnk;

	@FindBy(className = "tile--vid")
	private WebElement totalVideos;
	
	
	
	
	@FindBy(id ="reserveFlights")
	private WebElement flightReservation;

	public SearchModulePage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 20);
		PageFactory.initElements(driver, this);

	}
	
	
	public void gotTo(){
		driver.get("https://duckduckgo.com/");
	}
	
	public void doSearch(String searchKeyword){
		wait.until(ExpectedConditions.visibilityOf(searchbox));
		searchbox.sendKeys(searchKeyword);
		searchbox.sendKeys(Keys.ENTER);
	}
	
	public void goToVideos(){
		wait.until(ExpectedConditions.visibilityOf(videoslnk));
		videoslnk.click();
		
		
	}
	
	
	public void countOfLinks(){
		By by=By.className("tile--vid");
		this.wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(by, 0));
		System.out.println(totalVideos.getSize());
		
		
	}

}
