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

    private int day = 4;
    private int month = 4;
    private String monthStr = "April";
    private int year = 2000;

    @When("I select a date of birth")
    public void iSelectADateOfBirth()
    {
        regPage.chooseDay(day).chooseMonth(month).chooseYear(year);
    }


    @Then("That date is visible on the screen")
    public void thatDateIsVisibleOnTheScreen()
    {
        boolean dayMatch = regPage.getSelectedDay() == day;
        boolean monthMatch = regPage.getSelectedMonth() == monthStr;
        boolean yearMatch = regPage.getSelectedYear() == year;

        Assert.assertTrue(dayMatch && monthMatch && yearMatch);
    }

    private String firstName = "Eng";
    private String lastName = "TwoEight";

    @When("I add a first name and last name in the personal details section")
    public void iAddAFirstNameAndLastNameInThePersonalDetailsSection()
    {
        regPage.sendKeysTo(firstName + "\t", "customer_firstname");
        regPage.sendKeysTo(lastName + "\t", "customer_lastname" );
    }


    @Then("I can read the first name from the address details section")
    public void iCanReadTheFirstNameFromTheAddressDetailsSection()
    {
        Assert.assertEquals(regPage.readKeys("customer_firstname"), firstName);
    }

    @And("I can read the last name from the address details section")
    public void iCanReadTheLastNameFromTheAddressDetailsSection()
    {
        Assert.assertEquals(regPage.readKeys("customer_lastname"), lastName);
    }


    @When("I add the string 0z478909823 into the mobile phone field")
    public void iAddTheStringAIntoTheMobilePhoneField()
    {
        regPage.sendKeysTo("0z478909823", "phone_mobile");
    }


    @Then("I receive an error stating the mobile phone number is invalid")
    public void iReceiveAnErrorStatingTheMobilePhoneNumberIsInvalid()
    {
        Assert.assertTrue(regPage.getErrorList().contains("is invalid"));
    }


    @When("I add the string 0z478909823 into the home phone field")
    public void iAddTheStringAIntoTheHomePhoneField()
    {
        regPage.sendKeysTo("0z478909823", "phone");
    }


    @Then("I receive an error stating the phone number is invalid")
    public void iReceiveAnErrorStatingThePhoneNumberIsInvalid()
    {
        Assert.assertTrue(regPage.getErrorList().contains("is invalid"));
    }


    @And("The sign up for our newsletter checkbox is ticked")
    public void theSignUpForOurNewsletterCheckboxIsTicked()
    {
        regPage.clickNews();
    }


    @When("I click on the receive special offers tickbox")
    public void iClickOnTheReceiveSpecialOffersTickbox()
    {
        regPage.clickOptIn();
    }


    @Then("I can see that the newsletter checkbox is ticked")
    public void iCanSeeThatTheNewsletterCheckboxIsTicked()
    {
        Assert.assertTrue(regPage.getNewsVal());
    }


    @And("I can see that the special offers checkbox is ticked")
    public void iCanSeeThatTheSpecialOffersCheckboxIsTicked()
    {
        Assert.assertTrue(regPage.getOptInVal());
    }

    @After("@registration")
    public void teardown()
    {
        driver.quit();
    }
}
