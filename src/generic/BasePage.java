package generic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class BasePage {
	
	public void verifyPageIsDisplayed(WebDriver driver,String eResult) {
		String sETO = AutoUtil.getProperty(IAutoConst.CONFIG_PATH, "ETO");
		long ETO = Long.parseLong(sETO);
		WebDriverWait wait=new WebDriverWait(driver,ETO);
		try {
			wait.until(ExpectedConditions.titleIs(eResult));
			Reporter.log("Fail:Expected page is displayed",true);
		}catch(Exception e) {
			Reporter.log("Fail:Expected page is NOT displayed",true);
			Assert.fail();
		}
		
	}
	public void verifyText(WebElement e,String eText) {
		try {
			Thread.sleep(1000);
		}catch(InterruptedException e1) {
			e1.printStackTrace();
		}
		String aText = e.getText();
		Assert.assertEquals(aText,eText);
	}

}
