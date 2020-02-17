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

    public int[] readInts(String input) {
        String[] arr = input.split("\\s+");
        int[] output = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            output[i] = Integer.parseInt(arr[i]);
        }
        return output;
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

    public SmartDate(int m, int d, int y) {
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

    public SmartDate(String str) {
        String[] array = new String[3];
        if (str.contains("/"))
            array = str.split("/");
        else
            array = str.split("\\s+");
        int y = Integer.parseInt(array[0]);
        int m = Integer.parseInt(array[1]);
        int d = Integer.parseInt(array[2]);
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

    @Override
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

class Transaction {
    private final String who;
    private final SmartDate when;
    private final double amount;

    public Transaction(String who, SmartDate when, double amount) {
        if (Double.isNaN(amount) || Double.isInfinite(amount))
            throw new IllegalArgumentException("The amount can't be none or infinite!");
        this.who = who;
        this.when = when;
        this.amount = amount;
    }

    public Transaction(String input) {
        String[] array = input.split("\\s+");
        if (Double.isNaN(Double.parseDouble(array[2])) || Double.isInfinite(Double.parseDouble(array[2])))
            throw new IllegalArgumentException("The amount can't be none or infinite!");
        this.who = array[0];
        this.when = new SmartDate(array[1]);
        this.amount = Double.parseDouble(array[2]);
    }

    public String who() {
        return this.who;
    }

    public SmartDate when() {
        return this.when;
    }

    public Double amount() {
        return this.amount;
    }

    @Override
    public String toString() {
        return String.format("%-10s %10s %8.2f", this.who, this.when, this.amount);
    }

    public int compareTo(Transaction that) {
        return Double.compare(this.amount, that.amount);
    }

    public boolean equals(Object other) {
        if (other == this)
            return true;
        if (other == null)
            return false;
        if (other.getClass() != this.getClass())
            return false;
        Transaction that = (Transaction) other;
        return (this.amount == that.amount) && (this.who.equals(that.who)) && (this.when.equals(that.when));
    }

    public int hashCode() {
        int hash = 1;
        hash = 31 * hash + who.hashCode();
        hash = 31 * hash + when.hashCode();
        hash = 31 * hash + ((Double) amount).hashCode();
        return hash;
    }
}

class Rational {
    private final int numerator;
    private final int denominator;

    public Rational(int numerator, int denominator) {
        if (denominator == 0)
            throw new IllegalArgumentException("The denominator can't be 0 or infinity!");
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public Rational plus(Rational that) {
        int num_out = this.numerator * that.denominator + that.numerator * this.denominator;
        int den_out = this.denominator * that.denominator;
        return new Rational(num_out, den_out);
    }

    public Rational minus(Rational that) {
        int num_out = this.numerator * that.denominator - that.numerator * this.denominator;
        int den_out = this.denominator * that.denominator;
        return new Rational(num_out, den_out);
    }

    public Rational times(Rational that) {
        int num_out = this.numerator * that.numerator;
        int den_out = this.denominator * that.denominator;
        return new Rational(num_out, den_out);
    }
    
    public Rational divides(Rational that) {
        int num_out = this.numerator * that.denominator;
        int den_out = this.denominator * that.numerator;
        return new Rational(num_out, den_out);
    }

    public boolean equals(Rational that) {
        if (divides(that).denominator == divides(that).numerator)
            return true;
        else
            return false;
    }
    
    @Override
    public String toString() {
        return String.format("%d / %d", this.numerator, this.denominator);
    }
}