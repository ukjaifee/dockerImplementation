package com.flight_booking;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.duckDuckGoPage.SearchModulePage;

import utility.Driver;

public class SearchModuleTest  extends Driver{
	
	private String keyword;
	
	
	@BeforeTest
	@Parameters({"keyword"})
	public void initalize( String keyword) {
      this.keyword=keyword;
		
		 
	

	}
	
	
	
	@Test
	public void searchTest(){
		SearchModulePage searchModulePage=new SearchModulePage(driver);
		searchModulePage.gotTo();
		searchModulePage.doSearch(keyword);
		searchModulePage.goToVideos();
		searchModulePage.countOfLinks();
		
	}
	

}
