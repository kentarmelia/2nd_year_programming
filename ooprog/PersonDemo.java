//Class - a blueprint of an object, idea or concept about a future object
//Object - an instance of a class
//Encapsulation - when you create your own class. 
                  //There's a proper way of doing encapsulation
                  //declaring the member variables private and 
                  //providing setter/mutator and getter/accessor methods

class Person
{
   //member variables, attributes, data
   private String name; //automatic initial values only take effect if the variable is declared inside the class
   private int age;
   private String address;
   
   //constructor(s), 0 or more
   //because the class Person is not provided with a constructor, explicitly
   //java provides an automatic default-no-argument constructor, implictly
   //default-no-argument constructor only takes effect if there is no constructor provided
   //once there is a constructor, the the default-no-argument constructor is waived
   
   Person() //this constructor looks exactly the same with the default-no-argument constructor
   {
      System.out.println("Wow, I am a Person object created!");
   }
   
   Person(String n)
   {
      this.name = n;
   }
   
   Person(String n, int a)
   {
      this.name = n;
      this.age = a;
   }
   
   Person(String name, int age, String address)
   {
      this.name = name;
      this.age = age;
      this.address = address;
   }
   
   //setter/mutator for name
   public void setName(String name)
   {
      this.name = name;
   }
   
   //getter/accessor for name
   public String getName()
   {
      return this.name;
   }
   
   //setter/mutator for age
   public void setAge(int age)
   {
      this.age = age;
   }
   
   //getter/accessor for age
   public int getAge()
   {
      return this.age;
   }
   
   //setter/mutator for address
   public void setAddress(String address)
   {
      this.address = address;
   }
   
   //getter/accessor for name
   public String getAddress()
   {
      return this.address;
   }


   
   //member methods, behavior, codes that act on data
   public void introduce()
   {
      System.out.println("Hello, my name is " + name);
      System.out.println("I am " + age + " years young.");
      System.out.println("I live in " + address);
   }
}

//-----------------------------------------------------------------
public class PersonDemo
{  
   PersonDemo() //EXPLICITLY-PROVIDED
   {
    System.out.print("Hello");
   }
   
   public static void main(String args[])
   {
      Person p;//p is the reference variable to a future Person object
      p = new Person("Melvin", 20, "Cebu");//creating a person object out of the Person class referred by p
      p = new Person("Juan");
      p = new Person();
      p.setName("Pedro");
      p.setAge(23);
      p.setAddress("Manila");
      p.introduce();
      System.out.println("In 2022 I will be " + (p.getAge() + 2));
      //Java has an automatic garbage-collector
      //new is the operator that creates an object
      //Person() is the constructor
      //constructor is a special kind of method
      //special because it takes the name of the class
      //special because it doest have a return type (not even void)
      //special because you can only call it if you want to cfeate an object
   }
}
