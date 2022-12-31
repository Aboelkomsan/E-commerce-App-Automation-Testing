package org.example.stepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;

public class D07_followUsStepDef {
    P03_homePage homePage=new P03_homePage();
    @When("^user opens \"(.*)\" link$")
    public void open_First_Link(String socialAccounts)
    {
        homePage.get_socialAccount_Element(socialAccounts).click();
    }
    @Then("^\"(.*)\" is opened in new tab$")
    public void open_First_Link_inNewTab(String expectedUrl) throws InterruptedException {
        Thread.sleep(2000);
        ArrayList<String> tabs = new ArrayList<>(Hooks.driver.getWindowHandles());

        Hooks.driver.switchTo().window(tabs.get(1));
        Boolean firstResult = new WebDriverWait(Hooks.driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.urlContains(expectedUrl));
        System.out.println(Hooks.driver.getCurrentUrl());
        System.out.println(Hooks.driver.getTitle());
        Assert.assertEquals(Hooks.driver.getCurrentUrl(),expectedUrl);
        Hooks.driver.close();
        Hooks.driver.switchTo().window(tabs.get(0));
        System.out.println(Hooks.driver.getCurrentUrl());
        System.out.println(Hooks.driver.getTitle());
    }
}
