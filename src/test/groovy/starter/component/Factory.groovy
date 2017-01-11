package starter.component

import org.testatoo.bundle.html5.input.InputTypeText
import org.testatoo.core.component.ListView
import org.testatoo.core.component.field.TextField

import static org.testatoo.core.Testatoo.$

class Factory {

    static TextField getSearchField() {
        $('#lst-ib') as InputTypeText   // 1
    }

    static ListView getResultList() {
        $('#rso') as GoogleListView     // 2
    }

}
