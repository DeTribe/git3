class Culater{
 public int add(int s) {  
  int sum = 4 * s;
  System.out.println("The Perimeter of a sqare is s+s+s+=4s which when s = " + s + " equals: " + sum );
  return sum;
}
 
 public int add( int l, int w) {
   int sum = ((2 * l) + (2 * w ));
   System.out.println("The Perimeter of a rectangle is l+w+l+w=2l + 2w which when l= " + l + " and w= " + w + " equals: " + sum );
   return sum;
}

 public double add( double a, double b, double c) {
   double sum = a + b + c;
   System.out.println("The Perimemter of a Triangle is a+b+c which when a = " + a + " ,b = " + b + " , and c = " + c + " equals; " + sum);
   return sum;
}
  
  public static void main(String[] args){
  Culater c = new Culater();
  c.add(3);
  c.add(3,2);
  c.add(2.4,3.5,4.6);
}
}