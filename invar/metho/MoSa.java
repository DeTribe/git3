import java.util.Arrays;

public class MoSa{
   public static void main(String[] args) {
      int[] val= { 165, 24, 23, 22, 25, 192, 19092};
      System.out.println(getFirst(val));
     
      String[] valStr = { "First ", "Second " , "Third ", "Wadjet ", "Ahnk ", "Ra "};
      System.out.println(getFirst(valStr));

}
   public static int getFirst(int[] input) {
      if(input == null || input.length == 0) return -1;
      Arrays.sort(input);
 
      return input[0];
}

   public static String getFirst(String[] input) {
      if(input == null || input.length == 0) return "";
      Arrays.sort(input);
 
      return input[0];


}
}