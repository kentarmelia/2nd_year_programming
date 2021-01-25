NODE
public class Node{
    int data;
    Node next;
    public Node(int data){
        this.data = data;
        this.next = null;
    }
}

QUEUE APPLICATION
public class QueueApplication{
    private Node front;

    public Node createNode(int data) {
        return new Node(data);
    }
    
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

    public int peekFront() {
        // TODO Auto-generated method stub
        return 0;
    }

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

    public boolean isEmpty() {
        return front == null;
    }

}

MAINDRIVER
import java.util.*;
public class MainDriver {
    public static void main(String [] Args){
        QueueApplication checkout = new QueueApplication();
        Scanner sc = new Scanner(System.in);
        int number;
        do{
        number = 0;
        System.out.println("             FLORES' GROCERY STORE CHECK OUT SYSTEM             ");
        System.out.println("===============================================");
        System.out.println("Choose an option: ");
        System.out.println("1 - ENQUEUE");
        System.out.println("2 - DEQUEUE");
        System.out.println("3 - DISPLAY QUEUE");
        System.out.println("4 - EXIT");
       
        number = sc.nextInt();
        if(number == 1){
         String customer = "";
         checkout.enqueue(getName(customer));
        }
        else if(number == 2){
         System.out.println("Dequeuing --> " + checkout.dequeue());
        }
        else if(number == 3){
         checkout.displayQueue();
        }
        else if(number == 4){
         System.out.println("Exiting.....");
        }
        else{
         System.out.println("\n\n-------------------------------------\n");
         System.out.println("Error Input! Please input a number from 1-5.");
         System.out.println("-------------------------------------\n\n");
         }
      }while(number !=4);
   }
}