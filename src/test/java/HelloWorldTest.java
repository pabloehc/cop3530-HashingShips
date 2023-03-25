import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HelloWorldTest {

    @Test
    public void helloWord(){
        String expectedString = "Hello world.";
        assertEquals(expectedString, HelloWorld.helloWorld());
    }
}