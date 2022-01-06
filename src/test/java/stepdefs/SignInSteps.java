package stepdefs;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import ApplicationPages.Signinpage;
import WebConnector.webconnector;
import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SignInSteps extends webconnector{
	private Signinpage signInPage;
	private String scenDesc;
	String totalItemPrice= null;
	String orderReferenceNumber = null;

	public SignInSteps(){
		this.signInPage = new Signinpage();
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


	@Given("I am on Website")
	public void applicationIsLoaded() throws InvalidFormatException, IOException {
		this.signInPage.appIsLoaded();
	}

	@When("I enter username and password")
	public void LoginTest() throws Exception {
		this.signInPage.clickSignIn();
		this.signInPage.enterUsername();
		this.signInPage.enterPassword();
		this.signInPage.clickSignInButton();

		//		driver.findElement(By.id("email")).sendKeys("SeleniumTesting@gmail.com");
		//		driver.findElement(By.id("passwd")).sendKeys("Selenium123.");
		//		driver.findElement(By.id("SubmitLogin")).click();

	}

	@Then("I am successfully logged in")
	public void validateLogin() throws Exception {
		this.signInPage.loggedIn();
		//Assert.assertTrue(driver.getCurrentUrl().contains("my-account"));
	}

	@Given("I am logged in to application")
	public void verifyLoggedIntoApplication() throws Exception {
		this.signInPage.loggedIn();
	}

	@When("I select the T-shirt")
	public void clickOnTshirtLinkOnHomePage() throws Exception {
		this.signInPage.clickOnTshirtLink();

	}

	@When("I add T-shirt to cart")
	public void addTshirtToCart() throws Exception {
		this.signInPage.clickOnAddToCartButton();
	}

	@When("I place the order")
	public void clickOnProceedToCheckoutButtonOnPopup() throws Exception {
		totalItemPrice = this.signInPage.getTotalItemPriceOnTshirtPage();
		this.signInPage.clickOnProceedToCheckoutButton();
		this.signInPage.verifySelectedShoppingCartHeader("Your shopping cart");
		this.signInPage.clickOnProceedToCheckoutButtonOnCheckoutPage();
		this.signInPage.verifySelectedShoppingCartHeader("Address");
		this.signInPage.clickOnProceedToCheckoutButtonOnAddressPage();
		this.signInPage.verifySelectedShoppingCartHeader("Shipping");
		this.signInPage.clickOnTermsOfServiceCheckbox();
		this.signInPage.clickOnProceedToCheckoutButtonOnAddressPage();
		this.signInPage.verifySelectedShoppingCartHeader("Your payment method");
		this.signInPage.clickOnPayByBankWireOption();
		this.signInPage.verifySelectedShoppingCartHeader("Bank-wire payment.");
		this.signInPage.clickOnConfirmMyOrderButton();
		this.signInPage.verifySelectedShoppingCartHeader("Order confirmation");
		orderReferenceNumber = this.signInPage.getOrderReferenceNumberFromPaymentPage();
		this.signInPage.clickOnBackToOrdersButton();
	}


	@Then("I can see ordered T-shirt in Order History")
	public void i_can_see_ordered_T_shirt_in_Order_History() throws Exception {
		this.signInPage.verifySelectedShoppingCartHeader("Order history");
		
		this.signInPage.verifyCurrentOrderDetailsUnderOrderHistoryPage("Order reference", orderReferenceNumber);
	//	this.signInPage.verifyCurrentOrderDetailsUnderOrderHistoryPage("Date", wc.get);
		this.signInPage.verifyCurrentOrderDetailsUnderOrderHistoryPage("Total price", totalItemPrice);
	}

}
