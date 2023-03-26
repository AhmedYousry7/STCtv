package LandingPage;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.observer.entity.MediaEntity;
import config.Drivers;
import config.FilePaths;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pom.Welcome_page;
import utilities.Reporting_Functions;

import java.io.IOException;

public class Home_Page_Test_Cases {
    private WebDriver driver;
    Welcome_page wp;
    static ExtentTest test;
    static ExtentReports report;

    Reporting_Functions reporting_functions = new Reporting_Functions();
    @BeforeMethod
    public void setup() {
        driver= new Drivers().Chrome();
         wp= new Welcome_page(driver);
        driver.get(FilePaths.appURL);
    }

    @Test
    public void TC1_EnsrueThatUserCanChangeCountryToJordanSuccessfully() throws IOException {
        ExtentReports extent = reporting_functions.report("TC1_Execution_Report");
        ExtentTest test = extent.createTest("TC1_Ensrue that user can change country to Jordan successfully");
        test.pass("Step1:Open the URL https://subscribe.stctv.com/", MediaEntityBuilder.createScreenCaptureFromPath(reporting_functions.takeScreenShot(driver)).build());
        wp.ClickChangeLangueIcon();
        test.pass("Step2: Click on change language icon", MediaEntityBuilder.createScreenCaptureFromPath(reporting_functions.takeScreenShot(driver)).build());
        wp.ChagneCountry("                                    Jordan                                ","");
        test.pass("Step3: Click on Jordan country", MediaEntityBuilder.createScreenCaptureFromPath(reporting_functions.takeScreenShot(driver)).build());
        extent.flush();
    }

    @Test
    public void TC2_CheckCurrencyBySelectedCountryJordan() throws IOException {
        ExtentReports extent = reporting_functions.report("TC2_Execution_Report");
        ExtentTest test = extent.createTest("TC02_Check currency by the selected country Jordan");
        test.pass("Step1:Open the URL https://subscribe.stctv.com/", MediaEntityBuilder.createScreenCaptureFromPath(reporting_functions.takeScreenShot(driver)).build());
        wp.ClickChangeLangueIcon();
        test.pass("Step2: Click on change language icon", MediaEntityBuilder.createScreenCaptureFromPath(reporting_functions.takeScreenShot(driver)).build());
        wp.ChagneCountry("                                    Jordan                                ","From 0.99 JOD/week");
        test.pass("Step3: Click on Jordan country, then check that the currency is JOD", MediaEntityBuilder.createScreenCaptureFromPath(reporting_functions.takeScreenShot(driver)).build());
        extent.flush();
    }

    @Test
    public void TC3_EnsrueThatLitePlanPriceIsDisplayedSuccessfullyForJordanCountry() throws IOException {
        By Lite_Plan_Name =By.xpath("//*[@id=\"name-lite\"]");
        By Lite_Plan_Price=By.xpath("//*[@id=\"currency-lite\"]");
        ExtentReports extent = reporting_functions.report("TC3_Execution_Report");
        ExtentTest test = extent.createTest("TC3_Ensrue that Lite plan price is displayed successfully for Jordan country");
        test.pass("Step1: Open the URL https://subscribe.stctv.com/", MediaEntityBuilder.createScreenCaptureFromPath(reporting_functions.takeScreenShot(driver)).build());
        wp.ClickChangeLangueIcon();
        test.pass("Step2: Click on change language icon", MediaEntityBuilder.createScreenCaptureFromPath(reporting_functions.takeScreenShot(driver)).build());
        wp.ChagneCountry("                                    Jordan                                ","");
        test.pass("Step3: Click on Jordan country", MediaEntityBuilder.createScreenCaptureFromPath(reporting_functions.takeScreenShot(driver)).build());
        String AssertionPlanName=driver.findElement(Lite_Plan_Name).getText();
        if (AssertionPlanName.equals("LITE")) {
            String AssertionPlanPrice = driver.findElement(Lite_Plan_Price).getText();
            Assert.assertEquals(AssertionPlanPrice, "2.7 USD/month");
        test.pass("Step4: Check Lite plan price", MediaEntityBuilder.createScreenCaptureFromPath(reporting_functions.takeScreenShot(driver)).build());
        extent.flush();
        }
    }
    @Test
    public void TC4_EnsrueThatClassicPlanPriceIsDisplayedSuccessfullyForJordanCountry() throws IOException {
        By Lite_Plan_Name =By.xpath("//*[@id=\"name-classic\"]");
        By Lite_Plan_Price=By.xpath("//*[@id=\"currency-classic\"]");
        ExtentReports extent = reporting_functions.report("TC4_Execution_Report");
        ExtentTest test = extent.createTest("TC4_Ensrue that Classic plan price is displayed successfully for Jordan country");
        test.pass("Step1: Open the URL https://subscribe.stctv.com/", MediaEntityBuilder.createScreenCaptureFromPath(reporting_functions.takeScreenShot(driver)).build());
        wp.ClickChangeLangueIcon();
        test.pass("Step2: Click on change language icon", MediaEntityBuilder.createScreenCaptureFromPath(reporting_functions.takeScreenShot(driver)).build());
        wp.ChagneCountry("                                    Jordan                                ","");
        test.pass("Step3: Click on Jordan country", MediaEntityBuilder.createScreenCaptureFromPath(reporting_functions.takeScreenShot(driver)).build());
        String AssertionPlanName=driver.findElement(Lite_Plan_Name).getText();
        if (AssertionPlanName.equals("CLASSIC")) {
            String AssertionPlanPrice = driver.findElement(Lite_Plan_Price).getText();
            Assert.assertEquals(AssertionPlanPrice, "5.2 USD/month");
        test.pass("Step4: Check CLASSIC plan price", MediaEntityBuilder.createScreenCaptureFromPath(reporting_functions.takeScreenShot(driver)).build());
        extent.flush();
        }
    }

