package young.calendar;

import java.util.Scanner;

public class Prompt {

	private final static String PROMPT = "cal> ";

	public void runPrompt() {

		Scanner scanner = new Scanner(System.in);
		Calendar cal = new Calendar();
		
		int month = 0;
		int year = 0;

		for (int i = 0;; i++) {
			System.out.println("연도를 입력하세요:");
			System.out.print(PROMPT);
			year = scanner.nextInt();
			System.out.println("달을 입력하세요:");
			System.out.print(PROMPT);
			month = scanner.nextInt();

			if (month == -1) {
				System.out.println("Have a nice day!");
				break;
			} else if (month > 12) {
				continue;
			} else {

				cal.printCalendar(year, month);;

				System.out.println("");
			}
		}

		System.out.println("bye~");
		scanner.close();
	}

	public static void main(String[] args) {

		// 셀 실행
		Prompt p = new Prompt();
		p.runPrompt();

	}

}
