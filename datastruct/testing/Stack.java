public class Stack {
    
   private Node top;
    
   private Node createNode(char bracket) {
      return new Node(bracket);
   }

   public void push(char bracket) {
      Node newnode = createNode(bracket);
      if (isEmpty()) {
         top = newnode;
      } else {
         newnode.next = top;
         top = newnode;
      }
   }

   public void pop() {
      if (isEmpty()) {
         System.out.println("pop(): Stack Underflow!");
      } else {
         Node temp = top;
         top = top.next;
         temp.next = null;
      }
   }

   public int peek() {
      if (isEmpty()) {
         return -1;
      } else {
         return top.bracket;
      }
   }
        
   public void displayStack(String bracket) {
      Node temp = top;
      while (temp != null) { 
         System.out.print(temp.bracket + " <- ");
         temp = temp.next;
      }
      System.out.println();
   }

   public boolean isEmpty() {
      return top == null;
   }
  
   public boolean Balances(String bracket) {
      Stack st = new Stack();  
      for(int i = 0 ; i < bracket.length(); i++) {
         char a = bracket.charAt(i);
         if(a == '(' || a == '{' || a == '[') { st.push(a); } else {
            if(st.isEmpty() || a == ')' && st.peek() != '(' || a == ']' && st.peek() != '[' || a == '}' && st.peek() != '{'){
               return false; }
            st.pop();
         }
      }  
      return st.isEmpty();
   } 
}


