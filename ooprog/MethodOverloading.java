//method overloading - defining 2 methods of the same name with different parametres inside a class
//method overriding - defining a method in the child class which has similar signature as the method in the super class

class MethodOverloading
{
   public int add(int num1, int num2)
   {
      return num1 + num2;
   }
   
   public int add(int num1, int num2, int num3)
   {
      return num1 + num2 + num3;
   }
   
   public int add(int a, int b, int c, int d)
   {
      return a + b + c + d;
   }
   
   public double add(double a, double b)
   {
      return a + b;
   }
   
   public static void main(String args[])
   {
      MethodOverloading mo = new MethodOverloading();
      
      System.out.println(mo.add(23, 24, 12.78));
   }
}