package young.calendar;


public class Calendar {

	private static final int[] MaxDays = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	private static final int[] LeapMaxDays = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	public static boolean isLeapYear(int year) {

		if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0)
			return true;
		else
			return false;
	}

	public static int getMaxDaysOfMonth(int year, int month) {
		if (isLeapYear(year))
			return LeapMaxDays[month - 1];
		else
			return MaxDays[month - 1];
	}
	
	
	

	public void printCalendar(int year, int month, int weekday) {
		System.out.printf("   <<%4d년%3d월>>\n", year, month);
		System.out.println(" SU MO TU WE TU FR SA");
		System.out.println("----------------------");
		
		for (int i = 0; i < weekday; i++) {
			
			System.out.print("   ");
		}
			
		int maxDay = getMaxDaysOfMonth(year, month);
		int count = 7 - weekday;
		int delim = (count < 7)? count:0;
			
		
		
		for(int i = 1; i <= count; i++) {
			System.out.printf("%3d", i);
			
		}
		System.out.println();

		
		for (int j = count+1; j <= maxDay; j++) {
			System.out.printf("%3d", j);
			if (j % 7 == delim) {
				System.out.println();
			}
		}
		System.out.println();
	}

	}
	
