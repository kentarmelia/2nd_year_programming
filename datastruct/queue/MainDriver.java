import java.util.*;
public class MainDriver{
    public static void main(String Args[]){
        QueueApplication wash = new QueueApplication();
        Scanner in = new Scanner(System.in);
        int choose;
        do{                             //i use do while for looping the system
        choose = 0;
        System.out.println("              ~~~~~~~~~~Kent's Carwash~~~~~~~~~~");
        System.out.println("========================================================");
        System.out.println("Choose an option (1 - 4): ");
        System.out.print("\n 1 - ADD CAR");
        System.out.print("\n 2 - REMOVE CAR");
        System.out.print("\n 3 - DISPLAY CAR/S");
        System.out.print("\n 4 - EXIT");
        System.out.print("\nChoose: ");
        choose = in.nextInt();

        switch(choose){                                       //i use switch instead using if else

            case 1:                                          //enqueue
                System.out.print("Enter owners name: ");
                String owner = wash.getInfo();
                System.out.print("\nEnter car brand name: ");
                String brand = wash.getInfo();
                wash.Showopt();
                System.out.print("\nEnter an option: ");
                int option = in.nextInt();
                System.out.print("\nEnter car size (S,M,L): ");
                char size = in.next().charAt(0);
                System.out.println("-------------------------------------------------------------------------------------------\n");
                wash.enqueue(owner,brand,option,size);

                break;
            case 2:                                              //dequeue
                System.out.println("Done --> " + wash.dequeue());
                System.out.println("\n---------------------------------------------\n");
                break;
            case 3:                                              //display queue
                wash.displayQueue();
                System.out.println("\n--------------------------------------------\n");
                break;
            case 4:                                              // terminate option
                System.out.println("Exit");
                break;
            default:                                             
                 System.out.println("Error Input! Please input a choose from 1-5.");
                 System.out.println("\n--------------------------------------------\n");
                 break;
             }
        }while(choose !=4);
   }
}