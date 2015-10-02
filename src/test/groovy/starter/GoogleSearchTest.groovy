/**
 * Copyright (C) 2014 Ovea (dev@ovea.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package starter

import org.junit.AfterClass
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

import org.junit.runners.JUnit4
import org.openqa.selenium.firefox.FirefoxDriver
import org.testatoo.bundle.html5.Button
import org.testatoo.bundle.html5.input.TextField
import org.testatoo.core.evaluator.webdriver.WebDriverEvaluator
import starter.component.GoogleItem
import starter.component.GoogleListView

import static org.testatoo.core.Testatoo.*
import static org.testatoo.core.action.Actions.fill
import static org.testatoo.core.action.Actions.visit
import static org.testatoo.core.input.Mouse.click_on
import static org.testatoo.core.property.Properties.getTitle
import static org.testatoo.core.state.States.getMissing
import static org.testatoo.core.state.States.getVisible
import static starter.component.property.Properties.getDescription
import static starter.component.property.Properties.getUrl

/**
 * @author David Avenante (d.avenante@gmail.com)
 */
@RunWith(JUnit4)
class GoogleSearchTest {

    static TextField searchField
    static Button searchButton
    static GoogleListView resultList

    @Before
    public void setup() {
        evaluator = new WebDriverEvaluator(new FirefoxDriver())
        visit 'http://www.google.ca'

        searchField = $('#lst-ib') as TextField
        searchButton = $('#sblsbb button') as Button
        resultList = $('#rso') as GoogleListView
    }

    @AfterClass
    public static void tearDown() { evaluator.close() }

    @Test
    public void simple_test() {
        resultList.should { be missing }
        searchField.should { be visible }

        fill searchField with 'groovy'
        click_on searchButton

        resultList.should { be visible }

        GoogleItem item = resultList.items[1];
        item.should {
            have title.containing('The Groovy programming language')
            have url.containing('www.groovy-lang.org')
            have description.containing('Groovy is a powerful, optionally typed and dynamic language')
        }
    }
}
