public class LinkedListDeque<T> {
    private class IntNode {
        IntNode prev;
        T item;
        IntNode next;

        IntNode(IntNode p, T i, IntNode n) {
            prev = p;
            item = i;
            next = n;
        }
    }
    private IntNode sentinel;

    public LinkedListDeque() {
        sentinel = new IntNode(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;

    }
/*    public LinkedListDeque(T i) {
        sentinel = new IntNode(null, null, null);
        IntNode a = new IntNode(sentinel, i, sentinel);
        sentinel.prev = a;
        sentinel.next = a;
    }*/
    public LinkedListDeque(LinkedListDeque other) {
        this();
        if (other.sentinel.next != other.sentinel) {

            IntNode curp2 = other.sentinel;

            while (curp2.next != other.sentinel) {
                curp2 = curp2.next;
                T a = curp2.item;
                this.addLast(a);
            }
        }
    }

    public void addFirst(T i) {

        if (isEmpty()) {
            IntNode a = new IntNode(sentinel, i, sentinel);
            sentinel.prev = a;
            sentinel.next = a;
            return;
        }
        IntNode curFirst = sentinel.next;
        IntNode b = new IntNode(sentinel, i, curFirst);
        sentinel.next = b;
        curFirst.prev = b;
        return;
    }
    public void addLast(T i) {
        if (isEmpty()) {
            IntNode a = new IntNode(sentinel, i, sentinel);
            sentinel.prev = a;
            sentinel.next = a;
            return;
        }
        IntNode curLast = sentinel.prev;
        IntNode b = new IntNode(curLast, i, sentinel);
        sentinel.prev = b;
        curLast.next = b;
        return;
    }
    public boolean isEmpty() {
        if (sentinel.next == sentinel) {
            return true;
        }
        return false;
    }
    public int size() {
        if (sentinel.next == sentinel) {
            return 0;
        }
        IntNode curP = sentinel;
        int i = 0;
        while (curP.next != sentinel) {
            curP = curP.next;
            i += 1;
        }
        return i;
    }
    public void printDeque() {
        if (sentinel.next == sentinel) {
            System.out.println();
        }
        IntNode curP = sentinel;
        while (curP.next != sentinel) {
            System.out.print(curP.next.item.toString() + " ");
            curP = curP.next;
        }
        System.out.println();
    }
    public T removeFirst() {
        if (sentinel.next == sentinel) {
            return null;
        }
        IntNode curFirst = sentinel.next;
        T a = curFirst.item;
        sentinel.next = curFirst.next;
        curFirst.next.prev = sentinel;
        return a;
    }
    public T removeLast() {
        if (sentinel.next == sentinel) {
            return null;
        }
        IntNode curLast = sentinel.prev;
        T a = curLast.item;
        sentinel.prev = curLast.prev;
        curLast.prev.next = sentinel;
        return a;

    }
    public T get(int index) {
        if ((index < 0) || (index >= this.size())) {
            return null;
        }
        IntNode curP = sentinel.next;
        int i = 0;
        while (i != index) {
            curP = curP.next;
            i++;
        }
        return curP.item;
    }
    private T getRecursivehelp(IntNode p, int index) {
        if (index == 0) {
            return p.item;
        }
        return getRecursivehelp(p.next, index - 1);
    }
    public T getRecursive(int index) {
        if ((index < 0) || (index >= this.size())) {
            return null;
        }
        return getRecursivehelp(sentinel.next, index);
    }

}


