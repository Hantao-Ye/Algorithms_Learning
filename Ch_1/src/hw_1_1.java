package Ch_1.src;
import java.util.*;

class Solution {
    public void equal(int a, int b, int c) {
        if (a == b && a == c && b == c)
            System.out.println("equal");
        else
            System.out.println("not equal");
    }

    public void range(double x, double y) {
        if (x <= 1.0 && x >= 0.0 && y <= 1.0 && y >= 1.0)
            System.out.println("true");
        else
            System.out.println("false");
    }

    public String bString(int N) {
        StringBuffer buffer = new StringBuffer();
        for (int n = N; n > 0; n /= 2) {
            buffer.append(n % 2);
        }
        return buffer.reverse().toString();
    }

    public void printArray(boolean[][] array, int m, int n) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (array[i][j])
                    System.out.println("*");
                else
                    System.out.println(" ");
            }
        }
    }

    public void printTransArray(int[][] array, int m, int n) {
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m; i++) {
                System.out.println(array[i][j]);
            }
        }
    }

    public int lg(int N) {
        int output = 0;
        while (N > 1) {
            output++;
            N /= 2;
        }
        return output;
    }

    public int[] histogram(int[] a, int M) {
        int[] output = new int[M];
        for (int i = 0; i < a.length; i++) {
            output[a[i]]++;
        }
        return output;
    }

    public void printFibonacci(int num) {
        int[] array = new int[num];
        array[0] = 1;
        array[1] = 1;
        System.out.println(1 + " " + array[0]);
        System.out.println(2 + " " + array[1]);
        for (int i = 2; i < num; i++) {
            array[i] = array[i - 1] + array[i - 2];
            System.out.println((i + 1) + " " + array[i]);
        }
    }

    public int rec_ln(int num) {
        int output = 0;
        if (num == 1)
            return 0;
        while (num > 1) {
            output++;
            num /= Math.E;
        }
        return rec_ln(num - 1) + output;
    }

    public void tabulate(int num) {
        Scanner sc = new Scanner(System.in);
        Map<String, Float> map = new HashMap<>();
        for (int i = 0; i < num; i++) {
            String[] str = sc.nextLine().split(" ");
            float div = Float.parseFloat(str[1]) / Float.parseFloat(str[2]);
            map.put(str[0], div);
        }
        sc.close();
        Iterator<Map.Entry<String, Float>> entries = map.entrySet().iterator();
        while (entries.hasNext()) {
            Map.Entry<String, Float> entry = entries.next();
            System.out.format("%s %.3f\n", entry.getKey(), entry.getValue());
        }
    }

    public int BinarySearch(int key, int[] a) {
        return rank(key, a, 0, a.length - 1);
    }

    public int rank(int key, int[] a, int lo, int hi) {
        System.out.println(lo + " " + hi);
        if (lo > hi)
            return -1;
        int mid = lo + (hi - lo) / 2;
        if (key < a[mid])
            return rank(key, a, lo, mid - 1);
        else if (key > a[mid])
            return rank(key, a, mid + 1, hi);
        else
            return mid;
    }

    public int gcd(int p, int q) {
        System.out.format("p: %d, q: %d\n", p, q);
        if (q == 0)
            return p;
        int r = p % q;
        return gcd(q, r);
    }
    
    public double binomial(int N, int k, double p) {
        double[][] array = new double[N][k + 1];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < k + 1; j++) {
                if (i == 0 || j == 0)
                    array[i][j] = 1.0;
                else
                    array[i][j] = (1.0 - p) * array[i - 1][j] + p * array[i - 1][j - 1];
            }
        }
        return array[N - 1][k];
    }
}