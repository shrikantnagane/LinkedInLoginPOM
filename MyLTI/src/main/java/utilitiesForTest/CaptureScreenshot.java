package utilitiesForTest;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class CaptureScreenshot {
	public static void capturescreen(WebDriver driver, String screenShotName, String status)
    {
        try {
//            TakesScreenshot takesScreenshot = (TakesScreenshot) driver;

            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            if (status.equals("FAILURE")) {
                FileUtils.copyFile(scrFile, new File("C:\\Users\\SHREE\\eclipse-workspace\\MyLTI\\TestScreenshots\\ScreenshotsFailure\\" + screenShotName + ".png"));
            }
            else if(status.equals("SUCCESS"))
            {
                FileUtils.copyFile(scrFile, new File("C:\\Users\\SHREE\\eclipse-workspace\\MyLTI\\TestScreenshots\\ScreenshotsSuccess\\" + screenShotName + ".png"));
            }


            System.out.println("Screen shot taken for className "+ screenShotName);

        }
        catch (Exception e)
        {
            System.out.println("Exception while taking screenshot " + e.getMessage());
        }

    }
}


