package generic;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public abstract class BaseTest implements IAutoConst{
	public WebDriver driver;
	static {
		System.setProperty(CHROME_KEY, CHROME_VALUE);
		System.setProperty(GECKO_KEY, GECKO_VALUE);
	}
	@Parameters({"browser","ip"})
	@BeforeMethod(alwaysRun=true)
	
	public void openApplication(String browserName,String ip) throws Exception {
		 driver=new ChromeDriver();
		 String appURL = AutoUtil.getProperty(CONFIG_PATH, "appURL");
		
		 String sITO = AutoUtil.getProperty(CONFIG_PATH, "ITO");
		long ITO = Long.parseLong(sITO);  //long is DATA TYPE and Long is CLASS
		
		URL node = new URL("http://"+ip+":4444/wd/hub");
		DesiredCapabilities browser = new DesiredCapabilities();
		browser.setBrowserName(browserName);
		driver = new RemoteWebDriver(node,browser);
		driver.get(appURL);
		driver.manage().timeouts().implicitlyWait(ITO, TimeUnit.SECONDS);
	}
	@AfterMethod
	public void closeApplication(ITestResult r) {
		String testName = r.getName();
		int status = r.getStatus();
		if(status==2) {
			AutoUtil.getPhoto(driver, PHOTO_PATH, testName);
		}
		driver.quit();
	}

}
