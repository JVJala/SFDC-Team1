package com.salesforce.dev.pages.Campaigns;

import com.salesforce.dev.framework.DriverManager;
import com.salesforce.dev.pages.Base.FormBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

/**
 * Created by Marcelo.Vargas on 13-06-15.
 */
public class CampaignForm extends FormBase {

    // Campaign Information

    @FindBy(id = "cpn1")
    @CacheLookup
    WebElement campaignNameFld;

    @FindBy(id = "cpn16")
    @CacheLookup
    WebElement activeCheckbox;

    @FindBy(id = "cpn2")
    @CacheLookup
    WebElement typeSelect;

    @FindBy(id = "cpn3")
    @CacheLookup
    WebElement statusSelect;

    @FindBy(id = "cpn5") // calendar
    @CacheLookup
    WebElement startDate;

    @FindBy(id = "cpn6") // calendar
    @CacheLookup
    WebElement endDate;

    @FindBy(id = "cpn8")
    @CacheLookup
    WebElement expectedRevenueFld;

    @FindBy(id = "cpn9")
    @CacheLookup
    WebElement budgetedCostFld;

    @FindBy(id = "cpn10")
    @CacheLookup
    WebElement actualCostFld;

    @FindBy(id = "cpn11")
    @CacheLookup
    WebElement expectedResponseFld;

    @FindBy(id = "cpn13")
    @CacheLookup
    WebElement numSentFld;

    @FindBy(id = "Parent")
    @CacheLookup
    WebElement parentFld;

    // Description Information

    @FindBy(id = "cpn4")
    @CacheLookup
    WebElement descriptionFld;

    Select typeDropdown, statusDropdown;

    public CampaignForm(WebDriver driver) {
        super.driver = driver;
        super.wait = DriverManager.getInstance().getWait();
        PageFactory.initElements(driver, this);
        try {
            wait.withTimeout(10, TimeUnit.SECONDS)
                    .until(ExpectedConditions.visibilityOf(saveBtn));
        } catch (WebDriverException e) {
            throw new WebDriverException(e);
        } finally {
            wait.withTimeout(15, TimeUnit.SECONDS);
        }
    }

    public CampaignForm setCampaignName(String text) {
        campaignNameFld.clear();
        campaignNameFld.sendKeys(text);
        return this;
    }

    public CampaignForm checkActiveCheckbox(String text) {
        if (!activeCheckbox.isEnabled()) {
            activeCheckbox.click();
        }
        return this;
    }

    public CampaignForm setTypeSelect(String text) {

        typeDropdown = new Select(typeSelect);
        typeDropdown.selectByVisibleText(text);
        return this;
    }

    public CampaignForm setStatusSelect(String text) {
        statusDropdown = new Select(statusSelect);
        statusDropdown.selectByVisibleText(text);
        return this;
    }

    public CampaignForm setStartDate(String text) {
        startDate.clear();
        startDate.sendKeys(text);
        return this;
    }

    public CampaignForm setEndDate(String text) {
        endDate.clear();
        endDate.sendKeys(text);
        return this;
    }

    public CampaignForm setExpectedRevenue(String text) {
        expectedRevenueFld.clear();
        expectedRevenueFld.sendKeys(text);
        return this;
    }

    public CampaignForm setBudgetedCost(String text) {
        budgetedCostFld.clear();
        budgetedCostFld.sendKeys(text);
        return this;
    }

    public CampaignForm setActualCost(String text) {
        actualCostFld.clear();
        actualCostFld.sendKeys(text);
        return this;
    }

    public CampaignForm setExpectedResponse(String text) {
        expectedResponseFld.clear();
        expectedResponseFld.sendKeys(text);
        return this;
    }

    public CampaignForm setNumSent(String text) {
        numSentFld.clear();
        numSentFld.sendKeys(text);
        return this;
    }

    public CampaignForm setParent(String text) {
        parentFld.clear();
        parentFld.sendKeys(text);
        return this;
    }

    public CampaignForm setDescription(String text) {
        descriptionFld.clear();
        descriptionFld.sendKeys(text);
        return this;
    }

    @Override
    public CampaignDetail clickSaveBtn() {
        clickSaveButton();
        return new CampaignDetail(driver);
    }

    @Override
    public Object clickSaveNewBtn() {
        return null;
    }

    @Override
    public Object clickCancelBtn() {
        return null;
    }
}
