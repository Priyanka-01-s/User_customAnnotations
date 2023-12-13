import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.example.User;
import com.example.ValiadationException;
import com.example.Validation;

public class ValidationTest {

    @Test
    public void testHappyPathValidation() {
        User validUser = new User("Priyanka Sengupta", "password", 21);

        try {
            Validation.validate(validUser);
            assertTrue(true);
        } catch (ValiadationException e) {
            fail("Unexpected ValidationException: " + e.getMessage());
        }
    }

    @Test
    public void testSadPathValidation() {
        User invalidUser = new User("", "root", -5);

        try {
            Validation.validate(invalidUser);
            fail("Expected ValidationException but no exception was thrown.");
        } catch (ValiadationException e) {
            assertEquals("Validation failed: username must not be blank.", e.getMessage());
        }
    }
    
}
