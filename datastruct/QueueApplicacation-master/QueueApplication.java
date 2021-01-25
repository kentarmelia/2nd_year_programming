public class QueueApplication implements IQueue {
    private Node front;

    public Node createNode(int data) {
        return new Node(data);
    }

    @Override
    public void enqueue(int data) {
        Node newnode = createNode(data);
        if (isEmpty()) {
            front = newnode;
        } else {
            Node temp = front;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newnode;
        }

    }

    @Override
    public int dequeue() {
        if (isEmpty()) {
            return -1;
        } else {
            Node temp = front;
            front = front.next;
            temp.next = null;
            return temp.data;
        }

    }

    @Override
    public int peekFront() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int peekLast() {
        // TODO Auto-generated method stub
        return 0;
    }

    public void displayQueue() {
        Node temp = front;
        while (temp != null) {
            System.out.print(temp.data + "<-");
            temp = temp.next;
        }
        System.out.println();

    }

    @Override
    public boolean isEmpty() {
        return front == null;
    }

}
