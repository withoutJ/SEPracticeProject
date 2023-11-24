package authentication;

import java.util.ArrayList;
import java.util.List;
import user.*;

public class AuthenticationService {
    // Assuming Customer and SessionManager are defined in the user package or appropriately imported.
    private static List<Customer> users = new ArrayList<>();
    // private static Admin admin; // This line can be removed if Admin is not used.

    public AuthenticationService() {
        // Constructor initialization if needed
    }

    private static Customer findUser(String userName, String password) {
        if (users != null) {
            for (Customer user : users) {
                if (user.getUserName().equals(userName) && user.getPassword().equals(password)) {
                    return user;
                }
            }
        
        return null;
    }

    private static boolean validatePassword(String password) {
        if (password.length() < 8) {
            return false;
        }
    
        boolean hasNumber = false;
        boolean hasUpperCase = false;
        boolean hasLowerCase = false;
    
        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) {
                hasNumber = true;
            } else if (Character.isUpperCase(c)) {
                hasUpperCase = true;
            } else if (Character.isLowerCase(c)) {
                hasLowerCase = true;
            }
    
            if (hasNumber && hasUpperCase && hasLowerCase) {
                break;
            }
        }
    
        return hasNumber && hasUpperCase && hasLowerCase;
    }

    public static Customer login(String userName, String password) {
        Customer result = findUser(userName, password);

        if (result != null) {
            SessionManager sessionManager = SessionManager.getInstance();
            sessionManager.createSession(result);
        }
        
        return result;
    }

    public static boolean logout(Customer user) {
        return SessionManager.getInstance().removeSession(user);
    }

    public static Customer register(String userName, String password) {
        Customer user = findUser(userName, password);
        if (user != null) return null; // User already exists

        boolean goodPassword = validatePassword(password);

        if (goodPassword) {
            Customer newUser = new Customer(userName, password); // Assuming Customer constructor is defined.
            users.add(newUser);
            return newUser; // Return the new user instead of null
        }

        return null;
    }

    // public static Admin registerAdmin(String username, String password){

    // }



}