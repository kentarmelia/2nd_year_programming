import java.util.Scanner;
public class QueueApplication{
    private Node front;

    public Node getname(String owner,String brand,int option,char size) { 
        return new Node(owner,brand,option,size);
    }
    
    public void enqueue(String owner,String brand,int option,char size) {
        Node newnode = getname(owner,brand,option,size);
        if (isEmpty()){
            front = newnode;
        } else {
            Node temp = front;
            while (temp.next != null) {
             temp = temp.next;
            }
            temp.next = newnode;
        }
    }
    public String dequeue() {
        if (isEmpty()) {
          return "no cars";
        } else {
            Node temp = front;
            front = front.next;
            temp.next = null;
            return temp.owner+" Car";
        }
    }
    public void displayQueue() {
        Node temp = front;
        int x=1;
        while (temp != null) {
         System.out.print("\nCar #"+x+"\n"+"\tOweners name\t=>\t"+temp.owner+"\n\tCar Brand\t=>\t"+temp.brand);
        if(temp.option == 1){
            System.out.print("\n\tWash Service\t=>\tWash");
            if(temp.size == 's'||temp.size == 'S'){
                System.out.print("\n\tCar Size\t=>\tSmall");
                System.out.print("\n\tPrice\t=>\tP170");
            }else if(temp.size == 'm'||temp.size == 'M'){
                System.out.print("\n\tCar Size\t=>\tMedium");
                System.out.print("\n\tPrice\t\t=>\tP190");
            }else if(temp.size == 'l'||temp.size == 'L'){
                System.out.print("\n\tCar Size\t=>\tLarge");
                System.out.print("\n\tPrice\t\t=>\tP210");
            }else{
                System.out.print("\n\tPrice\t\t=>\tNULL");
            }
        }
        else if(temp.option == 2){
            System.out.print("\n\tWash Service\t=>\tGlass Polish");
            if(temp.size == 's'||temp.size == 'S'){
                System.out.print("\n\tCar Size\t=>\tSmall");
                System.out.print("\n\tPrice\t\t=>\tP2,000");
            }else if(temp.size == 'm'||temp.size == 'M'){
                System.out.print("\n\tCar Size\t=>\tMedium");
                System.out.print("\n\tPrice\t\t=>\tP2,000");
            }else if(temp.size == 'l'||temp.size == 'L'){
                System.out.print("\n\tCar Size\t=>\tLarge");
                System.out.print("\n\tPrice\t\t=>\tP2,500");
            }else{
                System.out.print("\n\tPrice\t\t=>\tNULL");
            }
        }
        else if(temp.option == 3){
            System.out.print("\n\tWash Service\t=>\tZero Bacteria");
            if(temp.size == 's'||temp.size == 'S'){
                System.out.print("\n\tCar Size\t=>\tSmall");
                System.out.print("\n\tPrice\t\t=>\tP500");
            }else if(temp.size == 'm'||temp.size == 'M'){
                System.out.print("\n\tCar Size\t=>\tMedium");
                System.out.print("\n\tPrice\t\t=>\tP500");
            }else if(temp.size == 'l'||temp.size == 'L'){
                System.out.print("\n\tCar Size\t=>\tLarge");
                System.out.print("\n\tPrice\t\t=>\tP850");
            }else{
                System.out.print("\n\tPrice\t\t=>\tNULL");
            }
           } 
        else{
            System.out.print("\n\tCar size\t=>\tNULL");
            System.out.print("\n\tPrice\t\t=>\t\tNULL");
        }
         temp = temp.next;
         x++;
        }   
        System.out.println();
    }

    public boolean isEmpty() {
     return front == null;
    }
    public String getInfo(){                         //Scanner method that can accept spaces in string
     Scanner sc = new Scanner(System.in);
      return sc.nextLine();
    }
    public void Showopt(){                         
        System.out.println("Car Service\t\tSmall\tMedium\tLarge");
        System.out.println("------------------------------------------------------------------------\n");
        System.out.println("1 )Wash\t\t\tP170\tP190\tP210");
        System.out.println("2 )Glass polish\t\tP2,000\tP2,000\tP2,500");
        System.out.println("3 )Zero Bacteria\tP500\tP500\tP850");    
    }

}