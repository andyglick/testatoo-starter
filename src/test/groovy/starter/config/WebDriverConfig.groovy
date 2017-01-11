package starter.config

import org.junit.rules.ExternalResource
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.remote.DesiredCapabilities
import org.openqa.selenium.remote.RemoteWebDriver
import org.testatoo.evaluator.webdriver.WebDriverEvaluator

import static org.testatoo.core.Testatoo.getConfig

class WebDriverConfig extends ExternalResource {
    @Override
    protected void before() throws Throwable {
        // Defined by JVM maven arguments
        final String drivers = System.getProperty('driver') ?: '/usr/bin'
        final boolean docker = System.getProperty('docker') ? true : false // -Ddocker

        if (docker) {
            WebDriver driver = new RemoteWebDriver(new URL('http://localhost:4444/wd/hub'), DesiredCapabilities.chrome())
            config.evaluator = new WebDriverEvaluator(driver)
        } else {
            System.setProperty('webdriver.chrome.driver', drivers + '/chromedriver')
            config.evaluator = new WebDriverEvaluator(new ChromeDriver())
        }
    }

    @Override
    protected void after() {
        config.evaluator.close()
    }
}