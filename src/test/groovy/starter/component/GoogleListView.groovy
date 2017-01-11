package starter.component

import org.testatoo.core.By
import org.testatoo.core.ComponentException
import org.testatoo.core.CssIdentifier
import org.testatoo.core.component.Item
import org.testatoo.core.component.ListView

@CssIdentifier('div')
class GoogleListView extends ListView {
    List<GoogleItem> items() {
        find(By.css('div.g'), GoogleItem)
    }

    Item item(String value) {
        throw new ComponentException('Unsupported Operation')
    }

    boolean empty() {
        items().empty
    }
}