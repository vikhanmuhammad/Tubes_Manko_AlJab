package uas;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void testSuccessfulLogin() {
        UserData user = new UserData(1234, 8766);
        try {
            user.login();
            assertTrue(user.isloggedin);
        } catch (LoginFailed e) {
            fail("Login should have succeeded");
        }
    }

    @Test
    public void testFailedLogin() {
        UserData user = new UserData(1234, 1234);
        try {
            user.login();
            fail("Login should have failed");
        } catch (LoginFailed e) {
            assertFalse(user.isloggedin);
            assertEquals(2, LoginFailed.getfailedcounter(1234));
        }
    }

    @Test
    public void testMultipleFailedLogin() {
        UserData user = new UserData(1234, 1234);
        for (int i = 0; i < 3; i++) {
            try {
                user.login();
                fail("Login should have failed");
            } catch (LoginFailed e) {
                assertFalse(user.isloggedin);
            }
        }
        assertEquals(5, LoginFailed.getfailedcounter(1234));
    }

    @Test
    public void testExceptionMessage() {
        UserData user = new UserData(1234, 1234);
        try {
            user.login();
            fail("Login should have failed");
        } catch (LoginFailed e) {
            assertEquals("Login user 1234 gagal, telah gagal login 0 kali", e.getMessage());
        }
    }

    @Test
    public void testAssertion() {
        UserData user = new UserData(12345, 1234);
        try {
            user.login();
            fail("Assertion should have failed");
        } catch (AssertionError e) {
            assertTrue(e.getMessage().contains("User ID and Password must be 4 digits long"));
        } catch (LoginFailed e) {
            fail("Should not reach here due to assertion error");
        }
    }
}
