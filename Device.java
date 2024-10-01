
import com.mypack.View;


public class Device extends View{

void def() {
System.out.println("As void def() I have a default access level");

}

public static void main(String[] args) {
Device d = new Device();


//calling protected variable in View package
d.packmsg();

//calling default method
d.def();

//getting public method's String value of private i variable in View package;
String value = d.getI();
System.out.println(value);

//setting public method's String value of private name parameter in View package
d.setName("Public method setName displayed as getName member");

//getting public method's String value of private name member in View package
System.out.println(d.getName());

}
}