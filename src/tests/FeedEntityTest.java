package tests;

import feed.FeedEntity;
import junit.framework.TestCase;

import java.net.MalformedURLException;
import java.net.URL;


/**
 * Created by IntelliJ IDEA.
 * User: mkotsur
 * Date: Dec 12, 2009
 * Time: 11:08:00 PM
 * To change this template use File | Settings | File Templates.
 */
public class FeedEntityTest extends TestCase {

    private URL mockedUrl;

    public void setUp() {
        try {
            mockedUrl = new URL("http://google.com");
        } catch (MalformedURLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    public void testGetter() {
        FeedEntity entity = new FeedEntity(mockedUrl);
        assertEquals(entity.getFeedUrl(), mockedUrl);
    }
    

}
