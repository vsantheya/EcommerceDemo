package ExcerciseDemo.ETestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import ExcerciseDemo.EPageObjects.ELoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class EBaseTest {

	public WebDriver driver;
	public ELoginPage loginpage;
	
	public WebDriver EInitilizeDriver() throws IOException
	{
		Properties prop = new Properties();
		FileInputStream  fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\ExcerciseDemo\\resources\\EGlobaldata.Properties");
		prop.load(fis);
		
		String browserName =System.getProperty("browser")!= null ? System.getProperty("browser") : prop.getProperty("browser");
		
		
		
		
		if(browserName.contains("chrome"))
		{
			ChromeOptions options = new ChromeOptions();
			WebDriverManager.chromedriver().setup();
			if(browserName.contains("headless"))
				{
				options.addArguments("headless");
			}
			driver=new ChromeDriver(options);
			driver.manage().window().setSize(new Dimension(1440,900));
		}
		else if (browserName.contains("firefox"))
		{
			//System.setProperty(browserName, browserName)
			driver = new FirefoxDriver();
			
		}else if (browserName.contains("edge"))
		{
			//System.setProperty(browserName, browserName)
			driver = new EdgeDriver();
			
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		return driver;
		
	}
	
	
	
	
	public List<HashMap<String, String>> getJsonDataToMap(String filepath) throws IOException
	{
		//json to string
		String jsoncontent = FileUtils.readFileToString(new File(filepath),
				StandardCharsets.UTF_8);
		
		//string to map
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String,String>> data = mapper.readValue(jsoncontent, new TypeReference<List<HashMap<String,String>>>(){
			
		});
		return data;
	}
	
	public String EgetScreenShot(String testCaseName,WebDriver driver) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File(System.getProperty("user.dir")+"//reports//"+testCaseName+".png");
		FileUtils.copyFile(src, dest);
		return  System.getProperty("user.dir")+"//reports//"+testCaseName+"//.png";
				
	}
	
	
	public ELoginPage ELaunchApplication() throws IOException
	{
		driver=EInitilizeDriver();
	    loginpage = new ELoginPage(driver);
		loginpage.goTo();
		return loginpage;
		
	}
	
	
	public void tearDown()
	
	{
		driver.close();
	}




	
}















