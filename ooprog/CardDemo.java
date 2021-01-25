//Encapsulation --> classes and objects
//Inheritance --> Reusability
//Abstraction or Abstract Classes --> Organization
//Polymorphism

//Regular class -- you can instantiate objects
//Abstract class -- a class that can never be instantiated. We cannot create an object out of it.

abstract class Card //not a regular class but abstract because of the abstract keyword
{
   /*default - will only work implicitly
      Card()
      {
      
      }
   */
   
   protected String recipient;      // name of who gets the card
   public abstract void greeting();  // abstract greeting() method
   
   public String sample() //regular method
   {
      return null;
   }
}

class Valentine extends Card
{   
   public Valentine()
   {
      //does nothing
   }
   
   public Valentine(String recipient)
   {
      this.recipient = recipient;
   }
   
   }

class Birthday extends Card
{
   public void greeting()
   {
      System.out.println("Dear " + recipient + ":");
      System.out.println("Happy Birthday\nHow have you grown?");
   }
}

class Holiday extends Card
{
  public Holiday( String r )//constructor
  {
    recipient = r; // recipient in Card is protected, so this works
  }

  public void greeting()//overriden method from the abstract class Card
  {
    System.out.println("Dear " + recipient + ",");
    System.out.println("Season's Greetings!\n");
  }
}

class Halloween extends Card
{
   public  void greeting()
   {
   
   }
}

class Fiesta extends Card
{

}

public class CardDemo
{
   public static void main(String args[])
   {
      Card c; //declaring c as a reference to Card
      c = new Valentine();
         c.greeting();//whose greeting() method is called?
      c = new Valentine("Juan");//creating a Valentine object using the constructor with String parameter
         c.greeting();//whose greeting() method is called? 
      c = new Birthday();//creating a new Birthday object using the default no-argument constructor
         c.greeting();//whose greeting() method is called? 
      c = new Holiday("Maria");
         c.greeting();
         
   }
}