public class MainDriver{
    public static void main(String [] args){
        StackApplication sa = new StackApplication();
        sa.push(5);
        sa.push(10);
        sa.push(15);
        sa.push(20);
        sa.push(25);
        sa.displayStack();
        System.out.println("Peeking:"+sa.peek());
        sa.pop();
        sa.pop();
        sa.pop();
        sa.displayStack();
        System.out.println("Peeking:"+sa.peek());
        sa.pop();
        sa.pop();
        sa.pop();
        sa.displayStack();
        System.out.println("Peeking:"+sa.peek());
    }
}