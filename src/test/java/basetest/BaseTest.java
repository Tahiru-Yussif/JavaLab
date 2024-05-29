package basetest;


import Week3SeleniumProject.util.AppConfig;
import Week3SeleniumProject.util.WebdriverSetUp;
import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

    public WebDriver driver;
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

//    @BeforeClass
    @BeforeSuite
    public void setUp() {
        driver = WebdriverSetUp.setUp();
        driver.manage().window().maximize();
//        driver.manage().window().setSize(new Dimension(1024, 768));
        baseURL = AppConfig.getBaseURL(); // Retrieve base URL from AppConfig
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
        this.htmlReporter = new ExtentHtmlReporter("ExternalTestReport.html");
        this.extent = new ExtentReports();
        this.extent.attachReporter(new ExtentReporter[]{this.htmlReporter});
    }

//    @AfterClass
    @AfterSuite
    public void tearDown() {
        WebdriverSetUp.endTest();
        this.extent.flush();
    }
}
