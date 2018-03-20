package org.cucumbertest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.annotation.After;
import cucumber.annotation.Before;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import junit.framework.Assert;

public class NodiscountStepDefinition {

	WebDriver driver; 
	String text;
	

	@Before
	@Given("^I have open the browser$")
	public void setUp() {
		driver = new FirefoxDriver(); 
		
	}
	
	

	@When("^\"([^\"]*)\" and \"([^\"]*)\" are given and Submit button is clicked$")
	public void testNoDiscount(String arg1, String arg2) {
		driver.navigate().to("http://apps.qa2qe.cognizant.e-box.co.in/CompanyOffersDiscount/ "); 
		driver.findElement(By.id("weight")).sendKeys(arg1); 
		driver.findElement(By.id("distance")).sendKeys(arg2); 
		 
        //driver.findElement(By.id(arg2)).click();
 
        driver.findElement(By.id("submit")).click();
	    
	}
@Then("^no discount \"([^\"]*)\" should be displayed$")
public void validate_the_result(String arg1) {
	
	WebElement result1=driver.findElement(By.cssSelector("#result"));
	text=result1.getText();
	System.out.println(text);
   // text=msg.getText();
    Assert.assertTrue(text.contains(arg1));
}

@After
public void tearDown(){
	driver.close();
}
	
}
