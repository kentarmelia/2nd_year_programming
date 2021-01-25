class SolidFigures
{
   //int radius;
   //int side;
   //int l, w, h;
   
   //Since there is no explicit constructor provided, Java system implicitly 
   //provides a default no-argument constructor SolidFigures()
   
   public double areaSphere(int radius)
   {
      return 4 * Math.PI * radius * radius;
   }
   
   public double areaCube(int side)
   {
      return 6 * side * side;
   }
   
   public double areaRecSolid(int l, int w, int h)
   {
      return 2*(l*w + l*h + w*h);
   }
   
   public double areaCylinder(int radius, int h)
   {
      return (2 * Math.PI * radius * radius) + (2 * Math.PI * radius * h);
   }
   
   public double volumeSphere(int radius)
   {
      return 4.0/3.0 * (Math.PI * radius * radius * radius);
   }
   
   public double volumeCube(int side)
   {
      return side * side * side;
   }

   public double volumeRecSolid(int l, int w, int h)
   {
      return l * w * h;
   }

   public double volumeCylinder(int radius, int h)
   {
      return Math.PI * radius * radius * h;
   }
}
//----------------------DEMO CLASS------------------------------
public class SolidFiguresDemo
{
   public static void main(String args[])
   {
      int option;
      java.util.Scanner sc= new java.util.Scanner(System.in);
      SolidFigures sf = new SolidFigures(); //create SolidFigures object using the new 
                                            //operator and the SolidFigures() constructor
      int radius, side, l, w, h;
      
      do
      {
         System.out.println("1)Sphere \n2)Cube \n3)Rec Solid \n4)Cylinder \n0)Quit");
         System.out.print("Please Input your choice: ");
         option = sc.nextInt();
         
         switch(option)
         {
            case 1:  System.out.print("Input radius: "); 
                     radius = sc.nextInt();
                     System.out.println("Surface Area: " + sf.areaSphere(radius));
                     System.out.println("Volume: " + sf.volumeSphere(radius));
                     break;
            case 2:  System.out.print("Input side: "); 
                     side = sc.nextInt();
                     System.out.println("Surface Area: " + sf.areaCube(side));
                     System.out.println("Volume: " + sf.volumeCube(side));
                     break;
            case 3:  System.out.print("Input length, width and height: "); 
                     l = sc.nextInt();
                     w = sc.nextInt();
                     h = sc.nextInt();
                     System.out.println("Surface Area: " + sf.areaRecSolid(l, w, h));
                     System.out.println("Volume: " + sf.volumeRecSolid(l, w, h));
                     break;
            case 4:  System.out.print("Input radius and height: "); 
                     radius = sc.nextInt();
                     h = sc.nextInt();
                     System.out.println("Surface Area: " + sf.areaCylinder(radius, h));
                     System.out.println("Volume: " + sf.volumeCylinder(radius, h));
                     break;
            default: System.out.println("Options are only 0, 1, 2, 3 , and 4. Nayabag ka!!!");
         }
      }while(option!=0);
      System.out.println("Thank you!!!");
   }
}