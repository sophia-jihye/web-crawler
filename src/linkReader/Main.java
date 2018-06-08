package linkReader;

public class Main {
	public static void main(String[] args) {

		Spider spider = new Spider();

		spider.search(
				"http://ie.snu.ac.kr/ko/board/8",
				"SUBSCRIBE");

	}
}
