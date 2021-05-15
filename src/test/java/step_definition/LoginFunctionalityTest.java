package step_definition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import base.Main;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginFunctionalityTest extends Main{
	
	@Given("user is in home page")
	public void user_is_in_home_page() {
	   Assert.assertEquals(driver.getCurrentUrl(), "http://demo.guru99.com/test/newtours/index.php");
	}

	@When("user provides valid username")
	public void user_provides_valid_username() {
	   driver.findElement(By.name("userName")).sendKeys("test123");
	}

	@And("provides valid password")
	public void provides_valid_password() {
		driver.findElement(By.name("password")).sendKeys("123");
	}

	@And("clicks submit button")
	public void clicks_submit_button() {
	   driver.findElement(By.name("submit")).click();
	}

	@Then("user should be able to login")
	public void user_should_be_able_to_login() {
	   Assert.assertTrue(driver.findElement(By.xpath("//table[@width='492']")).isDisplayed());
	}
	
	@And("hits enter")
	public void hits_enter() {
	    driver.findElement(By.name("submit")).sendKeys(Keys.ENTER);
	}
	
	@When("user provides invalid username")
	public void user_provides_invalid_username() {
		driver.findElement(By.name("userName")).sendKeys("tom123");
	}

	@When("provides invalid password")
	public void provides_invalid_password() {
		driver.findElement(By.name("password")).sendKeys("t12345");
	}

	@Then("user should not be able to login")
	public void user_should_not_be_able_to_login() {
	    Assert.assertTrue(driver.findElement(By.xpath("//td[@width='112']/span")).isDisplayed());
	}
	
	@Given("user is in Sign on page")
	public void user_is_in_sign_on_page() {
		Assert.assertEquals(driver.getCurrentUrl(), "http://demo.guru99.com/test/newtours/index.php");
		driver.findElement(By.linkText("SIGN-ON")).click();
	}
	
	@When("user provides valid {string}")
	public void user_provides_valid_username(String username) {
		driver.findElement(By.name("userName")).sendKeys(username);
	}

	@And("provides valid {string}")
	public void provides_valid_password(String password) {
		driver.findElement(By.name("password")).sendKeys(password);
	}

}
