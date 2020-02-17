package Ch_1.src;
class Solution {
    public boolean rotation(String s, String t) {
        if (s.length() != t.length())
            return false;
        else if ((t + t).indexOf(s) != -1)
            return true;
        else
            return false;
    }
}

class VirtualCounter {
    public int N;
    public int max;
    private int count;
    private int sum;

    public VirtualCounter(int N, int max) {
        this.N = N;
        this.max = max;
        count = 0;
        sum = 0;
    }

    public void add() {
        if (count >= N || Math.abs(sum) >= max)
            System.out.println("You've counted too much!");
        else {
            count++;
            sum++;
        }
    }

    public void sub() {
        if (count >= N || Math.abs(sum) >= max)
            System.out.println("You've counted too much!");
        else {
            count++;
            sum--;
        }
    }
}

class SmartDate {
    private final int month;
    private final int day;
    private final int year;

    public SmartDate(int m, int d, int y) throws Exception {
        if (y < 0)
            throw new IllegalArgumentException("The year is illegal!");
        if (m > 12 || m < 1)
            throw new IllegalArgumentException("The month is illegal!");
        if (d > 32)
            throw new IllegalArgumentException("The day is illegal!");
        if (d == 31 && m != 1 && m != 3 && m != 5 && m != 7 && m != 8 && m != 10 && m != 12)
            throw new IllegalArgumentException("The day is illegal!");
        if (m == 2) {
            if (y % 400 == 0 || (y % 4 == 0 && y % 100 != 0))
                if (d > 29)
                    throw new IllegalArgumentException("The day is illegal!");
                else if (d > 28)
                    throw new IllegalArgumentException("The day is illegal!");
        }
        month = m;
        day = d;
        year = y;
    }

    public int month() {
        return month;
    }

    public int day() {
        return day;
    }

    public int year() {
        return year;
    }

    public String toString() {
        return month() + "/" + day() + "/" + year();
    }

    public boolean equals(Object x) {
        if (this == x)
            return true;
        if (x == null)
            return false;
        if (this.getClass() != x.getClass())
            return false;
        SmartDate that = (SmartDate) x;
        if (this.day != that.day)
            return false;
        if (this.month != that.month)
            return false;
        if (this.year != that.year)
            return false;
        return true;
    }

    public String dayOfTheWeek() {
        String day = "";
        int y = this.year;
        int m = this.month;
        int d = this.day;
        if (m == 1 || m == 2) {
            m += 12;
            y--;
        }
        int w = (d + 2 * m + 3 * (m + 1) / 5 + y + y / 4 - y / 100 + y / 400) % 7;
        switch (w) {
        case 0:
            day = "Monday";
            break;
        case 1:
            day = "Tuesday";
            break;
        case 2:
            day = "Wednesday";
            break;
        case 3:
            day = "Thursday";
            break;
        case 4:
            day = "Friday";
            break;
        case 5:
            day = "Saturday";
            break;
        case 6:
            day = "Sunday";
            break;
        }
        return day;
    }
}
