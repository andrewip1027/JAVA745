public class Method {
    //FIRST METHOD
    static void myMethod(String fname, int age) {  //you just created a method
      // code to be executed
      // System.out.println("I just got executed");
      System.out.println(fname + "is" + age);
    }

    //SECOND METHOD
    // static void mySecondMethod(){
    //   System.out.println("Second Method just got executed!);
    // }
    public static void main(final String[] args) {
        // mySecondMethod();
        myMethod("Andrew", 25);
        secondMethod.mySecondMethod();  //CALL MyClass Second Method
    }
}