public class ArrayDeque<T> {
    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;
    private static int FACTOR = 4;
    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
        nextFirst = 7;
        nextLast = 0;
    }

    public ArrayDeque(ArrayDeque other) {
        T[] a = (T[]) new Object[other.items.length];
        System.arraycopy(other.items, 0, a, 0, other.items.length);
        items = a;
        this.size = other.size;
        this.nextFirst = other.nextFirst;
        this.nextLast = other.nextLast;

    }
    public void addFirst(T item) {
        if (size == items.length) {
            resize(size * FACTOR);
        }

        items[nextFirst] = item;
        nextFirst = nextFirst - 1;
        if (nextFirst < 0) {
            nextFirst = nextFirst + items.length;
        }
        size += 1;

    }
    public void addLast(T item) {
        if (size == items.length) {
            resize(size * FACTOR);
        }

        items[nextLast] = item;
        nextLast = nextLast + 1;
        if (nextLast >= items.length) {
            nextLast = nextLast - items.length;
        }
        size += 1;

    }
    public boolean isEmpty() {
        if (this.size == 0) {
            return true;
        }
        return false;
    }
    public int size() {
        return size;
    }
    public void printDeque() {
        if (size == 0) {
            System.out.println(" ");
            return;
        }
        int curPoint = nextFirst + 1;
        if (curPoint >= items.length) {
            curPoint = curPoint - items.length;
        }


        while (curPoint != nextLast) {
            System.out.printf(items[curPoint].toString() + " ");
        }
        System.out.println();
    }
    public T removeFirst() {
        if (size == 0) {
            System.out.println(" ");
            return null;
        }
        int curPoint = nextFirst + 1;
        if (curPoint >= items.length) {
            curPoint = curPoint - items.length;
        }
        T a = items[curPoint];
        items[curPoint] = null;
        nextFirst = curPoint;
        size -= 1;

        return a;

    }
    public T removeLast() {
        if (size == 0) {
            System.out.println(" ");
            return null;
        }
        int curPoint = nextLast - 1;
        if (curPoint < 0) {
            curPoint = nextLast + items.length;
        }
        T a = items[curPoint];
        items[curPoint] = null;
        nextLast = curPoint;

        return a;
    }
    public T get(int index) {
        if ((index < 0) || (index > (size - 1))) {
            return null;
        }
        int curPoint = nextFirst + index + 1;
        if (curPoint >= items.length) {
            curPoint -= items.length;
        }


        return items[curPoint];

    }
    private void resize(int newsize) {
        T[] a = (T[]) new Object[newsize];
        int curp = 0;
        int oldSize = this.size;
        while (curp < this.size) {

            a[curp] = this.get(curp);
            curp += 1;

        }
        items = a;
        nextFirst = newsize - 1;
        nextLast = oldSize;
        size = oldSize;

    }

    public static void main(String[] args) {
        ArrayDeque<Integer> AD1 = new ArrayDeque<>();
        /*int i = 0;
        while (i < 15){
            AD1.addLast(i);
            i++;
        }*/
        AD1.addLast(1);
        Integer a = AD1.removeFirst();

        System.out.println(AD1.isEmpty());
    }


}
