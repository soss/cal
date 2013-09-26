/**
   I pledge my honor that I have abided by the Stevens Honor System.
   Jason Gardella - Jeremy Bassi
   Created: Sep 18, 2013
 */
package cal;

import java.util.Calendar;
import java.util.HashMap;

public class Cal
{
	
	private static int[][] days = new int[6][7];
	private static int[] maxDays = { 31, 28, 31, 30, 31, 30, 31, 30, 31, 31, 30, 31 };
	private static int month = 8, year = 2013;
	
	private static HashMap<Integer, String> hashish = new HashMap<>();
	
	private static void packTheHashish()
	{
		hashish.put(0, "January");
		hashish.put(1, "February");
		hashish.put(2, "March");
		hashish.put(3, "April");
		hashish.put(4, "May");
		hashish.put(5, "June");
		hashish.put(6, "July");
		hashish.put(7, "August");
		hashish.put(8, "September");
		hashish.put(9, "Octobor");
		hashish.put(10, "November");
		hashish.put(11, "December");
	}
	
	private static void fill(int month)
	{
		int numDay = 1;
		Calendar cal = Calendar.getInstance();
		cal.clear();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		int startIndex = cal.get(Calendar.DAY_OF_WEEK) % 7;
		System.out.println("Start Index: "+startIndex);
		for(int i = 0; i < days.length; i++)
		{
			for(int j = 0; j < days[i].length && numDay <= maxDays[month]; j++)
			{
				if(i == 0 && j < startIndex)
					days[i][j] = 0;
				else
				{
					days[i][j] = numDay;
					numDay++;
				}	
			}
		}
	}
	
	
	private static void printMonth()
	{
		System.out.println(hashish.get(month) + " " + year);
		System.out.printf(" %2.2s %2.2s %2.2s %2.2s %2.2s %2.2s %2.2s", "Su", "Mo", "Tu", "We", "Th", "Fr", "Sa");
		System.out.println();
		for(int i = 0; i < days.length; i++)
		{
			for(int j = 0; j < days[i].length; j++)
			{
				if(days[i][j] != 0)
					System.out.printf("%3d", days[i][j]);
				else
					System.out.print("   ");
			}
			System.out.println();
		}
	}

	
	public static void main(String[] args)
	{
		packTheHashish();
		fill(0);
		printMonth();
	}
	

}
