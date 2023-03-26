package utilities;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class Actions {
    WebDriverWait wait;
    WebDriver driver;
    org.openqa.selenium.interactions.Actions actions;

    public Actions(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        actions = new org.openqa.selenium.interactions.Actions(driver);
    }

    public void checkIfElementISDisplayed(By ByElement) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(ByElement));
            WebElement Webelement = driver.findElement(ByElement);
            // Add screen shot to allure report
            Webelement.isDisplayed();
            actions.moveToElement(Webelement).perform();
            System.out.println(ByElement + " Is Displayed");

        } catch (Exception exc) {
            System.out.println(ByElement + " Is not Found");
            throw exc;
        }

    }

    public void clickOn(By ByElement) {
        try {
            checkIfElementISDisplayed(ByElement);
            wait.until(ExpectedConditions.elementToBeClickable(ByElement));
            WebElement Webelement = driver.findElement(ByElement);
            // Add screen shot to allure report
            Webelement.click();
            System.out.println("Element clicked ");
        } catch (ElementClickInterceptedException exc) {
            System.out.println(ByElement + " Is not Clickable");
            throw exc;
        }
    }

    public void selectfromListByname(By ByElement, String Name) {
        try {
            checkIfElementISDisplayed(ByElement);
            wait.until(ExpectedConditions.elementToBeClickable(ByElement));
            WebElement dropdown = driver.findElement(ByElement);
            List<WebElement> options = dropdown.findElements(By.tagName("li"));
            for (WebElement option : options) {
                if (option.getText().equals(Name)) {
                    // Add screen shot to allure report
                    option.click();
                    break;
                }
            }
            System.out.println("Element clicked ");
        } catch (ElementClickInterceptedException exc) {
            System.out.println(ByElement + " Is not Clickable");
            throw exc;
        }
    }

    public String getTextOf(By ByElement) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(ByElement));
            WebElement Webelement = driver.findElement(ByElement);
            actions.moveToElement(Webelement).perform();
            // Add screen shot to allure report
            System.out.println("Displayed Text : " + Webelement.getText());
            return Webelement.getText();
        } catch (Exception exc) {
            System.out.println(ByElement + " Is not Found");
        }
        return "";
    }

    public void addDataToField(By ByElement,String data ) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(ByElement));
            WebElement Webelement = driver.findElement(ByElement);
            checkIfElementISDisplayed(ByElement);
            Webelement.sendKeys(data);
            // Add screen shot to allure report
            System.out.println(data + " added successfully");

        } catch (Exception exc) {
            System.out.println(ByElement + " Is not Found");
            throw exc;
        }

    }


}
