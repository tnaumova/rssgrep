package pages.inner;

import org.apache.click.Page;
import pages.Index;

public class AnonymousFilterBuilder extends Page {

    public String sourceRss = "";

    public void onInit() {
        if (rssUrlValid()) {
            sourceRss = getContext().getRequestParameter("rssUrl");
        } else {
            goToIndex();
        }
    }

    protected void goToIndex() {
        setRedirect(getContext().getPagePath(Index.class));
    }

    protected boolean rssUrlValid() {
        String param = getContext().getRequestParameter("rssUrl");
        return (param != null && param.length() > 0);
    }
    

}
