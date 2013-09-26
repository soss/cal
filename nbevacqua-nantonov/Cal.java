import java.util.Arrays;
import java.util.Calendar;

public class Cal {

	private static int getNumDaysInMonth(int month, int year) {
		int days;
		boolean isLeapYear = (year % 4 == 0 && year % 100 != 0)
				|| (year % 400 == 0);
		switch (month) {
		case 1:
			days = 31;
			break;
		case 2:
			if (isLeapYear)
				days = 29;
			else
				days = 28;
			break;
		case 3:
			days = 31;
			break;
		case 4:
			days = 30;
			break;
		case 5:
			days = 31;
			break;
		case 6:
			days = 30;
			break;
		case 7:
			days = 31;
			break;
		case 8:
			days = 31;
			break;
		case 9:
			days = 30;
			break;
		case 10:
			days = 31;
			break;
		case 11:
			days = 30;
			break;
		case 12:
			days = 31;
			break;
		default:
			return 31;
		}

		return days;
	}

	private static String bufferSpace(String s, int i) {
		if (i <= 0)
			return s;
		if(i%2 == 0) {
			for(int j = 0; j < i/2; j++)
			{
				s = (" " + s + " ");
			}
		} else {
			for(int j = 0; j < i/2; j++)
			{
				s = (" " + s + " ");
			}
			s = " "+s;
		}
		
		return s;
	}
	
	
	public static void main(String[] args) {
		String[] months = new String[] {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
		String dayOfWeekStr = "Su Mo Tu We Th Fr Sa";
		Calendar cal = Calendar.getInstance();
		
		if(args.length == 2) {
			int monthInt = Integer.parseInt(args[0])-1;
			int yearInt = Integer.parseInt(args[1]);
			cal.set(Calendar.MONTH, monthInt);
			cal.set(Calendar.YEAR, yearInt);
		}
		cal.set(Calendar.DAY_OF_MONTH, 1);
		
		String titleString = months[cal.get(Calendar.MONTH)]+" "+cal.get(Calendar.YEAR);
		titleString = bufferSpace(titleString, dayOfWeekStr.length()-titleString.length());
		System.out.println(titleString);
		System.out.println(dayOfWeekStr);
		
		
		String[] data = new String[7];
		Arrays.fill(data, "");
		String printfString = "%2s %2s %2s %2s %2s %2s %2s";
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK)-1;
		
		for(int i = 0; i < getNumDaysInMonth(cal.get(Calendar.MONTH)+1, cal.get(Calendar.YEAR)); i++) {
			data[dayOfWeek++] = ""+(i+1);
			if(dayOfWeek == 7) {
				dayOfWeek = 0;
				System.out.println(String.format(printfString, data[0], data[1], data[2], data[3], data[4], data[5], data[6]));
				Arrays.fill(data, "");
			}
			
			if(i == getNumDaysInMonth(cal.get(Calendar.MONTH)+1, cal.get(Calendar.YEAR))-1) {
				System.out.println(String.format(printfString, data[0], data[1], data[2], data[3], data[4], data[5], data[6]));
			}
		}
	}

}
