/**
 * A simple Hello World application
 * This demonstrates basic Maven project structure
 */
public class HelloWorld {

    /**
     * Main method - the entry point of our application
     * @param args command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Hello, Maven World!");
        System.out.println("This project was built successfully!");
    }

    /**
     * A simple method to demonstrate testing
     * @param name the name to greet
     * @return a greeting message
     */
    public String greet(String name) {
        return "Hello, " + name + "!";
    }
}