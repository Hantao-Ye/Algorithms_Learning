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
        if (array.length % 2 != 0)
            return false;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == '{' || array[i] == '[' || array[i] == '(') {
                iStack.push(array[i]);
            } else if (array[i] == '}' || array[i] == ']' || array[i] == ')') {
                if (iStack.isEmpty())
                    return false;
                char pop = iStack.pop();
                if (array[i] == ')') {
                    if (pop != '(') {
                        sign--;
                        break;
                    }
                } else if (array[i] == ']') {
                    if (pop != '[') {
                        sign--;
                        break;
                    } else {
                        if (!iStack.isEmpty())
                            if (iStack.peek() == '(') {
                                sign--;
                                break;
                            }
                    }
                } else {
                    if (pop != '{') {
                        sign--;
                        break;
                    } else {
                        if (!iStack.isEmpty())
                            if (iStack.peek() == '(' || iStack.peek() == '[') {
                                sign--;
                                break;
                            }
                    }
                }

            }
        }
        if (!iStack.isEmpty() || sign != 1)
            return false;
        else
            return true;
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

class ResizingArrayStack<Item> implements Iterable<Item> {
    private Item[] a = (Item[]) new Object[1]; // stack items
    private int N = 0;

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    private void resize(int max) { // Move stack to a new array of size max.
        Item[] temp = (Item[]) new Object[max];
        for (int i = 0; i < N; i++)
            temp[i] = a[i];
        a = temp;
    }

    public void push(Item item) { // Add item to top of stack.
        if (N == a.length)
            resize(2 * a.length);
        a[N++] = item;
    }

    public Item pop() { // Remove item from top of stack.
        Item item = a[--N];
        a[N] = null; // Avoid loitering (see text).
        if (N > 0 && N == a.length / 4)
            resize(a.length / 2);
        return item;
    }

    public Item peek() {
        return a[N];
    }

    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<Item> { // Support LIFO iteration.
        private int i = N;

        public boolean hasNext() {
            return i > 0;
        }

        public Item next() {
            return a[--i];
        }

        public void remove() {
        }
    }
}

class Solution {
    public static String outFullString(String input) {
        StringBuffer sBuffer = new StringBuffer();
        char[] array = input.toCharArray();
        for (int i = 0; i < array.length; i++) {

        }
        return sBuffer.toString();
    }
}