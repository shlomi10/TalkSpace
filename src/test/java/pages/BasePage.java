package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author Shlomi
 * @category Main methods
 * @apiNote These functions are for all pages
 */
@SuppressWarnings({ "javadoc"})
public abstract class BasePage {

	public WebDriver driver;
	public WebDriverWait wait;
	public Actions action;
	
	// constructor
	public BasePage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 10);
	}

	// function to navigate to URL
	public void navigateToURL(String URL) {
		driver.navigate().to(URL);
	}
	
	// function to get back webElement
	public WebElement returnWebElement(By elem) {
		return driver.findElement(elem);
	}
	
	// function to click on element
	public void clickOnElement(By elem) {
		driver.findElement(elem).click();
	}
	
	// function to wait for element to be clickable
	public void waitForElementToBeClickable(By elem) {
		wait.until(ExpectedConditions.elementToBeClickable(elem));
	}
	
	// function to wait for element to be presented
	public void waitForElementToBePresented(By elem) {
		wait.until(ExpectedConditions.presenceOfElementLocated(elem));
	}

	// function to get any attribute from element
	public String getAttributeFromElement(By elem, String attribute) {
		return driver.findElement(elem).getAttribute(attribute);
	}

}
