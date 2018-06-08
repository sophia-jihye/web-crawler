package pageReader;

public class Spider {

	public boolean search(String url, String searchWord) {

		String currentUrl;
		SpiderLeg leg = new SpiderLeg();
		currentUrl = url;

		leg.crawl(currentUrl);

		boolean success = leg.searchForWord(searchWord);
		if (success) {
			System.out.println(String.format("**Success** Word %s found at %s", searchWord, currentUrl));
			return true;
		}

		return false;
	}
}
