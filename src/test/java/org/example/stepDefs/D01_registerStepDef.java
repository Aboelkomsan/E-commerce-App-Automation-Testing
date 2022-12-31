package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P01_Register;
import org.testng.asserts.SoftAssert;

public class D01_registerStepDef {

     P01_Register register = new P01_Register();
    @Given("user go to register page")
    public void registerPage()
    {
        register.registerPage().click();
    }

    @When("user select gender type")
    public void select_Gender_Type()
    {
        if(!(register.genderSelector("Male").isSelected()))
        {
            register.genderSelector("Male").click();
        }
    }
    @And("^user enter first name \"(.*)\" and last name \"(.*)\"$")
    public void enter_first_lastName(String firstName,String lastName )
    {
        register.enteringNames(firstName,lastName);
    }
    @And("user enter date of birth")
    public void SelectDateOfBirth()
    {
        register.Day();
        register.Month();
        register.Year();
    }
    @And("^user enter email \"(.*)\" field$")
    public void enter_Email(String mail)
    {
        register.Email().sendKeys(mail);
    }
    @And("^user fills Password fields \"(.*)\" \"(.*)\"$")
    public void fill_password_Fields(String password,String confirmPassword)
    {
        register.Password().sendKeys(password);
        register.confirmPassword().sendKeys(confirmPassword);
    }
    @And("user clicks on register button")
    public void click_Register()
    {
        register.RegisterBtn().click();
    }
    @Then("success message is displayed")
    public void success_message()
    {
        String expectedResult="Your registration completed";
        String actualResult=register.success_Message().getText();
        SoftAssert soft=new SoftAssert();
        soft.assertEquals(actualResult,expectedResult);

        soft.assertEquals(register.back_GroundColor().getCssValue( "color"),"rgba(76, 177, 124, 1)");
        soft.assertAll();
    }
}
