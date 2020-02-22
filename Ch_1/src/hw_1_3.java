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

class my_Stack<Item> implements Iterable<Item> {
    Node<Item> first; // top of stack
    int n; // size of the stack

    private static class Node<Item> {
        private Item item;
        private Node<Item> next;
    }

    public my_Stack() {
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

class InfixToPostfix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            change(sc.nextLine());
        }
        sc.close();
    }

    public static void change(String input) {
        Stack<Character> iStack = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '+' || input.charAt(i) == '*')
                iStack.push(input.charAt(i));
            else if (input.charAt(i) == ')')
                System.out.print(iStack.pop() + " ");
            else if (input.charAt(i) == '(')
                System.out.print("");
            else
                System.out.print(input.charAt(i));
        }
    }
}

class EvaluatePostfix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            System.out.println(evaluate(sc.nextLine()));
        }
        sc.close();
    }

    public static int evaluate(String input) {
        Stack<Integer> iStack = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) >= '0' && input.charAt(i) <= '9')
                iStack.push(Integer.valueOf(input.charAt(i)));
            else if (input.charAt(i) == '+')
                iStack.push(iStack.pop() + iStack.pop());
            else if (input.charAt(i) == '*')
                iStack.push(iStack.pop() * iStack.pop());
        }
        return iStack.pop();
    }
}

class ResizingArrayQueueOfStrings implements Iterable<String> {
    private String[] queue;
    private int num;

    public ResizingArrayQueueOfStrings(int num) {
        this.queue = new String[num];
        this.num = 0;
    }

    public boolean isFull() {
        return queue.length <= num;
    }

    public boolean isEmpty() {
        return queue.length == 0;
    }

    private void resize(int max) {
        String[] temp = new String[max];
        for (int i = 0; i < num; i++)
            temp[i] = queue[i];
        queue = temp;
    }

    public int size() {
        return queue.length;
    }

    public void enqueue(String str) {
        if (isFull()) {
            resize(2 * num);
            queue[++num] = str;
        } else
            queue[++num] = str;
    }

    public String dequeue() {
        if (isEmpty())
            throw new EmptyStackException();
        else {
            String item = queue[num--];
            queue[num] = null;
            if (num > 0 && num == queue.length / 4)
                resize(queue.length / 2);
            return item;
        }
    }

    public Iterator<String> iterator() {
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<String> { // Support LIFO iteration.
        private int i = num;

        public boolean hasNext() {
            return i > 0;
        }

        public String next() {
            return queue[++i];
        }

        public void remove() {

        }
    }
}

class Josephus {
    public static void main(String[] args) {
        int n = Integer.valueOf(args[0]);
        int m = Integer.valueOf(args[1]);
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++)
            queue.add(i);
        while (queue.size() > 0) {
            for (int i = 0; i < m - 1; i++)
                queue.add(queue.remove());
            System.out.print(queue.remove() + " ");
        }
    }
}

class CheckStack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String[] array = sc.nextLine().split(" ");
            int check = 0;
            for (int i = 0; i < array.length; i++) {
                if(array[i]=="-")
                    check--;
                else {
                    check++;
                }
                if (check < 0) {
                    System.out.println("Stack underflow");
                }
            }
        }
        sc.close();
    }
}