package young.calendar;

import java.util.Scanner;

public class Sum {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("숫자를 2번 입력하시오");
		int input1 = scanner.nextInt();
		int input2 = scanner.nextInt();
		int sum = input1 + input2;
		System.out.printf("두수의 합은 %d 입니다",sum);
		
		scanner.close();

	}

}
