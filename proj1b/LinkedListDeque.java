public class LinkedListDeque<Item> implements Deque<Item> {
    private class IntNode {
        IntNode prev;
        Item item;
        IntNode next;

        IntNode(IntNode p, Item i, IntNode n) {
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

    public LinkedListDeque(LinkedListDeque other) {
        this();
        if (other.sentinel.next != other.sentinel) {

            IntNode curp2 = other.sentinel;

            while (curp2.next != other.sentinel) {
                curp2 = curp2.next;
                Item a = curp2.item;
                this.addLast(a);
            }
        }
    }


    @Override
    public void addFirst(Item item) {
        if (isEmpty()) {
            IntNode a = new IntNode(sentinel, item, sentinel);
            sentinel.prev = a;
            sentinel.next = a;
            return;
        }
        IntNode curFirst = sentinel.next;
        IntNode b = new IntNode(sentinel, item, curFirst);
        sentinel.next = b;
        curFirst.prev = b;
        return;
    }

    @Override
    public void addLast(Item item) {
        if (isEmpty()) {
            IntNode a = new IntNode(sentinel, item, sentinel);
            sentinel.prev = a;
            sentinel.next = a;
            return;
        }
        IntNode curLast = sentinel.prev;
        IntNode b = new IntNode(curLast, item, sentinel);
        sentinel.prev = b;
        curLast.next = b;
        return;
    }

    @Override
    public boolean isEmpty() {
        if (sentinel.next == sentinel) {
            return true;
        }
        return false;
    }

    @Override
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

    @Override
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

    @Override
    public Item removeFirst() {
        if (sentinel.next == sentinel) {
            return null;
        }
        IntNode curFirst = sentinel.next;
        Item a = curFirst.item;
        sentinel.next = curFirst.next;
        curFirst.next.prev = sentinel;
        return a;
    }

    @Override
    public Item removeLast() {
        if (sentinel.next == sentinel) {
            return null;
        }
        IntNode curLast = sentinel.prev;
        Item a = curLast.item;
        sentinel.prev = curLast.prev;
        curLast.prev.next = sentinel;
        return a;
    }

    @Override
    public Item get(int index) {
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
    private Item getRecursivehelp(IntNode p, int index) {
        if (index == 0) {
            return p.item;
        }
        return getRecursivehelp(p.next, index - 1);
    }
    public Item getRecursive(int index) {
        if ((index < 0) || (index >= this.size())) {
            return null;
        }
        return getRecursivehelp(sentinel.next, index);
    }

}

