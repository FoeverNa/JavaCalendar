package young.calendar;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class Calendar {

	private static final int[] MaxDays = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	private static final int[] LeapMaxDays = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	private HashMap<Date, String> planMap;
	
	public Calendar() {
		planMap = new HashMap<Date, String>();
	
	}
	 
	public void registerPlan(String strDate, String plan) throws ParseException {
		
		Date date = new SimpleDateFormat("yyyy-MM-dd").parse(strDate);
		//System.out.println(date);
		planMap.put(date, plan);
		
	}
	
	public String serchPlan(String strDate) throws ParseException {
		
		Date date = new SimpleDateFormat("yyyy-MM-dd").parse(strDate);
		String plan = planMap.get(date);
		return plan;
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
	
			
		public static int getWeekDay(int year, int month, int day) {
		
		int syear = 1970; // 목요일
		final int STANDARD_WEEKDAY = 4; //1970/Jan/1st = Thursday
		
		int count = 0;
		
		for (int i = syear; i < year; i++ ) {
			
			int delta = isLeapYear(i) ? 366:365;
			count += delta;			
		}
			
		for (int i = 1; i <month; i ++) {
			
			int delta = getMaxDaysOfMonth(year, i);
			count += delta;
		}
		
		count += day -1;
		
		//System.out.println(count);
		
		int weekday = (count + STANDARD_WEEKDAY) % 7;
		
		return weekday;
	}
		 
	
	//simple test code
	public static void main(String[] args) throws ParseException {
		
		Calendar cal = new Calendar();
		
	cal.registerPlan("2020-07-08", "Let's hava dinner!");
	System.out.println(cal.serchPlan("2020-07-08"));
		
		
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

	
