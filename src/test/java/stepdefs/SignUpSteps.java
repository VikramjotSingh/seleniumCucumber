package stepdefs;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import ApplicationPages.Checkoutpage;
import ApplicationPages.Homepage;
import ApplicationPages.Orderhistorypage;
import ApplicationPages.SignUpPage;
import ApplicationPages.Signinpage;
import WebConnector.webconnector;
import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SignUpSteps extends webconnector{
	private SignUpPage signUpPage;
	private Homepage homepage;
	private Checkoutpage checkoutpage;
	private Orderhistorypage orderhistorypage;
	private String scenDesc;
	String totalItemPrice= null;
	String orderReferenceNumber = null;

	public SignUpSteps(){
		this.signUpPage = new SignUpPage();
	}

	@Before
	public void before(Scenario scenario) {
		//this.scenDesc = scenario.getName();
		setUpDriver();
	}

	@After
	public void after(Scenario scenario){
		closeDriver(scenario);
	}

	//	@BeforeStep
	//	public void beforeStep() throws InterruptedException {
	//		Thread.sleep(2000);
	//	}

	@When("I enter user personal information")
	public void enterUserDetails() throws Exception {
		this.signUpPage.enterTextInEmailAddressField();
		this.signUpPage.clickOnCreateAnAccountButton();
	//	this.signUpPage.enterPersonalInformationOnCreateAnAccountButton("First Name", data.get(1).get(1));
	}

	@When("I click register button")
	public void i_click_register_button() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new cucumber.api.PendingException();
	}

	@Then("I am successfully registered")
	public void i_am_successfully_registered() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new cucumber.api.PendingException();
	}
}
