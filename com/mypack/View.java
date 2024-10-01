package com.mypack;

public class View {

private String i="A mahn Canno ide me if'm nah prI 'veete, ya getIin(i)?";
private String name;

protected void packmsg() {
System.out.println("This is the protected packmsg() method");
}

public String getI() {
return i;
} 

public void setI(String i){
  this.i = i;
}


public String getName(){
return name;
}
public void setName(String name){
this.name = name;
}
}