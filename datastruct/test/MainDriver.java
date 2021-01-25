import java.util.*;
public class MainDriver{
    public static void main(String [] args){
        Scanner in = new Scanner(System.in);
        Stack stack = new Stack();
        int choose;
        do{
            String str="";
            choose = 0;
            System.out.println("Enter an options:");           
            System.out.println("1  -  add");                               
            System.out.println("2  -  DisplayStack");
            System.out.println("3  -  delete");
            System.out.println("4  -  Exit");
            choose = in.nextInt();

                                         
                if(choose == 1){                                                 
                    System.out.print("Enter: ");    
                    str = in.next();
                    stack.push(str);
                }
                else if(choose == 2){                                    
                    stack.DisplayStack();
                }
                else if(choose == 3){                                    
                    stack.pop();
                }
                else if(choose == 4){                                    
                    System.out.println("Exit"); 
                }
                else{
                    System.out.println("Enter only 1 - 3");
                }
            
        }while(choose !=4);
    }

}