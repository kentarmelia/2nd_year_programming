public class Node{
    String owner;
    String brand;
    int option;
    char size;
    Node next;
    public Node(String owner,String brand,int option,char size){
        this.owner = owner;
        this.brand = brand;
        this.option = option;
        this.size = size;
        this.next = null;
    }
}