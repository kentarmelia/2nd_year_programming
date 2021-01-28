
class Shape{

    private String color;
    private boolean filled;
    public Shape()
    {
        color = "red";
        filled = true;
    }
    Shape(String color,boolean filled){
     this.color = color;
     this.filled = filled;
    }
    public String getColor(){
     return this.color;   
    }
    public void setColor(String color){
        this.color = color;
    }
    public boolean isFilled(){
        return this.filled;
    }
    public void setFilled(boolean filled){
        this.filled = filled;
    }
    public String toString(){
        return "Shape[Color: "+getColor()+",Filled: "+isFilled()+"]";
    }
}

class circle extends Shape{

    private Double radius;

    public circle(){ 
     radius =  1.0;
    } 
   public circle(double radius){ 
     this.radius = radius;
    } 
    public circle(double radius, String color, boolean fill)
    {
       super(color,fill);
       this.radius = radius;
    }
    public Double getRadius(){
        return this.radius;
    }
    public void setRadius(Double radius){
        this.radius = radius;
    }
    public Double getArea(){
        return Math.PI*radius*radius;
    }
    public Double getPerimeter(){
        return 2*Math.PI*radius;
    }
    public String toString(){
        return "Circle["+super.toString()+"]";
    }
}

class Rectangle extends Shape{
    private Double width2;
    private Double length2;
   

    public Rectangle(){
    width2 = 1.0;
    length2 = 1.0;
    }
   public Rectangle(double width,double length){
      width2 = width;
      length2 = length;
    }
   public Rectangle(double width,double length, String color, boolean fill){
      super(color, fill);
      width2 = width;
      length2 = length;
    
    }
    public Double getWidth(){
        return width2;
    }
    public void setWidth(Double width){
        width2 = width;
    }
    public Double getLength(){
        return length2;
    }
    public void setLength(Double length){
        length2 = length;
    }
    public Double getArea(){
        return width2*length2;
    }
    public Double getPerimeter(){
        return 2*(length2+width2);
    }
    public String toString(){
        return "Rectangle["+super.toString()+" Width: "+getWidth()+",Length: "+getLength()+"]";
    }
}

class Square extends Rectangle{

    private Double side;
    private Double width;
    private Double length;

    private double Side;
   public Square(){
    Side = 1.0;
    super.setWidth(Side);
    super.setLength(Side);
   }
   public Square(double side){
    super(side,side);
    Side = side;
    
   }
   public Square(double side, String color, boolean fill){
      super(side,side,color,fill);
      Side = side;
   }
   public double getSide(){
       return Side;
    }
   public void setSide(double side){
       Side = side;
       setWidth(side);
       setLength(side);
    }
   public void setWidth(double side){
       super.setWidth(side);
    }
   public void setLength(double side){
       super.setLength(side);
    }
    public String toString(){
        return "Square["+super.toString()+"]";
    }
}





class ArmeliaKentDemo {
    public static void main(String []args){
        Shape S = new Shape();
        circle C = new circle(2.0,"red",true);
        Rectangle R = new Rectangle(1.0,1.0);
        Square Sq = new Square(1.0,"red",true);
   
        System.out.println("-------------------------------------------------");
        System.out.println("Shape:");
        System.out.println(S.toString());
        System.out.println("-------------------------------------------------");
        System.out.println("Circle:");
        System.out.println(C.toString());
        System.out.println("Area: "+C.getArea()+"\nPerimeter: "+C.getPerimeter());
        System.out.println("-------------------------------------------------");
        System.out.println("Rectangle:");
        System.out.println(R.toString());
        System.out.println("Area: "+R.getArea()+"\nPerimeter: "+R.getPerimeter());
        System.out.println("-------------------------------------------------");
        System.out.println("Square:");
        System.out.println(Sq.toString());

    } 
}
