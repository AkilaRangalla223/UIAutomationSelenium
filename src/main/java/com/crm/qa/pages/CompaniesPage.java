package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CompaniesPage extends TestBase {

    @FindBy(id = "company_name")
    WebElement companyName;

    @FindBy(name = "industry")
    WebElement industry;

    @FindBy(id = "num_of_employees")
    WebElement numEmployees;

    @FindBy(name = "status")
    WebElement statusList;

    @FindBy(name = "category")
    WebElement categoryList;

    @FindBy(xpath = "//input[@type='submit' and @value='Save']")
    WebElement saveBtn;


    // Initializing the Page Objects:
    public CompaniesPage() {
        PageFactory.initElements(driver, this);
    }

    public void createNewCompany(String compName, String ind, String numEmp, String status, String category){
        companyName.sendKeys(compName);
        industry.sendKeys(ind);
        numEmployees.sendKeys(numEmp);

        Select select = new Select(statusList);
        select.selectByVisibleText(status);

        Select select1 = new Select(categoryList);
        select1.selectByVisibleText(category);

        saveBtn.click();

    }
}
