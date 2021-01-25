import java.util.*;
public class MainDriver {
    public static void main(String[] args){
        Linkedlist web = new Linkedlist();
        Scanner in = new Scanner(System.in);
        int num;
                                          
        do{                                                 //i use do while for looping options                         
            System.out.println("Option:");
            System.out.println("1. add website");
            System.out.println("2. go back to previous website");
            System.out.println("3. display browsing history");
            System.out.println("4. get total website");
            System.out.println("5. display current website");
            System.out.println("0. Exit");
            System.out.print("\nEnter option: ");
             num = in.nextInt();

            switch(num){                                                

                case 1 :                                     //case for adding nodes                                          
                    System.out.print("Enter domain name: ");            
                    String str = in.next();
                    System.out.print("Enter link: ");
                    String str2 = in.next();

                    web.addLast(new Website(str,str2));               //creating object with 2 parameters
                    System.out.println("\nWebsite is added!\n\n");
                    System.out.println("go back to menu\n");
                    break;
                case 2:                                   //case for displaying the previous node
                    web.displayPrevious();
                    System.out.println("\n");
                    System.out.println("go back to menu\n");
                    break;
                case 3:                                  //case for displaying all inputed nodes
                    System.out.println(" ------------- \n browsing history \n --------------\n");
                    web.displayWebsite();
                    System.out.println("\n");
                    System.out.println("go back to menu\n");
                    break;
                case 4:                                 //case for count the inputed nodes
                    System.out.println(" ------------- \n total visited sites \n --------------\n");
                    System.out.println("total = "+ web.getLength());
                    System.out.println("go back to menu\n");
                    break;
                case 5:                                 //case for displaying last input site
                    System.out.println(" ------------- \n Current site \n --------------\n");
                    web.displayCurrent();
                    System.out.println("\n");
                    System.out.println("go back to menu\n");
                    break;
                case 0:                                 //case for terminate program
                    System.out.println("\nThank you for browsing");
                    break;  
                default:                                
                    System.out.println("\nPlease enter 0 - 5 only\n");  
                    break;      
                }
        }while(num != 0);                               // if num is 0 the loop condition is false
    }
}
