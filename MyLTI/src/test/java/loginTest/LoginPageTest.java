package loginTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
//import org.testng.Assert;
import org.testng.annotations.*;

//import io.github.bonigarcia.wdm.WebDriverManager;
import pages.LoginPage;
import utilitiesForTest.CaptureScreenshot;

public class LoginPageTest  {
	WebDriver  driver;
		
	@BeforeTest
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver", "F:\\SHRI D\\SKN\\Softwares 2020\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.linkedin.com/home");
				
	}
	
	@Test (priority =  1)
	public void testCase1() {
		
		LoginPage LIn1= new LoginPage(driver);
		LIn1.setUserName("shrikant.nagane2106@gmail.com");
		LIn1.setpassword("Shrikant@123");
		LIn1.clickOnSignInButton();	
		String HomePageHeading = LIn1.getHomePageHeader();
		System.out.println("Heading on Home Page :   " + HomePageHeading);
		Assert.assertEquals(HomePageHeading, "Prepare for your job search");
		
	}
	
	@Test (priority =  -1)
	public void testCase2() {
		LoginPage LIn= new LoginPage(driver);
		String LoginPageHeading = LIn.getLoginPageHeader();
		System.out.println("Heading on Login Page :  " + LoginPageHeading);
		Assert.assertEquals(LoginPageHeading, "Welcome to your professional community");
		
	}
	
	@AfterMethod
public void ScreenShot(ITestResult result) {
		
		if(ITestResult.FAILURE==result.getStatus()) {
            CaptureScreenshot.capturescreen(driver,result.getName(),"FAILURE");
        }
        else {
            CaptureScreenshot.capturescreen(driver,result.getName(),"SUCCESS");
        }
		
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	
}
