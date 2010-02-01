package controller;

import feed.FeedEntity;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class RssServlet extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {


        try {
            FeedEntity feed = this.getFeedEntity(req.getParameter("feed"));
            resp.setContentType("text/plain");
            resp.getWriter().println("Hello, world : " + feed.getFeedUrl());
        } catch (MalformedURLException urlException) {
            resp.getWriter().println("Error : " + urlException.getMessage());
            return;
        }
    }


    private FeedEntity getFeedEntity(String url) throws MalformedURLException {
        return new FeedEntity(new URL(url));
    }

}
