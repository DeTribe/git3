/* P(n)=n is an od numbern=1
P(n+1)=n+1 is an even number
n%1=0 = false
n+1%0 = true */
public class Prep{

public void prep(){
int n = 1;
System.out.println("Element 1-The number 1 is odd : " + (n%2 != 0));
++n;
System.out.println("Element 2-The number 2 is odd : " + (n%2 != 0));

//System.out.println("Element 2 is even : " + (n%2==0));
 
System.out.println("Int n = " + n + ": (n**2 + 2n) is an odd number when n = 2 : " + ((n * n + 2 * n)%2 != 0));
++n;
System.out.println("Int n = " + n + ": (n**2 + 2n) is an odd number when n = 3 : " + ((n * n + 2 * n)%2 != 0));
n-=2;
System.out.println("Int n = " + n + ": (n**2 + 2n) is an odd number when n = 1 : " + ((n * n + 2 * n)%2 != 0));

}

public static void main(String[] args) {
Prep p= new Prep();
p.prep();
}
}
