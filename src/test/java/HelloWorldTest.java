import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test class for HelloWorld
 * This shows how to write basic unit tests
 */
public class HelloWorldTest {

    @Test
    public void testGreet() {
        // Arrange - set up test data
        HelloWorld helloWorld = new HelloWorld();
        String expectedMessage = "Hello, Maven :)";

        // Act - run the method we're testing
        String actualMessage = helloWorld.greet("Maven");

        // Assert - check if the result is what we expected
        assertEquals(expectedMessage, actualMessage);
    }
}