public class MainDriver {
    public static void main(String [] Args){
        QueueApplication queueApp = new QueueApplication();
        queueApp.enqueue(2);
        queueApp.enqueue(4);
        queueApp.enqueue(6);
        queueApp.enqueue(8);
        queueApp.enqueue(10);
        queueApp.displayQueue();

        System.out.println("Dequeuing -> "+queueApp.dequeue());
        queueApp.displayQueue();

        System.out.println("Dequeuing -> "+queueApp.dequeue());
        System.out.println("Dequeuing -> "+queueApp.dequeue());
        System.out.println("Dequeuing -> "+queueApp.dequeue());
        System.out.println("Dequeuing -> "+queueApp.dequeue());
        System.out.println("Dequeuing -> "+queueApp.dequeue());
        System.out.println("Dequeuing -> "+queueApp.dequeue());
        queueApp.displayQueue();
    }
}
