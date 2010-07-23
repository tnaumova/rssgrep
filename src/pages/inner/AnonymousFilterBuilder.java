package pages.inner;

import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;
import pages.Index;
import pages.element.Border;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.apache.click.control.*;

public class AnonymousFilterBuilder extends Border {

    public String sourceRss = "";
    public String msg;
    public List<SyndEntry> entries;
    public Form filterForm = new Form();

    @Override
    public void onInit() {
        super.onInit();

        sourceRss = getContext().getRequestParameter("rssUrl");

        try {

            if (rssUrlValid() == false) {
                System.out.println("URL is invalid");
            }

            buildFilterForm();
            entries = getXmlEntriesForUrl(new URL(sourceRss));
            System.out.println("no error");
        } catch (Exception e) {
            System.out.println("error");
            e.printStackTrace();
            goToIndexWithError();
        }

    }

    public boolean onFilterSubmit() {
        if (!filterForm.isValid()) {
            msg = "You have to enter the filter. Please, do so!";
            return true;
        }

        Iterator<SyndEntry> ourIterator = entries.iterator();

        while (ourIterator.hasNext()) {
            SyndEntry nextValue = ourIterator.next();
            if (!nextValue.getTitle().contains(filterForm.getFieldValue("filter"))) {
                System.out.println(nextValue.getTitle());
                ourIterator.remove();
            } else {
                System.out.println(":-( " + nextValue.getTitle());
            }
        }
/*
        for(SyndEntry entry : entries) {
            if (!entry.getTitle().contains(filterForm.getFieldValue("filter"))) {
                entries.remove(entry);
            }
        }
*/
        return true;


    }

    protected void goToIndexWithError() {
        getContext().setRequestAttribute("rssUrl", sourceRss);
        getContext().setRequestAttribute("error", "1");
        setForward("index.htm");   
    }

    protected boolean rssUrlValid() {
        return (sourceRss != null && sourceRss.length() > 5);
    }


    protected List<SyndEntry> getXmlEntriesForUrl(URL feedUrl) {
        try {
            XmlReader xmlReader = new XmlReader(feedUrl);
            return new SyndFeedInput().build(xmlReader).getEntries();
        } catch(Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    protected Form buildFilterForm() {

        filterForm.add(new TextField("filter", "Filter phrase", true));
        filterForm.add(new Submit("Go filter"));
        filterForm.add(new HiddenField("rssUrl", sourceRss));
        filterForm.setListener(this, "onFilterSubmit");
        return filterForm;

    }


}
