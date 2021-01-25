public class Linkedlist {
    private Website head;
    private Website newWebsite(String website, String link){
        return new Website(website,link);
    }

    public void addLast(Website w){
        Website web = newWebsite(w.website,w.link);
        if(head == null){
            head = web;
        }
        else{
            Website temp = head;
            while(temp.next != null){
                temp = temp.next;
            }
            temp.next = web;
        }
    }
    public void displayPrevious(){
        Website temp = head;
       if(temp == null){
           System.out.println(temp);
       }
       else{
           if(temp.next == null)
            System.out.println();
           else
           while(temp.next.next != null){
            temp = temp.next;
           }
           System.out.print("previous site: "+temp.website+" --> "+temp.link);
       }
    }
    public void displayWebsite(){
        Website temp = head;
        int i = 1;
        while(temp != null){
            System.out.println(i+". "+temp.website+" --> "+temp.link);
            temp = temp.next;
            i++;
        }
    }

    public int getLength(){
        int len = 0;
        Website temp = head;
        while(temp !=null){
            len++;
            temp = temp.next;
        }
        return len;
    }
    public void displayCurrent(){
        Website temp = head;
       if(temp == null){
           System.out.println(temp);
       }
       else{
           while(temp.next != null){
            temp = temp.next;
           }
           System.out.print("previous site: "+temp.website+" --> "+temp.link);
       }

    }
}
