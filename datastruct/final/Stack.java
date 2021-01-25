public class Stack{

    private Node top;
    private Node createNode(String data){
        return new Node(data);
    }
    
    public void push(String data){
        Node newnode = createNode(data);
        if (isEmpty()) {
            top = newnode;
        } 
        else{
            newnode.next = top;
            top = newnode;
        }
    }
    public void DisplayStack() {
        Node temp = top;
        while (temp != null){
            String str = temp.data;                   //node data convert into string data
            System.out.println(temp.data +" => "+ valid(str));
            temp = temp.next;
        }
        System.out.println();
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
    public boolean valid(String str){                 //boolean method that determine if the string if the order of the braces is valid
        String temp = str;                           
        boolean para=true,curly=true,box=true;        //it declares true if the user did not input other braces
        if(temp.length()%2==1||temp.charAt(temp.length()-1)=='('||temp.charAt(temp.length()-1)=='{'||temp.charAt(temp.length()-1)=='['){    //it return false if the length of string is odd or last character of string is open braces
            return false;
        }
        
        for(int i = 0;i < temp.length()-1;i++){  
            int count = 0;
            if(temp.charAt(i)=='('){                   //if the statement is true the boolean para will declared as false                                       
                int bal = 0;    
                para = false;
            for(int j = i+1;j<=temp.length()-1;j++){
                      bal++;                        //count to make balance
                if(temp.charAt(j)==')'){            //to make the variable para true is to find the matching braces in an even index
                    count = bal;
                        break;
                }
                
            }
                if(count%2==1){                        //if the count is odd the balance is true
                    para = true;
                }
            }
            
            if(temp.charAt(i)=='{'){                                                          
                int bal = 0;    
                curly = false;
            for(int j = i+1;j<=temp.length()-1;j++){
                      bal++;
                if(temp.charAt(j)=='}'){   
                    count = bal;
                        break;
                } 
            }
                if(count%2==1){
                    curly = true;
                }
            }

             if(temp.charAt(i)=='['){                                                         
                int bal = 0;    
                box = false;
            for(int j = i+1;j<=temp.length()-1;j++){
                      bal++;
                if(temp.charAt(j)==']'){   
                    count = bal;
                        break;
                }
                
            }
                if(count%2==1){
                    box = true;
                }
            } 
        }
        return para && curly && box;
    }

    public boolean isEmpty() {
        return top == null;
    }

}