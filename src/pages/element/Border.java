package pages.element;

import org.apache.click.Page;
import org.apache.click.element.CssImport;
import org.apache.click.element.JsImport;

import java.util.List;

public abstract class Border extends Page {

    protected List headElements;
    
    public List getHeadElements() {
        if (headElements == null) {
            headElements = super.getHeadElements();

            headElements.add(new CssImport("css/main.css"));
            headElements.add(new JsImport("js/main.js"));
        }
        return headElements;
    }

    public String getTemplate() {
        return "/border.htm";
    }
}
