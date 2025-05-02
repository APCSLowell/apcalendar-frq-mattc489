public class APCalendar
{
  private static boolean isLeapYear(int year)
  {
    return year % 4 == 0 && (year % 100 != 0 || year % 400 == 0);
  }

  public static int numberOfLeapYears(int year1, int year2)
  {
    int count = 0;
    for (int y = year1; y <= year2; y++) {
      if (isLeapYear(y)) {
        count++;
      }
    }
    return count;
  }

  private static int firstDayOfYear(int year)
  {
    // January 1, 1980 was a Tuesday (day 2)
    return (2 + 365 * (year - 1980) + numberOfLeapYears(1980, year - 1)) % 7;
  }

  private static int dayOfYear(int month, int day, int year)
  {
    final int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    int n = day;
    for (int m = 1; m < month; m++) {
      n += daysInMonth[m - 1];
    }
    if (month > 2 && isLeapYear(year)) {
      n++;
    }
    return n;
  }
  public static int dayOfWeek(int month, int day, int year)
  {
    int startDay = firstDayOfYear(year); 
    int nthDay = dayOfYear(month, day, year);
    return (startDay + nthDay - 1) % 7;
  }
}
