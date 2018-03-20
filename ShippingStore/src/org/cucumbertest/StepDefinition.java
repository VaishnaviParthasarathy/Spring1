package org.cucumbertest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.annotation.After;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import junit.framework.Assert;

public class StepDefinition {
	
	WebDriver driver; 
	String text;
	String headerText;
	boolean isResultDivEnabled;
	
	
	@Given("^I have open the browser$")
	public void setUp() {
		driver = new FirefoxDriver(); 
		driver.navigate().to("http://apps.qa2qe.cognizant.e-box.co.in/shippingDetails/"); 
	    
	}

	
	@When("^(\\d+) is clicked$")
	public void testShippingDetails(Integer arg1) {
		//get header text
		WebElement msg=driver.findElement(By.cssSelector("h2"));
		headerText=msg.getText();
		//click link
		driver.findElement(By.linkText(arg1.toString())).click();
		//result div is displayed
		WebElement msg1=driver.findElement(By.cssSelector("#result"));
		isResultDivEnabled=msg1.isEnabled();
		WebElement customerNameText=driver.findElement(By.xpath("//div[@id='result']//td[contains(text(), 'Maya')]"));
		text=customerNameText.getText();
				
	}
	
	@Then("^\"([^\"]*)\" should be displayed$")
	public void validateResult(String arg1) {
		Assert.assertTrue(headerText.contains("Shipping Details"));
		Assert.assertTrue(isResultDivEnabled);
		Assert.assertTrue(text.contains(arg1));
	}
	
	@After
	public void tearDown(){
		driver.close();
	}
		
}
