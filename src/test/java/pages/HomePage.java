package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//input[@type='submit']")
	private WebElement submitButton;

	@FindBy(how = How.CSS, using = "input[type='number']")
	private WebElement enterValueInputBox;

	public void clickSubmitButton() {
		submitButton.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// If we submit without entering any value in the submit text box , it shows a
	// browser based error. This browser based error
	// occurs because of the required attribute in the html.
	public void confirmErrorDisplayedWhenWeClickSubmitWithoutEnteringAnyNumber() {
		String actual = enterValueInputBox.getAttribute("required");
		String expected = "true";
		Assert.assertEquals(expected, actual);
	}

	public void enterValueIntoInputBox(int value) {
		enterValueInputBox.sendKeys(String.valueOf(value));
	}

	public void enterDecimalValueIntoInputBox(double value) {
		enterValueInputBox.sendKeys(String.valueOf(value));
	}

	// If we submit entering any value less than 1 in the submit textbox , it shows
	// a browser based error. This browser based error
	// occurs due to the min attribute set to 1
	// If we submit entering any value decimal in the submit textbox , it shows a
	// browser based error. This browser based error
	// occurs because every number field in html5 spec is using step=1 on the input
	// fields
	public void confirmNumberEnteredInTheInputBoxShouldBeGreaterThan1() {
		String actual = enterValueInputBox.getAttribute("min");
		String expected = "1";
		Assert.assertEquals(expected, actual);
	}

}
