package starter

import org.junit.Before
import org.junit.ClassRule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.testatoo.core.component.Item
import starter.config.WebDriverConfig

import static starter.component.Factory.*
import static org.testatoo.core.Testatoo.*
import static org.testatoo.core.input.Key.RETURN

@RunWith(JUnit4)
class GoogleSearchTest {

    @ClassRule
    public static WebDriverConfig driver = new WebDriverConfig() // <1>

    @Before
    void setup() {
        visit 'http://www.google.ca'
    }

    @Test
    void simple_search_test() {
        searchField.should { be visible }
        resultList.should { be missing }    // <2>

        fill searchField with 'groovy'      // <3>
        type RETURN

        resultList.should { be visible }

        Item item = resultList.items()[0]
        item.should {
            have title('The Groovy programming language')
            have reference('http://www.groovy-lang.org/')
        }
    }
}