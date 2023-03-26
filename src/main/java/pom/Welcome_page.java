package pom;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Actions;

import java.time.Duration;

public class Welcome_page {
    WebDriverWait wait;
    private final WebDriver driver;
    Actions actions;
    By Changelang_Icon = By.id("translation-btn");
    By ChangeCountry_Icon =By.id("country-btn");
    By Currency = By.xpath("//*[@id='main']/div/div[1]/div[3]/div");

    public Welcome_page(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        actions= new Actions(driver);
    }
    public void ClickChangeLangueIcon() {
        if (driver.findElement(Changelang_Icon).getText().trim().equals("English")) {
            actions.clickOn(Changelang_Icon);
        }
    }

    public void ChagneCountry(String country,String assertiontext) {
        actions.clickOn(ChangeCountry_Icon);
        By example = By.xpath("//*[contains(text(), '"+country+"')]");
        actions.clickOn(example);
        if(!assertiontext.equals("")) {
            String AssertionCurrency=driver.findElement(Currency).getText().trim();
            Assert.assertEquals(AssertionCurrency, assertiontext);
        }
    }
}