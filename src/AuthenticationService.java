import java.util.ArrayList;
import java.util.List;

public class AuthenticationService{
    //private SessionManager sessionManager;
    //private AdminStub admin;
    private static List<UserStub> users;

    public AuthenticationService(){
        //this.sessionManager=sessionManager;
        //this.admin=admin;
        AuthenticationService.users = new ArrayList<UserStub>();
    }

    private static UserStub findUser(String userName, String password){
        for (UserStub user : users) {
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

    public static UserStub login(String userName, String password, AdminStub admin){
        UserStub result=null;
        if(admin.getUserName()==userName && admin.getPassword()==password){
            result = admin;
        }
        
        if(result==null)result=findUser(userName, password);

        if(result!=null){
            SessionManager sessionManager = SessionManager.getInstance();
            sessionManager.createSession(result);
        }
        
        return result;
    }

    public static Boolean logout(UserStub user){
        return SessionManager.getInstance().removeSession(user);
    }

    public UserStub register(String userName, String password){

        UserStub user = findUser(userName,password);
        if(user!=null)return null;

        Boolean goodPassword = validatePassword(password);

        if(goodPassword){
            UserStub newUser = new UserStub(userName, password);
            users.add(newUser);
            return user;
        }

        return null;
    }





}