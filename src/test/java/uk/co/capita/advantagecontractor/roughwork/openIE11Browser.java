package uk.co.capita.advantagecontractor.roughwork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import org.openqa.selenium.JavascriptExecutor;

public class openIE11Browser {
	public static JavascriptExecutor executor;
	public static void main(String[] args) throws InterruptedException {
		//IMP-Ensure that Enable Protected mode is same for all 4 options viz Internet, Local Intranet, Trusted Sites and Restricted Sites.
		//To do this open IE, go to Tools-->Internet Options-->Security tab
		//Select "Enable Protected mode" checkbox for all 4 options.
		
		
		System.out.println("Hello World - How are you?1");

		System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "\\DriverServers\\IEDriver\\IEDriverServer.exe");
		DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
		capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		capabilities.setCapability("ignoreZoomSetting", true);
		capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		capabilities.setJavascriptEnabled(true);
		WebDriver driver = new InternetExplorerDriver();
		((HtmlUnitDriver) driver).setJavascriptEnabled(true);
		driver.navigate().to("https://www.google.co.uk/");
		System.out.println("Opened");
		Thread.sleep(5000);


		driver.findElement(By.xpath(".//*[@id='gs_htif0']")).sendKeys("MotoC");
		WebElement element = driver.findElement(By.xpath(".//*[@id='tsf']/div[2]/div[3]/center/input[1]"));
		executor = (JavascriptExecutor)((HtmlUnitDriver)driver);
		executor.executeScript("arguments[0].click();", element);
		
//		driver.findElement(By.cssSelector("")).click();
//		System.out.println("Hello World - How are you?2");
		System.out.println("DONE");
		System.out.println(driver.findElement(By.xpath("//span[text() = 'Mihnea Motoc']")).getText());
	}

}
