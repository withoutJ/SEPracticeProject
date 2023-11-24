package authentication;
import java.util.ArrayList;
import java.util.List;
import user.*;

public class AuthenticationService{
    //private SessionManager sessionManager;
    //private AdminStub admin;
    private static List<Customer> users;
    private static Admin admin;

    public AuthenticationService(){
        //this.sessionManager=sessionManager;
        //this.admin=admin;
        AuthenticationService.users = new ArrayList<>();
    }

    private static Customer findUser(String userName, String password){
        if (users != null)
            for (Customer user : users) {
                if((user.getUserName()).equals(userName) && (user.getPassword()).equals(password)){
                    return user;
                }
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

    public static Customer login(String userName, String password){
        Customer result=null;
        // if(admin.getUserName().equals(userName) && admin.getPassword().equals(password)){
        //     result = admin;
        // }
        
        if(result==null)result=findUser(userName, password);

        if(result!=null){
            SessionManager sessionManager = SessionManager.getInstance();
            sessionManager.createSession(result);
        }
        
        return result;
    }

    public static Boolean logout(Customer user){
        return SessionManager.getInstance().removeSession(user);
    }

    public static Customer register(String userName, String password){

        Customer user = findUser(userName,password);
        if(user!=null)
            return null;

        Boolean goodPassword = validatePassword(password);

        if(goodPassword){
            Customer newUser = new Customer(userName, password);
            users.add(newUser);
            return user;
        }

        return null;
    }

    // public static Admin registerAdmin(String username, String password){

    // }



}