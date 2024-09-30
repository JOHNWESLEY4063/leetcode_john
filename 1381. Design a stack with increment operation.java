class CustomStack {
    private int[] stack;
    private int maxSize;
    private int currentSize;

    public CustomStack(int maxSize) {
        this.maxSize = maxSize;
        this.stack = new int[maxSize];
        this.currentSize = 0;
    }

    public void push(int x) {
        if (currentSize < maxSize) {
            stack[currentSize] = x;
            currentSize++;
        }
    }

    public int pop() {
        if (currentSize == 0) {
            return -1;
        }
        currentSize--;
        return stack[currentSize];
    }

    public void increment(int k, int val) {
        int limit = Math.min(k, currentSize);
        for (int i = 0; i < limit; i++) {
            stack[i] += val;
        }
    }
}