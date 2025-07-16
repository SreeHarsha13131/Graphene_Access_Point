package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageObject.DashBoardWithMoreThanOneTabPage;
import utils.TestContextSetUp;

import java.util.List;

public class DashBoardWithMoreThanOneTabStepDefination {
    TestContextSetUp testContextSetUp;
    DashBoardWithMoreThanOneTabPage dashBoardWithMoreThanOneTabPage;
    public DashBoardWithMoreThanOneTabStepDefination(TestContextSetUp testContextSetUp){
        this.testContextSetUp=testContextSetUp;
        this.dashBoardWithMoreThanOneTabPage=testContextSetUp.pageObjectManager.getDashBoardWithMoreThanOneTabPage();
    }
    @Given("Open the Chrome Browser and Navigate to AccessPoint Login Pages")
    public void open_the_chrome_browser_and_navigate_to_access_point_url_urls() {
        Assert.assertTrue(dashBoardWithMoreThanOneTabPage.getGrapheneUserText().contains("Graphene User"));
        System.out.println(dashBoardWithMoreThanOneTabPage.getGrapheneUserText());
    }
    @When("^User login to the AccessPoint Site usings (.+) and (.+)$")
    public void user_login_to_the_access_point_site_using_UserName_And_Passwords(String UserName, String Password) throws InterruptedException {
        dashBoardWithMoreThanOneTabPage.selectGrapheneUser();
        dashBoardWithMoreThanOneTabPage.searchMicrosoftSignInTextField(UserName);
        dashBoardWithMoreThanOneTabPage.microsoftSubmitBtn();
        dashBoardWithMoreThanOneTabPage.SendMicrosoftPasswordTestField(Password);
        Thread.sleep(5000);

//        genericUtils.explicitWait(genericUtils.driver, loginPage.microsoftSignInBtn());
        dashBoardWithMoreThanOneTabPage.microsoftSignInBtn();
        Thread.sleep(1000);
        dashBoardWithMoreThanOneTabPage.microsoftDoNotShowAgain();
        Thread.sleep(1000);
        dashBoardWithMoreThanOneTabPage.microsoftYesBtn();
        Thread.sleep(1000);
    }
    @Then("User will land on the Home page of the AccessPoint Sites")
    public void user_will_land_on_the_home_page_of_the_access_point_sites() throws InterruptedException {
        Assert.assertTrue(dashBoardWithMoreThanOneTabPage.accessPointText().contains("Access Point"));
        Thread.sleep(200);
        System.out.println(dashBoardWithMoreThanOneTabPage.accessPointText());
    }
    @And("Click on the Application Tabs")
    public void click_On_The_ApplicationTabs() throws InterruptedException {
        dashBoardWithMoreThanOneTabPage.getAllEmpMainTabs();
        Thread.sleep(200);
        dashBoardWithMoreThanOneTabPage.getAppMainTab();
        Thread.sleep(200);
    }
    @Then("I click on the following Application and Validate the DashBoard Loadings:")
    public void clickAndValidateSites(DataTable table) throws InterruptedException {
        List<String> siteNames = table.asList();
        Thread.sleep(200);
        dashBoardWithMoreThanOneTabPage.clickAndValidateSites(siteNames);
    }
}
