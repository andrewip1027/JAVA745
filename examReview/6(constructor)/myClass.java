// Create a MyClass class

public class MyClass {
  int x;  // Create a class attribute

  // Create a class constructor for the MyClass class
  public MyClass() {
    x = 5;  // Set the initial value for the class attribute x
  }
  public static void main(String[] args) {
   
   //Note that the constructor name must match the class name, and it cannot have a return type (like void).
//!All classes have constructors by default: if you do not create a class constructor yourself, Java creates one for you. However, then you are not able to set initial values for object attributes.
    MyClass myObj = new MyClass(); // Create an object of class MyClass (This will call the constructor)
    System.out.println(myObj.x); // Print the value of x
  }
}
//* Outputs 5
//TODO create working class


//**important information
/*
! deprecated
? should this method be in public 
*/

