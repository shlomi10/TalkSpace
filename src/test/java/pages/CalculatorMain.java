package pages;


import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
/**
 * @author Shlomi
 */
@SuppressWarnings({ "javadoc" })
public class CalculatorMain extends BasePage {

	// constructor
	public CalculatorMain(WebDriver driver) {
		super(driver);
	}

	By numpadZero = By.id("Btn0");
	By numpadOne = By.id("Btn1");
	By numpadTwo = By.id("Btn2");
	By numpadThree = By.id("Btn3");

	By leftParenthesis = By.id("BtnParanL");
	By rightParenthesis = By.id("BtnParanR");
	
	By plusSign = By.id("BtnPlus");
	By minusSign = By.id("BtnMinus");
	By equalSign = By.id("BtnCalc");
	By multiButton = By.id("BtnMult");
	By sinusButton = By.id("BtnSin");
	int result;
	By resultElem = By.xpath("(//p[@class='r'])[1]");
	int expectedPlusResult = 5;
	int expectedSubtractResult = 8;
	int notExpectedResult = 20;
	double expectedsinusResult = 0.5;
	double sinusResult;
	By clearButton = By.id("BtnClear");
	
	By acceptAggreement = By.name("cookies");
	String [] expectedInputs = new String[]{"sin(30)", "(10-2)*2", "10-2", "2+3"};
	String [] expectedOutputs = new String[]{"0.5","16","8","5"};

	
	String historyItemN = "(//li/p[@class='%s'])[%d]";
	
	
	// open website function
	public void getWebSite(String siteURL) {
		navigateToURL(siteURL);
	}

	// plus function
	public void plusFunction() {
		clickOnElement(clearButton);
		waitForElementToBeClickable(acceptAggreement);
		clickOnElement(acceptAggreement);
		clickOnElement(numpadTwo);
		clickOnElement(plusSign);
		clickOnElement(numpadThree);
		clickOnElement(equalSign);
		waitForElementToBePresented(resultElem);
		result = Integer.parseInt(returnWebElement(resultElem).getAttribute("title"));
		assertEquals(result, expectedPlusResult, "the result of plus is not right");
		
	}
	
	// subtract function
	public void subtractFunction() {
		clickOnElement(clearButton);
		waitForElementToBeClickable(acceptAggreement);
		clickOnElement(clearButton);
		clickOnElement(numpadOne);
		clickOnElement(numpadZero);
		clickOnElement(minusSign);
		clickOnElement(numpadTwo);
		clickOnElement(equalSign);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		result = Integer.parseInt(returnWebElement(resultElem).getAttribute("title"));
		System.out.println("result: "+result);
		assertEquals(result, expectedSubtractResult, "the result of subtract is not right");
	}

	// multiplication function
	public void multiplicationFunction() {
		clickOnElement(clearButton);
		waitForElementToBeClickable(acceptAggreement);
		clickOnElement(clearButton);
		clickOnElement(leftParenthesis);
		clickOnElement(numpadOne);
		clickOnElement(numpadZero);
		clickOnElement(minusSign);
		clickOnElement(numpadTwo);
		clickOnElement(rightParenthesis);
		clickOnElement(multiButton);
		clickOnElement(numpadTwo);
		clickOnElement(equalSign);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		result = Integer.parseInt(returnWebElement(resultElem).getAttribute("title"));
		assertNotEquals(result, notExpectedResult, "the result of multiplication is not right");
	}
	
	// sinus function
	public void sinusFunction() {
		clickOnElement(clearButton);
		waitForElementToBeClickable(acceptAggreement);
		clickOnElement(clearButton);
		clickOnElement(sinusButton);
		clickOnElement(numpadThree);
		clickOnElement(numpadZero);
		clickOnElement(rightParenthesis);
		clickOnElement(equalSign);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		sinusResult = Double.parseDouble(returnWebElement(resultElem).getAttribute("title"));
		assertEquals(sinusResult, expectedsinusResult, "the result of sinus is not right");
	}
	
	
	// historyValidation function
	public void historyValidation() {
		for(int i=1; i<5; i++) {
			String input = String.format(historyItemN, "l",i);
			String output = String.format(historyItemN, "r",i);
			assertTrue(returnWebElement(By.xpath(input)).getAttribute("title").contains(expectedInputs[i-1]));
			assertTrue(returnWebElement(By.xpath(output)).getAttribute("title").contains(expectedOutputs[i-1]));
		}
	}
	
}
