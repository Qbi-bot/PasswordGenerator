package PasswordGenerator;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import static junit.framework.TestCase.*;


class PasswordTest {
    @Test
    public void canCreatePasswordObject() throws Exception{
        Password password = new Password(10);
        assertFalse("" == password.getPassword());
    }
    @RepeatedTest(value = 100)
    public void canCreateOneChar() throws Exception{
        Password password = new Password(10);
        char randomChar = password.getRandomChar();
        assertTrue(randomChar > 32 && randomChar < 127);
    }
    @RepeatedTest(value = 100)
    public void canCreateRandomPassword() throws Exception{
        int passwordLength = 10;
        Password password = new Password(passwordLength);
        Boolean hasGoodChars = true;
        for (int i = 0; i < passwordLength; i++) {
            if (password.getPassword().charAt(i) < 33 || password.getPassword().charAt(i) > 126) hasGoodChars = false;
        }
        assertTrue(password.getPassword().length() == passwordLength && hasGoodChars);
    }

    @RepeatedTest(value = 100)
    public void canRandomPasswordCheck() throws Exception{
        Password password = new Password(10);
        assertTrue(password.checkPassword());
    }

}