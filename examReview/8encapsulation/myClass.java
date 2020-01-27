/** 
*!The get method returns the value of the variable name.
* ! The set method takes a parameter (newName) and assigns it to the name variable. The this keyword is used to refer to the current object.

However, as the name variable is declared as private, we cannot access it from outside this class:
*/
public class MyClass {
    public static void main(String[] args) {
      Person myObj = new Person();
      myObj.name = "John";  // error
      System.out.println(myObj.name); // error 
    }
}