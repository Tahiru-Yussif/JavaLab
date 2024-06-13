package basetest;

import Week3SeleniumProject.util.AppConfig;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.codeborne.selenide.Configuration;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class BaseTest {

    public String baseURL;
    public String formFieldURL;
    public String popupsURL;
    public String modalsURL;
    public String calendarsURL;
    public String fileUploadURL;
    public String iframeURL;
    public String slidersURL;
    public String windowOperationsURL;
    public String tablesURL;
    public String fileDownloadURL;
    public String filePath;
    public String name;
    public String email;
    public String message;
    protected ExtentReports extent;
    ExtentHtmlReporter htmlReporter;
    protected ExtentTest test;

    @BeforeSuite
    public void setUp() {
        // Set Selenide configuration
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";  // Set browser size instead of startMaximized
        Configuration.timeout = 10000;
        Configuration.baseUrl = AppConfig.getBaseURL();

        // Load URLs and other configurations from AppConfig
        baseURL = AppConfig.getBaseURL();
        formFieldURL = AppConfig.getFormFieldURL();
        popupsURL = AppConfig.getPopupsURL();
        modalsURL = AppConfig.getModalsURL();
        calendarsURL = AppConfig.getCalendarsURL();
        fileUploadURL = AppConfig.getFileUploadURL();
        iframeURL = AppConfig.getIframeURL();
        slidersURL = AppConfig.getSlidersURL();
        windowOperationsURL = AppConfig.getWindowsOperationURL();
        tablesURL = AppConfig.getTablesURL();
        fileDownloadURL = AppConfig.getFileDownloadURL();
        filePath = AppConfig.getFileUploadPath();
        name = AppConfig.getName();
        email = AppConfig.getEmail();
        message = AppConfig.getMessage();

        // Set up ExtentReports
        this.htmlReporter = new ExtentHtmlReporter("ExternalTestReport.html");
        this.extent = new ExtentReports();
        this.extent.attachReporter(this.htmlReporter);
    }

    @AfterSuite
    public void tearDown() {
        // Close the browser
        closeWebDriver();

        // Flush the ExtentReports
        this.extent.flush();
    }
}
