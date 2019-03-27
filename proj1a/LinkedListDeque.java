public class LinkedListDeque <T> {
    private  class IntNode{
        public IntNode prev;
        public T item;
        public IntNode next;

        public IntNode (IntNode p, T i, IntNode n) {
            prev = p;
            item = i;
            next = n;
        }
    }
    private IntNode sentinel;
    private int size;

    public LinkedListDeque(){
        sentinel = new IntNode(null,null,null);
        size = 0;
    }
    public LinkedListDeque(T i){
        sentinel = new IntNode(null,null,null);
        IntNode a = new IntNode(sentinel, i, sentinel);
        sentinel.prev = a;
        sentinel.next = a;
    }

    public void addFirst(T i) {
        size += 1;
        if (sentinel.next == null){
            IntNode a = new IntNode(sentinel, i, sentinel);
            sentinel.prev = a;
            sentinel.next = a;
        }
        IntNode curFirst = sentinel.next;
        IntNode b = new IntNode(sentinel, i, curFirst);
        sentinel.next = b;
        curFirst.prev = b;
    }

}
