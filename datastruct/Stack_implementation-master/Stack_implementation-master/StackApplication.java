public class StackApplication implements IStack {

    private Node top;

    private Node createNode(int data) {
        return new Node(data);
    }

    @Override
    public void push(int data) {
        Node newnode = createNode(data);
        if (isEmpty()) {
            top = newnode;
        } else {
            newnode.next = top;
            top = newnode;
        }
    }

    @Override
    public void pop() {
        if (isEmpty()) {
            System.out.println("pop(): Stack Underflow!");
        } else {
            Node temp = top;
            top = top.next;
            temp.next = null;
        }
    }

    @Override
    public int peek() {
        if (isEmpty()) {
            return -1;
        } else {
            return top.data;
        }
    }

    public void displayStack() {
        Node temp = top;
        while (temp != null) {
            System.out.print(temp.data + "<-");
            temp = temp.next;
        }
        System.out.println();
    }

    @Override
    public boolean isEmpty() {
        return top == null;
        // if(top == null){
        // return true;
        // } else {
        // return false;
    }

}
