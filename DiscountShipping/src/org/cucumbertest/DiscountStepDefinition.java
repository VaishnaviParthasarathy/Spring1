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

public class DiscountStepDefinition {
	
	WebDriver driver; 
	String text;
	boolean isResultDivEnabled;

	@Before
	@Given("^I open the browser$")
	public void setUp() {
		driver = new FirefoxDriver(); 
		driver.navigate().to("http://apps.qa2qe.cognizant.e-box.co.in/CompanyOffersDiscount/ "); 
	}

	@When("^\"([^\"]*)\" and \"([^\"]*)\" given and Submit button is clicked$")
	public void testDiscount(String arg1, String arg2) {
		//driver.navigate().to("http://apps.qa2qe.cognizant.e-box.co.in/CompanyOffersDiscount/ "); 
		driver.findElement(By.id("weight")).sendKeys(arg1); 
		driver.findElement(By.id("distance")).sendKeys(arg2); 
		 
        //driver.findElement(By.id(arg2)).click();
 
        driver.findElement(By.id("submit")).click();
	    
	}
@Then("^discount \"([^\"]*)\" should be displayed$")
public void validate_the_result(String arg1) {
	WebElement msg=driver.findElement(By.cssSelector("#result"));
	isResultDivEnabled=msg.isEnabled();
	//WebElement result1=driver.findElement(By.xpath("//div[@id='result'])"));
	WebElement result1=driver.findElement(By.cssSelector("#result"));
	text=result1.getText();
   // text=msg.getText();
    Assert.assertTrue(text.contains(arg1));
}

@After
public void tearDown(){
	driver.close();
}
	
	  
	}