    @Test
    public void TC5_EnsrueThatPremiumPlanPriceIsDisplayedSuccessfullyForJordanCountry() throws IOException {
        By Lite_Plan_Name =By.xpath("//*[@id=\"name-premium\"]");
        By Lite_Plan_Price=By.xpath("//*[@id=\"currency-premium\"]");
        ExtentReports extent = reporting_functions.report("TC5_Execution_Report");
        ExtentTest test = extent.createTest("TC5_Ensrue that Premium plan price is displayed successfully for Jordan country");
        test.pass("Step1: Open the URL https://subscribe.stctv.com/", MediaEntityBuilder.createScreenCaptureFromPath(reporting_functions.takeScreenShot(driver)).build());
        wp.ClickChangeLangueIcon();
        test.pass("Step2: Click on change language icon", MediaEntityBuilder.createScreenCaptureFromPath(reporting_functions.takeScreenShot(driver)).build());
        wp.ChagneCountry("                                    Jordan                                ","");
        test.pass("Step3: Click on Jordan country", MediaEntityBuilder.createScreenCaptureFromPath(reporting_functions.takeScreenShot(driver)).build());
        String AssertionPlanName=driver.findElement(Lite_Plan_Name).getText();
        if (AssertionPlanName.equals("PREMIUM")) {
            String AssertionPlanPrice = driver.findElement(Lite_Plan_Price).getText();
            Assert.assertEquals(AssertionPlanPrice, "8 USD/month");
        test.pass("Step4: Check PREMIUM plan price", MediaEntityBuilder.createScreenCaptureFromPath(reporting_functions.takeScreenShot(driver)).build());
        extent.flush();
        }
    }
    @Test
    public void TC6_EnsrueThatUserCanChangeCountryToUAESuccessfully() throws IOException {
        ExtentReports extent = reporting_functions.report("TC6_Execution_Report");
        ExtentTest test = extent.createTest("TC06_Ensrue that user can change country to UAE successfully");
        test.pass("Step1: Open the URL https://subscribe.stctv.com/", MediaEntityBuilder.createScreenCaptureFromPath(reporting_functions.takeScreenShot(driver)).build());
        wp.ClickChangeLangueIcon();
        test.pass("Step2: Click on change language icon", MediaEntityBuilder.createScreenCaptureFromPath(reporting_functions.takeScreenShot(driver)).build());
        wp.ChagneCountry("                                    UAE                                ","");
        test.pass("Step3: Click on UAE country", MediaEntityBuilder.createScreenCaptureFromPath(reporting_functions.takeScreenShot(driver)).build());
        extent.flush();
    }

