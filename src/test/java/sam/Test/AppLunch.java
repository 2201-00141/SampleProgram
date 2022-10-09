package sam.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.windows.WindowsDriver;
import io.appium.java_client.windows.WindowsElement;

public class AppLunch
{
	public static WindowsDriver<WindowsElement> driver = null;

	 

    @BeforeMethod

    public void setUp() {

                   DesiredCapabilities cap = new DesiredCapabilities();

  //            cap.setCapability("app","C:\\Users\\2201-00098\\AppData\\Roaming\\Microsoft\\Windows\\Start Menu\\Programs\\Fisker.lnk");

                   cap.setCapability("app", "C:\\Program Files\\Fisker\\Fisker.exe");

                   cap.setCapability("platform", "Windows");

                   cap.setCapability("deviceName", "WindowsPC");

                   try {

                                 driver = new WindowsDriver<WindowsElement>(new URL("http://127.0.0.1:4723"), cap);

                   } catch (MalformedURLException e) {

                                 e.printStackTrace();

                   }

                   driver.manage().timeouts().implicitlyWait(35, TimeUnit.SECONDS);



    }


//Aftermethod
    @AfterMethod

    public void cleanUp() {

                   driver.quit();

                   // setUp();

    }



    @Test(priority=0)

    public void validateLogin() {

                   System.out.println("IN");

                   // driver.findElementById("login-button").click();

                   // driver.findElement(By.id("login-button")).click();

//               driver.findElementByName("Login With Microsoft Account").click();

                   WebElement VINConnect = driver.findElementByName("Connect with VIN");

                   VINConnect.click();

                   System.out.println("Successfully clicked VIN connect link");

    }

   

    @Test(priority=1)

    public void viewProfile() {



                   WebElement userProfile = driver.findElementByName("User Profile");

                   userProfile.click();

    }

   

    @Test(priority=3)

    private void logout() {

                   viewProfile();                  



                   WebElement logout = driver.findElementByName("Logout");

                   logout.click();



                   WebElement confirmLogout = driver.findElementByName("Okay");

                   confirmLogout.click();



    }

}
