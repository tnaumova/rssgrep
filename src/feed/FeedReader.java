package feed;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URLConnection;

/**
 * Created by IntelliJ IDEA.
 * User: mkotsur
 * Date: Dec 13, 2009
 * Time: 9:14:58 PM
 * To change this template use File | Settings | File Templates.
 */
public class FeedReader extends DefaultHandler {

    private FeedEntity feedEntity;
    final private int attemptsCount = 5;

    public void readFeed(FeedEntity feed) {

        feedEntity = feed;

        try {
            XMLReader xmlReader = XMLReaderFactory.createXMLReader();
            xmlReader.setContentHandler(this) ;
            xmlReader.setErrorHandler(this);

            xmlReader.parse(getInputSource());
            
        } catch (Exception e) {
            
        }

    }

    private InputSource getInputSource() throws IOException {
        return new InputSource(new InputStreamReader(openConnection().getInputStream()));
    }

    private URLConnection openConnection() {

        int tryCount = 0;

        while (tryCount < attemptsCount) {
            try {
                return feedEntity.getFeedUrl().openConnection();
            }  catch(IOException e) {
               tryCount ++;
            }
        }

        return null;

    }
}