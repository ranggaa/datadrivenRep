package config;

import java.io.FileInputStream;
import java.util.Properties;

import org.checkerframework.common.util.report.qual.ReportCall;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class AppUtil {
public static WebDriver driver;
public static Properties conpro;
@BeforeTest
public static void setUp()throws Throwable
{
	conpro = new Properties();
	conpro.load(new FileInputStream("./PropertyFiles/Environment.properties"));
	if(conpro.getProperty("browser").equalsIgnoreCase("chrome"))
	{
		System.setProperty("webdriver.chrome.driver", "D:/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	else if(conpro.getProperty("browser").equalsIgnoreCase("firefox"))
	{
		System.setProperty("webdriver.gecko.driver", "D:/geckodriver.exe");
		driver = new FirefoxDriver();
	}
	else
	{
		Reporter.log("Browser Value is Not matching",true);
	}
			
}
@AfterTest
public static void tearDown()
{
	driver.quit();
}
}
