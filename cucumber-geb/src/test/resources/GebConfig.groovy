/*
	This is the Geb configuration file.

	See: http://www.gebish.org/manual/current/configuration.html
*/

import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.phantomjs.PhantomJSDriver
import org.openqa.selenium.ie.InternetExplorerDriver
import org.openqa.selenium.remote.DesiredCapabilities
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.net.InetAddress;
import java.net.UnknownHostException;


driver = { new ChromeDriver() }

environments {

	// run as â€œgradle -Dgeb.env=chrome cucumberâ€�
	// See: http://code.google.com/p/selenium/wiki/ChromeDriver
	firefox {

		DesiredCapabilities capabilities =  DesiredCapabilities.firefox();
				capabilities.setCapability("marionette", true);
        		capabilities.setCapability("networkConnectionEnabled", true);
        		capabilities.setCapability("browserConnectionEnabled", true);
				capabilities.setJavascriptEnabled(true);
				
  	driver = { new FirefoxDriver(capabilities) }		
	}
	

	// run as â€œgradle -Dgeb.env=phantomjs cucumberâ€�
	// See: https://github.com/detro/ghostdriver
	phantomjs {
		driver = { new PhantomJSDriver() }
	}

	chrome {
		ChromeOptions options = new ChromeOptions();
		options.AddArguments("--disable-infobars");
		options.AddArguments("start-maximized");
		driver = new ChromeDriver(options);

  }

	ie {
    driver = {new InternetExplorerDriver()}
  }
	chromeheadless {
	   driver =  { new ChromeDriver() }
	   ChromeOptions chromeOptions = new ChromeOptions();
           chromeOptions.addArguments("--headless");
	   driver = {new ChromeDriver(chromeOptions)};
  }

}

baseUrl = "https://opentdb.com/"

println "BaseUrl = " + baseUrl;



baseNavigatorWaiting = true
