import java.util.*;

public class MainDriver{
    public static void main(String [] args){
        Stack st = new Stack();
        Scanner scan = new Scanner(System.in);
         String bracket = "";
         int opt = 0;
         /*===================
         Input ("(,[,{,),],}")
         ====================*/
         do{
         
         System.out.print("1 - Input\n2 - EXIT\nENTER: ");
         opt = scan.nextInt();
         
         switch(opt){
         case 1:
         System.out.print("Input: ");
         bracket = scan.next();
         System.out.println("BALANCED: " + st.Balances(bracket));
         break;
         default:
         System.out.print("EXITING...");
         break;
         } 
         }while(opt != 2);
   }
}