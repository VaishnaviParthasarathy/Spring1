package cucumberTest;


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

public class StepDefinition {

	WebDriver driver; 
	String text;
	
	@Before
	@Given("^i open browser$")
	public void setUp() {
		driver = new FirefoxDriver(); 
	    
	}

	@When("^i open shipping website$")
	public void loadUrl() {
		driver.navigate().to("http://apps.qa2qe.cognizant.e-box.co.in/CostCalculation/"); 
	    
	}

	@When("^weight is \"([^\"]*)\" and mode of transport is \"([^\"]*)\"$")
	public void testCalculateCost(String arg1,String arg2) {
		
		driver.findElement(By.id("weight")).sendKeys(arg1); 
		 
        driver.findElement(By.id(arg2)).click();
 
        driver.findElement(By.id("calculate")).click();
        
	}

	@Then("^result should be Dear Customer, your total shipping cost is \\$(\\d+)$")
	public void validate_the_result(String arg1) {
		WebElement msg=driver.findElement(By.cssSelector("#result"));
        text=msg.getText();
        Assert.assertTrue(text.contains(arg1));
	}
	
	@After
	public void tearDown(){
		driver.close();
	}
		
	   
	 
}
