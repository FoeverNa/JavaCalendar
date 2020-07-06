package young.calendar;

import java.util.Scanner;

public class DaysA {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("궁금하신 월을 입력하세요");
		int input = sc.nextInt();
		
		int[] Maxdays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		
		if (input >0 && input <13) {
		
		System.out.printf("%d월은 %d까지 입니다.",input,Maxdays[input-1]);

		} else {System.out.println("1~12까지의 숫자를 입력하시오");
		}
		
	}
	}

