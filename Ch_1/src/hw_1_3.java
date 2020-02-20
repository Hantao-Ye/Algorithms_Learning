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

class Stack<Item> implements Iterable<Item> {
    private Node<Item> first; // top of stack
    private int n; // size of the stack

    private static class Node<Item> {
        private Item item;
        private Node<Item> next;
    }

    public Stack() {
        first = null;
        n = 0;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return n;
    }

    public void push(Item item) {
        Node<Item> oldfirst = first;
        first = new Node<Item>();
        first.item = item;
        first.next = oldfirst;
        n++;
    }

    public Item pop() {
        if (isEmpty())
            throw new NoSuchElementException("Stack underflow");
        Item item = first.item; // save item to return
        first = first.next; // delete first node
        n--;
        return item; // return the saved item
    }

    public Item peek() {
        if (isEmpty())
            throw new NoSuchElementException("Stack underflow");
        return first.item;
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Item item : this) {
            s.append(item);
            s.append(' ');
        }
        return s.toString();
    }

    public Iterator<Item> iterator() {
        return new LinkedIterator(first);
    }

    private class LinkedIterator implements Iterator<Item> {
        private Node<Item> current;

        public LinkedIterator(Node<Item> first) {
            current = first;
        }

        public boolean hasNext() {
            return current != null;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Item next() {
            if (!hasNext())
                throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
}