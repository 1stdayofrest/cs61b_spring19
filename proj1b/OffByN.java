public class OffByN implements CharacterComparator {
    private int N;
    @Override
    public boolean equalChars(char x, char y) {
        return ((x - N) == y) || ((y - N) == x);
    }

    public OffByN(int N) {
        this.N = N;
    }

}
