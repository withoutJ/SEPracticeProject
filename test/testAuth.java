package test;
import static org.junit.Assert.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.Test;

import authentication.*;
import user.*;

public class testAuth {
    
    @Test
    public void testLogin_when_userNotNull(){
       
        User user1 = new User("Aisha","Password123");
        User user2 = new User("Taswar", "SecondPassword12");
        User user3 = new User("User3","ThirdPassword");
        Admin admin = new Admin("Adminboy","AdminPass12");

        AuthenticationService.addUser(user1);
        AuthenticationService.addUser(user2);
        AuthenticationService.addUser(user3);

        User loggedInUser = AuthenticationService.login("Aisha", "Password123", admin);

        assertEquals(user1,loggedInUser);
    }

    @Test
    public void testLogin_when_userIsNull(){
       
        User user1 = new User("Aisha","Password123");
        User user2 = new User("Taswar", "SecondPassword12");
        User user3 = new User("User3","ThirdPassword");
        Admin admin = new Admin("Adminboy","AdminPass12");

        AuthenticationService.addUser(user1);
        AuthenticationService.addUser(user2);
        AuthenticationService.addUser(user3);

        User loggedInUser = AuthenticationService.login("NonUser", "Password123", admin);

        assertEquals(null,loggedInUser);
    }

    
}
