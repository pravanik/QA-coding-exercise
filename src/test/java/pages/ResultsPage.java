package pages;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ResultsPage {

	WebDriver driver;

	public ResultsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//table[@name='Results']/tbody/tr/td[2]")
	private List<WebElement> SurfaceAreaActualValues;

	@FindBy(how = How.XPATH, using = "//table[@name='Results']/tbody/tr/td[3]")
	private List<WebElement> gallonsRequiredActualValues;

	@FindBy(how = How.CSS, using = "h5")
	private WebElement TotalGallonsRequiredActual;

	public int calculateSurfaceOfAreaToPaint(int length, int width, int height) {
		int surfaceAreaInFt = ((length * 2) + (width * 2)) * height;
		return surfaceAreaInFt;
	}

	public int calculateGallonsRequired(int length, int width, int height) {
		int gallonsRequiredInFt = Math.round((calculateSurfaceOfAreaToPaint(length, width, height) / 400));
		return gallonsRequiredInFt;
	}

	public void confirmSurfaceArea(int roomSize, int length, int width, int height) {
		if (roomSize >= 1) {
			for (int i = 0; i < roomSize; i++) {
				String SurfaceAreaActual = SurfaceAreaActualValues.get(i).getText();
				String SurfaceAreaExpected = Integer.toString(calculateSurfaceOfAreaToPaint(length, width, height));
				Assert.assertEquals(SurfaceAreaExpected, SurfaceAreaActual);
			}
		}
	}

	public void confirmGallonsRequired(int roomSize, int length, int width, int height) {
		int TotalGallonsRequired = 0;
		String TotalGallonsRequiredExpected = null;
		if (roomSize >= 1) {
			for (int i = 0; i < roomSize; i++) {
				String gallonsRequiredActual = gallonsRequiredActualValues.get(i).getText();
				String gallonsRequiredExpected = Integer.toString(calculateGallonsRequired(length, width, height));
				Assert.assertEquals(gallonsRequiredExpected, gallonsRequiredActual);
				TotalGallonsRequired = TotalGallonsRequired + Integer.parseInt(gallonsRequiredActual);
				TotalGallonsRequiredExpected = Integer.toString(TotalGallonsRequired);
			}
			Assert.assertTrue((TotalGallonsRequiredActual.getText().trim()).contains(TotalGallonsRequiredExpected));
		}
	}

}
