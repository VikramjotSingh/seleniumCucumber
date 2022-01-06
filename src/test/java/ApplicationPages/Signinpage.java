package ApplicationPages;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import WebConnector.webconnector;
import static WebConnector.webconnector.driver;
import java.io.IOException;

public class Signinpage {
	webconnector wc=new webconnector();

	public void appIsLoaded() throws InvalidFormatException, IOException {
		String URL=wc.getSpecificColumnData("./src/test/testdata/data.xlsx","sheet1", "URL");
		driver.get(URL);
		wc.waitForCondition("PageLoad","",60);
		wc.verify("Equals", "My Store", wc.driverCommand("GetPageTitle"));
		//Assert.assertEquals("My Store", driver.getTitle());
	}

	public void clickSignIn() throws Exception {
		wc.PerformActionOnElement("SignInLink_Homepage", "Click","");
		//driver.findElement(By.className("login")).click();
		wc.PerformActionOnElement("SignInButton_SignInPage", "WaitForElementDisplay","");
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("SubmitLogin")));
	}

	public void enterUsername() throws Exception {
		wc.PerformActionOnElement("Usernam_SignInPage", "Type", "SeleniumTesting@gmail.com");
		//driver.findElement(By.id("email")).sendKeys("SeleniumTesting@gmail.com");
	}

	public void enterPassword() throws Exception {
		wc.PerformActionOnElement("Password_SignInPage", "Type", "Selenium123.");
	}


	public void clickSignInButton() throws Exception {
		wc.PerformActionOnElement("SignInButton_SignInPage", "Click", "");
		wc.PerformActionOnElement("OrderHistory_MyAcntPage", "WaitForElementDisplay", "");
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".icon-list-ol")));
	}

	public void loggedIn() throws Exception {
		wc.PerformActionOnElement("OrderHistory_MyAcntPage", "Click", "");
	}

	public void clickOnTshirtLink() throws Exception {
		wc.PerformActionOnElement("TshirtLink_HomePage", "Click", "");
		wc.PerformActionOnElement("TshirtLabel_TshirtPage", "WaitForElementDisplay", "");
	}

	public void clickOnAddToCartButton() throws Exception {
		wc.performMouseActions("Item_TshirtPage", "MouseHover");
		wc.PerformActionOnElement("AddToCartButton_TshirtPage", "Click", "");
	}

	public void clickOnProceedToCheckoutButton() throws Exception {
		wc.PerformActionOnElement("ProceedToCheckout_TshirtPage", "Click", "");
	}

	public void verifySelectedShoppingCartHeader(String requiredHeaderText) throws Exception {
		String returnedPageHeader = wc.PerformGetTextActionOnElement("checkoutPageHeader", "GetText").trim();
		wc.verify("Equals", returnedPageHeader, requiredHeaderText);
	}

	public void clickOnProceedToCheckoutButtonOnCheckoutPage() throws Exception {
		wc.PerformActionOnElement("proceedToCheckoutButton", "Click", "");
	}

	public void clickOnProceedToCheckoutButtonOnAddressPage() throws Exception {
		wc.PerformActionOnElement("proceedToCheckoutButton_AddressPage", "Click", "");
	}

	public void clickOnTermsOfServiceCheckbox() throws Exception {
		wc.PerformActionOnElement("termsOfServiceCheckbox", "Click", "");
	}

	public void clickOnPayByBankWireOption() throws Exception {
		wc.PerformActionOnElement("payByBankWireOption", "Click", "");
	}

	public void clickOnConfirmMyOrderButton() throws Exception {
		wc.PerformActionOnElement("confirmMyOrderButton", "Click", "");
	}

	public void clickOnBackToOrdersButton() throws Exception {
		wc.PerformActionOnElement("backToOrdersButton", "Click", "");
	}

	public String getTotalItemPriceOnTshirtPage() throws Exception {
		return wc.PerformGetTextActionOnElement("TotalItemPrice_TshirtPage", "GetText");
	}

	public String getOrderReferenceNumberFromPaymentPage() throws Exception {
		String output = wc.PerformGetTextActionOnElement("orderCompletionDetails", "GetText");
		String order= "order reference";
		int index= output.indexOf(order) + order.length(); 
		int index2= output.indexOf(" ", index+1);
		String orderReferenceNumber= output.substring(index, index2).trim();
		return orderReferenceNumber;
	}

	public String getCurrentOrderDetailsUnderOrderHistoryPage(String tableSection) throws Exception {
		if (tableSection.equals("Order reference")) {
			return wc.PerformGetTextActionOnElement("currentOrderDetails_OrderHistoryPage" + "1]", "GetText");
		}
		if (tableSection.equals("Date")) {
			return wc.PerformGetTextActionOnElement("currentOrderDetails_OrderHistoryPage" + "2]", "GetText");
		}
		if (tableSection.equals("Total price")) {
			return wc.PerformGetTextActionOnElement("currentOrderDetails_OrderHistoryPage" + "3]", "GetText");
		}
		else {
			return null;
		}
	}
	
	public void verifyCurrentOrderDetailsUnderOrderHistoryPage(String tableSection, String epectedValue) throws Exception {
		String actualValue = getCurrentOrderDetailsUnderOrderHistoryPage(tableSection);
		wc.verify("Equals", actualValue, epectedValue);
	}
	
}