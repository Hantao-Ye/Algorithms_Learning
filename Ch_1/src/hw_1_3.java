package Ch_1.src;

import java.util.*;

class FixedCapacityStackOfStrings {
    private String[] a; // stack entries
    private int N;

    // size
    public FixedCapacityStackOfStrings(int cap) {
        a = new String[cap];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void push(String item) {
        a[N++] = item;
    }

    public String pop() {
        return a[--N];
    }

    public boolean isFull() {
        return N == a.length;
    }
}

class Parentheses {
    public static boolean isBalanced(String s) {
        Stack<Character> iStack = new Stack<>();
        int sign = 1;
        char[] array = s.toCharArray();
        for (int i = 0; i < array.length; i++) {
            if (array[i] == '{' || array[i] == '[' || array[i] == '(') {
                iStack.push(array[i]);
            } else if (array[i] == '}' || array[i] == ']' || array[i] == ')') {
                char pop = iStack.pop();
                if (pop == '(' && array[i] != ')') {
                    sign--;
                    break;
                } else if (pop == '[' && array[i] != ']') {
                    sign--;
                    break;
                } else if (pop == '[' && array[i] != ']') {
                    sign--;
                    break;
                }
            }
        }
        if (sign == 1)
            return true;
        else
            return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.nextLine();
            if (isBalanced(str))
                System.out.println("True");
            else
                System.out.println("False");

        }
        sc.close();
    }
}