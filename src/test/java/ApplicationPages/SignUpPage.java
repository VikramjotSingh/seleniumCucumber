package ApplicationPages;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import WebConnector.webconnector;
import static WebConnector.webconnector.driver;
import java.io.IOException;

public class SignUpPage {
	webconnector wc=new webconnector();

	public void enterTextInEmailAddressField() throws Exception {
		String userEmail=wc.getSpecificColumnData("./src/test/testdata/data.xlsx","sheet2", "User Email");
		wc.PerformActionOnElement("EmailAddressField_SignUpPage", "Type", userEmail);
	}

	public void clickOnCreateAnAccountButton() throws Exception {
		wc.PerformActionOnElement("CreateAccountButton_SignUpPage", "Click", "");
		wc.PerformActionOnElement("PageHeader_SignUpPage", "WaitForElementDisplay", "");
	}
	
	public void enterPersonalInformationOnCreateAnAccountButton(String fieldName) throws Exception {
		String fieldValue=wc.getSpecificColumnData("./src/test/testdata/data2.xls","sheet3", "User Email");
		switch (fieldName) {
		case "First Name Personal Information":
			wc.PerformActionOnElement("FirstName_PersonalInformationSection", "Type", fieldValue);
			break;
			
		case "Last Name Personal Information":
			wc.PerformActionOnElement("LastName_PersonalInformationSection", "Type", fieldValue);
			break;

		default:
			break;
		}
		

	
	
	}
	
	

	

}