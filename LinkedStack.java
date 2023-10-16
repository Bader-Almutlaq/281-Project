public class LinkedStack<T> {
    private Node<T> top;

    public LinkedStack() {
        top = null;
    }

    public boolean empty() {
        return top == null;
    }

    public boolean full() {
        return false;
    }

    public void push(T e) {
        Node<T> tmp = new Node<T>(e);
        tmp.next = top;
        top = tmp;
    }

    public T pop() {
        T e = top.data;
        top = top.next;
        return e;
    }

    public void printStack() {
        LinkedStack<T> temp = new LinkedStack<T>();

        while (!this.empty()) {
            T x = this.pop();
            System.out.println(x);
            temp.push(x);
        }

        while (!temp.empty()) {
            this.push(temp.pop());
        }
    }
}