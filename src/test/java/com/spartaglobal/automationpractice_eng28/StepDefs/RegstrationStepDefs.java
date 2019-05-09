package com.spartaglobal.automationpractice_eng28.StepDefs;

import com.spartaglobal.automationpractice_eng28.AutomationPractice.Pages.RegistrationPage;
import com.spartaglobal.automationpractice_eng28.AutomationPractice.SeleniumConfig.SeleniumConfig;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class RegstrationStepDefs {

    private WebDriver driver;
    private RegistrationPage regPage;


    @Given("I am on the registration page")
    public void Go_to_Registration()
    {
        driver = new SeleniumConfig("chrome").getDriver();
        regPage = new RegistrationPage(driver);
        regPage.navigateToPage();
    }

    @When("I click the mr radio button")
    public void iClickTheMrRadioButton()
    {
        regPage.selectMrButton();
    }

    @Then("The mr radio button will be highlighted")
    public void theMrRadioButtonWillBeHighlighted()
    {
        Assert.assertTrue(regPage.isMrSelected());
    }


    @And("The value of the button can be retrieved")
    public void theValueOfTheButtonCanBeRetrieved()
    {
        Assert.assertFalse(regPage.isMrsSelected());
    }


    @When("I enter a string which includes a number into name field with id {word}")
    public void iEnterAStringWhichIncludesANumberIntoNameFieldWithIdId(String fieldId)
    {
        regPage.sendKeysTo("abc1abc\t", fieldId);
    }


    @Then("the name entry field {word} will be marked as invalid")
    public void theNameEntryFieldIdWillBeMarkedAsInvalid(String fieldId)
    {
        Assert.assertTrue( regPage.getFieldCssColour(fieldId).contains( "(241," ));
    }

    @When("I type {string} into the menu item with id {word}")
    public void iTypeInputIntoTheMenuItemWithIdId(String input, String id)
    {
        regPage.sendKeysTo(input, id);
    }


    @Then("the field {word} will display the typed string {string}")
    public void theFieldIdWillDisplayTheTypedStringInput(String id, String input)
    {
        Assert.assertEquals(regPage.readKeys(id),input);
    }


    @And("I have added valid data into the mandatory fields")
    public void iHaveAddedValidDataIntoTheMandatoryFields()
    {
        regPage.completeForm();
    }


    @When("I click the submit button")
    public void iClickTheSubmitButton()
    {
        regPage.clickRegister();
    }


    @Then("I will arrive at the manage account screen")
    public void iWillArriveAtTheManageAccountScreen()
    {
        Assert.assertTrue(driver.getCurrentUrl().contains("my-account"));
    }


    @And("I have added valid data into all fields except the phone number fields")
    public void iHaveAddedValidDataIntoAllFieldsExceptThePhoneNumberFields()
    {
        regPage.completeForm();
        regPage.clearField("phone_mobile");
    }


    @Then("I will receive an error saying a phone number must be present")
    public void iWillReceiveAnErrorSayingAPhoneNumberMustBePresent()
    {
        Assert.assertTrue(regPage.getErrorList().contains("is req"));
    }

    private String addressAlias;

    @When("I view the Address Alias field")
    public void iViewTheAddressAliasField()
    {
        addressAlias = regPage.readKeys("alias");
    }


    @Then("I see the value 'My address'")
    public void iSeeTheValueMyAddress()
    {
        Assert.assertEquals("My address",addressAlias);
    }

    private String displayedEmail;

    @When("I read the email address field")
    public void iReadTheEmailAddressField()
    {
        displayedEmail = regPage.readKeys("email");
    }

    @Then("it is equal to the email address I typed on the log in screen")
    public void itIsEqualToTheEmailAddressITypedOnTheLogInScreen()
    {
        Assert.assertEquals(displayedEmail,regPage.getTestEmail());
    }


    @And("I have deleted the entry in the field with id {word}")
    public void iHaveDeletedTheEntryInTheFieldWithIdId(String field)
    {
        regPage.clearField(field);
    }


    @Then("I will receive an error containing {string}")
    public void iWillReceiveAnErrorContainingError(String error)
    {
        Assert.assertTrue(regPage.getErrorList().contains(error));
    }

    
}
