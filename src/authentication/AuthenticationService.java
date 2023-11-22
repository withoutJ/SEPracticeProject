package authentication;
import java.util.ArrayList;
import java.util.List;
import user.*;

public class AuthenticationService{
    //private SessionManager sessionManager;
    //private AdminStub admin;
    private static List<User> users;

    public AuthenticationService(){
        //this.sessionManager=sessionManager;
        //this.admin=admin;
        AuthenticationService.users = new ArrayList<User>();
    }

    private static User findUser(String userName, String password){
        for (User user : users) {
            if(user.getUserName()==userName && user.getPassword()==password){
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

    public static User login(String userName, String password, Admin admin){
        User result=null;
        if(admin.getUserName().equals(userName) && admin.getPassword().equals(password)){
            result = admin;
        }
        
        if(result==null)result=findUser(userName, password);

        if(result!=null){
            SessionManager sessionManager = SessionManager.getInstance();
            sessionManager.createSession(result);
        }
        
        return result;
    }

    public static Boolean logout(User user){
        return SessionManager.getInstance().removeSession(user);
    }

    public User register(String userName, String password){

        User user = findUser(userName,password);
        if(user!=null)return null;

        Boolean goodPassword = validatePassword(password);

        if(goodPassword){
            User newUser = new User(userName, password);
            users.add(newUser);
            return user;
        }

        return null;
    }





}