package pages;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class RoomsPage {

	WebDriver driver;
	
	public RoomsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.CSS,using="h1")
	private WebElement calculatingPaintRequiredHeader;
	
	@FindBy(how=How.XPATH,using="//tr/td/input")
	private List<WebElement> lengthbreadthheighttabledata;
	
	
	
	public void headerIsDisplayed(){
		Assert.assertTrue(calculatingPaintRequiredHeader.isDisplayed());
	}
	
	
	public void enterLWHByRoomSize(int roomSize,int length,int width,int height){
			if(roomSize>=1){
				for(int i=0;i<roomSize*3;i+=3){
					lengthbreadthheighttabledata.get(i).sendKeys(String.valueOf(length));
					lengthbreadthheighttabledata.get(i+1).sendKeys(String.valueOf(width));
					lengthbreadthheighttabledata.get(i+2).sendKeys(String.valueOf(height));
				}
			}
		}
	}

