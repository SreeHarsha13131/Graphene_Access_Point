package pageObject;

import org.openqa.selenium.WebDriver;


public class PageObjectManager {
    public WebDriver driver;
    public LoginPage loginPage;
    public AllSitePage allSitePage;
    public DashBoardRunPage dashBoardRunPage;
    public DashBoardWithMoreThanOneTabPage dashBoardWithMoreThanOneTabPage;
//    public BasicSeleniumPage  basicSeleniumPage;

    public PageObjectManager(WebDriver driver) {

        this.driver = driver;
    }

    public LoginPage getLoginPage() {
        loginPage = new LoginPage(driver);
        return loginPage;
    }

    public AllSitePage getAllSitePage() {
        allSitePage = new AllSitePage(driver);
        return allSitePage;
    }

    public DashBoardRunPage getDashBoardRunPage() {
        dashBoardRunPage = new DashBoardRunPage(driver);
        return dashBoardRunPage;
    }

    public DashBoardWithMoreThanOneTabPage getDashBoardWithMoreThanOneTabPage() {
        dashBoardWithMoreThanOneTabPage = new DashBoardWithMoreThanOneTabPage(driver);
        return dashBoardWithMoreThanOneTabPage;
    }


//    public BasicSeleniumPage getBasicSelenium() {
//        basicSeleniumPage = new BasicSeleniumPage(driver);
//        return basicSeleniumPage;
//    }
}
