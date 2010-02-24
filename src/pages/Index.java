package pages;

import java.util.Date;
import org.apache.click.Page;
import org.apache.click.control.ActionLink;
import org.apache.click.util.Bindable;

import org.apache.click.control.Form;
import org.apache.click.control.Submit;
import org.apache.click.control.TextField;

import pages.inner.AnonymousFilterBuilder;


public class Index extends Page {

    public Form rssUrlForm = new Form();

    private TextField rssUrlField = new TextField("rssUrl", "Rss URL");

    public Index() {
        prepareRssUrlForm();
    }

    protected void prepareRssUrlForm() {

        rssUrlForm.setLabelsPosition(Form.POSITION_LEFT);

        rssUrlForm.add(rssUrlField);
        rssUrlForm.add(new Submit("rssUrlFormSubmit", "Go ahead !", this, "onSubmitRssUrl"));
    }

    public boolean onSubmitRssUrl() {

        setRedirect(getContext().getPagePath(AnonymousFilterBuilder.class) + "?rssUrl=" + rssUrlField.getValue());
        return false;
        

    }

    
}
