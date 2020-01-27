public class MyClass {
    // Static method    a static method, which means that it can be accessed without creating an object of the class
    static void myStaticMethod() {
      System.out.println("Static methods can be called without creating objects");
    }
  
    // Public method      Public can only be accessed by objects
    public void myPublicMethod() {
      System.out.println("Public methods must be called by creating objects");
    }
  
    // Main method
    public static void main(String[] args) {
      myStaticMethod(); // Call the static method
      // myPublicMethod(); This would compile an error
  
      MyClass myObj = new MyClass(); // Create an object of MyClass
      myObj.myPublicMethod(); // Call the public method on the object
    }
  }