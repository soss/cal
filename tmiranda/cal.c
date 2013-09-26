#include <time.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>


char *monthrel[] = {
	"January",
	"February",
	"March",
	"April",
	"May",
	"June",
	"July",
	"August",
	"September",
	"October",
	"November",
	"December",
};

int monthdays[] = {31, 0, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

/* Given a day, month, and year what is the day of the week? */
int day_of_week(int day, int month, int year)
{
	int a = (14 - month) / 12;
	int y = year - a;
	int m = month + 12 * a - 2;

	return ((day + y + y / 4 - y / 100 + y / 400 + (31 * m) / 12) % 7);
}

/* Is it a leap year? */
int leap_year(int year)
{
	if (year % 4 == 0)
	{
		if (year % 100 == 0)
		{
			if (year % 400 == 0)
				return (1);
			else
				return (0);
		}
		else
			return (1);
	}
	else
		return (0);
}

int main(int argc, char *argv[])
{
	time_t curtime;
	struct tm *curdate;
	int i, j, fday, tdays, month, year;

	month = atoi(argv[1]);
	year = atoi(argv[2]);

	/* Don't want to enter arguments? Well, fuck you too, buddy. */
	if (month == '\0' || year == 0)
	{
		curtime = time(NULL);
		curdate = localtime(&curtime);
		month = curdate->tm_mon + 1;
		year = curdate->tm_year + 1900;
	}

	puts(""); /* Newline */
	printf("%s %d\n", monthrel[month - 1], year);
	puts("Su Mo Tu We Th Fr Sa");
	puts("--------------------");

	/* Deal with the first week */
	fday = day_of_week(1, month, year);
	for (i = 0, j = 1; i < 8; i++)
	{
		if (i > 0 && day_of_week(j, month, year) == 0)
			break;
		if (i < fday)
			printf("   ");
		else
		{
			printf("%2.d ", j);
			j++;
		}
	}
	puts(""); /* Newline */

	/* Is it a leap year? */
	if (month == 2)
		tdays = leap_year(year) ? 29 : 28;
	else
		tdays = monthdays[month - 1];

	/* Deal with the rest of the month */
	for (i = j; i <= tdays; i++)
	{
		printf("%2.d ", i);
		if (day_of_week(i, month, year) == 6)
			puts("");
	}
	puts(""); /* Newline */

	return (0);
}
