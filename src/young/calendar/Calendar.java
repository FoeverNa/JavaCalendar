package young.calendar;


public class Calendar {

	private static final int[] MaxDays = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	private static final int[] LeapMaxDays = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	public static int getWeekDay(int year, int month, int day) {
		
		int syear = 1970; // 목요일
		final int STANDARD_WEEKDAY = 3; //1970/Jan/1st = Thursday
		
		int count = 0;
		
		for (int i = syear ; i < year; i++) {
			int delta = isLeapYear(i) ? 366 : 365;
			count += delta; 
		}
//		System.out.println(count);
		for (int i = 1; i < month; i++) {
			int delta = getMaxDaysOfMonth(year,i);
			count += delta;
		}
		count += day;
		//System.out.println(count);
		
		int weekday = (count + STANDARD_WEEKDAY) % 7;
		return weekday;
	}
		 
	//simple test code
	public static void main(String[] args) {
		
		Calendar cal = new Calendar();
		
		System.out.println(cal.getWeekDay(1970, 1, 1) == 3);
		System.out.println(cal.getWeekDay(1971, 1, 1) == 4);
		System.out.println(cal.getWeekDay(1972, 1, 1) == 5);
		System.out.println(cal.getWeekDay(1973, 1, 1) == 0);
		System.out.println(cal.getWeekDay(1974, 1, 1) == 1);
		
		
		
		
	}
	
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
	
	
	

	public void printCalendar(int year, int month) {
		System.out.printf("   <<%d년 %d월>>\n", year, month);
		System.out.println(" SU MO TU WE TU FR SA");
		System.out.println("----------------------");
		
		
		int weekday = getWeekDay(year, month, 1);
		
		
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

	
