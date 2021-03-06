package pages;

import java.util.HashMap;

import org.apache.click.control.Form;
import org.apache.click.control.Submit;
import org.apache.click.control.TextField;

import pages.element.Border;
import pages.inner.AnonymousFilterBuilder;

public class Index extends Border {

    public Form rssUrlForm = new Form();

    private TextField rssUrlField;

    @Override
    public void onInit() {

        super.onInit();

        rssUrlField = new TextField("rssUrl", "Rss URL:");

        rssUrlField.setSize(90);
        rssUrlField.setMinLength(1);
        rssUrlField.setRequired(true);
        rssUrlField.setFocus(true);
        prepareRssUrlForm();
    }

    protected void prepareRssUrlForm() {

        rssUrlForm.setLabelsPosition(Form.POSITION_LEFT);
        rssUrlForm.setButtonAlign(Form.ALIGN_RIGHT);
        rssUrlForm.add(rssUrlField);
        rssUrlForm.add(new Submit("rssUrlFormSubmit", "Go ahead !", this, "onSubmitRssUrl"));
    }

    public boolean onSubmitRssUrl() {
        
        if(rssUrlForm.isValid()) {
            HashMap parameters = new HashMap(1);
            parameters.put("rssUrl", rssUrlField.getValue());
            setRedirect(getContext().getPagePath(AnonymousFilterBuilder.class), parameters);
        }

        return false;
    }

    
}
