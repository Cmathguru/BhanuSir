package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic.BasePage;

public class LoginPage extends BasePage{
	@FindBy(id="username") private WebElement unTB;
	@FindBy(name="pwd") private WebElement pwTB;
	@FindBy(xpath="//div[.='Login ']") private WebElement loginBTN;
	@FindBy(xpath="//span[@class='errormsg']") private WebElement errMsg;
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public void setUserName(String un) {
		unTB.sendKeys(un);
	}
	public void setPassword(String pw) {
		unTB.sendKeys(pw);
	}
	public void clickLogin() {
		loginBTN.click();
	}
	public void verifyErrMsg(String etext) {
		verifyText(errMsg,etext);
	}


}
