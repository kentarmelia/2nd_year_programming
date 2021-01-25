//Classes - are blueprint of objects, concepts about the object
   //member variables
   //constructors
   //member methods

//Objects - are instances of a class. Meaning you create an object based on the class.
//Proper Encapsulation - declaring the member variables private and then just provide setter and getter methods

/*
Point class
Line class
Demo class
*/

class Point //properly encapsulated
{
   //MEMBER VARIABLES
   private int x; //What is the initial value? 0 is the automatic initial value for integer variables declared inside a class
   private int y;
      
   //CONSTRUCTORS
      //if the class does not provide a constructor explicitly, automatically Java will provide the
      //what we call Default-No-Argument Contructor(DNAC) , which look like this:
     
      Point()
      {
         //does nothing
      }
      
      Point(int x, int y)
      {
         this.x = x;
         this.y = y;
      }
     
      //The moment a class is provided with a any constructor explicitly, the DNAC will not take effect
      //Constructor is a special kind of method (no return type, it takes the name of the class, its called once only to create object)
   
   //MEMBER METHODS
   //setter methods/mutator methods
   public void setX(int x)
   {
      this.x = x;
   }
   
   public void setY(int y)
   {
      this.y = y;
   }

   
   //getter methods/accessor methods
   public int getX()
   {
      return this.x;
   }
   
   public int getY()
   {
      return this.y;
   }
 
}

//------------------------------------------------
class Line //proper encapsulation
{
   private Point p1;
   private Point p2;
   
   Line(Point p1, Point p2)
   {
      this.p1 = p1;
      this.p2 = p2;
   }
   
   public double getDistance()
   {
      return Math.sqrt((p2.getX() - p1.getX())*(p2.getX() - p1.getX())  +  (p2.getY() - p1.getY())*(p2.getY() - p1.getY()));
   }
}

//------------------------------------------------
public class Demo
{
   public static void main(String args[])
   {
      Point p = new Point(); // created a Point object using the new operator and the Point() constructor
      
      //p.x = 20; INCORRECT because x is private in Point
      p.setX(20); //CORRECT
      //System.out.println(p.x); INCORRECT
      System.out.println(p.getX()); //CORRECT
      
      p.setY(100);
      System.out.println(p.getY());
      
      p = new Point(23, 124); // creates a Point object referrd by p1 with initial values 23 and 124 passed to the Point(int, int) constructor
      System.out.println(p.getX());
      
      System.out.println("===============================================");
      
      Point dot1 = new Point(10, 200); //to create an object we need the new operator as well as the constructor
      Point dot2 = new Point();
      
      Line linya = new Line(dot1, dot2);
      
      double distance = linya.getDistance();
      System.out.println("Distance/Radius: " + distance);
      //use the distance as radius and compute the are of the circle
      System.out.println("Area of Circle: " + Math.PI*distance*distance);


   }
}