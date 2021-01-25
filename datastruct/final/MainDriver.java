import java.util.*;
public class MainDriver{
    public static void main(String [] args){
        Scanner in = new Scanner(System.in);
        Stack stack = new Stack();
        int choose;
        do{
            String str="";
            choose = 0;
            System.out.println("Choose an options:");           
            System.out.println("option #1  -  Push");                               
            System.out.println("option #2  -  DisplayStack");
            System.out.println("option #3  -  Pop");
            System.out.println("option #4  -  Exit");
            System.out.print("\nChoose option: ");
            choose = in.nextInt();

            switch(choose){                               // i using switch for option statement

                case 1:                                   //push operation              
                    System.out.print("Enter string(parentheses, brackets and curly braces only): ");    
                    str = in.next();
                    stack.push(str);
                    break;
                case 2:                                    //peek all stack
                    stack.DisplayStack();
                    break;
                case 3:                                    //pop or remove the top stack
                    stack.pop();
                    break;
                case 4:                                    //terminate the program
                    System.out.println("Exit"); 
                    break;
                default:
                    System.out.println("Enter only 1 - 3");
                    break;
            }
        }while(choose !=4);
    }

}