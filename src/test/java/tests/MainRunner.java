package tests;

import org.testng.annotations.Test;

@SuppressWarnings("javadoc")
public class MainRunner extends BaseTest {

	String calcSite = "https://web2.0calc.com/";

	@Test(priority = 1, groups = { "Open Web Site test" }, description = "Open the web site test")
	public void OpenSite() {
		mainCalcPage.getWebSite(calcSite);
	}

	
	@Test(priority = 2, groups = { "plus test" }, description = "test the plus function")
	public void plusTest() {
		mainCalcPage.plusFunction();
	}
	
	@Test(priority = 3, groups = { "subtract test" }, description = "test the subtract function")
	public void subtractTest() {
		mainCalcPage.subtractFunction();
	}
	
	@Test(priority = 4, groups = { "multiplication test" }, description = "test the multiplication function")
	public void multiplicationTest() {
		mainCalcPage.multiplicationFunction();
	}
	
	@Test(priority = 5, groups = { "sinus test" }, description = "test the sinus function")
	public void sinusTest() {
		mainCalcPage.sinusFunction();
	}
	
	@Test(priority = 6, groups = { "history test" }, description = "test the history")
	public void historyValidationTest() {
		mainCalcPage.historyValidation();
	}
	

}
