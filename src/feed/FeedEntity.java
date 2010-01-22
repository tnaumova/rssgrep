package feed;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by IntelliJ IDEA.
 * User: mkotsur
 * Date: Dec 12, 2009
 * Time: 8:57:30 PM
 * To change this template use File | Settings | File Templates.
 */
public class FeedEntity {

    private URL feedUrl;

    public FeedEntity(URL feedUrl) {
        this.feedUrl = feedUrl;
    }

    public URL getFeedUrl() {
        return feedUrl;
    }

}
