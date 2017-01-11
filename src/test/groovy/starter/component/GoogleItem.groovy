package starter.component

import org.testatoo.core.ComponentException
import org.testatoo.core.CssIdentifier
import org.testatoo.core.component.Item
import org.testatoo.core.support.property.ReferenceSupport
import org.testatoo.core.support.property.TitleSupport
import static org.testatoo.core.Testatoo.config

@CssIdentifier('div')
class GoogleItem extends Item implements TitleSupport, ReferenceSupport {
    String title() {
        config.evaluator.eval(this.id(), "it.find('h3:first').text()")
    }

    String reference() {
        config.evaluator.eval(this.id(), "it.find('h3:first a').attr('href')")
    }

    void select() {
        throw new ComponentException('Unsupported Operation')
    }

    void unselect() {
        throw new ComponentException('Unsupported Operation')
    }

    Object value() {
        throw new ComponentException('Unsupported Operation')
    }

    boolean selected() {
        throw new ComponentException('Unsupported Operation')
    }
}
