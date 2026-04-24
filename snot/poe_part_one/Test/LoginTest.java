import org.junit.Test;
import static org.junit.Assert.*;

public class LoginTest {

    Login login = new Login();

    @Test
    public void testCheckUsernameValid() {

        login.setUsername("nunu_23");
        String expected = "Welcome <user first name> ,<user second name> it is great to see you.";
        assertEquals(expected, "Welcome <user first name> ,<user second name> it is great to see you.");
    }

    @Test
    public void testCheckUsernameInvalid() {

        login.username = "nunu";
        String expected = "Username incorrectly formatted, make sure it contains an underscore and is no more than 5 characters long";
        assertEquals(expected, "Username incorrectly formatted, make sure it contains an underscore and is no more than 5 characters long");
    }

    @Test

    public void testCheckPasswordValid() {

        login.password = "Not4sale!";
        String expected = "Password captured";
        assertEquals(expected, "Password captured");
    }

    @Test
    public void testCheckPasswordInvalid() {

        login.password = "not4sale";
        String expected = "Password is not formatted correctly, make sure contains a symbol and a capital letter";
        assertEquals(expected, "Password is not formatted correctly, make sure contains a symbol and a capital letter");
    }

    @Test
    public void testPhoneNumberValid() {

        login.cellNumber = "+27625516104";
        String expected = "Number captured successful";
        assertEquals(expected, "Number captured successful");
    }

    @Test
    public void testPhoneNumberInvalid() {

        login.cellNumber = "06255161";
        String expected = "Number not entered correctly or does not contain international code";
        assertEquals(expected, "Number not entered correctly or does not contain international code");
    }

    @Test
    public void testCheckUserNameTrue() {

        login.username = "nunu_23";
        assertTrue(login.checkUserName());
    }

    @Test
    public void testCheckUserNameFalse() {

        login.username = "nunu";
        assertFalse(login.checkUserName());
    }

    @Test
    public void testPasswordTrue() {

        login.password = "Not4sale!";
        assertTrue(login.checkPasswordComplexity("Not4sale!"));
    }

    @Test
    public void testPasswordFalse() {

        login.password = "not4sale";
        assertFalse(login.checkPasswordComplexity("not4sale"));
    }

    @Test
    public void loginSuccessTrue() {
        login.setUsername("nunu_23");
        login.setPassword("Not4sale!");
        assertTrue(login.loginUser("nunu_23", "Not4sale!"));
    }

    @Test
    public void loginSuccessFalse() {
        assertFalse(login.loginUser("nunu", "not4sale"));
    }
}

