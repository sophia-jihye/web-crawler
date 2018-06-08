package pageReader;

import samples.mail.Gmail;

public class Main {
	public static void main(String[] args) {

		Spider spider = new Spider();

		String userId = "sophia.jihyeparkk";
		String passwd = "111111";
		String emailFrom = "sophia.jihyeparkk@gmail.com";
		String emailTo = "jihyeparkk@naver.com";
		String subject = "�Խ��� ������Ʈ ����~";
		String content = "http://ie.snu.ac.kr/ko/board/8";

		Gmail gmail = new Gmail();
		Gmail.userId = userId;
		Gmail.passwd = passwd;
		gmail.setEmailFrom(emailFrom);
		gmail.setEmailTo(emailTo);
		gmail.setSubject(subject);
		gmail.setContent(content);

		while (true) {
			boolean flag = spider.search("http://ie.snu.ac.kr/ko/board/8", "2018-06-08");
			if (flag) {
				gmail.sendMail();
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
