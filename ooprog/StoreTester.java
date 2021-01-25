interface Taxable
{
  final double taxRate = 0.06 ;
  double calculateTax() ;
}
//-------------------------
class Goods
{
  protected String description;
  protected double price;

  public Goods( String des, double pr )
  {
    description = des;
    price       = pr;
  }

  public String toString()
  {
    return "item: " + description +  " price: " + price ;
  }
}
//-------------------
class Food extends Goods
{
  double calories;

  Food( String des, double pr, double cal)
  {
    super( des, pr );
    calories = cal ;
  }

  public String toString()
  {
    return super.toString() + calories + " calories";
  }
}
//-------------------------
class Toy extends Goods implements Taxable
{
  protected int minimumAge;

  public Toy( String des, double pr, int min)
  {
    super( des, pr );
    minimumAge  = min ;
  }

  public String toString()
  {
    return super.toString() + "minimum age: " + minimumAge ;
  }

  public double calculateTax()
  {
    return price * taxRate ;
  }
}
//------------------------
class Book  extends Goods implements Taxable
{
  protected String author;

  public Book( String des, double pr, String auth)
  {
    super( des, pr );
    author  = auth ;
  }


  public String toString()
  {
    return super.toString() + "author: " + author ;
  }

  public double calculateTax()
  {
    return price * taxRate ;
  }
}
//-----------------------
public class StoreTester
{

  public static void main ( String[] args )
  {
    Goods gd = new Goods( "bubble bath", 1.40 );
    Food  fd = new Food ( "ox tails", 4.45, 1500 );
    Book  bk = new Book ( "Emma", 24.95, "Austin" );
    Toy   ty = new Toy  ( "Legos", 54.45, 8 );

    System.out.println( gd );

    System.out.println( fd );

    System.out.println( ty );
    System.out.println("Tax is: " + ty.calculateTax() + "\n" );

    System.out.println( bk );
    System.out.println("Tax is: " + bk.calculateTax() + "\n" );

  }
}