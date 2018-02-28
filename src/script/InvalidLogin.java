package script;

import org.testng.annotations.Test;

import generic.BaseTest;
import generic.Excel;
import page.LoginPage;

public class InvalidLogin extends BaseTest{
	@Test (priority=2)
	public void testInvalidLogin() {
		String un = Excel.getData(XL_PATH, "InvalidLogin", 1, 0);
		String pw = Excel.getData(XL_PATH, "InvalidLogin", 1, 1);
		String msg = Excel.getData(XL_PATH, "InvalidLogin", 1, 2);
		//Enter invalid username
		LoginPage l=new LoginPage(driver);
		l.setUserName(un);
		//Enter Invalid password
		l.setPassword(pw);
		//click on login
		l.clickLogin();
		//verify error massage
		l.verifyErrMsg(msg);
		
	}

}
