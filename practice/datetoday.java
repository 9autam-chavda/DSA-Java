package practice;

import java.util.Calendar;

public class datetoday {
    public static String findDay(int month, int day, int year) {
            final String[] days = {"SUNDAY", "MONDAY", "TUESDAY", "WEDNESDAY","THURSDAY", "FRIDAY", "SATURDAY"};
             Calendar cal = Calendar.getInstance();
            cal.set(year, month - 1, day);
            return days[cal.get(Calendar.DAY_OF_WEEK)-1];
    }
    public static void main(String[] args) {
        String day = findDay(05, 14, 2006);
        System.out.println(day);

    }
}
