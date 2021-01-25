class A extends Object// who is the parent of A? == Object
{
   A()
   {
      System.out.println("a");
   }
}

class B extends A
{
   B()
   {
      //super(); //A()
      System.out.println("b");
   }
}

class C extends B
{
   C()
   {
      //super(); implicitly provided -- B()
      System.out.println("c");

   }
}

class D extends C
{
  D()
  {
  super(); //explicitly provided -- C()
  System.out.println("d");

  }
}

class E extends D
{
   E()
   {
      super(); // D()
      System.out.println("e");

   }
}

public class DemoABCDE //extends Object
{
   public static void main(String args[])
   {
      E e = new E();
   }
}