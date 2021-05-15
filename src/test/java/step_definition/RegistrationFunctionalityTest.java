package step_definition;

import org.openqa.selenium.By;
import org.testng.Assert;

import base.Main;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegistrationFunctionalityTest extends Main{

	@Given("user is in register page")
	public void user_is_in_register_page() {
	    driver.findElement(By.linkText("REGISTER")).click();
	    Assert.assertEquals(driver.getTitle(), "Register: Mercury Tours");
	}

	@When("user provides {string}, {string} and {string}")
	public void user_provides_username_password_and_confirmPassword(String username, 
			String password, String confirmPassword) {
	    driver.findElement(By.name("email")).sendKeys(username);
	    driver.findElement(By.name("password")).sendKeys(password);
	    driver.findElement(By.name("confirmPassword")).sendKeys(confirmPassword); 
	}

	@Then("{string} should be able to register")
	public void username_should_be_able_to_register(String username) {
		String expectedRegistrationSuccessMsg = driver.findElement(By.
				xpath("//table[@width='492']/tbody/tr[3]/td/p[3]/font")).getText();
	    Assert.assertEquals(expectedRegistrationSuccessMsg, "Note: Your user name is "+username+".");
	}

}
