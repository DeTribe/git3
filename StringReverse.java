public class StringReverse {

     static String str = " Algebraic rules for dividing by zero: a/a, a not 0, a/a = 1. Let b= 0. Then a/b = undefined. Lastly, b/b=indeterminate";
    /**
     * Task: return the reverse of a string.
     * There are multiple good ways to solve this problem.
     *
     * You could do some math 
     * Use StringBuilder for the new Reveresed String
     *
     * @param str a String.
     * @return the reverse of str.
     *
     */
     
    public String studyDontCriticize(){
       return  " My logic ...reversed.";
}

    public String reverse(String str){
        if ( str == null) {
            System.out.println( "String is empty");
    }

    int length = str.length();
    StringBuilder reversed = new StringBuilder(length);

    //local variable i; i>=0 condition; i-- DECREMENT. Declining count

          for (int i = length-1; i >= 0; i--) {

            reversed.append(str.charAt(i)); 
}
            return  "\n" + str + "\n" + "\n" + " " + reversed.toString();
 
}

     public static void main(String[] args) {
       StringReverse s = new StringReverse();

       String result = s.reverse(str);
       System.out.println(result);
       String lesson = s.studyDontCriticize();
       System.out.println();
       System.out.println(lesson);
        
   }
}