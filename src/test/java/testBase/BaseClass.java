package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

// Commonly used methods....
public class BaseClass {

	public static WebDriver driver;
	public Logger logger;
	public Properties p;

	
	@BeforeClass
	@Parameters({ "os", "Browser" })
	public void Setup(String os, String br) throws IOException {

		// loading cofig file
		FileReader file = new FileReader(".\\src\\test\\resources\\config.properties");
		p = new Properties();
		p.load(file);
		logger = LogManager.getLogger(this.getClass());

		if(p.getProperty("execution_env").equalsIgnoreCase("remote"))
		{
			DesiredCapabilities capabilities=new DesiredCapabilities();

			if(os.equalsIgnoreCase("Windows"))
			{
				capabilities.setPlatform(Platform.WIN10);
			}
			else if(os.equalsIgnoreCase("Mac"))
			{
				capabilities.setPlatform(Platform.WIN10);

			}
			else if(os.equalsIgnoreCase("Linux"))
			{
				capabilities.setPlatform(Platform.WIN10);

			}
			else 
			{
				System.out.println("No Matching os");
				return;
			}
			
			switch(br.toLowerCase()) {
			case "chrome": capabilities.setBrowserName("chrome");break;
			case "edge": capabilities.setBrowserName("MicrosoftEdge");break;
			case "firefox": capabilities.setBrowserName("firefox");break;
			default : System.out.println("Invalid Browser");return;
			}
			
			//driver=new RemoteWebDriver(new URL("http://192.168.151.155:4444/wd/hub"),capabilities);
			driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities);
		}
		
		if(p.getProperty("execution_env").equalsIgnoreCase("local")) {
			switch (br.toLowerCase()) {
			case "chrome":
				driver = new ChromeDriver();
				break;
			case "edge":
				driver = new EdgeDriver();
				break;
			case "firefox":
				driver = new FirefoxDriver();
				break;
			default:
				System.out.println("Invalid Browser");
				return;
		}		
		}
	/*	switch (br.toLowerCase()) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		default:
			System.out.println("Invalid Browser");
			return;

		}*/

		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// driver.get("https://tutorialsninja.com/demo/");
		driver.get(p.getProperty("appurl"));
		driver.manage().window().maximize();
	
	}

	@AfterClass
	public void teardown() {
		driver.quit();
	}

	public String randomString() {
		String generated = RandomStringUtils.randomAlphabetic(5);
		return generated;

	}

	public String randomnumeric() {
		String number = RandomStringUtils.randomNumeric(10);
		return number;
	}

	public String ranpwd() {
//		String pwd=RandomStringUtils.randomAlphabetic(8);
//		return (pwd);

		String generatedString = RandomStringUtils.randomAlphabetic(4);
		String generatedNumeric = RandomStringUtils.randomNumeric(3);
		return (generatedString + "@" + generatedNumeric);
	}

	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile=new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
			
		return targetFilePath;

	}
	
	
}
