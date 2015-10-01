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
package starter.component

import org.testatoo.bundle.html5.list.ListView
import org.testatoo.core.property.Items
import org.testatoo.core.property.Size

/**
 * @author David Avenante (d.avenante@gmail.com)
 */
class GoogleListView extends ListView {

    GoogleListView() {
        support Size, { eval("it.find('div.rc').length") as int }
        support Items, { find('div.rc', GoogleItem) }
    }

    List<GoogleItem> getItems() {
        find('div.rc', GoogleItem)
    }
}
