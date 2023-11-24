package authentication;

import java.util.ArrayList;
import java.util.List;
import user.*;

public class AuthenticationService{
    //private SessionManager sessionManager;
    //private AdminStub admin;
    private List<Customer> users;
    private SessionManager sessionManager;
    //private static Admin admin;


    public AuthenticationService(){
        //this.sessionManager=sessionManager;
        //this.admin=admin;
        users = new ArrayList<>();
        sessionManager = new SessionManager();
    }

    private Customer findUser(String userName, String password){
        if (users != null)
            for (Customer user : users) {
                if (user.getUserName().equals(userName) && user.getPassword().equals(password)) {
                    return user;
                }
            }
        
        return null;
    }

    private boolean validatePassword(String password) {

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

    public Customer login(String userName, String password){
        Customer result=null;
        // if(admin.getUserName().equals(userName) && admin.getPassword().equals(password)){
        //     result = admin;
        // }
        
        if(result==null)result=findUser(userName, password);

        if(result!=null){
            //SessionManager sessionManager = SessionManager.getInstance();
            sessionManager.createSession(result);
        }
        
        return result;
    }

    public Boolean logout(Customer user){
        return sessionManager.removeSession(user);
    }

    public Customer register(String userName, String password){

        Customer user = findUser(userName,password);
        if(user!=null)
            return null;

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