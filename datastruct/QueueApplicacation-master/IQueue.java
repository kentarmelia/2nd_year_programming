public interface IQueue {
    public void enqueue(int data);
    public int dequeue();
    public int peekFront();
    public int peekLast();
    public boolean isEmpty();
}
