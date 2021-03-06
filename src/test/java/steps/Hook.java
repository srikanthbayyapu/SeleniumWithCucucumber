package steps;

import Base.BaseUtil;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
/**
 * Created by Karthik on 31/01/2019.
 */

public class Hook extends BaseUtil{


    private BaseUtil base;

    public Hook(BaseUtil base) {
        this.base = base;
    }

    @Before
    public void InitializeTest(Scenario scenario) {


        scenarioDef = base.features.createNode(scenario.getName());

        System.out.println("Opening the browser : Chrome");

       System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");
 
            // Initialize browser
            WebDriver driver=new ChromeDriver();

            // Open Execute automation site
            driver.get("http://executeautomation.com/demosite/Login.html");

            // Maximize browser

            driver.manage().window().maximize();


        //Chrome driver
        /*System.setProperty("webdriver.chrome.driver", "C:\\Libs\\chromedriver");
        base.Driver = new ChromeDriver();*/
    }


    @After
    public void TearDownTest(Scenario scenario) {
        if (scenario.isFailed()) {
            //Take screenshot logic goes here
            System.out.println(scenario.getName());
        }
        System.out.println("Closing the browser : MOCK");
    }

}
