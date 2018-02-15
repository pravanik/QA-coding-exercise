package stepdefinitions;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.HomePage;
import pages.ResultsPage;
import pages.RoomsPage;

public class paintCalculatorStepDefs {

	int RoomSize;

	WebDriver driver = null;

	public WebDriver getdriver() {
		if (driver == null) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			return driver;
		} else {
			return driver;
		}
	}

	HomePage homePage = new HomePage(getdriver());
	RoomsPage roomsPage = new RoomsPage(getdriver());
	ResultsPage resultsPage = new ResultsPage(getdriver());

	@Given("^I launch the  url$")
	public void i_launch_the_url() throws Throwable {
		getdriver().get("http://127.0.0.1:5000/");
		getdriver().manage().window().maximize();

	}

	@When("^I click submit button without entering any value$")
	public void i_click_submit_button_without_entering_any_value() throws Throwable {
		homePage.clickSubmitButton();
	}

	@Then("^I should see required field error$")
	public void i_should_see_required_field_error() throws Throwable {
		homePage.confirmErrorDisplayedWhenWeClickSubmitWithoutEnteringAnyNumber();

	}

	@When("^I enter any value less than (\\d+) and submit$")
	public void i_enter_any_value_less_than_and_submit(int arg1) throws Throwable {
		homePage.enterValueIntoInputBox(0);
		homePage.clickSubmitButton();
	}

	@Then("^I should see \"([^\"]*)\" error$")
	public void i_should_see_error(String arg1) throws Throwable {
		homePage.confirmNumberEnteredInTheInputBoxShouldBeGreaterThan1();
	}

	@When("^I enter any decimal value$")
	public void i_enter_any_decimal_value() throws Throwable {
		homePage.enterDecimalValueIntoInputBox(1.5);
		homePage.clickSubmitButton();
	}

	@Then("^I should see the\"([^\"]*)\"error\\.$")
	public void i_should_see_the_error(String arg1) throws Throwable {
		homePage.confirmNumberEnteredInTheInputBoxShouldBeGreaterThan1();
	}

	@When("^I enter a value for number of rooms and submit (\\d+)$")
	public void i_enter_a_value_for_number_of_rooms_and_submit(int numOfRooms) throws Throwable {
		homePage.enterValueIntoInputBox(numOfRooms);
		homePage.clickSubmitButton();
	}

	@Then("^the rooms with dimensions page is displayed$")
	public void the_rooms_with_dimensions_page_is_displayed() throws Throwable {
		roomsPage.headerIsDisplayed();

	}

	@When("^we enter length breadth height (\\d+) (\\d+) (\\d+) (\\d+)$")
	public void we_enter_length_breadth_height(int roomSize, int length, int width, int height) throws Throwable {
		roomsPage.enterLWHByRoomSize(roomSize, length, width, height);
		RoomSize = roomSize;
	}

	@When("^click submit button$")
	public void click_submit_button() throws Throwable {
		homePage.clickSubmitButton();
	}

	@Then("^the results page is displayed$")
	public void the_results_page_is_displayed() throws Throwable {
		roomsPage.headerIsDisplayed();
	}

	@Then("^the amount of feet to paint value is displayed  (\\d+) (\\d+) (\\d+)$")
	public void the_amount_of_feet_to_paint_value_is_displayed(int length, int width, int height) throws Throwable {

		resultsPage.confirmSurfaceArea(RoomSize, length, width, height);
	}

	@Then("^the gallons required is displayed  (\\d+) (\\d+) (\\d+)$")
	public void the_gallons_required_is_displayed(int length, int width, int height) throws Throwable {
		resultsPage.confirmGallonsRequired(RoomSize, length, width, height);
	}

	@After
	public void teardown() throws InterruptedException {
		getdriver().close();
		getdriver().quit();

	}

}
