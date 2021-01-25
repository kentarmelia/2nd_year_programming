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
public class StoreArray
{

  public static void main ( String[] args )
  {
    Goods[] inventory =  new Goods[10];
    inventory[0] = new Goods( "bubble bath", 1.40 );
    inventory[1] = new Food ( "ox tails", 4.45, 1500 );
    inventory[2] = new Book ( "Emma", 24.95, "Austen" );
    inventory[3] = new Toy  ( "Leggos", 54.45, 8 );
    
    System.out.println( inventory[0] );
    System.out.println( inventory[1] ); 
    System.out.println( inventory[2] );
    System.out.println( inventory[3] );
    
    Taxable item1 = new Book ( "Emma", 24.95, "Austen" );
    Taxable item2 = new Toy  ( "Leggos", 54.45, 8 );

    System.out.println( "Tax on item 1 "+ item1.calculateTax() );
    System.out.println( "Tax on item 2 "+ item2.calculateTax() );
  }
}