    @Test
    public void TC7_CheckCurrencyBySelectedCountryUAE() throws IOException {
        ExtentReports extent = reporting_functions.report("TC7_Execution_Report");
        ExtentTest test = extent.createTest("TC07_Check currency by the selected country UAE");
        test.pass("Step1: Open the URL https://subscribe.stctv.com/", MediaEntityBuilder.createScreenCaptureFromPath(reporting_functions.takeScreenShot(driver)).build());
        wp.ClickChangeLangueIcon();
        test.pass("Step2: Click on change language icon", MediaEntityBuilder.createScreenCaptureFromPath(reporting_functions.takeScreenShot(driver)).build());
        wp.ChagneCountry("                                    UAE                                ","From 10.00 AED/week");
        test.pass("Step3: Click on UAE country, then check that the currency is AED", MediaEntityBuilder.createScreenCaptureFromPath(reporting_functions.takeScreenShot(driver)).build());
        extent.flush();
    }
    @Test
    public void TC8_EnsrueThatLitePlanPriceIsDisplayedSuccessfullyForUAECountry() throws IOException {
        By Lite_Plan_Name =By.xpath("//*[@id=\"name-lite\"]");
        By Lite_Plan_Price=By.xpath("//*[@id=\"currency-lite\"]");
        ExtentReports extent = reporting_functions.report("TC8_Execution_Report");
        ExtentTest test = extent.createTest("TC08_Ensrue that Lite plan price is displayed successfully for UAE country");
        test.pass("Step1: Open the URL https://subscribe.stctv.com/", MediaEntityBuilder.createScreenCaptureFromPath(reporting_functions.takeScreenShot(driver)).build());
        wp.ClickChangeLangueIcon();
        test.pass("Step2: Click on change language icon", MediaEntityBuilder.createScreenCaptureFromPath(reporting_functions.takeScreenShot(driver)).build());
        wp.ChagneCountry("                                    UAE                                ","");
        test.pass("Step3: Click on UAE country", MediaEntityBuilder.createScreenCaptureFromPath(reporting_functions.takeScreenShot(driver)).build());
        String AssertionPlanName=driver.findElement(Lite_Plan_Name).getText();
        if (AssertionPlanName.equals("LITE")) {
            String AssertionPlanPrice = driver.findElement(Lite_Plan_Price).getText();
            Assert.assertEquals(AssertionPlanPrice, "5.4 USD/month");
        test.pass("Step4: Check Lite plan price", MediaEntityBuilder.createScreenCaptureFromPath(reporting_functions.takeScreenShot(driver)).build());
        extent.flush();
        }
    }
    @Test
    public void TC9_EnsrueThatClassicPlanPriceIsDisplayedSuccessfullyForUAECountry() throws IOException {
        By Lite_Plan_Name =By.xpath("//*[@id=\"name-classic\"]");
        By Lite_Plan_Price=By.xpath("//*[@id=\"currency-classic\"]");
        ExtentReports extent = reporting_functions.report("TC9_Execution_Report");
        ExtentTest test = extent.createTest("TC09_Ensrue that Classic plan price is displayed successfully for UAE country");
        test.pass("Step1: Open the URL https://subscribe.stctv.com/", MediaEntityBuilder.createScreenCaptureFromPath(reporting_functions.takeScreenShot(driver)).build());
        wp.ClickChangeLangueIcon();
        test.pass("Step2: Click on change language icon", MediaEntityBuilder.createScreenCaptureFromPath(reporting_functions.takeScreenShot(driver)).build());
        wp.ChagneCountry("                                    UAE                                ","");
        test.pass("Step3: Click on UAE country", MediaEntityBuilder.createScreenCaptureFromPath(reporting_functions.takeScreenShot(driver)).build());
        String AssertionPlanName=driver.findElement(Lite_Plan_Name).getText();
        if (AssertionPlanName.equals("CLASSIC")) {
            String AssertionPlanPrice = driver.findElement(Lite_Plan_Price).getText();
            Assert.assertEquals(AssertionPlanPrice, "10.9 USD/month");
        test.pass("Step4: Check CLASSIC plan price", MediaEntityBuilder.createScreenCaptureFromPath(reporting_functions.takeScreenShot(driver)).build());
        extent.flush();
        }
    }

