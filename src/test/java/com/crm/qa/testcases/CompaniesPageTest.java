package com.crm.qa.testcases;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.CompaniesPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CompaniesPageTest extends TestBase {

    LoginPage loginPage;
    HomePage homePage;
    TestUtil testUtil;
    CompaniesPage companiesPage;


    public CompaniesPageTest(){
        super();
    }

    @BeforeMethod
    public void setUp() throws InterruptedException {

        initialization();
        testUtil = new TestUtil();
        companiesPage = new CompaniesPage();
        loginPage = new LoginPage();
        homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
        TestUtil.runTimeInfo("error", "login successful");
        testUtil.switchToFrame();
    }

    @Test(priority=1)
    public void validateCreateNewCompany() {
        homePage.clickOnNewCompaniesLink();
        companiesPage.createNewCompany("Test Company","IT", "900", "New","Partner");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
