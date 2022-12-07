//This is my first project (CALENDAR)
public class Cal {

    static String[] weekdays = {"mon", "tue", "wed", "thu", "fri", "sat", "sun"};
    String[] monthsname = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};


    public static void main(String[] args) {

        int noofdays = Daysinmonth(12, 2022);
        int weekdays = weekDayno(1, 12, 2022);
        printCalender(noofdays, weekdays);


    }

    public static void printCalender(int nodays, int startweekday) {
        for (String day : weekdays) {
            System.out.printf("%6s", day);
        }
        System.out.println();

        for (int i = 0; i < startweekday; i++) {
            System.out.printf("%6s", "");


        }
        for (int i = 1; i < nodays + 1; i++) {
            System.out.printf("%6s", i);
            if ((i + startweekday) % 7 == 0) {
                System.out.println();
            }

        }

    }

    public static boolean isleapyear(int year) {
        if (year % 4 == 0 && year % 100 != 0) {
            return true;
        } else if (year % 400 == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static int Daysinmonth(int month, int year) {
        if (month == 4 || month == 6 || month == 9 || month == 11) {
            return 30;
        }
        if (month == 2) {

            if (isleapyear(year)) {
                return 29;
            }
            return 28;
        } else {
            return 31;
        }

    }

    public static int compare(int d1, int m1, int y1, int d2, int m2, int y2) {
        if (y1 > y2) {
            return 1;
        }
        if (y2 > y1) {
            return -1;
        }
        if (m1 > m2) {
            return 1;
        }
        if (m2 > m1) {
            return -1;
        }
        if (d1 > d2) {
            return 1;
        }
        if (d1 < d2) {
            return -1;
        }
        return 0;

    }

    public static int datedif(int d1, int m1, int y1, int d2, int m2, int y2) {

        int sign = compare(d1, m1, y1, d2, m2, y2);
        int temp;
        if (sign == 0) {
            return 0;
        }

        if (sign == -1) {
            temp = d1;
            d1 = d2;
            d2 = temp;
            temp = m1;
            m1 = m2;
            m2 = temp;
            temp = y1;
            y1 = y2;
            y2 = temp;
        }

        d1 = d1 - 1;
        d2 = d2 - 1;
        int d3 = 0;
        for (int i = 1; i <= m1 - 1; i++) {
            d3 = d3 + Daysinmonth(i, y1);
        }
        int d4 = 0;
        for (int i = 1; i <= m2 - 1; i++) {
            d4 = d4 + Daysinmonth(i, y2);

        }
        int d5 = 0;
        for (int i = y2; i <= y1 - 1; i++) {
            if (isleapyear(i)) {
                d5 = d5 + 366;
            } else {
                d5 = d5 + 365;
            }

        }
        return sign * (d3 + d1 + d5 - d4 - d2);
    }

    public static int weekDayno(int d, int m, int y) {
        int diff = datedif(d, m, y, 5, 12, 2022);
        diff = diff % 7;
        diff = 7 + diff;
        diff = diff % 7;
        return diff;

    }

   /* public static String weekname(int d, int m, int y) {
        int day;
        day = weekDayno(d, m, y);
        return weekdays[day];
    }*/


}
