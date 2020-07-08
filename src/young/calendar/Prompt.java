package young.calendar;

import java.util.Scanner;

public class Prompt {

	
	public void runPrompt() {

		Scanner scanner = new Scanner(System.in);
		Calendar cal = new Calendar();
		
		int month = 1;
		int year = 2020;
		int weekday = 0;
		
		for (;;) {
					
			System.out.println("연도를 입력하세요.(exit: -1)");
			System.out.print("YEAR> ");
			year = scanner.nextInt();
				
			if (year == -1) {
				break;
			}
			System.out.println("월을 입력하세요:");
			System.out.print("MONTH> ");
			month = scanner.nextInt();
			
			if (month >12 || month <1) {
				System.out.println("잘못된 입력 입니다.");
				continue;
			}  else {

				cal.printCalendar(year, month);;

				System.out.println("");
			}
		}

		System.out.println("bye~");
		scanner.close();
	}

	public static void main(String[] args) {

		// 셀 실행2
		Prompt p = new Prompt();
		p.runPrompt();
		
		System.out.println();
	 
	}

}