    @Test
    public void TC10_EnsrueThatPremiumPlanPriceIsDisplayedSuccessfullyForUAECountry() throws IOException {
        By Lite_Plan_Name =By.xpath("//*[@id=\"name-premium\"]");
        By Lite_Plan_Price=By.xpath("//*[@id=\"currency-premium\"]");
        ExtentReports extent = reporting_functions.report("TC10_Execution_Report");
        ExtentTest test = extent.createTest("TC10_Ensrue that Lite plan price is displayed successfully for UAE country");
        test.pass("Step1: Open the URL https://subscribe.stctv.com/", MediaEntityBuilder.createScreenCaptureFromPath(reporting_functions.takeScreenShot(driver)).build());
        wp.ClickChangeLangueIcon();
        test.pass("Step2: Click on change language icon", MediaEntityBuilder.createScreenCaptureFromPath(reporting_functions.takeScreenShot(driver)).build());
        wp.ChagneCountry("                                    UAE                                ","");
        test.pass("Step3: Click on Jordan country", MediaEntityBuilder.createScreenCaptureFromPath(reporting_functions.takeScreenShot(driver)).build());
        String AssertionPlanName=driver.findElement(Lite_Plan_Name).getText();
        if (AssertionPlanName.equals("PREMIUM")) {
            String AssertionPlanPrice = driver.findElement(Lite_Plan_Price).getText();
            Assert.assertEquals(AssertionPlanPrice, "16.3 USD/month");
        test.pass("Step4: Check PREMIUM plan price", MediaEntityBuilder.createScreenCaptureFromPath(reporting_functions.takeScreenShot(driver)).build());
        extent.flush();
        }
    }

    @Test
    public void TC11_EnsrueThatUserCanChangeCountryToIRAQSuccessfully() throws IOException {
        ExtentReports extent = reporting_functions.report("TC11_Execution_Report");
        ExtentTest test = extent.createTest("TC11_Ensrue that user can change country to IRAQ successfully");
        test.pass("Step1: Open the URL https://subscribe.stctv.com/", MediaEntityBuilder.createScreenCaptureFromPath(reporting_functions.takeScreenShot(driver)).build());
        wp.ClickChangeLangueIcon();
        test.pass("Step2: Click on change language icon", MediaEntityBuilder.createScreenCaptureFromPath(reporting_functions.takeScreenShot(driver)).build());
        wp.ChagneCountry("                                    Iraq                                ","");
        test.pass("Step3: Click on Iraq country", MediaEntityBuilder.createScreenCaptureFromPath(reporting_functions.takeScreenShot(driver)).build());
        extent.flush();
    }

    @Test
    public void TC12_CheckCurrencyBySelectedCountryIRAQ() throws IOException {
        ExtentReports extent = reporting_functions.report("TC12_Execution_Report");
        ExtentTest test = extent.createTest("TC12_Check currency by the selected country IRAQ");
        test.pass("Step1: Open the URL https://subscribe.stctv.com/", MediaEntityBuilder.createScreenCaptureFromPath(reporting_functions.takeScreenShot(driver)).build());
        wp.ClickChangeLangueIcon();
        test.pass("Step2: Click on change language icon", MediaEntityBuilder.createScreenCaptureFromPath(reporting_functions.takeScreenShot(driver)).build());
        wp.ChagneCountry("                                    Iraq                                ","From 900.00 IQ/week");
        test.pass("Step3: Click on Jordan country, then check that the currency is IQ", MediaEntityBuilder.createScreenCaptureFromPath(reporting_functions.takeScreenShot(driver)).build());
        extent.flush();
    }

