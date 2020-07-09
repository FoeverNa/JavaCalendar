package young.calendar;

import java.text.ParseException;
import java.util.Scanner;

public class Prompt {

	public void printMenu() {
		
		System.out.println("+----------------------+");
		System.out.println("| 1. 일정 등록 ");          
		System.out.println("| 2. 일정 검색");           
		System.out.println("| 3. 달력 보기");
		System.out.println("| h. 도움말 q. 종료");
		System.out.println("+----------------------+");
	}
	
	public void runPrompt() throws ParseException {
		
		printMenu();
		Scanner scanner = new Scanner(System.in);
		Calendar cal = new Calendar();
				
		for (;;) {
								
			String cmd = scanner.next();
			if (cmd.equals("1")) cmdRegister(scanner, cal);
			else if(cmd.equals("2")) cmdSearch(scanner, cal);
			else if(cmd.equals("3")) cmdCal(scanner, cal);
			else if(cmd.equals("h")) printMenu();
			else if(cmd.equals("q")) break;
		}

		System.out.println("Thanks, Bye~");
		scanner.close();
	}

	private void cmdCal(Scanner s, Calendar c) {
		
		int month = 1;
		int year = 2020;
		
		System.out.println("연도를 입력하세요.(exit: -1)");
		System.out.print("YEAR> ");
		year = s.nextInt();
			
		System.out.println("월을 입력하세요:");
		System.out.print("MONTH> ");
		month = s.nextInt();
		
		if (month >12 || month <1) {
			System.out.println("잘못된 입력 입니다.");
			
		} else{ c.printCalendar(year, month);;
			
			System.out.println("");
		}
			
			return;
		}
	
	

	
	private void cmdSearch(Scanner s, Calendar c) throws ParseException {
		System.out.println("[일정 검색]");
		System.out.println("날짜를 입력해주세요 (yyyy-MM-dd)");
		String date = s.next();
		String plan = c.serchPlan(date);
		
		System.out.println(plan);
	}
	
	private void cmdRegister(Scanner s, Calendar c) throws ParseException {
		System.out.println("[새 일정 등록]");
		System.out.println("날짜를 입력해주세요 (yyyy-MM-dd)");
		String date = s.next();
		String text = "";
		s.nextLine(); // ignore one new line
		System.out.println("일정을 입력해주세요 (yyyy-MM-dd)");
		text = s.nextLine();
		
		c.registerPlan(date, text);
		
	}
	public static void main(String[] args) throws ParseException {

		// 셀 실행2
		Prompt p = new Prompt();
		p.runPrompt();
		
		System.out.println();
	 
	}

}
