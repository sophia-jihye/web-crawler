package linkReader;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class SpiderLeg {

	// We'll use a fake USER_AGENT so the web server thinks the robot is a
	// normal web browser.
	private static final String USER_AGENT = "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/535.1 (KHTML, like Gecko) Chrome/13.0.782.112 Safari/535.1";

	// Just a list of URLs
	private List<String> links = new LinkedList<String>();

	// This is our web page, or in other words, our document
	private Document htmlDocument;

	// Returns a list of all the URLs on the page
	public List<String> getLinks() {
		return this.links;
	}

	// Give it a URL and it makes an HTTP request for a web page
	public Document crawl(String url) {
		try {
			Connection connection = Jsoup.connect(url).userAgent(USER_AGENT);
			Document htmlDocument = connection.get();
			this.htmlDocument = htmlDocument;

			System.out.println("Received web page at " + url);

			Elements linksOnPage = htmlDocument.select("a[href]");
			System.out.println("Found (" + linksOnPage.size() + ") links");
			for (Element link : linksOnPage) {
				this.links.add(link.absUrl("href"));
			}
		} catch (IOException ioe) {
			// We were not successful in our HTTP request
			System.out.println("Error ocurred in HTTP request " + ioe);
		}
		return htmlDocument;
	}

	// Tries to find a word on the page
	public boolean searchForWord(String searchWord) {
		System.out.println("Searching for the word " + searchWord + "...");
		if (this.htmlDocument == null || this.htmlDocument.body() == null) {
			System.out.println("NULL OCCURED");
			return false;
		}
		String bodyText = this.htmlDocument.body().text();
		return bodyText.toLowerCase().contains(searchWord.toLowerCase());
	}

}
