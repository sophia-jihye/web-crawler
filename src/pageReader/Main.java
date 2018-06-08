package pageReader;

public class Main {
	public static void main(String[] args) {

		Spider spider = new Spider();

		while (true) {
			boolean flag = spider.search("http://ie.snu.ac.kr/ko/board/8", "2018-06-08");
			if (flag) {
				break;
			}
			try {
				Thread.sleep(60000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}
}
