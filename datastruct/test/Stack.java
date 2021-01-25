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
            String str = temp.data;                  
            System.out.println(temp.data +"-"+ valid(str));
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
    public boolean valid(String str){                 
        String temp = str;                           
        boolean para=true,curly=true,box=true;       
        if(temp.length()%2==1||temp.charAt(temp.length()-1)=='('||temp.charAt(temp.length()-1)=='{'||temp.charAt(temp.length()-1)=='['){   
            return false;
        }
        
        for(int i = 0;i < temp.length()-1;i++){  
            int count = 0;
            if(temp.charAt(i)=='('){                                                      
                int bal = 0;    
                para = false;
            for(int j = i+1;j<=temp.length()-1;j++){
                      bal++;                       
                if(temp.charAt(j)==')'){            
                    count = bal;
                        break;
                }
                
            }
                if(count%2==1){                       
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