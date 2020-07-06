package young.calendar;

import java.util.Scanner;

public class Days {

	public static void main(String[] args) {
		
		//숫자를 입력받아 입력받은 달의 최대 일수를 구하는 프로그램
		
		Scanner sc = new Scanner(System.in);
		System.out.println("궁금하신 월을 입력하세요");
		int input = sc.nextInt();
				
		int days = 31;
		
		
		switch (input) {
			case 1: case 3:case 5:case 7:case 8:case 10:case 12:
				days += 0;
				break;
			case 2: 
				days -= 3;
				break;
			case 4: case 6: case 9: case 11: 
				days -= 1;
				break;
			default : 
				System.out.println("1~12의 숫자를 입력하세요");
		}
		
		
		if ( input > 0 && input < 13) {
		System.out.printf("%d월은 %d까지 입니다.",input,days);
		}
	}

}
