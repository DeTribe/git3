import java.text.DecimalFormat;
public class Props {
    /* 
    String prop = "Baseball Players who hit over .300 in 1974: ";
    String prop = baseBp[i] + " hit over .300 in 1974: ";
    String[] baseBp = {"Rod Carew", "Ralph Garr", "Hal McRae", "Reggie Jackson"}; // Domain of Discourse
    String[] baseBt = { "Minnesota Twins", "Atlanta Braves", "Kansas City Royals", "Bad News Bears" };
    double[] batAvg = {.364, .353, .310, .289 };  
    boolean m = true;
    */
    
    String[] baseBp = {"Rod Carew", "Ralph Garr", "Hal McRae", "Reggie Jackson"};
    double[] batAvg = {.364, .353, .310 };
    String[] baseBt = { "Minnesota Twins", "Atlanta Braves", "Kansas City Royals", "Bad News Bears" };
    DecimalFormat df = new DecimalFormat(".000");
    public void props() {
        int i = 0;
        String[] baseBp = {"Rod Carew", "Ralph Garr", "Hal McRae", "Reggie Jackson"};
        System.out.println(baseBp[i] + " hit over .300 in 1974: " + (baseBp[i] != baseBp[3]));
        i += 3;
        System.out.println(baseBp[i] + " hit over .300 in 1974: " + (baseBp[i] != baseBp[3]));   
        i -= 2;
        System.out.println(baseBp[i] + " came in second with a " + df.format(batAvg[i]) + " batting average: " +(baseBp[i]==baseBp[1]));
        i += 1;
        boolean m = true;
        while(m) {
        System.out.println(baseBp[i] + " played in the MLB in 1974 as well with a batting average of " + df.format(batAvg[i]) + " came in 12th with Mike Jorganson");
        m = false;
}    
        System.out.println("The following are Rod, Ralph's and Hal's batting averages in 1974.");

        do{
        m=true;
        for(double batAv:batAvg) {
        //System.out.println("\n" + df.format(batAv) + "\n");
        System.out.print(" " + df.format(batAv) + " ");
        System.out.println();
        m=false;
}
}        while(m);
         //m=false;

       --i;

       System.out.println("Another MLB player that year who came close to hitting over .300 was " + baseBp[3] + ". We'll add him to the list.");

       for( i=0 ; i < baseBp.length/2; ++i) {
       String temp = baseBp[i];
       
       baseBp[i]=baseBp[baseBp.length-1-i];
       baseBp[baseBp.length-1-i]=temp;
}

       for( i= 0 ; i<baseBp.length; ++i) {
       System.out.println( "\n" + (baseBp[i]) + "\n");
}
       /* for( i=0; i< baseBp.length; ++i) {
          for( int j=0;j < baseBt.length;++j) {
          System.out.println(baseBp[i] + " was a member of the club " + baseBt[j] ); */
         
       for ( i=0; i<baseBp.length; ++i){
       System.out.println(baseBp[i] + " was a member of the club " + baseBt[i] );
}    
}
    public static void main(String[] args) {
        Props p = new Props();
        p.props();  // Fixed method call syntax
    }
}
