import java.util.Scanner; 

class nameAge {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter name and Age"); 

        //String input
        String name = scanner.nextLine();
        String age = scanner.nextLine();
        
        System.out.println(name + age);
    }
}