    @Test
    public void TC13_EnsrueThatLitePlanPriceIsDisplayedSuccessfullyForIRAQCountry() throws IOException {
        By Lite_Plan_Name =By.xpath("//*[@id=\"name-lite\"]");
        By Lite_Plan_Price=By.xpath("//*[@id=\"currency-lite\"]");
        ExtentReports extent = reporting_functions.report("TC13_Execution_Report");
        ExtentTest test = extent.createTest("TC13_Ensrue that Lite plan price is displayed successfully for IRAQ country");
        test.pass("Step1: Open the URL https://subscribe.stctv.com/", MediaEntityBuilder.createScreenCaptureFromPath(reporting_functions.takeScreenShot(driver)).build());
        wp.ClickChangeLangueIcon();
        test.pass("Step2: Click on change language icon", MediaEntityBuilder.createScreenCaptureFromPath(reporting_functions.takeScreenShot(driver)).build());
        wp.ChagneCountry("                                    Iraq                                ","");
        test.pass("Step3: Click on Jordan country", MediaEntityBuilder.createScreenCaptureFromPath(reporting_functions.takeScreenShot(driver)).build());
        String AssertionPlanName=driver.findElement(Lite_Plan_Name).getText();
        if (AssertionPlanName.equals("LITE")) {
            String AssertionPlanPrice = driver.findElement(Lite_Plan_Price).getText();
            Assert.assertEquals(AssertionPlanPrice, "2.4 USD/month");
        test.pass("Step4: Check Lite plan price", MediaEntityBuilder.createScreenCaptureFromPath(reporting_functions.takeScreenShot(driver)).build());
        extent.flush();
        }
    }
    @Test
    public void TC14_EnsrueThatClassicPlanPriceIsDisplayedSuccessfullyForIRAQCountry() throws IOException {
        By Lite_Plan_Name =By.xpath("//*[@id=\"name-classic\"]");
        By Lite_Plan_Price=By.xpath("//*[@id=\"currency-classic\"]");
        ExtentReports extent = reporting_functions.report("TC14_Execution_Report");
        ExtentTest test = extent.createTest("TC14_Ensrue that Classic plan price is displayed successfully for IRAQ country");
        test.pass("Step1: Open the URL https://subscribe.stctv.com/", MediaEntityBuilder.createScreenCaptureFromPath(reporting_functions.takeScreenShot(driver)).build());
        wp.ClickChangeLangueIcon();
        test.pass("Step2: Click on change language icon", MediaEntityBuilder.createScreenCaptureFromPath(reporting_functions.takeScreenShot(driver)).build());
        wp.ChagneCountry("                                    Iraq                                ","");
        test.pass("Step3: Click on Iraq country", MediaEntityBuilder.createScreenCaptureFromPath(reporting_functions.takeScreenShot(driver)).build());
        String AssertionPlanName=driver.findElement(Lite_Plan_Name).getText();
        if (AssertionPlanName.equals("CLASSIC")) {
            String AssertionPlanPrice = driver.findElement(Lite_Plan_Price).getText();
            Assert.assertEquals(AssertionPlanPrice, "4.1 USD/month");
        test.pass("Step4: Check CLASSIC plan price", MediaEntityBuilder.createScreenCaptureFromPath(reporting_functions.takeScreenShot(driver)).build());
        extent.flush();
        }
    }

    @Test
    public void TC15_EnsrueThatPremiumPlanPriceIsDisplayedSuccessfullyForIRAQCountry() throws IOException {
        By Lite_Plan_Name =By.xpath("//*[@id=\"name-premium\"]");
        By Lite_Plan_Price=By.xpath("//*[@id=\"currency-premium\"]");
        ExtentReports extent = reporting_functions.report("TC15_Execution_Report");
        ExtentTest test = extent.createTest("TC15_Ensrue that Premium plan price is displayed successfully for IRAQ country");
        test.pass("Step1: Open the URL https://subscribe.stctv.com/", MediaEntityBuilder.createScreenCaptureFromPath(reporting_functions.takeScreenShot(driver)).build());
        wp.ClickChangeLangueIcon();
        test.pass("Step2: Click on change language icon", MediaEntityBuilder.createScreenCaptureFromPath(reporting_functions.takeScreenShot(driver)).build());
        wp.ChagneCountry("                                    Iraq                                ","");
        test.pass("Step3: : Click on Jordan country", MediaEntityBuilder.createScreenCaptureFromPath(reporting_functions.takeScreenShot(driver)).build());
        String AssertionPlanName=driver.findElement(Lite_Plan_Name).getText();
        if (AssertionPlanName.equals("PREMIUM")) {
            String AssertionPlanPrice = driver.findElement(Lite_Plan_Price).getText();
            Assert.assertEquals(AssertionPlanPrice, "6.2 USD/month");
        test.pass("Step4: Check PREMIUM plan price", MediaEntityBuilder.createScreenCaptureFromPath(reporting_functions.takeScreenShot(driver)).build());
        extent.flush();
        }
    }
    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}