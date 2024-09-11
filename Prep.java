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

System.out.println("If n = 1, n*n-n-6=0 :). " +  ((n*n-n-6==0)));
++n;
System.out.println("Hmmm. Ok. If n=2 , n*n-n-6=0 :I . " + ((n*n-n-6==0)));
++n;//increment from 2 to 3
System.out.println(":O...:C . We need to solve this equation. Let's factor and solve! :b");
System.out.println("What numbers when multiplied equal - 6 but when added equal -1?\n" + "Factors of 6 are 1,2,3,and 6. 6 and 1 are negative\n" + "The solutions are 3 and -2");
System.out.println("Let's see this in action");

do{
int f = n*n-n-6; //Store prepositional phrase
System.out.println("The value : " + n + " prepositions the fraze to be zero. " + f + " = 0? " + ((n*n-n-6==0)));//determines value of n and prep.fraze.
--n;//decrements the counter
}while(n>=-2);

 
System.out.println("So as we can now see above, the values of n which make n*n-n-6=0 true are -2 and 3. QED ;)");
}

public static void main(String[] args) {
Prep p= new Prep();
p.prep();
}
}
